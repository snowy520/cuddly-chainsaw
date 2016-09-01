package com.chainsaw.bean;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * Created by richard on 8/30/16 10:09 PM.
 */
public class InParam implements Serializable {
    private static final long serialVersionUID = -8752962518894945622L;
    @NotNull(message = "name ... is null")
    private String name;
    @Max(value = 30,message = "max ...")
    private int age;
    @Size(min = 5,max = 10,message = "{password.illegal}")
    private String password;
    @Pattern(regexp = "\\d{11}",message = "mobile")
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
