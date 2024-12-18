package vn.trungnam.jobhunter.controller;

import org.springframework.web.bind.annotation.*;
import vn.trungnam.jobhunter.domain.User;
import vn.trungnam.jobhunter.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping()
    public User createUser(@RequestBody User reqUser){
        return userService.createUser(reqUser);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userService.fetchUser(id);
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.fetchAllUsers();
    }

    @PutMapping()
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return "User has been deleted";
    }
}
