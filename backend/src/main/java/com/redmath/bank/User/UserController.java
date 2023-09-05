package com.redmath.bank.User;

import com.redmath.bank.*;
import com.redmath.bank.Account.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping()
public class UserController{
//private final UserService service;
//
//UserController(UserService service){
//    this.service = service;
//}
//    @PostMapping("/api/bank/login")
//    public ResponseEntity<?> login(@RequestBody LoginDto user) {
//        System.out.println("user name" +user);
//
//   //     System.out.println("password" + user.getpassword());
//
//        StatusLogin resp = service.login_service(user);
//         System.out.println("service" + resp.getmessage()+resp.getrole()+resp.getstatus());
//        return ResponseEntity.ok(resp);
//    }
           @GetMapping("/login.html")
           public String login()
           {
             return "login";
               }




}
