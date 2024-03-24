package com.safeWay.system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_enterprise")
public class Enterprise {

  @Id
  private Long cnpj_id;

  private String name;
  private String corporationEmail;
  private double saldo;
  private char PE;

  public Enterprise() {

  }

  public Long getcnpj() {
    return cnpj_id;
  }

  public void setcnpj(Long cnpj) {
    cnpj_id = cnpj;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double result) {
    this.saldo = result;
  }

  public char getPE() {
    return PE;
  }

  public void setPE(char p_e) {
    this.PE = p_e;
  }

  public String getCorporationEmail() {
    return corporationEmail;
  }

  public void setCorporationEmail(String corporationEmail) {
    this.corporationEmail = corporationEmail;
  }

}
