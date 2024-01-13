package com.zoeAcademy.controller.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.User;
import com.zoeAcademy.service.User.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/verify-user")
    public ResponseEntity<GenericReturn<?>> verifyUser(@RequestParam("email") String email,
            @RequestParam("password") String password) {
        return ResponseEntity.ok(userService.verifyUser(email, password));
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<GenericReturn<?>> getUser(@PathVariable("id") Long id) {
        System.out.println(id);
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping("/create-user")
    public ResponseEntity<GenericReturn<?>> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/update-user")
    public ResponseEntity<GenericReturn<?>> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<GenericReturn<?>> deleteUser(@RequestParam("id") Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}
