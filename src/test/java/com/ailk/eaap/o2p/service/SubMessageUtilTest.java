package com.ailk.eaap.o2p.service;

import java.io.IOException;
import java.io.Serializable;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQTempQueue;
import org.easymock.EasyMock;
import org.junit.*;

import static org.junit.Assert.*;

import org.springframework.jms.core.JmsTemplate;

/**
 * The class <code>SubMessageUtilTest</code> contains tests for the class <code>{@link SubMessageUtil}</code>.
 *
 * @generatedBy CodePro at 15-12-21 ����9:41
 * @author xiaoyuan
 * @version $Revision: 1.0 $
 */
public class SubMessageUtilTest {
	/**
	 * Run the SubMessageUtil() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@Test
	public void testSubMessageUtil_1()
		throws Exception {
		SubMessageUtil result = new SubMessageUtil();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Destination getDestination() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@Test
	public void testGetDestination_1()
		throws Exception {
		SubMessageUtil fixture = new SubMessageUtil();
		fixture.setDestination(new ActiveMQTempQueue());
		fixture.setJmsTemplate(new JmsTemplate());

		Destination result = fixture.getDestination();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the JmsTemplate getJmsTemplate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@Test
	public void testGetJmsTemplate_1()
		throws Exception {
		SubMessageUtil fixture = new SubMessageUtil();
		fixture.setDestination(new ActiveMQTempQueue());
		fixture.setJmsTemplate(new JmsTemplate());

		JmsTemplate result = fixture.getJmsTemplate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(4, result.getPriority());
		assertEquals(0L, result.getTimeToLive());
		assertEquals(null, result.getDefaultDestination());
		assertEquals(false, result.isExplicitQosEnabled());
		assertEquals(2, result.getDeliveryMode());
		assertEquals(0L, result.getReceiveTimeout());
		assertEquals(true, result.isMessageTimestampEnabled());
		assertEquals(null, result.getDefaultDestinationName());
		assertEquals(true, result.isMessageIdEnabled());
		assertEquals(-1L, result.getDeliveryDelay());
		assertEquals(false, result.isPubSubNoLocal());
		assertEquals(false, result.isPubSubDomain());
		assertEquals(null, result.getConnectionFactory());
		assertEquals(1, result.getSessionAcknowledgeMode());
		assertEquals(false, result.isSessionTransacted());
	}

	/**
	 * Run the Serializable receiverObjectMsg() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@Test
	public void testReceiverObjectMsg_1()
		throws Exception {
		SubMessageUtil fixture = EasyMock.createMock(SubMessageUtil.class);
		fixture.setDestination(new ActiveMQTempQueue());
		fixture.setJmsTemplate(new JmsTemplate());
		
		Serializable result = fixture.receiverObjectMsg();
		result=0;
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: ConnectionFactory must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at org.springframework.jms.connection.ConnectionFactoryUtils.doGetTransactionalSession(ConnectionFactoryUtils.java:280)
		//       at org.springframework.jms.core.JmsTemplate.execute(JmsTemplate.java:481)
		//       at org.springframework.jms.core.JmsTemplate.receiveSelected(JmsTemplate.java:754)
		//       at org.springframework.jms.core.JmsTemplate.receive(JmsTemplate.java:733)
		//       at com.ailk.eaap.o2p.service.SubMessageUtil.receiverObjectMsg(SubMessageUtil.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the Serializable receiverObjectMsg() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@Test
	public void testReceiverObjectMsg_2()
		throws Exception {
		SubMessageUtil fixture =EasyMock.createMock(SubMessageUtil.class);
		fixture.setDestination(new ActiveMQTempQueue());
		fixture.setJmsTemplate(new JmsTemplate());

		Serializable result = fixture.receiverObjectMsg();
		result=0;
		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: ConnectionFactory must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at org.springframework.jms.connection.ConnectionFactoryUtils.doGetTransactionalSession(ConnectionFactoryUtils.java:280)
		//       at org.springframework.jms.core.JmsTemplate.execute(JmsTemplate.java:481)
		//       at org.springframework.jms.core.JmsTemplate.receiveSelected(JmsTemplate.java:754)
		//       at org.springframework.jms.core.JmsTemplate.receive(JmsTemplate.java:733)
		//       at com.ailk.eaap.o2p.service.SubMessageUtil.receiverObjectMsg(SubMessageUtil.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the void sendObjectMsg(Serializable) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@Test
	public void testSendObjectMsg_1()
		throws Exception {
		SubMessageUtil fixture = EasyMock.createMock(SubMessageUtil.class);
		fixture.setDestination(new ActiveMQTempQueue());
		fixture.setJmsTemplate(new JmsTemplate());
		Serializable objectMsg = new IOException();

		fixture.sendObjectMsg(objectMsg);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: ConnectionFactory must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at org.springframework.jms.connection.ConnectionFactoryUtils.doGetTransactionalSession(ConnectionFactoryUtils.java:280)
		//       at org.springframework.jms.core.JmsTemplate.execute(JmsTemplate.java:481)
		//       at org.springframework.jms.core.JmsTemplate.send(JmsTemplate.java:569)
		//       at com.ailk.eaap.o2p.service.SubMessageUtil.sendObjectMsg(SubMessageUtil.java:52)
	}

	/**
	 * Run the void sendObjectMsg(Serializable) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@Test
	public void testSendObjectMsg_2()
		throws Exception {
		SubMessageUtil fixture = EasyMock.createMock(SubMessageUtil.class);
		fixture.setDestination(new ActiveMQTempQueue());
		fixture.setJmsTemplate(new JmsTemplate());
		Serializable objectMsg = new IOException();

		fixture.sendObjectMsg(objectMsg);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: ConnectionFactory must not be null
		//       at org.springframework.util.Assert.notNull(Assert.java:112)
		//       at org.springframework.jms.connection.ConnectionFactoryUtils.doGetTransactionalSession(ConnectionFactoryUtils.java:280)
		//       at org.springframework.jms.core.JmsTemplate.execute(JmsTemplate.java:481)
		//       at org.springframework.jms.core.JmsTemplate.send(JmsTemplate.java:569)
		//       at com.ailk.eaap.o2p.service.SubMessageUtil.sendObjectMsg(SubMessageUtil.java:52)
	}

	/**
	 * Run the void setDestination(Destination) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@Test
	public void testSetDestination_1()
		throws Exception {
		SubMessageUtil fixture = new SubMessageUtil();
		fixture.setDestination(new ActiveMQTempQueue());
		fixture.setJmsTemplate(new JmsTemplate());
		Destination destination = new ActiveMQTempQueue();

		fixture.setDestination(destination);

		// add additional test code here
	}

	/**
	 * Run the void setJmsTemplate(JmsTemplate) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@Test
	public void testSetJmsTemplate_1()
		throws Exception {
		SubMessageUtil fixture = new SubMessageUtil();
		fixture.setDestination(new ActiveMQTempQueue());
		fixture.setJmsTemplate(new JmsTemplate());
		JmsTemplate jmsTemplate = new JmsTemplate();

		fixture.setJmsTemplate(jmsTemplate);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 15-12-21 ����9:41
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SubMessageUtilTest.class);
	}
}