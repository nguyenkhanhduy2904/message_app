package com.example.message.Utils;
import com.example.message.User.User;
import com.example.message.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitilizer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            if (userRepository.count() == 0) {

                User u1 = new User();
                u1.setUserName("user1");
                u1.setUserPassword(passwordEncoder.encode("123456"));

                User u2 = new User();
                u2.setUserName("user2");
                u2.setUserPassword(passwordEncoder.encode("123456"));

                userRepository.save(u1);
                userRepository.save(u2);
            }
        };
    }

}
