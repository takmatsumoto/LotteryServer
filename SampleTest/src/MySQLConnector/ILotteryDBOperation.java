/**
 * 
 */
package MySQLConnector;

import java.util.Map;

import MySQLConnector.ILotteryDBCommandLine;

/**
 * @author takmatsumoto
 *
 */
public interface ILotteryDBOperation {

	/**
	 * 產生新的table
	 */
	public void operationMakeNewTable(Map<String, String> paramsMap);
	
	/**
	 * 
	 */
	public void operationInsertData(Map<String, String> paramsMap);
	
	/**
	 * 找尋需要的資料
	 * @param dbCommandLine
	 * @return csv format string
	 */
	public String operationSelectionData(Map<String, String> paramsMap);
}
