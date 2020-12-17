package com.mahmutkayadelen.isyonetimi.service;

import com.mahmutkayadelen.isyonetimi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Create by mkayadelen 14.12.2020
 */
public interface UserService {
    User save(User user);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);


}
