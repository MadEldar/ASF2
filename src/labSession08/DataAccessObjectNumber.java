package labSession08;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataAccessObjectNumber implements DataAccessObject<PhoneNumber> {
    @Override
    public boolean create(PhoneNumber phoneNumber) throws SQLException {
        String query = "insert into "+phoneNumber.getTableName()+"(phone_id, phone_type, phone_owner) values " +
                "("+phoneNumber.getNumber()+","+phoneNumber.getType()+","+phoneNumber.getOwner()+")";
        return Connector.executeQuery(query) > 0;
    }

    @Override
    public int update(PhoneNumber phoneNumber) throws SQLException {
        String query = "update "+phoneNumber.getTableName()+" set phone_type=" + phoneNumber.getType() +
                " where phone_id like " + phoneNumber.getNumber();
        return Connector.executeQuery(query);
    }

    @Override
    public int delete(PhoneNumber phoneNumber) throws SQLException {
        String query = "delete from "+phoneNumber.getTableName()+" where phone_id like "+phoneNumber.getNumber();
        return Connector.executeQuery(query);
    }

    @Override
    public ArrayList<PhoneNumber> read() throws SQLException {
        ResultSet result = Connector.findPhoneByAccount("%");
        ArrayList<PhoneNumber> list = new ArrayList<>();
        while (result.next()) {
            list.add(new PhoneNumber(
                    result.getInt("phone_id"),
                    result.getString("phone_type"),
                    result.getInt("phone_owner"))
            );
        }
        return list;
    }

    @Override
    public PhoneNumber find(Integer id) throws SQLException {
        ResultSet result = Connector.findPhoneById(id);
        return new PhoneNumber(
                result.getInt("phone_id"),
                result.getString("phone_type"),
                result.getInt("phone_owner")
        );
    }
}
