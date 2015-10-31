/**
 * 
 */
package MySQLConnector;

/**
 * @author liuliwey
 *
 */
public interface ILotteryDataBaseOperation {
	
	/**
	 * 創建樂透資料庫
	 */
	public void createTable(String tableName);
	
	/**
	 * 插入樂透資料
	 */
	public void insertNumberData();
}
