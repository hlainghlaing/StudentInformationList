/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinformationlist.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import studentinformationlist.database.Database;
import studentinformationlist.model.Student;

/**
 *
 * @author Dell
 */
public class StudentDAO 
{
    public int saveStudents(Student student) throws SQLException
    {
        Connection conn=Database.getInstance().getConnection();
        String name=student.getName();
        String email=student.getEmail();
        String gender=student.getGender();
        Date dob=student.getDob();
        String sql="insert into students (name,email,gender,dob) values (?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(sql);
        stmt.setString(1,name);
        stmt.setString(2,email);
        stmt.setString(3, gender);
        stmt.setDate(4, dob);
        int row=stmt.executeUpdate();
        return row;
    }
    
    public List<Student> getStudents() throws SQLException
    {
        Connection conn=Database.getInstance().getConnection();
        String sql="select * from students";
        Statement stmt=conn.createStatement();
        ResultSet result=stmt.executeQuery(sql);
        List<Student> studentlist=new ArrayList<>();
        while(result.next()){
        
            int id=result.getInt("id");
            String name=result.getString("name");
            String email=result.getString("email");
            String gender=result.getString("gender");
            Date dob=result.getDate("dob");
            Student student=new Student(id,name,email,gender,dob);
            studentlist.add(student);
        }
        return studentlist;
    }
    
    public Student getStudentByID(int id) throws SQLException
    {
        Student student=null;
        Connection conn=Database.getInstance().getConnection();
        String sql="select * from students where id=?";
        PreparedStatement stmt=conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet result=stmt.executeQuery();
        if(result.next()){
            String name=result.getString("name");
        String email=result.getString("email");
        String gender=result.getString("gender");
        Date dob=result.getDate("dob");
        student=new Student(name,email,gender,dob);
        }
        return student;
    }
    
//    public int updateStudentInfo(Student student) throws SQLException
//    {
//         Connection conn=Database.getInstance().getConnection();
//         String sql="update students set name=?,email=?,gender=?,dob=? where id=?";
//         PreparedStatement stmt=conn.prepareStatement(sql);
//         stmt.setString(1,student.getName() );
//         stmt.setString(2, student.getEmail());
//         stmt.setString(3, student.getGender());
//         stmt.setDate(4, student.getDob());
//         stmt.setInt(5, student.getId());
//        return stmt.executeUpdate();  
//     }
    
    
    public int DeleteStudent(int id) throws SQLException
    {
        Connection conn=Database.getInstance().getConnection();
        String sql="delete from students where id=?";
        PreparedStatement stmt=conn.prepareStatement(sql);
        stmt.setInt(1, id);
        int row=stmt.executeUpdate();
        return row;
    }
}
