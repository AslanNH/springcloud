package com.nh.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * java -jar **.jar --server.port**
 */
@RestController
public class UserController {
    @ApiOperation(value="打招呼")
    @ApiResponses({@ApiResponse(code=200,message="ok",response = String.class)})
    @GetMapping("/user/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/user/hello2")
    public String hello2(@RequestParam("name")String name){
        return name;
    }
}

