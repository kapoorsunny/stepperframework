package org.stepper.test;

import java.util.HashMap;

import org.stepper.control.AbstractEndTask;
import org.stepper.exception.ComponentExecutionException;

public class dummyEndComponent extends AbstractEndTask{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Dummy End Task";
	}

	@Override
	public boolean execute(HashMap valueStack)
			throws ComponentExecutionException {
		System.out.println("dummyEndComponent: Reached End task");
		return true;
	}



}
