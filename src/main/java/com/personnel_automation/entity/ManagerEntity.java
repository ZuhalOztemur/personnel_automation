package com.school_automation.entity;

import com.school_automation.dto.ManagerDTO;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class ManagerEntity extends BaseEntity
{
    private String userName;

    private String password;

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public ManagerDTO toDTO(){
        return ManagerDTO.builder()
                .id(this.getId())
                .userName(this.getUserName())
                .password(this.getPassword())
                .build();
    }


}
