package per.wkz.rookie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.wkz.rookie.bean.User;
import per.wkz.rookie.bean.UserSearchCriteria;
import per.wkz.rookie.dao.UserDao;
import per.wkz.rookie.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByAccountAndPwd(String account, String password, Integer type) {
        System.out.println(account);
        return userDao.getUserByAccountAndPwd(account, password, type);
    }

    @Transactional
    @Override
    public Integer updatePassword(String password, int id) {
        return userDao.updatePassword(password, id);
    }

    @Override
    public User getUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Boolean getIsAccountExisted(String account) {
        UserSearchCriteria userSearchCriteria = new UserSearchCriteria();
        userSearchCriteria.setAccount(account);
        List<User> users = userDao.getUserByCriteria(userSearchCriteria);

        System.out.println(users!=null);
        System.out.println(users.size());
        if (users != null && users.size()!=0) {
            return true;
        } else{
            return false;
        }

    }
}
