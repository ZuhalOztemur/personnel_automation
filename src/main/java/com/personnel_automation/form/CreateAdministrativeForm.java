package com.personnel_automation.form;

public class CreateAdministrativeForm
{
    private String name;

    private String userName;

    private String password;

    private String branch;

    private Long id;

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

    public String getName() {return name;}

    public  void setName(String name) {this.name = name;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}
}
