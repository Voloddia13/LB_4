package org.example.dto;

import java.time.LocalDate;

public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birth;

    public UserDTO() {
    }

    public UserDTO(final Long id, final String firstname, final String lastname, final LocalDate birth) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birth = birth;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(final LocalDate birth) {
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}