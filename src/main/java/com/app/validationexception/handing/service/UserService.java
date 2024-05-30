package com.app.validationexception.handing.service;

import com.app.validationexception.handing.dto.UserRequest;
import com.app.validationexception.handing.entity.User;
import com.app.validationexception.handing.exception.UserNotFoundException;
import com.app.validationexception.handing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User saveUser(UserRequest userRequest) {
        User user = User.
                build(0, userRequest.getName(), userRequest.getEmail(),
                        userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return userRepository.save(user);
    }
   public List<User> getAllUsers(){
        return userRepository.findAll();
   }
   public Optional<User> getUser(int id) throws UserNotFoundException {
        Optional<User> user= userRepository.findById(id);
        if(user.isPresent()){
            return user;
        }else {
        throw new UserNotFoundException("user not found with the Id :"+id);
        }

   }
}
