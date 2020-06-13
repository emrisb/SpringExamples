package com.emreisbarali.controller;

import com.emreisbarali.dto.UserDto;
import com.emreisbarali.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> listAll() {
        return ResponseEntity.ok(userService.getAll());
    }

}
