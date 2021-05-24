package per.wkz.rookie.service;
import per.wkz.rookie.bean.User;
public interface UserService {
    User getUserByAccountAndPwd(String account, String password,Integer type);
    Integer updatePassword(String password,int id);
    User getUserByPhone(String phone);
    Integer addUser(User user);
    Boolean getIsAccountExisted(String account);
}
