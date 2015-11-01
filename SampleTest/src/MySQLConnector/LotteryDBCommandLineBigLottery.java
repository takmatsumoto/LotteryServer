/**
 * 
 */
package MySQLConnector;

import java.util.Map;

/**
 * @author liuliwey
 *
 */
public class LotteryDBCommandLineBigLottery implements ILotteryDBCommandLine {

	static final private String DB_TABLENAME_LOTTERY_BIGLOTTERY = "LotteryBigLottery";
	/**
	 * 
	 */
	public LotteryDBCommandLineBigLottery() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see MySQLConnector.ILotteryDBCommandLine#createTable(java.util.Map)
	 */
	@Override
	public String createTable(Map<String, String> paramsMap) {
		// TODO Auto-generated method stub
		String commandline = "CREATE TABLE " + DB_TABLENAME_LOTTERY_BIGLOTTERY + " (" +			 	
				"year VARCHAR(4) " +
				", date  VARCHAR(10) " +
				", yearIndex     INTEGER " +
				", number1   VARCHAR(2)" +
				", number2  VARCHAR(2)" +
				", number3  VARCHAR(2)" +
				", number4  VARCHAR(2)" +
				", number5  VARCHAR(2)" +
				", number6  VARCHAR(2)" +
				", number7  VARCHAR(2)" +
				", totalIndex     INTEGER" +
				", CONSTRAINT keyIndex PRIMARY KEY (year,yearIndex)" + 
				")";
	return commandline;
	}

	/* (non-Javadoc)
	 * @see MySQLConnector.ILotteryDBCommandLine#insertData(java.util.Map)
	 */
	@Override
	public String insertData(Map<String, String> paramsMap) {
		// TODO Auto-generated method stub
		String commandline = "insert into " + DB_TABLENAME_LOTTERY_BIGLOTTERY + "(year,date,yearIndex,number1,number2,number3,number4,number5,number6,number7,totalIndex) " +
			      "values(?,?,?,?,?,?,?,?,?)";
		return commandline;
	}

	/* (non-Javadoc)
	 * @see MySQLConnector.ILotteryDBCommandLine#selectData(java.util.Map)
	 */
	@Override
	public String selectData(Map<String, String> paramsMap) {
		// TODO Auto-generated method stub
		String commandline = "select * from " + DB_TABLENAME_LOTTERY_BIGLOTTERY;
		return commandline;
	}

}
