 package org.stepper.control;

import java.util.HashMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.stepper.exception.ComponentExecutionException;
import org.stepper.interfaces.Task;

/**
 * Class Main is responsible for starting the app sequence.
 *
 * Author: Abhishek kapoor
 * 21 Jun, 2013
 */
public class Main {
	
//	private static Logger logger = Logger.getLogger(Main.class);
	/** The conf. */
private String conf=null;
	
	/** The app context. */
	private ClassPathXmlApplicationContext appContext;
	
	/** The value stack. */
	private HashMap<String,Object>  valueStack;
	
	/**
	 * Instantiates a new main.
	 *
	 * @param con the con
	 */
	//For multi-threaded sequence
	public Main(String con,HashMap<String,Object> valueStack){
		conf=con;
		this.valueStack=valueStack ;
		appContext = new ClassPathXmlApplicationContext(conf);
	}
	
	//For multi-threaded sequence
	public Main(String con,HashMap<String,Object> valueStack,ClassPathXmlApplicationContext appContext){
		conf=con;
		this.appContext=appContext;
		this.valueStack=valueStack ;
		}

	// For Single Sequence
	public Main(String con){
		conf=con;
		this.valueStack= new HashMap<String,Object>();
		appContext = new ClassPathXmlApplicationContext(conf);
	}
	
	// For single Sequence
	public Main(String con,ClassPathXmlApplicationContext appContext){
		conf=con;
		this.appContext = appContext;
	}
	
	
	
	public String getConf() {
		return conf;
	}


	public void setConf(String conf) {
		this.conf = conf;
	}


	public ClassPathXmlApplicationContext getAppContext() {
		return appContext;
	}


	public void setAppContext(ClassPathXmlApplicationContext appContext) {
		this.appContext = appContext;
	}


	public HashMap<String, Object> getValueStack() {
		return valueStack;
	}


	public void setValueStack(HashMap<String, Object> valueStack) {
		this.valueStack = valueStack;
	}


	
	
	/**
	 * Start will start the app sequence 
	 */
	public void start(){
		ApplicationSequence asq = (ApplicationSequence) appContext.getBean("AppSequence");
		try {
			asq.setValueStack(valueStack);
			asq.execute(valueStack);
		} catch(ComponentExecutionException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args) {
		HashMap valuseStack = new HashMap();
		Main mn  = new Main("ReportGenerator.xml");
		mn.start();
	}
	

}
