package com.mahmutkayadelen.isyonetimi.service.impl;

import com.mahmutkayadelen.isyonetimi.dto.UserDto;
import com.mahmutkayadelen.isyonetimi.entity.User;
import com.mahmutkayadelen.isyonetimi.repository.UserRepository;
import com.mahmutkayadelen.isyonetimi.service.UserService;
import com.mahmutkayadelen.isyonetimi.util.Tpage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto save(UserDto user) {
        {
            if (user.getEmail() == null) {
                throw new IllegalArgumentException("Email cannot be null!");
            }
            if (user.getNameSurname() == null) {
                throw new IllegalArgumentException("Name Surname cannot be null!");
            }
            User createdUser = modelMapper.map(user, User.class);
            createdUser = userRepository.save(createdUser);
            user.setId(createdUser.getId());
            return user;
        }


    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.getOne(id);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User getByIdForUser(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Tpage<UserDto> getAllPageable(Pageable pageable) {

        Page<User> data = userRepository.findAll(pageable);
        Tpage<UserDto> response = new Tpage<>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), UserDto[].class)));
        return response;
    }

    public List<UserDto> getAll() {
        List<User> data = userRepository.findAll();
        return Arrays.asList(modelMapper.map(data, UserDto[].class));
    }

    @Override
    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

}
