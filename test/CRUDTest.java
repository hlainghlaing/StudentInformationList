/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import studentinformationlist.dao.StudentDAO;
import studentinformationlist.model.Student;

/**
 *
 * @author Dell
 */
public class CRUDTest {
    
    public CRUDTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//    StudentDAO stdao=new StudentDAO();
//     @Test
//     public void testgetStudentByID() throws SQLException {
//     assertEquals("Hlaing", stdao.getStudentByID(1).getName());
//     }
//@Test
//    public void testupdating() throws SQLException{
//        StudentDAO stdao=new StudentDAO();
//        Student st=stdao.getStudentByID(3);
//        st.setEmail("emaillll@gmail.com");
//        assertEquals(1,stdao.updateStudentInfo(st));
//
//    }
}
