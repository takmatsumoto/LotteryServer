/**
 * 
 */
package db;

/**
 * @author takmatsumoto
 *
 */
public class RunnableTest implements Runnable {

	/**
	 * 
	 */
	public RunnableTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void run () {
		System.out.println("Here is the starting point of Thread.");
        for (;;) { // infinite loop to print message
            System.out.println("User Created Thread");
        }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new RunnableTest()); // ����Thread����
        t.start(); // �}�l����Runnable.run();
        for (;;) {
            System.out.println("Main Thread");
        }
	}

}
