package com.tw.clubmanagement.service;

import com.tw.clubmanagement.controller.representation.UserInformation;
import com.tw.clubmanagement.entity.UserEntity;
import com.tw.clubmanagement.exception.ResourceNotFoundException;
import com.tw.clubmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserInformation getUserInformation(String userId) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(Integer.valueOf(userId));
        UserEntity userEntity = userEntityOptional.orElseThrow(() -> new ResourceNotFoundException("未发现用户信息"));

        return userEntity.toUserInformation();
    }
}
