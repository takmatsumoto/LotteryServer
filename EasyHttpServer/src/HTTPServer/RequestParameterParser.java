package HTTPServer;
/**
 * 
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
/**
 * @category 處理client request的物件
 * @author takmatsumoto
 * @version 1.0
 * 
 * @deprecated
 * 		1.
 */
public class RequestParameterParser {

	private final String commandSpliter = "&";
	private final String parameterSpliter = "=";
	Map<String, String> commands = new HashMap<String,String>();
	
	
	
	/**
	 * 
	 */
	public RequestParameterParser(String parametersLine) {
		// TODO Auto-generated constructor stub
		String[] commands = parametersLine.split(commandSpliter);
		for (String command : commands) {
			String[] parameters = command.split(parameterSpliter);
			if	(parameters.length == 2) {
				this.commands.put(parameters[0], parameters[1]);
			}
		}
	}
	
	public String Description() {
		String resultString = "";
		Iterator it = commands.keySet().iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            String value = commands.get(key);
            resultString += "key: " + key + ", vaule: " + value + "\n";
        }
        return resultString;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		// TODO Auto-generated method stub

	}

}
