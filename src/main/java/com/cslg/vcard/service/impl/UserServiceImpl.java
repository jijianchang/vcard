package com.cslg.vcard.service.impl;

import com.cslg.vcard.entity.User;
import com.cslg.vcard.mapper.UserMapper;
import com.cslg.vcard.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjc
 * @since 2021-03-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
