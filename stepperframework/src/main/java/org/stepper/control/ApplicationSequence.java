package org.stepper.control;

import java.util.HashMap;
import java.util.List;

import org.stepper.exception.AppSequenceException;
import org.stepper.interfaces.Task;
import org.stepper.interfaces.TransactionalTask;

public class ApplicationSequence extends AbstractApplicationSequence{
	private static String NAME="ApplicationSequence";
	private HashMap<String, Object> valueStack;

	public ApplicationSequence(List task) {
		this.taskSequence=task;
	}

	
	
	public HashMap<String, Object> getValueStack() {
		return valueStack;
	}



	public void setValueStack(HashMap<String, Object> valueStack) {
		this.valueStack = valueStack;
	}



	@Override
	protected void start(HashMap<String, Object> valueStack) throws AppSequenceException {
		Task tsk = null;
		TransactionalTask tTsk = null;
		if (taskSequence.get(taskSequence.size()-1) instanceof AbstractEndTask){

//			System.out.println("size "+ sequence.size());
		for (int i = 0; i <= taskSequence.size() - 1; i++) {
			Object comp = taskSequence.get(i);
			if (comp instanceof Task) {
				try {
					tsk = (Task) comp;
					tsk.execute(valueStack);
				} catch (Exception e) {
					e.printStackTrace();
					if (tsk.getContinueOnError()) {
						tsk.getErrorHandler().handle(valueStack);

					} else {
						throw new AppSequenceException("[Task:" + tsk.getName()	+ "]" + e.getMessage(), e);
					}
				}
			} 
		}
		}
		else{
			throw new AppSequenceException("[Task:" + this.NAME+ "]"+ "Please end the workflow with EndTask");
		}
		
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.NAME;
	}

}
