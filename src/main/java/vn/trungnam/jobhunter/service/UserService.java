package vn.trungnam.jobhunter.service;

import org.springframework.stereotype.Service;
import vn.trungnam.jobhunter.domain.User;
import vn.trungnam.jobhunter.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User reqUser){
        User user = new User();

        user.setName(reqUser.getName());
        user.setEmail(reqUser.getEmail());
        user.setPassword(reqUser.getPassword());

        return this.userRepository.save(user);
    }

    public User fetchUser(String id){
        Optional<User> user = this.userRepository.findById(id);

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

    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }
}
