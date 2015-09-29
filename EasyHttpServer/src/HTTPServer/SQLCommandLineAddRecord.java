package HTTPServer;

import HTTPServer.ISQLCommandLineDescription;
import HTTPServer.SQLCommandLine;

public class SQLCommandLineAddRecord extends SQLCommandLine implements ISQLCommandLineDescription{

	public SQLCommandLineAddRecord(String paramsString) {
		// TODO Auto-generated constructor stub
		super(paramsString);
	}
	
	public String sql() {
		return "";
	}

}
