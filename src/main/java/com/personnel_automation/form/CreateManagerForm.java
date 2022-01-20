package com.personnel_automation.form;

public class CreateManagerForm {
    private String userName;
    private String password;
    private Long id;

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}
}
