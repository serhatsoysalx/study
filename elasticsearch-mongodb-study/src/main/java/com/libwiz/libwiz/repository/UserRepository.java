package com.libwiz.libwiz.repository;

import com.libwiz.libwiz.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    
}
