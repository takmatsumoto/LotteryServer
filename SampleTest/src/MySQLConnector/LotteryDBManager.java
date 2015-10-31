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
	
	static final private String DB_TABLENAME_LOTTERY_539 = "Lottery539";
	static final private String DB_TABLENAME_LOTTERY_BIGLOTTERY = "LotteryBigLottery";
	static final private String DB_TABLENAME_LOTTERY_POWER38 = "LotteryPower38";
	static final private String DB_TABLENAME_LOTTERY_BIGFU = "LotteryBigFu";
	
	private String createdb539SQL = "CREATE TABLE " + DB_TABLENAME_LOTTERY_539 + " (" +			 	
		 							"year VARCHAR(4) " +
		 							", date  VARCHAR(10) " +
		 							", yearIndex     INTEGER " +
		 							", number1   VARCHAR(2)" +
		 							", number2  VARCHAR(2)" +
		 							", number3  VARCHAR(2)" +
		 							", number4  VARCHAR(2)" +
		 							", number5  VARCHAR(2)" +
		 							", totalIndex     INTEGER" +
		 							", CONSTRAINT keyIndex PRIMARY KEY (year,yearIndex)" + 
		 							")";
	
	private String createdbBigLotterySQL = 	"CREATE TABLE " + DB_TABLENAME_LOTTERY_BIGLOTTERY + " (" +			 	
											"year VARCHAR(4) " +
											", date  VARCHAR(10) " +
											", yearIndex     INTEGER " +
											", number1  VARCHAR(2)" +
											", number2  VARCHAR(2)" +
											", number3  VARCHAR(2)" +
											", number4  VARCHAR(2)" +
											", number5  VARCHAR(2)" +
											", number6  VARCHAR(2)" +
											", number7  VARCHAR(2)" +
											", totalIndex     INTEGER" +
											", CONSTRAINT keyIndex PRIMARY KEY (year,yearIndex)" + 
											")";
	
	private String createdbPower38SQL = 	"CREATE TABLE " + DB_TABLENAME_LOTTERY_POWER38 + " (" +			 	
											"year VARCHAR(4) " +
											", date  VARCHAR(10) " +
											", yearIndex     INTEGER " +
											", sec1number1  VARCHAR(2)" +
											", sec1number2  VARCHAR(2)" +
											", sec1number3  VARCHAR(2)" +
											", sec1number4  VARCHAR(2)" +
											", sec1number5  VARCHAR(2)" +
											", sec1number6  VARCHAR(2)" +
											", sec2number1  VARCHAR(2)" +
											", totalIndex     INTEGER" +
											", CONSTRAINT keyIndex PRIMARY KEY (year,yearIndex)" + 
											")";
	
	private String createdbBigFuSQL = 	"CREATE TABLE " + DB_TABLENAME_LOTTERY_BIGFU + " (" +			 	
										"year VARCHAR(4) " +
										", date  VARCHAR(10) " +
										", yearIndex     INTEGER " +
										", number1  VARCHAR(2)" +
										", number2  VARCHAR(2)" +
										", number3  VARCHAR(2)" +
										", number4  VARCHAR(2)" +
										", number5  VARCHAR(2)" +
										", number6  VARCHAR(2)" +
										", number7  VARCHAR(2)" +
										", totalIndex     INTEGER" +
										", CONSTRAINT keyIndex PRIMARY KEY (year,yearIndex)" + 
										")";
	

	public LotteryDBManager() {
		// TODO Auto-generated constructor stub
	}
	
	protected void createTable(String tableName) {
		
	}
	

}
