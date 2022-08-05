package com.works.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {

    private String name;
    private String email;
    private int age;

    public void formSend() {
        System.out.println( name );
        System.out.println( email );
        System.out.println( age );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
