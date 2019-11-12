package nhom8.shoppingweb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Phong
 */
@Entity(name = "NguoiDung")
@Table(name = "NGUOIDUNG")
// Nếu tên bảng ở database là NguoiDung thì trong này viết hoa hết như trên nha
// Không là bị lỗi, còn lỗi gì đéo biết
public class NguoiDung implements Serializable{
    /*
        Tạo ra 1 entity từ bảng NguoiDung trong database.
        1 entity tương đương với 1 bảng.
    */
 
    @Id
    @GeneratedValue
    @Column(name = "MAND", nullable = false)
    // Tên thuộc tính MaND cũng viết hoa hết thành MAND luôn.
    private int maND;
 
    @Column(name = "TENDANGNHAP", length = 15, nullable = false)
    private String tenDangNhap;
 
    @Column(name = "MATKHAU", length = 15, nullable = false)
    private String matKhau;
 
    @Column(name = "HOTEN", length = 50, nullable = false)
    private String hoTen;
    
    @Column(name = "SDT", length = 15, nullable = false)
    private String sdt;
    
    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;
    
    @Column(name = "QUYENTRUYCAP", length = 10, nullable = false)
    private String quyenTruyCap;

    public int getMaND() {
        return maND;
    }

    public void setMaND(int maND) {
        this.maND = maND;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuyenTruyCap() {
        return quyenTruyCap;
    }

    public void setQuyenTruyCap(String quyenTruyCap) {
        this.quyenTruyCap = quyenTruyCap;
    }
 
}