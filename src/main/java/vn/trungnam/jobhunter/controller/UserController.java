package vn.trungnam.jobhunter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.trungnam.jobhunter.entity.User;
import vn.trungnam.jobhunter.request.ApiResponse;
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
    public ApiResponse<User> createUser(@RequestBody User reqUser){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setResult(userService.createUser(reqUser));

        return apiResponse;
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUser(@PathVariable String id){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setResult(userService.fetchUser(id));

        return apiResponse;
    }

    @GetMapping()
    public ApiResponse<List<User>> getAllUsers(){
        ApiResponse<List<User>> apiResponse = new ApiResponse<>();

        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setResult(userService.fetchAllUsers());

        return apiResponse;
    }

    @PutMapping()
    public ApiResponse<User> updateUser(@RequestBody User user){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setResult(userService.createUser(userService.updateUser(user)));

        return apiResponse;
    }


    @DeleteMapping("/{id}")
    public ApiResponse<User> deleteUser(@PathVariable("id") String id){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setCode(HttpStatus.OK.value());
        apiResponse.setMessage("User has been deleted!");
        apiResponse.setResult(userService.deleteUser(id));

        return apiResponse;

    }
}
