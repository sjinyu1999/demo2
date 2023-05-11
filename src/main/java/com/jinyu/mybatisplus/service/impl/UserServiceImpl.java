package com.jinyu.mybatisplus.service.impl;

import com.jinyu.mybatisplus.entity.User;
import com.jinyu.mybatisplus.mapper.UserMapper;
import com.jinyu.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jinyu
 * @since 2023-03-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
