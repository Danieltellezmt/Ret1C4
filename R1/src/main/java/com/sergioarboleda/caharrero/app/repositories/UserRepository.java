/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.caharrero.app.repositories;

import com.sergioarboleda.caharrero.app.model.User;
import com.sergioarboleda.caharrero.app.repositories.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository repository;
  /**
   * 
   * @return 
   */
    public List<User> getall() {
        return (List<User>) repository.findAll();
    }
    /**
     * 
     * @param user
     * @return 
     */
    public User save(User user){
    return repository.save(user);
    }
   /**
    * 
    * @param name
    * @return 
    */ 
   public Optional<User> getUserByName(String name){
   return repository.findByName(name);
   }
   /**
    * 
    * @param email
    * @return 
    */
   public Optional<User> getUserByEmail(String email){
   return repository.findByEmail(email);
   }
   /**
    * 
    * @param name
    * @param email
    * @return 
    */
   public List<User> getUsersByNameOrEmail( String name, String email){
   return repository.findByNameOrEmail(name, email);
           }
  /**
   * 
   * @param email
   * @param password
   * @return 
   */
   public Optional<User> getUserEmailAndPassword(String email, String password){
   return repository.findByEmailAndPassword(email, password);
}
   /**
    * 
    * @param id
    * @return 
    */
   public Optional<User> getUserById(Integer id){
   return repository.findById(id);
   }
}


