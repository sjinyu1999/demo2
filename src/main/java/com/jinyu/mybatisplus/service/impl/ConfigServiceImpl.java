package com.jinyu.mybatisplus.service.impl;

import com.jinyu.mybatisplus.entity.Config;
import com.jinyu.mybatisplus.mapper.ConfigMapper;
import com.jinyu.mybatisplus.service.IConfigService;
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
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

}
