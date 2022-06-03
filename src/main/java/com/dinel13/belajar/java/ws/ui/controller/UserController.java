package com.dinel13.belajar.java.ws.ui.controller;

import com.dinel13.belajar.java.ws.service.UserService;
import com.dinel13.belajar.java.ws.shared.dto.UserDto;
import com.dinel13.belajar.java.ws.ui.model.request.UserDetailRequestModel;
import com.dinel13.belajar.java.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http:localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping // this will mapping to req res as get method
    public String getUser() {
        return "get user was called";
    }

    @PostMapping // AS POST METHOD
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);


//        ModelMapper modelMapper = new ModelMapper();
//        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
//

        return returnValue;
    }

    @PutMapping
    public String UpdateUser() {
        return "user update";
    }

    @DeleteMapping
    public String deleteUse() {
        return "delete user";
    }

}
