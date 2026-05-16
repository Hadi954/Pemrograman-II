package com.latihan.jsf;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String userId;
    private String password;
    private String loginTime;
    private String loginDate;
    private boolean loggedIn = false;

    public void login() {
        if (userId != null && !userId.isEmpty() && password != null && !password.isEmpty()) {
            Date now = new Date();
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            
            this.loginTime = timeFormat.format(now);
            this.loginDate = dateFormat.format(now);
            this.loggedIn = true;
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
