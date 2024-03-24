package com.safeWay.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeWay.system.services.serviceClient;

@RestController
@RequestMapping("/client")
public class clientController {

  @Autowired
  serviceClient transitions;

  @GetMapping(value = "/{cpf}")

  public String saldo(@PathVariable Long cpf) throws Exception {

    String message = transitions.getInformations(cpf);
    return message;
  }

  @PostMapping(value = "{cpf}/deposito/{value}")
  public String deposito(@PathVariable Long cpf, @PathVariable double value) throws Exception {

    String message = transitions.setDeposito(cpf, value);

    transitions.notification();

    return message;

  }

  @PostMapping(value = "{cpf}/saque/{value}")
  public String saque(@PathVariable Long cpf, @PathVariable double value) throws Exception {
    String message = transitions.setSaque(cpf, value);

    transitions.notification();

    return message;
  }

}
