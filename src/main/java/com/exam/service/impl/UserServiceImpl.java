package com.exam.service.impl;

import com.exam.helper.UserFoundException;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

       User local= this.userRepository.findByUsername(user.getUsername());
       if(local!=null)
       {//user already exist
           System.out.println("User is already there!!!!");
           //throw new Exception("User already present!!");default exception
           throw new UserFoundException();//custom exception

       }
       else
       {
           //user create

           //find all roles from userroles
           for(UserRole ur:userRoles)
           {
               roleRepository.save(ur.getRole());
           }

           user.getUserRoles().addAll(userRoles);
           local=this.userRepository.save(user);
       }
        return local;
    }
//getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User deleteUser(long userId) {
        this.userRepository.deleteById(userId);
        return null;
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }


}
