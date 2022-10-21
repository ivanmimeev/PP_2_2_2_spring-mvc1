package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
        List<User> allUser();
        void add(User user);
        void edit(User user);
        User getById(long id);
        void deleteById(long id);
}


