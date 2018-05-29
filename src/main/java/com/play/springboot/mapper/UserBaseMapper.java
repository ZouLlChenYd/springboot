package com.play.springboot.mapper;

import java.util.List;

import com.play.springboot.entity.UserBase;

public interface UserBaseMapper {

    List<UserBase> getAll();

    UserBase getOne(String id);

    void insert(UserBase user);

    void update(UserBase user);

    void delete(String id);
}
