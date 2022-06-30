package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.model.entity.UserEntity;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private CurrentUser currentUser;

    public UserService(UserRepository userRepository,
                       CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    public void registerAndLogin(UserRegisterDTO userRegisterDTO){
        UserEntity newUser = new UserEntity()
                .setUsername(userRegisterDTO.getUsername())
                .setEmail(userRegisterDTO.getEmail())
                .setPassword(userRegisterDTO.getPassword());

        userRepository.save(newUser);
        login(newUser);
    }

    public boolean login(UserLoginDTO userLoginDTO){
        Optional<UserEntity> userOpt = userRepository.
                findByUsernameAndPassword(userLoginDTO.getUsername(),
                        userLoginDTO.getPassword());

        if (userOpt.isEmpty()){
            return false;
        }

        login(userOpt.get());

        return userOpt.get().getPassword().equals(userLoginDTO.getPassword());
    }


    private void login(UserEntity userEntity){
        currentUser.setLogged(true);
        currentUser.setName(userEntity.getUsername());
    }

    public void logout() {
        currentUser.clear();
    }
}
