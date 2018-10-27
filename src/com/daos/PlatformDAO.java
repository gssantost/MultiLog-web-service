package com.daos;

import com.entities.Platform;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlatformDAO extends DAO {

    public PlatformDAO() throws SQLException, ClassNotFoundException { super(); }

    private String SELECT_ALL = "SELECT platform.id_platform, platform.description FROM platform";
    public List<Platform> getAll() throws SQLException {
        ResultSet rs = this.executeQuery(this.SELECT_ALL);
        List<Platform> list = new ArrayList<Platform>();
        while(rs.next()) {
            Platform platform = new Platform();
            platform.setId(rs.getInt("id_platform"));
            platform.setDescription(rs.getString("description"));
            list.add(platform);
        }
        return list;
    }
    private String SELECT_BY_DESCRIPTION = "SELECT platform.id_platform, platform.description FROM platform WHERE platform.description = ?";
    public Platform get(String description) throws SQLException {
        ResultSet rs = this.executeQuery(this.SELECT_BY_DESCRIPTION, description);
        Platform platform = new Platform();
        if(rs.next()) {
            platform.setId(rs.getInt("id_log_type"));
            platform.setDescription(rs.getString("description"));
        }
        return platform;
    }
}
