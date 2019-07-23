package com.example.astroworld.bean;

import java.io.Serializable;

public class Profile implements Serializable
{
    public String userid;
    public String email;
    public String name;
    public String address;
    public String phoneno;
    public String gender;
    public String dob;
    public String dor;
    public String experience;
    public String skill;
    public String registrationno;
    public String usertype;
    public String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public Profile()
    {

    }

    public String errormsg;

    public Profile(String userid, String email, String name, String address, String phoneno, String gender, String dob, String dor, String experience, String skill, String registrationno, String usertype, String errormsg) {
        this.userid = userid;
        this.email = email;
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
        this.gender = gender;
        this.dob = dob;
        this.errormsg = errormsg;
        this.dor = dor;
        this.experience = experience;
        this.skill = skill;
        this.registrationno = registrationno;
        this.usertype = usertype;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRegistrationno() {
        return registrationno;
    }

    public void setRegistrationno(String registrationno) {
        this.registrationno = registrationno;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
