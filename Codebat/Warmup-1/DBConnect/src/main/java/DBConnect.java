import java.sql.*;
import java.util.Scanner;

public class DBConnect {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DBConnect dbConnect = new DBConnect();
        createConnection();

    }

    static void createConnection() {
        String host = "jdbc:mysql://localhost:3306/demo?serverTimezone=UTC";
        String uName = "root";
        String uPass = "password";
        CallableStatement myStmt = null;
        try {

            Connection con = DriverManager.getConnection(host, uName, uPass);

            PreparedStatement stat = con.prepareStatement("select * from employees");
            //   stat.setString(1, "Tomas");

            // stat.executeUpdate("INSERT INTO workers (First_Name,Second_Name,Job_Title) " + "VALUES ('Simpson', 'Tomas', 'Rolnik')");
            //  stat.executeUpdate("UPDATE workers SET First_Name='Andrzej', Second_Name='Duda' ,Job_Title='Prezydent' WHERE ID = 6");
            //   stat.executeQuery();

            String theDepartment = "Engineering";
            int theIncreaseAmount = 10000;


            ResultSet rs = stat.executeQuery();
            System.out.println("PRZED");
            System.out.println();

            while (rs.next()) {
                int id_col = rs.getInt("id");
                String last_name = rs.getString("last_name");
                String first_name = rs.getString("first_name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                float salary = rs.getFloat("salary");
                String p = id_col + " " + last_name + " " + first_name + " " + email + " " + department + " " + salary;
                System.out.println(p);
            }

            System.out.println();
            System.out.println("PO:");
            System.out.println();

            myStmt = con.prepareCall("{call increase_salaries_for_department(?,?)}");
            myStmt.setString(1, theDepartment);
            myStmt.setDouble(2, theIncreaseAmount);
            rs = myStmt.executeQuery();

            rs = stat.executeQuery();
            while (rs.next()) {
                int id_col = rs.getInt("id");
                String last_name = rs.getString("last_name");
                String first_name = rs.getString("first_name");
                String email = rs.getString("email");
                String department = rs.getString("department");
                float salary = rs.getFloat("salary");
                String p = id_col + " " + last_name + " " + first_name + " " + email + " " + department + " " + salary;
                System.out.println(p);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

}
