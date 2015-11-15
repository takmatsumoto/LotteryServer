/**
 * 
 */
package MySQLConnector;

import MySQLConnector.ILotteryDBCommandLine;

/**
 * @author takmatsumoto
 *
 */
public interface ILotteryDBOperation {

	/**
	 * 產生新的table
	 */
	public void operationMakeNewTable(ILotteryDBCommandLine dbCommandLine);
	
	/**
	 * 
	 */
	public void operationInsertData(ILotteryDBCommandLine dbCommandLine);
	
	/**
	 * 找尋需要的資料
	 * @param dbCommandLine
	 * @return csv format string
	 */
	public String operationSelectionData(ILotteryDBCommandLine dbCommandLine);
}
