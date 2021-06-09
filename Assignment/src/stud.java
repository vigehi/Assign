import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class stud {
    Connection conn = null;

    public void connect() {
        Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="student";
        String username="postgres";
        String password="100ee20gg";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null){

                String Student_ID = null;
                String Student_Name = null;
                String Course = null;
                String Grades = null;
                String sql = "insert into student values ('"+Student_ID+"','"+Student_Name+"','"+Course+"','"+Grades+"')";
                Statement statement = connection.createStatement();
                int x = statement.executeUpdate(sql);
                Component saveButton = null;
                if(x==0){
                    JOptionPane.showMessageDialog(saveButton,"user exists");

                }
                else{
                    JOptionPane.showMessageDialog(saveButton,"insert succesful");
                }


                connection.close();


            }
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveData(String student_ID, String student_Name, String Course, String Grades) {
        String strSql = "INSERT INTO stud (student_ID, student_Name, Course, Grades) "
                + " VALUES ('" + student_ID
                + "', '" +  student_Name
                + "', '" + Course
                + "', '" + Grades + "');";
        System.out.println(strSql);

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(strSql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Vector readStudent() {
        Vector<Vector<String>> vData = new Vector<Vector<String>>();
        try  {
            String sqlStr = "SELECT student_ID, student_Name, Course "
                    + "FROM stud ORDER BY student_ID";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlStr);
            while (rs.next()) {
                Vector<String> vRow = new Vector<String>();
                vRow.add(rs.getString("student_ID"));
                vRow.add(rs.getString("student_Name"));
                vRow.add(rs.getString("course"));

                System.out.println(rs.getString("student_ID"));

                vData.add(vRow);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return vData;
    }
    public void close() {
        try {
            if(conn != null) conn.close();
            System.out.println("Closed the PostgreSQL server connection.");
        }

    catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
