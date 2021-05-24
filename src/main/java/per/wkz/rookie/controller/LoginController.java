package per.wkz.rookie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import per.wkz.rookie.bean.CommonResult;
import per.wkz.rookie.bean.User;
import per.wkz.rookie.service.UserService;

import javax.servlet.http.HttpSession;


@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public CommonResult<User> login(@RequestParam("account") String account, @RequestParam("password")String password, @RequestParam("type")Integer type,HttpSession session){
        User user = userService.getUserByAccountAndPwd(account,password,type);
        if (user!=null){
            session.setAttribute("user",user);
            log.info(session.getAttribute("user").toString());
            return new CommonResult<User>(200,"登录成功!",user);
        } else {
            return new CommonResult<User>(444,"用户名或密码错误",null);
        }
    }

    @GetMapping("/login")
    public ModelAndView goLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login.html");
        return modelAndView;
    }

    @GetMapping("/logout")
    public CommonResult<User> logout(HttpSession session){
        session.invalidate();
        return new CommonResult<>(200,"注销成功",null);
    }



}
