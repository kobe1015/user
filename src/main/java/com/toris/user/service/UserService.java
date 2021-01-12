package com.toris.user.service;

import com.toris.user.model.dto.UserDto;
import com.toris.user.model.entity.kobe.User;
import com.toris.user.model.entity.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ModelMapper getModelMapper() {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper;
    }

    public List<UserDto> findAllUser() {
        List<UserDto> dtos = userRepository.findAll()
                .stream()
                .map(user -> getModelMapper().map(user, UserDto.class))
                .collect(Collectors.toList());

        return dtos;
    }

    public UserDto findUserById(Long userId) {
        UserDto userDto = getModelMapper().map(userRepository.findById(userId).get(), UserDto.class);
        return userDto;
    }

    public void insertUser(UserDto userDto) {
        User user = getModelMapper().map(userDto, User.class);
        userRepository.save(user);
    }

    public void updateUser(Long userId, UserDto userDto) {
        userDto.userId = userId;
        User user = getModelMapper().map(userDto, User.class);
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        User user = userRepository.getOne(userId);
        userRepository.delete(user);
    }
}
