package org.stepper.test;

import java.util.HashMap;

import org.stepper.control.AbstractTransactionalTask;
import org.stepper.exception.ComponentExecutionException;
import org.stepper.interfaces.ErrorHandler;

public class dummyComponent2 extends AbstractTransactionalTask {
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "DummyComponent2";
	}

	@Override
	public boolean execute(HashMap valueStack) throws ComponentExecutionException {
		/*if(valueStack.get("Name")!=null){
			System.out.println(" dummyComponent3 Found object:-> "+valueStack.get("Name"));
			System.out.println("");
		}*/
		System.out.println(valueStack.get("DummyComponent"));
		valueStack.put("DummyComponent2", "kapoor");
		throw new ComponentExecutionException(" dummyComponent2 dummy exception thrown");
//		System.out.println(getName()+ " execute called");
//		return true;
	}
	

	@Override
	public boolean rollBack(HashMap valueStack) {
		 System.out.println("Roll Back: dummyComponent2");
		return false;
	}

	@Override
	public ErrorHandler getErrorHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setErrorHandler(ErrorHandler errorHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getContinueOnError() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setContinueOnError(boolean continueOnError) {
		// TODO Auto-generated method stub
		
	}
	
}
