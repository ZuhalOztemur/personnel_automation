package com.personnel_automation.entity;

import com.personnel_automation.dto.AdministrativeDTO;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrative")
public class AdministrativeEntity extends BaseEntity
{
    private String name;

    private String password;

    private String userName;

    private String branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public String getBranch() {return branch;}

    public void setBranch(String branch) {this.branch = branch;}

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


    public AdministrativeDTO toDTO(){
        return AdministrativeDTO.builder()
                .id(this.getId())
                .name(this.getName())
                .branch(this.getBranch())
                .userName(this.getUserName())
                .password(this.getPassword())

                .build();
    }

}
