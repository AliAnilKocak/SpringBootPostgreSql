package com.nibblebytes.postgresql.controller;

import com.nibblebytes.postgresql.dto.UserDto;
import com.nibblebytes.postgresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> add(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

}
