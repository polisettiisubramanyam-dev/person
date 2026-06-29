package com.practice.person.service;

import com.practice.person.entity.ProfileEntity;
import com.practice.person.entity.UserEntity;
import com.practice.person.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public UserEntity update(int id, UserEntity user) {
        Optional<UserEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            UserEntity eUser = optional.get();
            // Update User fields
            if (user.getUserName() != null) {
                eUser.setUserName(user.getUserName());
            }

            // Update Profile fields
            if (user.getProfile() != null) {
                ProfileEntity reqProfile = user.getProfile();
                if (eUser.getProfile() != null) {
                    ProfileEntity dbProfile = eUser.getProfile();
                    if (reqProfile.getAddress() != null) {
                        dbProfile.setAddress(reqProfile.getAddress());
                    }
                    if (reqProfile.getPhoneNumber() != null) {
                        dbProfile.setPhoneNumber(reqProfile.getPhoneNumber());
                    }
                }
            }
            return repository.save(eUser);
        }
        return null;
    }

    public String deleteById(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "User Deleted Successfully";
        }
        return "User Not Found";
    }

    public String create(UserEntity user) {
        if (user.getProfile() != null) {
            user.getProfile().setUser(user);
        }
        repository.save(user);
        return "User Created Successfully";
    }

    public UserEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }
}