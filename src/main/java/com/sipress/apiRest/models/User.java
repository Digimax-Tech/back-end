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






 /* var myArray =
[
        {"ID": 1, "Cost": 200},
        {"ID": 2, "Cost": 1000},
        {"ID": 3, "Cost": 50},
        {"ID": 4, "Cost": 500}
        ]

        function finder(cmp, arr, attr) {
        var val = arr[0][attr];
        for(var i=1;i<arr.length;i++) {
        val = cmp(val, arr[i][attr])
        }
        return val;
        }

        alert(finder(Math.max, myArray, "Cost"));
        alert(finder(Math.min, myArray, "Cost"));



public static double getClosestToZero(double[] liste) {
//if the list is empty return 0
        if (liste.length != 0) {
        double near = liste[0];
        for (int i = 0; i < liste.length; i++) {
//here we are using Math.abs to manage the negative and
//positive number
        if (Math.abs(liste[i]) <= Math.abs(near)) {
//manage the case when we have two equal neagative numbers
        if (liste[i] == -near) {
        near = Math.abs(liste[i]);
        } else {
        near = liste[i];
        }
        }
        }
        return near;
        } else {
        return 0;
        }
        }*/
