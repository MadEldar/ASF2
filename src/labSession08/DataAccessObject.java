package labSession08;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DataAccessObject <S>{
    boolean create(S s) throws SQLException;
    int update(S s) throws SQLException;
    int delete(S s) throws SQLException;
    ArrayList<S> read() throws SQLException;
    S find(Integer id) throws SQLException;
}
