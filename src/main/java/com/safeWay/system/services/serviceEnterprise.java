package com.safeWay.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safeWay.system.entities.Enterprise;
import com.safeWay.system.repositories.enterpriseRepository;

@Service
public class serviceEnterprise {

  @Autowired
  private enterpriseRepository enterpriseRepository;

  public Enterprise gEnterprise(Long cnpj) throws Exception {

    Enterprise enterprise = enterpriseRepository.findById(cnpj)
        .orElseThrow(() -> new Exception("O CNPJ informado não consta em nosso banco"));
    return enterprise;
  }

  public String getInformations(Long cnpj) throws Exception {

    Enterprise enterprise = this.gEnterprise(cnpj);

    String name = enterprise.getName();
    Long cnpj_id = enterprise.getcnpj();
    double saldo = enterprise.getSaldo();

    String message = "A empresa: " + name + " que está vinculada ao CNPJ: " + cnpj_id + " possui o saldo de: " + saldo;
    return message;
  }

}
