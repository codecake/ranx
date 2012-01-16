/*
    ranx - general purpose reactive language
    Copyright (C) 2012  codec4ke@gmail.com

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.ranx.test;

import org.ranx.*;
import org.junit.*;

public class ValueOpsTest extends Assert {

	//
	// add
	// 
	
	@Test public void addInts() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(123);
		Value rhs = new IntValue(456);
		Value result = ValueOps.add(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isInt());
		assertEquals(579, result.toInt().get());
	}
	
	@Test public void addIntCastables() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(123);
		Value rhs = new StringValue("456");
		Value result = ValueOps.add(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isInt());
		assertEquals(579, result.toInt().get());		
	}
	
	@Test public void addFloats() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new FloatValue(456.78);
		Value result = ValueOps.add(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(580.23, result.toFloat().get(), 0.00001);
	}

	@Test public void addFloatCastables() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new StringValue("456.78");
		Value result = ValueOps.add(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(580.23, result.toFloat().get(), 0.00001);
	}

	@Test public void addFloatCastables2() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new IntValue(456);
		Value result = ValueOps.add(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(579.45, result.toFloat().get(), 0.00001);
	}
	
	@Test public void cannotAddStrings() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(123);
		Value rhs = new StringValue("abc");
		try {
			Value result = ValueOps.add(lhs, rhs);
			fail("added strings somehow");
		} catch(InvalidOperation e) {
			// expected
		}
	}

	//
	// subtract
	// 
	
	@Test public void subtractInts() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(123);
		Value rhs = new IntValue(456);
		Value result = ValueOps.subtract(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isInt());
		assertEquals(-333, result.toInt().get());
	}
	
	@Test public void subtractIntCastables() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(123);
		Value rhs = new StringValue("456");
		Value result = ValueOps.subtract(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isInt());
		assertEquals(-333, result.toInt().get());		
	}
	
	@Test public void subtractFloats() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new FloatValue(456.78);
		Value result = ValueOps.subtract(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(-333.33, result.toFloat().get(), 0.00001);
	}

	@Test public void subtractFloatCastables() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new StringValue("456.78");
		Value result = ValueOps.subtract(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(-333.33, result.toFloat().get(), 0.00001);
	}

	@Test public void subtractFloatCastables2() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new IntValue(456);
		Value result = ValueOps.subtract(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(-332.55, result.toFloat().get(), 0.00001);
	}
	
	@Test public void cannotSubtractStrings() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(123);
		Value rhs = new StringValue("abc");
		try {
			Value result = ValueOps.subtract(lhs, rhs);
			fail("subtracted strings somehow");
		} catch(InvalidOperation e) {
			// expected
		}
	}

	//
	// multiply
	// 
	
	@Test public void multiplyInts() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(123);
		Value rhs = new IntValue(456);
		Value result = ValueOps.multiply(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isInt());
		assertEquals(56088, result.toInt().get());
	}
	
	@Test public void multiplyIntCastables() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(123);
		Value rhs = new StringValue("456");
		Value result = ValueOps.multiply(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isInt());
		assertEquals(56088, result.toInt().get());		
	}
	
	@Test public void multiplyFloats() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new FloatValue(456.78);
		Value result = ValueOps.multiply(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(56389.491, result.toFloat().get(), 0.00001);
	}

	@Test public void multiplyFloatCastables() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new StringValue("456.78");
		Value result = ValueOps.multiply(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(56389.491, result.toFloat().get(), 0.00001);
	}

	@Test public void multiplyFloatCastables2() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new IntValue(456);
		Value result = ValueOps.multiply(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(56293.2, result.toFloat().get(), 0.00001);
	}
	
	@Test public void cannotMultiplyStrings() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(123);
		Value rhs = new StringValue("abc");
		try {
			Value result = ValueOps.multiply(lhs, rhs);
			fail("multiplied strings somehow");
		} catch(InvalidOperation e) {
			// expected
		}
	}

	//
	// divide
	// 
	
	@Test public void divideInts() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(456);
		Value rhs = new IntValue(123);
		Value result = ValueOps.divide(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isInt());
		assertEquals(3, result.toInt().get());
	}
	
	@Test public void divideIntCastables() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(456);
		Value rhs = new StringValue("123");
		Value result = ValueOps.divide(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isInt());
		assertEquals(3, result.toInt().get());		
	}
	
	@Test public void divideFloats() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new FloatValue(456.78);
		Value result = ValueOps.divide(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(0.270261395, result.toFloat().get(), 0.00001);
	}

	@Test public void divideFloatCastables() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new StringValue("456.78");
		Value result = ValueOps.divide(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(0.270261395, result.toFloat().get(), 0.00001);
	}

	@Test public void divideFloatCastables2() throws InvalidOperation, InvalidCast {
		Value lhs = new FloatValue(123.45);
		Value rhs = new IntValue(456);
		Value result = ValueOps.divide(lhs, rhs);
		assertNotNull(result);
		assertTrue(result.isFloat());
		assertEquals(0.270723684, result.toFloat().get(), 0.00001);
	}
	
	@Test public void cannotDivideStrings() throws InvalidOperation, InvalidCast {
		Value lhs = new IntValue(123);
		Value rhs = new StringValue("abc");
		try {
			Value result = ValueOps.divide(lhs, rhs);
			fail("divided strings somehow");
		} catch(InvalidOperation e) {
			// expected
		}
	}
	
}
