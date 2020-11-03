package beans;

import java.io.Serializable;

public class Profile implements Serializable
{
    public String userid,name,email,address,gender,phoneno,registrationno,errormsg,dob,dor,experience,skill,usertype;

    public String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getRegistrationno() {
        return registrationno;
    }

    public void setRegistrationno(String registrationno) {
        this.registrationno = registrationno;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Profile(String userid, String name, String email, String address, String gender, String phoneno, String registrationno, String errormsg, String dob, String dor, String experience, String skill, String usertype) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.phoneno = phoneno;
        this.registrationno = registrationno;
        this.errormsg = errormsg;
        this.dob = dob;
        this.dor = dor;
        this.experience = experience;
        this.skill = skill;
        this.usertype = usertype;
    }
    public Profile()
    {
    	
    }
}
