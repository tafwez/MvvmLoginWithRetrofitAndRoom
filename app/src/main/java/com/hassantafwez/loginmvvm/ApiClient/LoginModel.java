package com.hassantafwez.loginmvvm.ApiClient;
public class LoginModel {



    private String id;

    private String emp_email;

    private String database_name;

    private String emp_password;



    public String getId() {
        return id;
    }

    public void setId( String id) {
        this.id = id;
    }


    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }


    public String getDatabase_name() {
        return database_name;
    }

    public void setDatabase_name(String database_name) {
        this.database_name = database_name;
    }


    public String getEmp_password() {
        return emp_password;
    }

    public void setEmp_password(String emp_password) {
        this.emp_password = emp_password;
    }
}
