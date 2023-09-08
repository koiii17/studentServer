package com.studentDemo.pickCourse;

import com.studentDemo.pickCourse.TestSqlite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.studentDemo.pickCourse.methods.*;

public class Main {
    public static void main(String[] args) {
        TestSqlite.initialize();
        Connection connection = TestSqlite.getConnection();
        Scanner sc = new Scanner(System.in);
        Students student[] = new Students[100];//创建学生类数组用于存放学生信息
        Grade grade[][]=new Grade[100][100];
        List list = new ArrayList();//创建一个集合，用于存放课程信息的数组,无长度限制！！

        List list1 = new ArrayList();//创建一个集合，用于存放学生信息的数组,无长度限制！！

        List list2 = new ArrayList();//创建一个集合，用于存放学生所选的课程
        List list3 = new ArrayList();

        Course course[] = new Course[100];//创建课程类数组用于存放课程


        boolean exitProgram = false;
        boolean returnToMainMenu = false;  // 新增变量用于控制返回登录界面
        while (!exitProgram) {
            if (returnToMainMenu) {
                returnToMainMenu = false;  // 重置变量值，以便后续循环
            } else {
                //主界面编写
                System.out.println("---------登录界面---------");
                System.out.println("\t\t1.我是管理员     \t");
                System.out.println("\t\t2.我是学生    \t");
                System.out.println("\t\t3.退出程序    \t");
                String choose = sc.next();
                switch (choose)
                {
                    case "1" ->
                    {
                        System.out.println("\t\t1.录入学生信息     \t");
                        System.out.println("\t\t2.录入课程信息    \t");
                        System.out.println("\t\t3.查询学生选课信息\t");
                        System.out.println("\t\t4.录入成绩\t");
                        System.out.println("\t\t5.删除学生\t");
                        System.out.println("\t\t6.删除课程\t");
                        System.out.println("\t\t7.返回上一级\t");
                        System.out.println("-----\t请输入你需要的操作：\t----");
                        String choose1 = sc.next();
                        switch (choose1)
                        {
                            case "1" -> add(student, list1);//1.录入学生信息   传入学生数组还有学生信息集合
                            case "2" -> add1(course, list);//2.录入课程信息   传入课程数组还有课程信息集合
                            case "3" -> check();//4.查询学生选课信息 把所有集合和数组传入
                            case "4" -> addGrade();
                            case "5" -> deletestu();
                            case "6" -> deletecou();
                            case "8" -> deletegra();
                            case "7" -> returnToMainMenu = true;  // 设置变量以返回登录界面
                            default -> System.out.println("没有该选项！！请重新输入：");
                        }

                    }

                    case "2" ->
                    {
                        System.out.println("---------学生选课系统---------");
                        System.out.println("\t\t1.学生选课界面\t");
                        System.out.println("\t\t2.查看课程表\t");
                        System.out.println("\t\t3.查询学生选课信息\t");
                        System.out.println("\t\t4.返回上一级\t");
                        System.out.println("-----\t请输入你需要的操作：\t----");
                        String choose2 = sc.next();
                        switch (choose2)
                        {
                            case "1" ->
                            {
                                System.out.println("\t\t1.选必修课     \t");
                                System.out.println("\t\t2.选选修课    \t");
                                String choose3 = sc.next();
                                switch (choose3)
                                {
                                    case"1"->Selectionbixiu();
                                    case"2"->Selectionxuanxiu();
                                    default -> System.out.println("没有该选项！！请重新输入：");
                                }
                            }
                            case "2" -> checktable();
                            case "3" -> check();
                            case "4" -> returnToMainMenu = true;  // 设置变量以返回登录界面
                            default -> System.out.println("没有该选项！！请重新输入：");
                        }
                    }
                    case "3" -> {
                        System.out.println("成功退出！");
                        exitProgram = true; // 设置为 true 以退出整个循环
                    }

                    default -> System.out.println("没有该选项！！请重新输入：");
                }
            }
        }
        TestSqlite.closeConnection();
    }

}