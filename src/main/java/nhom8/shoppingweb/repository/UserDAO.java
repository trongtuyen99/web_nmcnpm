package nhom8.shoppingweb.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import nhom8.shoppingweb.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAO {
    /*
        Query từ entity User bằng JPQL.
    */
    @Autowired
    private EntityManager entityManager;

    public User findUser(String userName) {
        // trả về entity có thuộc tính USERNAME bằng với userName truyền vào.
        try {
            String sql = "Select e from " + User.class.getName() + " e " //
                    + " Where e.USERNAME = :userName";

            Query query = entityManager.createQuery(sql, User.class);
            query.setParameter("userName", userName);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}