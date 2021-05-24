package per.wkz.rookie.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import per.wkz.rookie.bean.User;
import per.wkz.rookie.bean.UserSearchCriteria;

import java.util.List;

@Mapper
public interface UserDao {
    User getUserById(@Param("id")Integer id);

    Integer addUser(User user);
    User getUserByPhone(@Param("phone")String phone);
    User getUserByAccountAndPwd(@Param("account")String account,@Param("password")String password,@Param("type")Integer type);//根据账号和密码查询用户信息

    Integer updatePassword(@Param("password") String password, @Param("id") Integer id);//修改密码
    List<User> getUserByCriteria(UserSearchCriteria userSearchCriteria);
}
