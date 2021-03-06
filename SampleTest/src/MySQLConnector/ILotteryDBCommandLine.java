/**
 * 
 */
package MySQLConnector;

import java.util.Map;

/**
 * @author liuliwey
 *
 */
public interface ILotteryDBCommandLine {
	
	/**
	 * 創建樂透資料庫
	 */
	public String createTable();
	
	/**
	 * 插入樂透資料
	 */
	public String insertData();
	
	/**
	 * 
	 * @param paramsMap 指令及
	 * @return 搜尋結果組合成的CSV檔案
	 */
	public String selectData();
}
