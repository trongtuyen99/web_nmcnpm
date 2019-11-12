package nhom8.shoppingweb.dao;

/**
 *
 * @author Phong
 */
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import nhom8.shoppingweb.entity.NguoiDung;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
@Transactional
public class NguoiDungDAO {
    /*
        Query từ entity NguoiDung bằng JPQL.
    */
    @Autowired
    private EntityManager entityManager;
 
    public NguoiDung findUser(String userName) {
        // trả về entity có thuộc tính tenDangNhap bằng với userName truyền vào.
        try {
            String sql = "Select e from " + NguoiDung.class.getName() + " e " //
                    + " Where e.tenDangNhap = :userName";
 
            Query query = entityManager.createQuery(sql, NguoiDung.class);
            query.setParameter("userName", userName);
            return (NguoiDung) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
 
}
