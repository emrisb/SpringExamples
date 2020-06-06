package com.emreisbarali.api;

import com.emreisbarali.entity.User;
import com.emreisbarali.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user = new User();
        user.setName("Emre");
        user.setSurname("isbarali");
        user.setAddress("test") ;
        user.setBirthday(Calendar.getInstance().getTime());
        user.setId("K001");
        userRepository.save(user);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search) {
        List<User> users = userRepository.findByNameLikeOrSurnameLike(search, search);
        return ResponseEntity.ok(users);
    }
}
