package com.nibblebytes.postgresql.controller;

import com.nibblebytes.postgresql.dto.UserDto;
import com.nibblebytes.postgresql.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "User Crud Swagger Dokumanı")
@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Add new user")
    @PostMapping
    public ResponseEntity<UserDto> add(@RequestBody @ApiParam(value = "Kullanıcı") UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @ApiOperation(value = "Get all users")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

}
