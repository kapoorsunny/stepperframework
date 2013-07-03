package org.stepper.control;

import java.util.HashMap;
import java.util.List;

import org.stepper.exception.AppSequenceException;
import org.stepper.exception.ComponentExecutionException;
import org.stepper.interfaces.Task;

/**
 * 
 * @author Abhishek Kapoor
 *
 */
public abstract class AbstractApplicationSequence{
	
	private static String NAME="AbstractApplicationSequence";
	protected List<Task> taskSequence;
	

	
	public void setTaskSequence(List<Task> taskSequence) {
		this.taskSequence = taskSequence;
	}



	
	public List<Task> getTaskSequence() {
		return taskSequence;
	}




	public abstract String getName();
	
	protected abstract void start(HashMap<String, Object> valueStack) throws AppSequenceException ; 
	
	
	public boolean execute(HashMap ValueStack)throws ComponentExecutionException {
		boolean success = false;
		try {
			start(ValueStack);
			success = true;
		} catch (AppSequenceException e) {
			//e.printStackTrace();
			success = false;
			throw new ComponentExecutionException(e);
		}
		return success;
	}

	
	
}
