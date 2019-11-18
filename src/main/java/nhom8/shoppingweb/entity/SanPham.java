/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author damtr
 */
@Entity(name = "SanPham")
@Table(name = "SANPHAM")
public class SanPham implements Serializable{
        /*
    	[maSP] [int] NOT NULL,
	[maNSX] [int] NOT NULL,
	[tenSanPham] [nvarchar](100) NOT NULL,
	[donGia] [varchar](20) NOT NULL,
	[soLuong] [int] NOT NULL,
	[thongTin] [nvarchar](500) NOT NULL,
	[hinhAnh] [varchar](50) NOT NULL,
	[nguoiCapNhat] [int] NULL,
	[ngayCapNhatCuoi] [datetime] NULL,
	[nguoiTao] [int] NOT NULL,
	[ngayTao] [datetime] NOT NULL,
        */
    /*
     
    @Column(name = "TENDANGNHAP", length = 15, nullable = false)
    private String tenDangNhap;
    */
    @Id
    @GeneratedValue
    @Column(name = "MASP", nullable = false)
    private int maSP;
    
    @Column(name = "MANSX",nullable = false)
    private int maNSX;
    
    @Column(name = "TENSANPHAM", length = 100, nullable = false)
    private String tenSanPham;
    
    @Column(name = "DONGIA", length = 20, nullable = false)
    private String donGia;
    
    @Column(name = "SOLUONG", nullable = false)
    private int soLuong;
    
    @Column(name = "THONGTIN", length = 500, nullable = false)
    private String thongTin;
     
    @Column(name = "HINHANH", length = 50, nullable = false)
    private String hinhAnh;
    
    @Column(name = "NGUOICAPNHAT",nullable = false)
    private int nguoiCapNhat;
    
    @Column(name = "NGAYCAPNHATCUOI", length = 20, nullable = false)
    private String ngayCapNhatCuoi;
    
    @Column(name = "NGUOITAO", nullable = false)
    private int nguoiTao;
    
    @Column(name = "NGAYTAO", length = 20, nullable = false)
    private String ngayTao;

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(int maNSX) {
        this.maNSX = maNSX;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getNguoiCapNhat() {
        return nguoiCapNhat;
    }

    public void setNguoiCapNhat(int nguoiCapNhat) {
        this.nguoiCapNhat = nguoiCapNhat;
    }

    public String getNgayCapNhatCuoi() {
        return ngayCapNhatCuoi;
    }

    public void setNgayCapNhatCuoi(String ngayCapNhatCuoi) {
        this.ngayCapNhatCuoi = ngayCapNhatCuoi;
    }

    public int getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(int nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
