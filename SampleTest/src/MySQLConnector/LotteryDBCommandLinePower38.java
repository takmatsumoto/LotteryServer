package MySQLConnector;

import java.util.Map;

public class LotteryDBCommandLinePower38 implements ILotteryDBCommandLine {
	static final private String DB_TABLENAME_LOTTERY_POWER38 = "LotteryPower38";

	public LotteryDBCommandLinePower38() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String createTable(Map<String, String> paramsMap) {
		// TODO Auto-generated method stub
		String commandline = 	"CREATE TABLE " + DB_TABLENAME_LOTTERY_POWER38 + " (" +			 	
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
		return commandline;
	}

	@Override
	public String insertData(Map<String, String> paramsMap) {
		// TODO Auto-generated method stub
		String commandline = "insert into " + DB_TABLENAME_LOTTERY_POWER38 + "(year,date,yearIndex,sec1number1,sec1number2,sec1number3,sec1number4,sec1number5,sec1number6,sec2number1,totalIndex) " +
			      "values(?,?,?,?,?,?,?,?,?)";
		return commandline;
	}

	@Override
	public String selectData(Map<String, String> paramsMap) {
		// TODO Auto-generated method stub
		String commandline = "select * from " + DB_TABLENAME_LOTTERY_POWER38;
		return commandline;
	}

}
