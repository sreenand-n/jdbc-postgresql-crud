import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws Exception {

         /*
            import package
            load and register driver
            create connection
            create statement
            execute statement
            process the results
            close
         */

        int sid = 103;
        String sname = "John";
        int marks = 89;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "1";
//        String sql = "select * from student";
//        String sql = "insert into student values (6, 'Adam', 90)";
//        String sql = "update student set sname = 'Max' where sid = 5";

//        String sql = "delete from student where sid = 6";

        String sql = "insert into student values (?, ?, ?)";

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection Established");
//        Statement st = con.createStatement();
        // ResultSet rs = st.executeQuery(sql);
        // System.out.println(rs.next());
        // rs.next();
        // String name = rs.getString("sname");
        // System.out.println("Name of student is " + name);

//        while(rs.next()){
//            System.out.print(rs.getInt(1) + " - ");
//            System.out.print(rs.getString(2) + " - ");
//            System.out.println(rs.getInt(3));
//        }

//        boolean status = st.execute(sql);
//        System.out.println(status);

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, marks);

        st.execute();

        con.close();
        System.out.println("Connection closed");
    }
}
