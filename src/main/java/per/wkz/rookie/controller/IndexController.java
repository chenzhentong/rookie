package per.wkz.rookie.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import per.wkz.rookie.bean.CommonResult;
import per.wkz.rookie.bean.User;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class IndexController {


    @RequestMapping("/index")
    public CommonResult<User> index(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user!=null){
            return new CommonResult<User>(200,"成功进入主页",user);
        } else {
            return new CommonResult<User>(444,"用户身份已经过期，请重新登录",null);
        }
    }



}
