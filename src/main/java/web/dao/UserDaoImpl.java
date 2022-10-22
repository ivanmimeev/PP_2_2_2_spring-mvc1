package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUser() {
        return entityManager.createQuery("Select a from User a ", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }


    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("Can't find user for ID "
                    + id);
        }
        return user;
    }

    @Override
    public void deleteById(long id) {
        int isSuccessful = entityManager.createQuery("delete from User p where p.id=:id")
                .setParameter("id", id)
                .executeUpdate();
        if (isSuccessful == 0) {
            throw new OptimisticLockException("user modified concurrently");
        }
    }
}


