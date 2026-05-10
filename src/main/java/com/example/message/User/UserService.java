package com.example.message.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse signIn(SigninRequest signinRequest) {
        User existedUser = userRepository.findByUserName(signinRequest.getUsername()).orElse(null);

        if(existedUser!=null){
            //compare pass here ( might not need hashed)
            if (passwordEncoder.matches(signinRequest.getPassword(), existedUser.getUserPassword())) {
                return convertToUserResponse(existedUser);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username or password not match");
    }

    public UserResponse convertToUserResponse(User user){
        return new UserResponse(user.getUserId(), user.getUserName());
    }

    public List<UserResponse> getAllUser() {
        List<User> users= userRepository.findAll();
        return users.stream()
                .map(this::convertToUserResponse)
                .toList();

    }
}
