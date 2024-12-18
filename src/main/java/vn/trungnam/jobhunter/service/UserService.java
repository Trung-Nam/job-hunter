package vn.trungnam.jobhunter.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.trungnam.jobhunter.entity.User;
import vn.trungnam.jobhunter.exception.AppException;
import vn.trungnam.jobhunter.exception.ErrorCode;
import vn.trungnam.jobhunter.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User reqUser){
        User user = new User();

        user.setName(reqUser.getName());
        user.setEmail(reqUser.getEmail());
        user.setPassword(passwordEncoder.encode(reqUser.getPassword()));

        return this.userRepository.save(user);
    }

    public User fetchUser(String id){
        Optional<User> user = Optional.ofNullable(this.userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));

        if (user.isPresent()) {
            return user.get();
        }else {
            return null;
        }
    }

    public List<User> fetchAllUsers(){
        return this.userRepository.findAll();
    }

    public User updateUser(User reqUser){
        User user = fetchUser(reqUser.getId());

        if (user != null){
            user.setName(reqUser.getName());
            user.setEmail(reqUser.getEmail());
            user.setPassword(reqUser.getPassword());

            return this.userRepository.save(user);
        }

        return null;
    }

    public User deleteUser(String id) {
        this.userRepository.deleteById(id);
        return null;
    }
}
