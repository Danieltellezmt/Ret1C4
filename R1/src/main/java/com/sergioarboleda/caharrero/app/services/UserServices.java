/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.caharrero.app.services;

import com.sergioarboleda.caharrero.app.model.User;
import com.sergioarboleda.caharrero.app.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.getall();
    }

    /**
     *
     * @param user
     * @return
     */
    public User save(User user) {
        //ojo este user viene de la capa services
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return user;
        } else {
            List<User> existUser = repository.getUsersByNameOrEmail(user.getName(), user.getEmail());
            if (existUser.isEmpty()) {
                if (user.getId() == null) {
                    return repository.save(user);

                } else {
                    Optional<User> existUser2 = repository.getUserById(user.getId());
                    if (existUser2.isEmpty()) {
                        return repository.save(user);
                    } else {
                        return user;
                    }
                }

            } else {
                return user;
            }
        }
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email) {
        //is present contrario de is empty
        return repository.getUserByEmail(email).isPresent();

    }

    public User getByEmailPass(String email, String password) {
        Optional<User> userExist = repository.getUserEmailAndPassword(email, password);
        if (userExist.isPresent()) {
            return userExist.get();
        }else{
            return new User(null,email,password,"NO DEFINIDO");
    }
    }
}
