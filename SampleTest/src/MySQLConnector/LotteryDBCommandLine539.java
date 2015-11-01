/**
 * 
 */
package MySQLConnector;

import java.util.Map;

/**
 * @author takmatsumoto
 *
 */
public class LotteryDBCommandLine539 implements ILotteryDBCommandLine {

	static final private String DB_TABLENAME_LOTTERY_539 = "Lottery539";
	
	/**
	 * 
	 */
	public LotteryDBCommandLine539() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see MySQLConnector.ILotteryDataBaseOperation#createTable(java.lang.String)
	 */
	@Override
	public String createTable(Map<String, String> paramsMap) {
		// TODO Auto-generated method stub
		String commandline = "CREATE TABLE " + DB_TABLENAME_LOTTERY_539 + " (" +			 	
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
		return commandline;
	}

	/* (non-Javadoc)
	 * @see MySQLConnector.ILotteryDataBaseOperation#insertNumberData(java.util.Map)
	 */
	@Override
	public String insertData(Map<String, String> paramsMap) {
		// TODO Auto-generated method stub
		String commandline = "insert into " + DB_TABLENAME_LOTTERY_539 + "(year,date,yearIndex,number1,number2,number3,number4,number5,totalIndex) " +
			      "values(?,?,?,?,?,?,?,?,?)";
		return commandline;
	}

	/* (non-Javadoc)
	 * @see MySQLConnector.ILotteryDataBaseOperation#selectDataInCSVFormat(java.util.Map)
	 */
	@Override
	public String selectData(Map<String, String> paramsMap) {
		// TODO Auto-generated method stub
		String commandline = "select * from " + DB_TABLENAME_LOTTERY_539;
		return commandline;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
