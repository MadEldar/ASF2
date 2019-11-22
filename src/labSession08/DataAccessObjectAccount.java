package labSession08;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAccessObjectAccount implements DataAccessObject<Account> {
    @Override
    public boolean create(Account account) throws SQLException {
        String query = "insert into " + account.getTableName() + " (account_name, account_company, account_address)" +
                " values (\"" + account.getName() + "\", \"" + account.getWorkplace() + "\", \"" + account.getAddress() + "\")";
        return Connector.executeQuery(query) > 0;
    }

    @Override
    public int update(Account account) throws SQLException {
        String query = "update " + account.getTableName() + " set account_name=\"" + account.getName() + "\" account_company=\"" +
                account.getWorkplace() + "\" account_address=\"" + account.getAddress() + "\" where account_id like " + account.getId();
        return Connector.executeQuery(query);
    }

    @Override
    public int delete(Account account) throws SQLException {
        String query = "delete from " + account.getTableName() + " where account_id like " + account.getId();
        return Connector.executeQuery(query);
    }

    @Override
    public ArrayList<Account> read() throws SQLException {
        ResultSet result = Connector.findAccountByName("%");
        ArrayList<Account> list = new ArrayList<>();
        while (result.next()) {
            Account.accountId++;
            list.add(new Account(
                    result.getInt("account_id"),
                    result.getString("account_name"),
                    result.getString("account_company"),
                    result.getString("account_address"))
            );
        }
        return list;
    }

    @Override
    public Account find(Integer id) throws SQLException {
        ResultSet result = Connector.findAccountById(id);
        return new Account(
                result.getInt("account_id"),
                result.getString("account_name"),
                result.getString("account_company"),
                result.getString("account_address")
        );
    }
}
