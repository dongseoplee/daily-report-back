package com.bulletinboard.bulletinboard.service;

import com.bulletinboard.bulletinboard.domain.User;
import com.bulletinboard.bulletinboard.dto.UserDTO;
import com.bulletinboard.bulletinboard.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository; //12번쨰 줄에서 userRepository의 생성자 만들어야 함

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        return userRepository.save(user);
    }

    public User convertToEntity(UserDTO userDTO) {
        User user = new User();

        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());

        return user;
    }
}
