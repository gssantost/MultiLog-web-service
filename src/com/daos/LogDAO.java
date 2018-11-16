package com.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entities.Log;

public class LogDAO extends DAO {

	public LogDAO() throws ClassNotFoundException, SQLException { super(); }

	private String INSERT = "INSERT INTO log (description, status_code, module, date, url, id_log_type, id_platform)" +
			" VALUES (?, ?, ?, now(), ?, ?, ?) RETURNING *;";
	/*public Boolean addLog(Log log) throws SQLException {
		return this.executeUpdate(this.INSERT,
				log.getDescription(),
				log.getCode(),
				log.getModule(),
				log.getUrl(),
				log.getLogType(),
				log.getPlatform()
		) == 1;
	}*/
	public Log addLog(Log log) throws SQLException {
		ResultSet rs = this.executeUpdateAndReturn(this.INSERT,
				log.getDescription(),
				log.getCode(),
				log.getModule(),
				log.getUrl(),
				log.getLogType(),
				log.getPlatform());
		return fillLog(rs);
	}

	private String DELETE = "DELETE FROM log WHERE log.id_log = ?;";
	public Boolean deleteLog(int id) throws SQLException {
		return this.executeUpdate(this.DELETE, id) == 1;
	}

	private String SELECT_ALL = "SELECT * FROM log";
	public List<Log> getAll() throws SQLException {
		ResultSet rs = this.executeQuery(this.SELECT_ALL);
		return fillLogs(rs);
	}

	private String SELECT_BY_DATE = "SELECT * FROM log WHERE log.date::date = to_date(?,'YYYY/MM/DD');";
	public List<Log> get(String date) throws SQLException {
		ResultSet rs = this.executeQuery(this.SELECT_BY_DATE, date);
		return fillLogs(rs);
	}

	private String SELECT_BETWEEN_DATES = "SELECT * FROM log WHERE log.date::date BETWEEN " +
			"to_date(?,'YYYY/MM/DD') AND to_date(?,'YYYY/MM/DD')";
	public List<Log> get(String dateFrom, String dateTo) throws SQLException {
		ResultSet rs = this.executeQuery(this.SELECT_BETWEEN_DATES, dateFrom, dateTo);
		return fillLogs(rs);
	}

	private String SELECT_HOUR = "SELECT * FROM log WHERE log.date BETWEEN to_timestamp(?, " +
			"'YYYY/MM/DD HH24') AND to_timestamp(?, 'YYYY/MM/DD HH24')";
	public List<Log> get(String date, int hour) throws SQLException {
		String from = date + " " + hour;
		String to = date + " " + (hour + 1);
		ResultSet rs = this.executeQuery(this.SELECT_HOUR, from, to);
		return fillLogs(rs);
	}

	private String SELECT_MINUTE = "SELECT * FROM log WHERE log.date BETWEEN to_timestamp(?, " +
			"'YYYY/MM/DD HH24:MI') AND to_timestamp(?, 'YYYY/MM/DD HH24:MI')";
	public List<Log> get(String date, int hour, int minute) throws SQLException {
		String from = date + " " + hour + ":" + minute;
		String to = date + " " + hour + ":" + (minute + 1);
		ResultSet rs = this.executeQuery(this.SELECT_MINUTE, from, to);
		return fillLogs(rs);
	}

	private String SELECT_SECOND = "SELECT * FROM log WHERE log.date BETWEEN to_timestamp(?, " +
			"'YYYY/MM/DD HH24:MI:SS') AND to_timestamp(?, 'YYYY/MM/DD HH24:MI:SS')";
	public List<Log> get(String date, int hour, int minute, int second) throws SQLException {
		String from = date + " " + hour + ":" + minute + ":" + second;
		String to = date + " " + hour + ":" + minute + ":" + (second + 1);
		ResultSet rs = this.executeQuery(this.SELECT_SECOND, from, to);
		return fillLogs(rs);
	}

	public List<Log> fillLogs(ResultSet rs) throws SQLException {
		List<Log> list = new ArrayList<>();
		while(rs.next()) {
			Log log = new Log();
			log.setId(rs.getInt("id_log"));
			log.setPlatform(rs.getInt("id_platform"));
			log.setLogType(rs.getInt("id_log_type"));
			log.setDescription(rs.getString("description"));
			log.setCode(rs.getInt("status_code"));
			log.setModule(rs.getString("module"));
			log.setDate(rs.getTimestamp("date").getTime());
			log.setUrl(rs.getString("url"));
			list.add(log);
		}
		return list;
	}

	public Log fillLog(ResultSet rs) throws SQLException {
		Log log = new Log();
		while (rs.next()) {
			log.setId(rs.getInt("id_log"));
			log.setPlatform(rs.getInt("id_platform"));
			log.setLogType(rs.getInt("id_log_type"));
			log.setDescription(rs.getString("description"));
			log.setCode(rs.getInt("status_code"));
			log.setModule(rs.getString("module"));
			log.setDate(rs.getTimestamp("date").getTime());
			log.setUrl(rs.getString("url"));
		}
		return log;
	}

	//TEST METHOD
	private String SELECT_BY_STATUS = "SELECT description FROM log WHERE status_code = ?";
	public String getLogByStatus(int statusCode) throws SQLException {
		String resp = null;
		ResultSet rs = this.executeQuery(SELECT_BY_STATUS, statusCode);
		while (rs.next()) {
			resp = rs.getString("description");
		}
		return resp;
	}

}
