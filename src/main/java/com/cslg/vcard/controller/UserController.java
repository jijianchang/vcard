package com.cslg.vcard.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cslg.utils.Result;
import com.cslg.vcard.entity.User;
import com.cslg.vcard.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2021-03-05
 */
@Slf4j
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value="登录", notes="登录")
        public Result<JSONObject> login(@RequestBody User user) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(token);
        Result<JSONObject> result = new Result();
        if (subject.isAuthenticated()) {
            result.setSuccess(true);
            result.setMessage("登录成功");
            return result;
        } else {
            token.clear();
            result.setSuccess(false);
            result.setMessage("登录失败");
            return result;
        }
    }


    @PostMapping("/register")
    @ApiOperation(value="注册", notes="注册")
    public Result<?> userRegister(@RequestBody User user) {
        int count = userService.count(new LambdaQueryWrapper<User>().eq(User::getUsername, user.getUsername()));
        if (count == 0) {
            String newPassword = new SimpleHash("md5", user.getPassword(),
                    ByteSource.Util.bytes(user.getUsername()+"salt"), 2).toHex();
            user.setPassword(newPassword);
            boolean flag = userService.save(user);
            if (flag) {
                return Result.ok("注册成功",user.getUsername());
            } else {
                return Result.ok("该用户注册失败");
            }
        } else {
                return Result.error(500,"该用户名已被注册，注册失败");
        }
    }


}

