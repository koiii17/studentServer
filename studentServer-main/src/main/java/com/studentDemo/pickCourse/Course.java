package com.studentDemo.pickCourse;

public class Course {
    private int id;
    private String cname;
    private String time;
    private int zhou;
    private int jie;
    private String place;
    private int score;
    private String Teacher;
    private int members;//已选课人数
    private int total;//最大容纳学生人数
    private String bixuanxiu;

    public Course() {
    }

    public Course(int id, String cname, int score, String teacher, int members, int total) {
        this.id = id;
        this.cname = cname;
        this.score = score;
        Teacher = teacher;
        this.members = members;
        this.total = total;
    }

    public int getcId() {
        return id;
    }
    public void setcId(int id) {
        this.id = id;
    }

    public String getcName() {
        return cname;
    }
    public void setcName(String name) {
        this.cname = name;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public int getZhou() {
        return zhou;
    }
    public void setZhou(int zhou) {
        this.zhou = zhou;
    }

    public int getJie() {
        return jie;
    }
    public void setJie(int jie) {
        this.jie = jie;
    }

    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String getTeacher() {
        return Teacher;
    }
    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public int getMembers() {
        return members;
    }
    public void setMembers(int members) {
        this.members = members;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    public String getBixuanxiu() {
        return bixuanxiu;
    }
    public void setBixuanxiu(String bixuanxiu) {
        this.bixuanxiu = bixuanxiu;
    }
}
