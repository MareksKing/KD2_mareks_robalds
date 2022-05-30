package com.marekskd2.java.repo;

import com.marekskd2.java.model.MyUser;

import org.springframework.data.repository.CrudRepository;

public interface IUserRepo extends CrudRepository<MyUser, Integer> {

}
    
