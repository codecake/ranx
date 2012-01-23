package org.ranx.core.test;

import org.junit.*;
import org.ranx.core.*;

public class NodeExpressionFactoryTest extends Assert {

	@Test public void add() {
		Node n1 = new ValueNode(Value.of(123));
		Node n2 = new ValueNode(Value.of(456));
		Node n = NodeExpressionFactory.add(n1,  n2);
		assertTrue(n1.isConnectedTo(n));
		assertTrue(n2.isConnectedTo(n));
		assertEquals(AddNodeExpression.class, n.expression().getClass());
	}
	
	@Test public void subtract() {
		Node n1 = new ValueNode(Value.of(123));
		Node n2 = new ValueNode(Value.of(456));
		Node n = NodeExpressionFactory.subtract(n1,  n2);
		assertTrue(n1.isConnectedTo(n));
		assertTrue(n2.isConnectedTo(n));
		assertEquals(SubtractNodeExpression.class, n.expression().getClass());
	}
	
	@Test public void multiply() {
		Node n1 = new ValueNode(Value.of(123));
		Node n2 = new ValueNode(Value.of(456));
		Node n = NodeExpressionFactory.multiply(n1,  n2);
		assertTrue(n1.isConnectedTo(n));
		assertTrue(n2.isConnectedTo(n));
		assertEquals(MultiplyNodeExpression.class, n.expression().getClass());
	}
	
	@Test public void divide() {
		Node n1 = new ValueNode(Value.of(123));
		Node n2 = new ValueNode(Value.of(456));
		Node n = NodeExpressionFactory.divide(n1,  n2);
		assertTrue(n1.isConnectedTo(n));
		assertTrue(n2.isConnectedTo(n));
		assertEquals(DivideNodeExpression.class, n.expression().getClass());
	}
}
