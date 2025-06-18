package com.praktikum.user;

import com.praktikum.action.AdminActions;


public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean login(String username, String password) {
        return this.getUsername().equals(username) && this.getPassword().equals(password);
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void ManageItems() {
    }

    @Override
    public void ManageUsers() {
    }

    public void displayAppMenu() {
    }

}
