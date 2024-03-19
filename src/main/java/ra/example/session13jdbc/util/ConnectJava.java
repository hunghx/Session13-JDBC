package ra.example.session13jdbc.util;

import ra.example.session13jdbc.model.Student;

import java.sql.*;

public class ConnectJava {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASS = "hung18061999";


    public static void main(String[] args) {
        Connection conn = openConnection();
        System.out.println(conn);
        Student s = new Student(1,"hung",18,true);
        System.out.println(s.getName());


        // câu truy vấn tĩnh
//        try {
//            Statement statement = conn.createStatement();

            // thêm mới
//            int count = statement.executeUpdate("insert into student(name, age, sex) value ('Nguyễn Văn A',18,true)");
//            System.out.println("count" + count);
            // lâấy ra
//            ResultSet rs = statement.executeQuery("select * from student where ... or 1=1");
//            while (rs.next()){
//                String name = rs.getString("name");
//                int id = rs.getInt("id");
//                int age = rs.getInt("age");
//                boolean sex = rs.getBoolean("sex");
//                System.out.printf("ID : %s | Name : %s | age: %s | sex : %s \n",id,name,age,(sex?"nam":"nữ"));
//            }


//
//            PreparedStatement preparedStatement = conn.prepareStatement("select * from student where id = ?");
//            // truyền đôi số
//            preparedStatement.setInt(1,2);
            // lấy theo id
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()){
//                String name = rs.getString("name");
//                int id = rs.getInt("id");
//                int age = rs.getInt("age");
//                boolean sex = rs.getBoolean("sex");
//                System.out.printf("ID : %s | Name : %s | age: %s | sex : %s \n",id,name,age,(sex?"nam":"nữ"));
//            }
//
//            // Callable Statement
//            CallableStatement callSt = conn.prepareCall("{call proc_update(?,?,?,?)}");
//            callSt.setInt(1,1);
//            callSt.setString(2,"Nguyễn Văn B");
//            callSt.setInt(3,100);
//            callSt.setBoolean(4,true);
//            callSt.executeUpdate();

//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            closeConnection(conn);
//        }
    }

    // mở kết nối
    public static Connection openConnection(){
        Connection conn = null;
        // B1 đăng kí driver
        try {
            Class.forName(DRIVER);
            //B2 ở kết nối
            conn = DriverManager.getConnection(URL,USER,PASS);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection conn){
        try {
            if (!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
