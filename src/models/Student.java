package models;

import enams.Gender;

import java.util.List;

public class Student {
    private Long id;
    private String name;
    private String LastName;
    private String gmail;
    private String password;
    private Gender gender;

    public Student(Long id, String name, String lastName, String gmail, String password, Gender gender) {
        this.id = id;
        this.name = name;
        LastName = lastName;
        this.gmail = gmail;
        this.password = password;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "\nID                       " + id +
                "\nName:                    " + name +
                "\nLast name:               " + LastName +
                "\nGmail:                   " + gmail +
                "\nPassword:                " + password +
                "\nGender:                  " + gender ;
    }
}
