package com.studentDemo.pickCourse;

public class Students {
    private int id;
    private String name;
    private String major;
    private String courses;
    private int score;//选的学分
    private int score1;//应选学分

    public Students() {
    }

    public Students(int id, String name, String major, String courses, int score, int score1) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.courses = courses;
        this.score = score;
        this.score1 = score1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }
}

