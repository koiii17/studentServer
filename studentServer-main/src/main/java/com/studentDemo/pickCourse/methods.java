package com.studentDemo.pickCourse;


import java.util.*;

import static com.studentDemo.pickCourse.TestSqlite.*;
import com.studentDemo.pickCourse.MyClass;

public class methods {


    // 增加学生基本信息
    public static Students addStudents() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的学号:");
        int id = sc.nextInt();
        Students s = new Students();
        s.setId(id);//设置学生id
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        s.setName(name);
        System.out.println("请输入学生的专业：");
        String major = sc.next();
        s.setMajor(major);

        s.setScore1(20);//应选学分：20分
        s.setScore(0);//初始学分 0分
        s.setCourses("");//初始课程 无
        //这里先不录入学生选的课程 这个放在一个独立的方法中
        //所选学分和应选学分同理。在上面的方法加以计算
        System.out.println("添加成功");
        TestSqlite.insertStu(s.getId(), s.getName(),
                s.getMajor(), s.getCourses(),
                s.getScore1(), s.getScore());
        return s;
    }

    //课程信息--课程编号，课程名称，学分，授课老师名，已选课人数，课程容量。
    public static Course addCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入课程编号:");
        int cid = sc.nextInt();
        Course s = new Course();
        s.setcId(cid);//设置课程id
        System.out.println("请输入课程名：");
        String cname = sc.next();
        s.setcName(cname);
        System.out.println("请输入上课时间：");

        System.out.println("请输入周几上课：");
        int zhou = sc.nextInt();
        s.setZhou(zhou);
        System.out.println("请输入第几节上课：");
        int jie = sc.nextInt();
        s.setJie(jie);
        String time = "周"+zhou+"  "+jie+"节";
        s.setTime(time);
        System.out.println("请输入上课地点：");
        String place = sc.next();
        s.setPlace(place);
        System.out.println("请输入课程的学分：");
        int score = sc.nextInt();
        s.setScore(score);
        System.out.println("请输入授课老师名字:");
        String teacher = sc.next();
        s.setTeacher(teacher);
        System.out.println("请输入课程最大容纳学生人数:");
        int total = sc.nextInt();
        s.setTotal(total);
        System.out.println("请输入是必修还是选修:");
        String bixuanxiu = sc.next();
        s.setBixuanxiu(bixuanxiu);
        //这这里先设置已选课人数为0已选课人数
        s.setMembers(0);

        TestSqlite.insertCou(s.getcId(), s.getcName(),
                s.getTime(), s.getPlace(),
                s.getScore(), s.getTeacher(),s.getMembers(),s.getTotal(),s.getBixuanxiu(),s.getZhou(),s.getJie());
        //这里先不录入学生选的课程 这个放在一个独立的方法中
        //所选学分和应选学分同理。在上面的方法加以计算
        System.out.println("添加成功");
        return s;
    }

    //3、学生选课（显示所有课程信息列表，录入学号，课程编号，即可以完成选课操作）
    //方法需要传入各个数组和集合 要反复调用！
    public static void Selectionbixiu() {
        Scanner sc = new Scanner(System.in);
        TestSqlite.readbixiucourse();
        TestSqlite.readstudents();
        System.out.println("请输入需要录入课程的学生学号，以录入所选课程：");
        Integer m = sc.nextInt();//定义一个整形 以匹配学生类中所要应用的学生
        System.out.println("请选择需要选择的课程编号：");
        Integer k = sc.nextInt();//定义一个整型 用于匹配

        String courseName = TestSqlite.selectOne("CouMessage", "cname", "cid=" + k, String.class);
        Integer courseCredit = TestSqlite.selectOne("CouMessage", "score", "cid=" + k, Integer.class);
        String studentCourses = TestSqlite.selectOne("StuMessage", "courses", "id='" + m + "'", String.class);
        Integer studentScore = TestSqlite.selectOne("StuMessage", "score", "id='" + m + "'", Integer.class);
        Integer courseMember = TestSqlite.selectOne("CouMessage", "members", "cid='" + k + "'", Integer.class);
        // 更新学生的课程信息和分数
        if (courseName != null && courseCredit != null && studentCourses != null && studentScore != null) {
            // 拼接新的课程信息和分数
            String newCourses = studentCourses + " " + courseName;
            int newScore = studentScore + courseCredit;
            int newcourseMember=courseMember+1;
            // 更新学生的课程和分数
            TestSqlite.changeOne("StuMessage", "courses", newCourses, "id='" + m + "'");
            TestSqlite.changeOne("StuMessage", "score", newScore, "id='" + m + "'");

            // 更新课程的选课人数
            TestSqlite.changeOne("CouMessage", "members", newcourseMember, "cid=" + k);

            System.out.println("选课成功！");
        } else {
            System.out.println("选课失败：无法找到对应的课程或学生信息。");
        }
    }

    public static void Selectionxuanxiu() {
        Scanner sc = new Scanner(System.in);
        TestSqlite.readxuanxiucourse();
        TestSqlite.readstudents();
        System.out.println("请输入需要录入课程的学生学号，以录入所选课程：");
        Integer m = sc.nextInt();//定义一个整形 以匹配学生类中所要应用的学生
        System.out.println("请选择需要选择的课程编号：");
        Integer k = sc.nextInt();//定义一个整型 用于匹配

        String courseName = TestSqlite.selectOne("CouMessage", "cname", "cid=" + k, String.class);
        Integer courseCredit = TestSqlite.selectOne("CouMessage", "score", "cid=" + k, Integer.class);
        String studentCourses = TestSqlite.selectOne("StuMessage", "courses", "id='" + m + "'", String.class);
        Integer studentScore = TestSqlite.selectOne("StuMessage", "score", "id='" + m + "'", Integer.class);
        Integer courseMember = TestSqlite.selectOne("CouMessage", "members", "cid='" + k + "'", Integer.class);
        // 更新学生的课程信息和分数
        if (courseName != null && courseCredit != null && studentCourses != null && studentScore != null) {
            // 拼接新的课程信息和分数
            String newCourses = studentCourses + " " + courseName;
            int newScore = studentScore + courseCredit;
            int newcourseMember=courseMember+1;
            // 更新学生的课程和分数
            TestSqlite.changeOne("StuMessage", "courses", newCourses, "id='" + m + "'");
            TestSqlite.changeOne("StuMessage", "score", newScore, "id='" + m + "'");

            // 更新课程的选课人数
            TestSqlite.changeOne("CouMessage", "members", newcourseMember, "cid=" + k);

            System.out.println("选课成功！");
        } else {
            System.out.println("选课失败：无法找到对应的课程或学生信息。");
        }
    }

    //添加学生的操作方法
    public static void add(Students[] student, List list1) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请录入学生信息：");
            student[list1.size()] = methods.addStudents();//通过集合的数量计数，往对应索引增加参数
            list1.add(student[list1.size()]);//往学生集合中存入学生数组的内容
            System.out.println("是否结束录入？结束请按0，按任意键继续录入：");
            int a = sc.nextInt();
            if (a == 0) {
                break;
            }
        }
    }

    //添加课程的操作方法
    public static void add1(Course[] course, List list) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请录入课程信息：");
            course[list.size()] = methods.addCourse();//从集合获取数组索引元素位置
            list.add(course[list.size()]);
            System.out.println("是否结束录入？结束请按0，按任意键继续录入：");
            int a = sc.nextInt();
            if (a == 0) {
                break;
            }
        }
    }



    //4、查询（输入学号，输出该学生学号、姓名，所选课程情况汇总列表，总学分总计，以及还需选修学分）
    public static void check() {
        Scanner sc = new Scanner(System.in);
        TestSqlite.readcourse();
        TestSqlite.readstudents();
        System.out.println("请输入需要录入课程的学生学号，以查询所选课程情况汇总列表，总学分总计，以及还需选修学分：");
        Integer m = sc.nextInt();//定义一个整形 以匹配学生类中所要应用的学生

        String Name = TestSqlite.selectOne("StuMessage", "name", "id=" + m, String.class);
        String Course = TestSqlite.selectOne("StuMessage", "courses", "id=" + m, String.class);
        Integer Credit = TestSqlite.selectOne("StuMessage", "score", "id=" + m, Integer.class);
        Integer needCredit = TestSqlite.selectOne("StuMessage", "score1", "id=" + m, Integer.class);
        Integer Id = TestSqlite.selectOne("StuMessage", "id", "id=" + m, Integer.class);
        if (Id != null && Name != null ) {
            String s = "学生学号：" + Id + " | 学生姓名：" + Name + " | 已选" + Credit + "分";
            String s1 = "所选课程：" + Course;
            String s2 = "还需选择学分" + (needCredit - Credit) + "分";
            System.out.println(s);//学生信息
            System.out.println(s1);//所选课程
            System.out.println(s2);//还需选择学分

        }
        else{
            System.out.println("查询失败：无法找到对应的课程或学生信息。");
        }

    }
    public static void checktable(){
        Scanner sc = new Scanner(System.in);
        TestSqlite.readstudents();
        System.out.println("请输入需要录入课程的学生学号，以查询这个学生的课表：");
        Integer m = sc.nextInt();//定义一个整形 以匹配学生类中所要应用的学生
        String Course = TestSqlite.selectOne("StuMessage", "courses", "id=" + m, String.class);
        String input = Course;
        String[] parts = input.split(" ");
        int count = parts.length;
        ArrayList<String> partList = new ArrayList<>();
        int i=1;
        for (String part : parts) {
            partList.add(part);
//            System.out.println(part);
            String a=part;
//            System.out.println(a);
            MyClass.cou[i]=a;
//            System.out.println(MyClass.cou[i]);
            i++;
        }
        for(int n=2;n<=count;n++) {
            String tableName1 = "CouMessage";
            String columnName1 = "zhou";
            String condition1 = "cname='" + MyClass.cou[n] + "'";
            String a = selectOne(tableName1, columnName1, condition1, String.class);
            String tableName2 = "CouMessage";
            String columnName2 = "zhou";
            String condition2 = "cname='" + MyClass.cou[n] + "'";
            String b = selectOne(tableName2, columnName2, condition2, String.class);
//            System.out.println(b);
//            Integer a = TestSqlite.selectOne("CouMessage", "zhou", "cname=" + MyClass.cou[n], Integer.class);
//            Integer b = TestSqlite.selectOne("CouMessage", "jie", "cname=" + MyClass.cou[n], Integer.class);
            MyClass.zhou[n]=a;
            MyClass.jie[n]=b;
//            System.out.println(a);
            System.out.println(MyClass.cou[n]+"  周"+MyClass.zhou[n]+"  第" +MyClass.jie[n]+"节");
        }


    }
    public static void addGrade()
    {
        TestSqlite.readcourse();
        TestSqlite.readstudents();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要录入成绩的学生学号：");
        Integer m = sc.nextInt();
        System.out.println("请选择需要选择的课程编号：");
        Integer k = sc.nextInt();
        Integer Id = TestSqlite.selectOne("StuMessage", "id", "id=" + m, Integer.class);
        String Name = TestSqlite.selectOne("StuMessage", "name", "id=" + m, String.class);
        String cName = TestSqlite.selectOne("CouMessage", "cname", "cid=" + k, String.class);
        if (Id != null && Name != null )
        {   MyClass.scg+=1;

            System.out.println("输入他的平时分成绩！");
            int psf = sc.nextInt();
            System.out.println("输入这门课的平时分占比！");
            double psfzb = sc.nextDouble();
            System.out.println("输入他的期中考试成绩！");
            int qz = sc.nextInt();
            System.out.println("输入这门课的平期中考试占比！");
            double qzzb = sc.nextDouble();
            System.out.println("输入他的期末考试成绩！");
            int qm = sc.nextInt();
            System.out.println("输入这门课的期末考试占比！");
            double qmzb = sc.nextDouble();
            double zong = psf * psfzb + qz * qzzb + qm * qmzb;
            Map<String, Object> values = new HashMap<>();
            boolean hasData = selectOne("GraMessage", "COUNT(*)", "stucougra IS NOT NULL", Integer.class) > 0;
            if(hasData=true)
            {
                Integer maxStucougra = selectOne("GraMessage", "MAX(stucougra)", null, Integer.class);
                values.put("stucougra",maxStucougra) ;
            }
            else {
                values.put("stucougra",MyClass.scg) ;
            }
            values.put("name", Name);
            values.put("cname", cName);
            values.put("psf", psf);
            values.put("psfzb", psfzb);
            values.put("qz", qz);
            values.put("qzzb", qzzb);
            values.put("qm", qm);
            values.put("qmzb", qmzb);
            values.put("zong", zong);
            addline("GraMessage", values);

        }

    }
    public static void deletestu(){

        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入要删除的id：");
        Integer c = sc2.nextInt();
        String condition = "id=" + c;
        TestSqlite.delete("StuMessage", condition);
    }
    public static void deletecou(){

        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入要删除的id：");
        Integer c = sc2.nextInt();
        String condition = "cid=" + c;
        TestSqlite.delete("CouMessage", condition);
    }
    public static void deletegra(){

        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入要删除的id：");
        Integer c = sc2.nextInt();
        String condition = "stucougra=" + c;
        TestSqlite.delete("GraMessage", condition);
    }
}
