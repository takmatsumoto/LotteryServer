package MySQLConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author liuliwey
 *
 * @version 0.0.1
 * 
 * 1.�����澈
 */

public abstract class LotteryDBManager {
	
	static final private String DBAdministrator = "root";
	static final private String DBRootPassword = "pm1101tak1226";
	static final private String DB_NAME = "LotteryDB";
	
		

	public LotteryDBManager() {
		// TODO Auto-generated constructor stub
	}
	
	protected void createTable(String tableName) {
		
	}
	

}
