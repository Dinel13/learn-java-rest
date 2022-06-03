package com.dinel13.belajar.java.ws.ui.controller;

import com.dinel13.belajar.java.ws.service.UserService;
import com.dinel13.belajar.java.ws.shared.dto.UserDto;
import com.dinel13.belajar.java.ws.ui.model.request.UserDetailRequestModel;
import com.dinel13.belajar.java.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http:localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    // this will mapping to req res as get method
    // resspon bisa json atau xml, dfaultr json karena ada produces
    // pake comusems untuk atur juga bisa terima json dan xml
    public UserRest getUser(@PathVariable String id) {
        UserRest returnValue = new UserRest();

        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto, returnValue);

        return returnValue;
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
