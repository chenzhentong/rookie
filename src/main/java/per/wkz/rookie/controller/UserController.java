package per.wkz.rookie.controller;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.wkz.rookie.bean.CommonResult;
import per.wkz.rookie.bean.User;
import per.wkz.rookie.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/info")
    public CommonResult<User> userInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return new CommonResult<User>(200, "成功进入个人主页", user);
        } else {
            return new CommonResult<User>(444, "用户身份已经过期，请重新登录", null);
        }
    }

    @GetMapping("/password/update")
    public CommonResult<Boolean> updatePassword(@RequestParam("newPassword") String newPassword, @RequestParam("userId") int userId, HttpSession session) {
        log.info(userId + "");
        Integer row = userService.updatePassword(newPassword, userId);
        if (row == 1) {
            log.info("密码更新成功");
            User user = (User) session.getAttribute("user");
            user.setPassword(newPassword);
            session.setAttribute("user", user);
            return new CommonResult<>(200, "密码更新成功", true);
        } else {
            return new CommonResult<>(444, "密码更新失败", false);
        }
    }

    @GetMapping("/getIdByPhone")
    public CommonResult<Integer> getUserIdByPhone(@RequestParam("phone") String phone) {
        User user = userService.getUserByPhone(phone);
        if (user != null) {
            return new CommonResult<Integer>(200, "查询到手机号为" + phone + "的用户信息", user.getId());
        } else {
            return new CommonResult<Integer>(444, "未查询到相关用户信息");
        }
    }


    @PostMapping("/register")
    public CommonResult<Integer> userRegister(@RequestBody User user) {
        log.info(user.toString());
        if (user.getType() == null) {
            user.setType(0);
        }
        if (user.getEmail() == null) {
            user.setEmail("");
        }


        Integer row = userService.addUser(user);
        if (row == 1) {
            log.info("注册成功，userId=" + user.getId());
            return new CommonResult<>(200, "注册成功，userId=" + user.getId(), row);
        } else {
            return new CommonResult<>(444, "注册失败");
        }
    }
    @PostMapping("/account/verify")
    public String verifyAccount(@RequestParam("account") String account){
        log.info(account);
        HashMap<String,Boolean> hashMap = new HashMap();
        if (userService.getIsAccountExisted(account)) {
            hashMap.put("valid",false);
            return JSONUtils.toJSONString(hashMap);
        } else {
            hashMap.put("valid",true);
            return JSONUtils.toJSONString(hashMap);
        }
    }


}
