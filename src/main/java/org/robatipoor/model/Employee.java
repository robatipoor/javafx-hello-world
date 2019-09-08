package org.robatipoor.model;

import java.util.*;
import javax.validation.constraints.*;
import javax.persistence.*;

/**
 * Employee
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 30)
    @NotBlank
    private String firstname;

    @Size(max = 30)
    @NotBlank
    private String lastname;

    @NotNull
    // @Basic
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Max(70)
    @Min(18)
    @NotNull
    private Integer age;

    public Employee() {
    }

    public Employee(String firstname, String lastname, Date birthday, Integer age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}