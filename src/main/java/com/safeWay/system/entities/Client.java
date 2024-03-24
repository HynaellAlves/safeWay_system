package com.safeWay.system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_client")
public class Client {

  @Id
  private Long CPF;

  private String firstName;
  private String lastName;
  private String Email;

  @ManyToOne
  @JoinColumn(name = "id_enterprise")
  private Enterprise enterprise;

  public Client() {

  }

  public Long getCPF() {
    return CPF;
  }

  public void setCPF(Long cpf) {
    CPF = cpf;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public Enterprise getEnterprise() {
    return enterprise;
  }

  public void setEnterprise(Enterprise enterprise) {
    this.enterprise = enterprise;
  }

}
