package com.studentDemo.pickCourse;

public class Grade {
    private int id;
    private String cname;
    private double zong;
    private int psf;
    private int qz;
    private int qm;
    private double psfzb;
    private double qzzb;
    private double qmzb;

    public Grade() {
    }
    public Grade(int id,String cname,double zong, int psf, int qz, int qm, double psfzb, double qzzb, double qmzb)
    {
        this.id = id;
        this.cname = cname;
        this.zong = zong;
        this.psf = psf;
        this.qz = qz;
        this.qm = qm;
        this.psfzb = psfzb;
        this.qzzb = qzzb;
        this.qmzb = qmzb;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getcName() {
        return cname;
    }
    public void setcName(String cname) {
        this.cname = cname;
    }

    public double getZong() {
        return zong;
    }
    public void setZong(double zong) {
        this.zong = zong;
    }

    public int getPsf() {
        return psf;
    }
    public void setPsf(int psf) {
        this.psf = psf;
    }

    public int getQz() {
        return qz;
    }
    public void setQz(int qz) {
        this.qz = qz;
    }

    public int getQm() {
        return qm;
    }
    public void setQm(int qm) {
        this.qm = qm;
    }

    public double getPsfzb() {
        return psfzb;
    }
    public void setPsfzb(double psfzb) {
        this.psfzb = psfzb;
    }

    public double getQmzb() {
        return qmzb;
    }
    public void setQmzb(double qmzb) {
        this.qmzb = qmzb;
    }

    public double getQzzb() {
        return qzzb;
    }
    public void setQzzb(double qzzb) {
        this.qzzb = qzzb;
    }
}
