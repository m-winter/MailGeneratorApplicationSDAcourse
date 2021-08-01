package main.java.models;

import java.time.LocalDate;

public class PersonObjectModel {
    private String email;
    private String name;
    private String lastName;
    private char gender;
    private double amount;
    private LocalDate finalDate;

    public PersonObjectModel(String email, String name, String lastName, char gender, double amount, LocalDate finalDate) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.amount = amount;
        this.finalDate = finalDate;
    }

    public PersonObjectModel() {
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public PersonObjectModel generateFromString(String stringToSplit) {
        String[] result = stringToSplit.split("  ");

        PersonObjectModel person = new PersonObjectModel(result[0], result[1], result[2], result[3].charAt(0),
                Double.valueOf((result[4]).replace(",", ".")), LocalDate.parse(result[5]));

        return person;
    }

    @Override
    public String toString() {
        return "PersonObjectModel{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", amount=" + amount +
                ", finalDate=" + finalDate +
                '}';
    }
}
