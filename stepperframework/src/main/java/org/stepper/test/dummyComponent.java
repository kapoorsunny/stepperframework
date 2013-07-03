package org.stepper.test;

import java.util.HashMap;

import org.stepper.control.AbstractTask;
import org.stepper.control.AbstractTransactionalTask;
import org.stepper.exception.ComponentExecutionException;

public class dummyComponent extends AbstractTask{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "DummyTask";
	}

	@Override
	public boolean execute(HashMap valueStack) throws ComponentExecutionException {
		
		valueStack.put("DummyComponent", new String("Abhishek"));
//		throw new ComponentExecutionException(" dummyComponent: dummy exception thrown");
//		System.out.println(getName()+ " execute called");
		return true;
	}
	



}
