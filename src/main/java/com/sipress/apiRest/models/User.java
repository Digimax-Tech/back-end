package com.sipress.apiRest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id @GeneratedValue
  public   Long id;
  public String email;
  public String nom;
  public String prenom;
  public String numTel;
  public String password;
}
