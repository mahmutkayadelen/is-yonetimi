package com.mahmutkayadelen.isyonetimi.controller;

import com.mahmutkayadelen.isyonetimi.dto.ProjectDto;
import com.mahmutkayadelen.isyonetimi.dto.UserDto;
import com.mahmutkayadelen.isyonetimi.service.impl.UserServiceImpl;
import com.mahmutkayadelen.isyonetimi.util.ApiPaths;
import com.mahmutkayadelen.isyonetimi.util.Tpage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author mahmutkayadelen
 * @create 19.02.2021  23:40
 */


@RestController
@RequestMapping(ApiPaths.UserCtrl.CTRL)
@Api(value = ApiPaths.UserCtrl.CTRL, description = "Users APIs")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get by Pagination Operation", response = UserDto.class)
    public ResponseEntity<Tpage<UserDto>> getAllPagination(Pageable pageable) {
        Tpage<UserDto> userList = userServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(userList);
    }

    @GetMapping()
    @ApiOperation(value = "Get by Non Pagination Operation", response = UserDto.class)
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> userList = userServiceImpl.getAll();
        return ResponseEntity.ok(userList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(userServiceImpl.delete(id));
    }
    @PostMapping
    @ApiOperation(value = "Create User Operation", response = UserDto.class)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto p = userServiceImpl.save(user);
        return ResponseEntity.ok(p);
    }
}
