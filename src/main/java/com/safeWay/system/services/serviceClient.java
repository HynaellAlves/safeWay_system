package com.safeWay.system.services;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeWay.system.entities.Client;
import com.safeWay.system.entities.Enterprise;
import com.safeWay.system.repositories.clientRepository;
import com.safeWay.system.repositories.enterpriseRepository;

@Service
public class serviceClient {

  @Autowired
  clientRepository clientRepository;

  @Autowired
  enterpriseRepository enterpriseRepository;

  public Client gClient(Long id) throws Exception {
    Client client = clientRepository.findById(id)
        .orElseThrow(() -> new Exception("O CPF informado está incorreto ou não existe"));

    return client;
  }

  public Enterprise gEnterprise(Client client) throws Exception {

    Enterprise enterprise = enterpriseRepository.findById(client.getEnterprise().getcnpj())
        .orElseThrow(() -> new Exception("O CNPJ não está vinculado a nenhuma empresa"));

    return enterprise;
  }

  public int gTaxa(Enterprise enterprise) {

    char Pe = enterprise.getPE();
    int Taxa = 0;

    switch (Pe) {
      case 'B':

        Taxa = 9;
        break;

      case 'M':

        Taxa = 6;
        break;

      case 'S':

        Taxa = 3;
        break;
    }

    return Taxa;
  }

  public String notification() {

    return "";
  }

  public String getInformations(Long id) throws Exception {

    Client client = this.gClient(id);

    String FirstName = client.getFirstName();
    String LastName = client.getLastName();
    String enterpriseName = client.getEnterprise().getName();
    double saldo = client.getEnterprise().getSaldo();

    String UserInformations = "Usuário: " + FirstName + " " + LastName;
    String EnterpriseInformations = "A empresa: " + enterpriseName + " possui o saldo de: " + saldo;

    String message = EnterpriseInformations + " " + UserInformations;

    return message;
  }

  // // public List<Client> getClients(Long cnpj){


  //  List<Client> clients = clientRepository.findAll();

  // }

  public String setDeposito(Long id, double value) throws Exception {

    Client client = gClient(id);

    Enterprise enterprise = gEnterprise(client);

    Enterprise newEnterprise = enterprise;

    double result = newEnterprise.getSaldo() + value;

    newEnterprise.setSaldo(result);

    enterpriseRepository.save(newEnterprise);

    String message = "O valor de: " + value + " foi depositado com êxito e o saldo atual é de " + enterprise.getSaldo();

    return message;

  }

  public String setSaque(Long id, double value) throws Exception {

    Client client = gClient(id);

    Enterprise enterprise = gEnterprise(client);

    int taxa = gTaxa(enterprise);

    Enterprise newEnterprise = enterprise;

    double porcentDown = (((newEnterprise.getSaldo() * taxa) / 100) + value);

    System.out.println(porcentDown);

    if (porcentDown > newEnterprise.getSaldo()) {

      String message = "O valor a ser descontado é superior ao balanço da conta";

      return message;

    } else if (porcentDown <= newEnterprise.getSaldo()) {

      double result = newEnterprise.getSaldo() - porcentDown;
      newEnterprise.setSaldo(result);

      enterpriseRepository.save(newEnterprise);
    }

    String message = "O valor de: " + value + " foi sacado com êxito na: " + enterprise.getName()
        + " e o saldo atual é de: " + enterprise.getSaldo();

    return message;
  }

}
