package com.prototype.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Ivanna on 21.05.2016.
 */
@Entity
@Table(name = "USER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable
{

//    @OneToMany(mappedBy = "user")
//    private Set<Role> roles = new HashSet<>();

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "USERNAME", nullable = false)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String passWord;

    @Column(name = "ISACTIVE", nullable = false)
    private Boolean isActive;

    public User(){

    }

    public User(String userName, String passWord, Boolean isActive) {
        this.userName = userName;
        this.passWord = passWord;
        this.isActive = isActive;
    }

    @Override
    public String toString(){
        return String.format(
                "User[id=%d, userName='%s']",
                id, userName
        );
    }

    public Integer getId() {
        return id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
//    public Set<Role> getRoles() {
//        return roles;
//    }
}
