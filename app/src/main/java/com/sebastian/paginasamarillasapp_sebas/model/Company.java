package com.sebastian.paginasamarillasapp_sebas.model;

public class Company {
    private String id;
    private String category;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String logo;
    private String info;

    public  Company(String id, String category, String name, String address, String phone, String email, String logo, String info) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.logo = logo;
        this.info = info;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
