package com.ninos.test;

import com.ninos.model.security.Authorities;
import com.ninos.model.security.User;
import com.ninos.repository.security.AuthoritiesRepository;
import com.ninos.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBtest implements CommandLineRunner {

    private UserRepository userRepository;
    private AuthoritiesRepository authoritiesRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DBtest(UserRepository userRepository, AuthoritiesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("ninos@gmail.com");
        user.setPassword(passwordEncoder.encode("12345"));
        user.setActive(1);
        List<Authorities> authorities = authoritiesRepository.findAll();
        user.getAuthorities().add(authorities.get(0));
        userRepository.save(user);

    }


}
