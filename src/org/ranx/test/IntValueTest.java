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

public class IntValueTest extends Assert {

	@Test public void ctor1() {
		IntValue v = new IntValue();
		assertEquals(v.get(), 0);
	}
	
	@Test public void ctor2() {
		IntValue v = new IntValue(123);
		assertEquals(v.get(), 123);
	}
	
	@Test public void type() {
		IntValue v = new IntValue(456);
		assertEquals(ValueType.TInt, v.type());
	}
	
	@Test public void add() throws InvalidOperation {
		IntValue lhs = new IntValue(123);
		IntValue rhs = new IntValue(456);
		Value v = lhs.add(rhs);
		assertNotNull(v);
		assertEquals(ValueType.TInt, v.type());
		IntValue result = (IntValue) v;
		assertEquals(579, result.get());
	}

	@Test public void subtract() throws InvalidOperation {
		IntValue lhs = new IntValue(456);
		IntValue rhs = new IntValue(123);
		Value v = lhs.subtract(rhs);
		assertNotNull(v);
		assertEquals(ValueType.TInt, v.type());
		IntValue result = (IntValue) v;
		assertEquals(333, result.get());
	}

	@Test public void multiply() throws InvalidOperation {
		IntValue lhs = new IntValue(66);
		IntValue rhs = new IntValue(42);
		Value v = lhs.multiply(rhs);
		assertNotNull(v);
		assertEquals(ValueType.TInt, v.type());
		IntValue result = (IntValue) v;
		assertEquals(2772, result.get());
	}

	@Test public void divide() throws InvalidOperation {
		IntValue lhs = new IntValue(66);
		IntValue rhs = new IntValue(11);
		Value v = lhs.divide(rhs);
		assertNotNull(v);
		assertEquals(ValueType.TInt, v.type());
		IntValue result = (IntValue) v;
		assertEquals(6, result.get());
	}
	
	@Test public void canCastTo() {
		IntValue v = new IntValue(123);
		assertTrue(v.canCastTo(ValueType.TInt));
		assertTrue(v.canCastTo(ValueType.TFloat));
		assertTrue(v.canCastTo(ValueType.TBool));
		assertTrue(v.canCastTo(ValueType.TString));
	}
	
	@Test public void castToInt() throws InvalidCast {
		IntValue v = new IntValue(123);
		Value r = v.castTo(ValueType.TInt);
		assertNotNull(r);
		assertEquals(ValueType.TInt, r.type());
		IntValue result = (IntValue) r;
		assertEquals(123, result.get());
	}
	
	@Test public void castToFloat() throws InvalidCast {
		IntValue v = new IntValue(456);
		Value r = v.castTo(ValueType.TFloat);
		assertNotNull(r);
		assertEquals(ValueType.TFloat, r.type());
		FloatValue result = (FloatValue) r;
		assertEquals(456.0, result.get(), 0.00001);
	}

	@Test public void castToString() throws InvalidCast {
		IntValue v = new IntValue(456);
		Value r = v.castTo(ValueType.TString);
		assertNotNull(r);
		assertEquals(ValueType.TString, r.type());
		StringValue result = (StringValue) r;
		assertEquals("456", result.get());
	}
}
