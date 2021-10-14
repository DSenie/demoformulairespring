package com.example.demoformulairespring.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable{

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;


    @Column(name = "fonction")
    private String fonction;


    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setFirstname(String firstName){
        this.firstname = firstName;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public void setLastname(String lastName){
        this.lastname = lastName;
    }

    public String getLastname(){
        return this.lastname;
    }


    public void setFonction(String fonction){
        this.fonction = fonction;
    }

    public String getFonction(){
        return this.fonction;
    }


    public Customer() {}

    public Customer(String firstName, String lastName,  String fonction) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.fonction = fonction;

    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', fonction='%s']",
                id, firstname, lastname, fonction);
    }
}
