package com.example.thi5913_1.model;

public class MonHoc {
    private String TenMH, NgayBD, NgayKT,DiaDiem,HinhThucThi;

    public MonHoc(String tenMH, String ngayBD, String ngayKT, String diaDiem, String hinhThucThi) {
        TenMH = tenMH;
        NgayBD = ngayBD;
        NgayKT = ngayKT;
        DiaDiem = diaDiem;
        HinhThucThi = hinhThucThi;
    }

    public MonHoc() {
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String ngayBD) {
        NgayBD = ngayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String ngayKT) {
        NgayKT = ngayKT;
    }

    public String getDiaDiem() {
        return DiaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        DiaDiem = diaDiem;
    }

    public String getHinhThucThi() {
        return HinhThucThi;
    }

    public void setHinhThucThi(String hinhThucThi) {
        HinhThucThi = hinhThucThi;
    }
}
