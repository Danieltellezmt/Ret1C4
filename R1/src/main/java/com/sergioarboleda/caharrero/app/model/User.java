/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.caharrero.app.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.metamodel.SingularAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Usuario
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")

public class User implements Serializable{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 
 @Column(name= "user_email", unique = true, length = 50, nullable = false)
 private String email;
 
 @Column(name ="user_password", length = 50, nullable = false)
 private String password;
 
 @Column(name="user_name", length = 80, nullable = false)
 private String name;

    public User(SingularAttribute<AbstractPersistable, Serializable> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
