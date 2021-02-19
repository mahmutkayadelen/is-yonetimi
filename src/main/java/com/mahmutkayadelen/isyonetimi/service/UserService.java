package com.mahmutkayadelen.isyonetimi.service;

import com.mahmutkayadelen.isyonetimi.dto.UserDto;
import com.mahmutkayadelen.isyonetimi.entity.User;
import com.mahmutkayadelen.isyonetimi.util.Tpage;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Create by mkayadelen 14.12.2020
 */
public interface UserService {
    UserDto save(UserDto user);

    User getById(Long id);

    Tpage<UserDto> getAllPageable(Pageable pageable);

    List<UserDto> getAll();

    Boolean delete(Long id);


}
