package com.mahmutkayadelen.isyonetimi.repository;

import com.mahmutkayadelen.isyonetimi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
