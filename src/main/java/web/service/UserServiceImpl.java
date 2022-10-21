package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Transactional(readOnly = true)
    @Override
    public List<User> allUser() {
        return userDao.allUser();
    }

    @Override
    public void add(User user) {
    userDao.add(user);
    }

    @Override
    public void edit(User user) {
    userDao.edit(user);
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }
}
