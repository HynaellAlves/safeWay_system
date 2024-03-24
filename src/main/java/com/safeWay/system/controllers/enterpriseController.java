package com.safeWay.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeWay.system.entities.Client;
import com.safeWay.system.repositories.clientRepository;
import com.safeWay.system.services.serviceClient;
import com.safeWay.system.services.serviceEnterprise;

@RestController
@RequestMapping("/enterprise")
public class enterpriseController {

  @Autowired
  private serviceEnterprise tEnterprise;

  // @GetMapping(value="/{cnpj}")
  // public List<Client> findClient(@PathVariable Long cnpj) {

  // List<Client> client = repository.findAll();

  // return client;

  // }

  @GetMapping(value = "{cnpj}/saldo")
  public String saldo(@PathVariable Long cnpj) throws Exception {

    String message = tEnterprise.getInformations(cnpj);

    return message;
  }

  @PostMapping(value = "{cnpj}/deposito")
  public void deposito() {

  }
}