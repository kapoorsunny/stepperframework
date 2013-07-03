package org.stepper.control;

import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.stepper.exception.ComponentExecutionException;

public class ApplicationSequenceTest {
	
	ApplicationSequence asq;
	private ClassPathXmlApplicationContext appContext;
	private HashMap ValueStack;
	@Before
	public void setUp() throws Exception {
		appContext = new ClassPathXmlApplicationContext("ReportGenerator.xml");
		asq = (ApplicationSequence) appContext.getBean("AppSequence");
		ValueStack = new HashMap();
	}



	@Test
	public void testExecute() {
//		fail("Not yet implemented");
		try {
			asq.execute(ValueStack);
		} catch (ComponentExecutionException e) {
			fail("test failed");
		}
	}

}
