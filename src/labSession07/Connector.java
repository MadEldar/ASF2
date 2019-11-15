package labSession07;

import java.sql.*;

public class Connector {
    private Connection connector;

    private static Connector cnt;

    static {
        try {
            cnt = new Connector();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private Connector() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/phone_list";
        String username = "root";
        String password = "";
        connector = DriverManager.getConnection(url, username, password);
    }

    public static Connection connect() {
        return cnt.connector;
    }

    public static ResultSet findAccountById(Integer accountId) throws SQLException {
        PreparedStatement stm = cnt.connector.prepareStatement("select * from account where account_id like ?");
        stm.setInt(1, accountId);
        return stm.executeQuery();
    }

    public static ResultSet findAccountByName(String accountName) throws SQLException {
        PreparedStatement stm = cnt.connector.prepareStatement("select * from account where account_name like ?");
        stm.setString(1, accountName);
        return stm.executeQuery();
    }

    public static ResultSet findPhoneById(Integer accountId) throws SQLException {
        PreparedStatement stm = cnt.connector.prepareStatement("select * from phone_list where phone_owner like ?");
        stm.setInt(1, accountId);
        return stm.executeQuery();
    }

    public static ResultSet findPhoneByName(String accountName) throws SQLException {
        PreparedStatement stm = cnt.connector.prepareStatement(
                "select * from phone_list where phone_owner like " +
                        "(select account_name from account where account_name like ?)"
        );
        stm.setString(1, accountName);
        return stm.executeQuery();
    }
}
