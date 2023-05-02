package entity;


public class XeMay {
    private String maXe;
    private String maLoai;
    private String soKhung;
    private String soMay;
    private String MauXe;
    private double donGia;
    public XeMay() {
        super();
    }
    public XeMay(String maXe){
        this.maXe = maXe;
    }
    public XeMay(String maXe, String maLoai, String soKhung, String soMay, String mauXe, double donGia) {
        super();
        this.maXe = maXe;
        this.maLoai = maLoai;
        this.soKhung = soKhung;
        this.soMay = soMay;
        MauXe = mauXe;
        this.donGia = donGia;
    }
    public String getMaXe() {
        return maXe;
    }
    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }
    public String getMaLoai() {
        return maLoai;
    }
    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
    public String getSoKhung() {
        return soKhung;
    }
    public void setSoKhung(String soKhung) {
        this.soKhung = soKhung;
    }
    public String getSoMay() {
        return soMay;
    }
    public void setSoMay(String soMay) {
        this.soMay = soMay;
    }
    public String getMauXe() {
        return MauXe;
    }
    public void setMauXe(String mauXe) {
        MauXe = mauXe;
    }
    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    @Override
    public String toString() {
        return "XeMay [maXe=" + maXe + ", maLoai=" + maLoai + ", soKhung=" + soKhung + ", soMay=" + soMay + ", MauXe="
                + MauXe + ", donGia=" + donGia + "]";
    }
}
