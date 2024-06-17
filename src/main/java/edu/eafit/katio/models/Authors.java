package edu.eafit.katio.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


    @Entity
@Table(name="Authors")
public class Authors {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private String Lastname;
    private String Country;
    private Date Birthdate;
    
    
    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getLastname() {
        return Lastname;
    }
    public void setLastname(String lastname) {
        Lastname = lastname;
    }
    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        Country = country;
    }
    public Date getBirthdate() {
        return Birthdate;
    }
    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }
    
}