/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom8.shoppingweb.dao;
import java.util.LinkedList;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import nhom8.shoppingweb.entity.SanPham;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 

/**
 *
 * @author damtr
 */
@Repository
@Transactional
public class SanPhamDAO {
    @Autowired
    private EntityManager entityManager;
 
    public LinkedList<SanPham> findSanPham(String tenSP) {
        // trả về entity có thuộc tính tenDangNhap bằng với userName truyền vào.
        try {
            String sql = "Select e from " + SanPham.class.getName() + " e " //
                    + " Where e.tenSanPham like N\"*:tenSP*\" ";
 
            Query query = entityManager.createQuery(sql, SanPham.class);
            query.setParameter("tenSP", tenSP);
            return (LinkedList<SanPham>) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public void xoaSanPham(String tenSP)
    {
        try {
            String sql = "delete from SanPham e where tensanPham = :tenSP" ;
            // todo
        } catch (Exception e) {
        }
    }
    public void themSanPham(SanPham sp)
    {
        String sql = "insert into table "+ SanPham.class.getName() + " e "//
                + " values (sp....)";
    }
    
}
