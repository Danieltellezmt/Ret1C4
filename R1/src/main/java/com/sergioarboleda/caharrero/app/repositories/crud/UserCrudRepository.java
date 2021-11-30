/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.caharrero.app.repositories.crud;

import com.sergioarboleda.caharrero.app.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface UserCrudRepository extends CrudRepository<User,Integer> {
   //Para validar datos
    /**
     * 
     * @param name
     * @return 
     */
    public Optional<User> findByName(String name);
    /**
     * 
     * @param email
     * @return 
     */
    
    public Optional<User>findByEmail(String email);
    
    /**
     * 
     * @param name
     * @param email
     * @return 
     */
    //Para validar datos
    public List<User>findByNameOrEmail(String name, String email);
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
}
