package org.ranx.core.test;

import org.junit.*;
import org.ranx.core.*;

public class NodeExpressionFactoryTest extends Assert {

	@Before public void clearBefore() {
		RuntimeContext.current().clear();
	}
	
	@After public void clearAfter() {
		RuntimeContext.current().clear();
	}

	@Test public void add() throws InvalidOperation {
		Node n1 = new ValueNode(Value.of(123));
		Node n2 = new ValueNode(Value.of(456));
		Node n = NodeExpressionFactory.add(n1,  n2);
		n.eval();
		assertTrue(n1.isConnectedTo(n));
		assertTrue(n2.isConnectedTo(n));
		assertEquals(AddExpression.class, n.expression().getClass());
	}
	
	@Test public void subtract() throws InvalidOperation {
		Node n1 = new ValueNode(Value.of(123));
		Node n2 = new ValueNode(Value.of(456));
		Node n = NodeExpressionFactory.subtract(n1,  n2);
		n.eval();
		assertTrue(n1.isConnectedTo(n));
		assertTrue(n2.isConnectedTo(n));
		assertEquals(SubtractExpression.class, n.expression().getClass());
	}
	
	@Test public void multiply() throws InvalidOperation {
		Node n1 = new ValueNode(Value.of(123));
		Node n2 = new ValueNode(Value.of(456));
		Node n = NodeExpressionFactory.multiply(n1,  n2);
		n.eval();
		assertTrue(n1.isConnectedTo(n));
		assertTrue(n2.isConnectedTo(n));
		assertEquals(MultiplyExpression.class, n.expression().getClass());
	}
	
	@Test public void divide() throws InvalidOperation{
		Node n1 = new ValueNode(Value.of(123));
		Node n2 = new ValueNode(Value.of(456));
		Node n = NodeExpressionFactory.divide(n1,  n2);
		n.eval();
		assertTrue(n1.isConnectedTo(n));
		assertTrue(n2.isConnectedTo(n));
		assertEquals(DivideExpression.class, n.expression().getClass());
	}
}
