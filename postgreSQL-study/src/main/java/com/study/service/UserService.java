package com.study.service;

import com.study.dto.AdressDto;
import com.study.dto.UserDto;
import com.study.entity.Adress;
import com.study.entity.User;
import com.study.repository.AdressRepository;
import com.study.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AdressRepository adressRepository;

    @Transactional
    public UserDto userRegister(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());
        Adress adress = new Adress();

        userDto.getAdress().forEach(adressDto -> {
            adress.setStatus(adressDto.isStatus());
            adress.setAdressType(adressDto.getAdressType());
            adress.setAdress(adressDto.getAdress());
            adress.setUser(user);

        });
        final User userDB = userRepository.save(user);
        adressRepository.save(adress);

        userDto.setId(userDB.getId());
        return userDto;
    }

    public boolean existUser(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public List<UserDto> getAllUser() {
        final  List<User> users = userRepository.findAll();
        List<UserDto> listOfUsersDto = new ArrayList();
        users.forEach(userDB -> {
            UserDto userDto = new UserDto();
            userDto.setId(userDB.getId());
            userDto.setName(userDB.getName());
            userDto.setSurname(userDB.getSurname());
            userDto.setUsername(userDB.getUsername());
            userDto.setAdress(new ArrayList<>());
            userDB.getAdress().forEach(adress -> {
                AdressDto adressDto = new AdressDto();
                adressDto.setAdress(adress.getAdress());
                adressDto.setStatus(adress.getStatus());
                adressDto.setAdressType(adress.getAdressType());

                userDto.getAdress().add((adressDto));
            });
            listOfUsersDto.add(userDto);
        });
        return listOfUsersDto;
    }

    public UserDto findingAUserByUsername(UserDto userDto) {
        final User userDB = userRepository.findByUsername(userDto.getUsername());
        userDto.setId(userDB.getId());
        userDto.setName(userDB.getName());
        userDto.setSurname(userDB.getSurname());
        userDto.setUsername(userDB.getUsername());
        userDto.setAdress(new ArrayList<>());
        userDB.getAdress().forEach(adress -> {
            AdressDto adressDto = new AdressDto();
            adressDto.setAdress(adress.getAdress());
            adressDto.setAdressType(adress.getAdressType());
            adressDto.setStatus(adress.getStatus());
           ;
            userDto.getAdress().add(adressDto);
        });

        return userDto;
    }
}
