package com.bulletinboard.bulletinboard.service;

import com.bulletinboard.bulletinboard.domain.User;
import com.bulletinboard.bulletinboard.dto.UserDTO;
import com.bulletinboard.bulletinboard.repository.UserRepository;
import com.bulletinboard.bulletinboard.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository; //12번쨰 줄에서 userRepository의 생성자 만들어야 함

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //올바른 이메일 아이디, 비밀번호 인지 확인
    public boolean validateUser(String email, String password) {
        User user = userRepository.findByEmail(email); //id, email, password, username
        if (user != null) {
            return user.getPassword().equals(password); //passsword 맞는지 확인

        }
        return false; //user가 null이면 false return
    }

    @Value("${jwt.secret}")
    private String secretKey;

    private Long expiredMs = 1000 * 60 * 60l; //1시간


    public String getToken(String email) {
        return JwtUtils.generateToken(email, secretKey, expiredMs);
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
