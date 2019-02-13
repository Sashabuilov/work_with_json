package com.example.jsontestapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response_User {

    //------------ID---------------
    @SerializedName("id")
    @Expose
    private String id;
    public String getId(){
        return id;
    }
    public void setId (String id){
        this.id = id;
    }

    //-----------FIRST_NAME-----------------

    @SerializedName("firstName")
    @Expose
    private String firstName;
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName (String firstName){
        this.firstName = firstName;
    }

    //--------------LAST_NAME--------------

    @SerializedName("lastName")
    @Expose
    private String lastName;
    public String getLastName(){
        return lastName;
    }
    public void setLastName (String lastName){
        this.lastName = lastName;
    }

    //------------USER_NAME----------------

    @SerializedName("userName")
    @Expose
    private String userName;
    public String getUserName(){
        return userName;
    }
    public void setUserName (String userName){
        this.userName = userName;
    }

    //------------EMAIL----------------

    @SerializedName("email")
    @Expose
    private String email;
    public String getEmail(){
        return email;
    }
    public void setEmail (String email){
        this.email = email;
    }

    //--------------ROLE---------------

    @SerializedName("role")
    @Expose
    private String role;
    public String getRole(){
        return role;
    }

    public void setRole (String role){
        this.role = role;
    }
    //------------PHONE-----------------

    @SerializedName("phone")
    @Expose
    private String phone;
    public String getPhone(){
        return phone;
    }
    public void setPhone (String phone){
        this.phone = phone;
    }

    //----------------ADDRESS-------------

    @SerializedName("address")
    @Expose
    private String address;
    public String getAddress(){
        return address;
    }
    public void setAddress (String address){
        this.address = address;
    }

    //-------------INFO----------------

    @SerializedName("info")
    @Expose
    private String info;
    public String getInfo(){
        return info;
    }
    public void setInfo (String info){
        this.info = info;
    }

    //-------------END-----------------
}
