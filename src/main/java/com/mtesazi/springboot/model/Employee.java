package com.mtesazi.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email_ID")
    private String emailId;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Address")
    private String address;
public Employee(){

}
    public Employee(String firstName, String lastName, String emailId, String telephone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.telephone = telephone;
        this.address = address;
    }

    public long getId() { return id; }
    public void setId(long id) {this.id = id;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getEmailId() {return emailId;}
    public void setEmailId(String emailId) {this.emailId = emailId;}
    public String getTelephone() {return telephone;}
    public void setTelephone(String telephone) {this.telephone = telephone;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
}
