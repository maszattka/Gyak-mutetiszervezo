
package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tajNumber;
    private String name;
    private int birthYear;
    private String surgeryType;
    private String operatingDoctor;

    public String getName() {
        return null;
    }

    public char[] getBirthYear() {
        return new char[0];
    }

    public String getSurgeryType() {
        return null;
    }

    public String getOperatingDoctor() {
        return null;
    }

    public Long getId() {
        return null;
    }

    public void setTajNumber(String text) {
    }

    public void setName(String text) {
    }

    public void setBirthYear(int i) {
    }

    public void setSurgeryType(String text) {
    }

    public void setOperatingDoctor(String text) {
    }

    public String getTajNumber() {
        return null;
    }

    public void setId(long l) {
    }

    // Getters and setters
}
