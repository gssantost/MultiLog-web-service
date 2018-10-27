package com.daos;

import com.entities.LogType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogTypeDAO extends DAO {

    public LogTypeDAO() throws ClassNotFoundException, SQLException { super(); }

    private String SELECT_ALL = "SELECT log_type.id_log_type, log_type.description FROM log_type";
    public List<LogType> getAll() throws SQLException {
        ResultSet rs = this.executeQuery(this.SELECT_ALL);
        List<LogType> list = new ArrayList<LogType>();
        while(rs.next()) {
            LogType logType = new LogType();
            logType.setId(rs.getInt("id_log_type"));
            logType.setDescription(rs.getString("description"));
            list.add(logType);
        }
        return list;
    }
    private String SELECT_BY_ID = "SELECT log_type.id_log_type, log_type.description FROM log_type WHERE log_type.id_log_type = ?";
    public LogType get(int id) throws SQLException {
        ResultSet rs = this.executeQuery(this.SELECT_BY_ID, id);
        LogType logType = new LogType();
        if(rs.next()) {
            logType.setId(rs.getInt("id_log_type"));
            logType.setDescription(rs.getString("description"));
        }
        return logType;
    }
}
