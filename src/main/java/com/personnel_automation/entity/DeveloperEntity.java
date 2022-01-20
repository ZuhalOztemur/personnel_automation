package com.personnel_automation.entity;

import com.personnel_automation.dto.DeveloperDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "developer")
public class DeveloperEntity extends BaseEntity{
    @Id
    @Column(name = "id")

    private Long id;

    private String name;

    private String userName;

    private String password;

    private int pay;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public DeveloperDTO toDTO(){
        return DeveloperDTO.builder()
                .id(this.getId())
                .name(this.getName())
                .userName(this.getUserName())
                .password(this.getPassword())
                .pay(this.getPay())
                .build();
    }

}
