package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> allUser() {
        return userDao.allUser();
    }
    @Transactional
    @Override
    public void add(User user) {
    userDao.add(user);
    }
    @Transactional
    @Override
    public void edit(User user) {
    userDao.edit(user);
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }
    @Transactional
    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }
}
