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

package org.ranx.core.test;

import org.ranx.core.*;
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
	
	@Test public void castToBool() throws InvalidCast {
		IntValue v = new IntValue(456);
		Value r = v.castTo(ValueType.TBool);
		assertNotNull(r);
		assertEquals(ValueType.TBool, r.type());
		BoolValue result = (BoolValue) r;
		assertEquals(true, result.get());
	}
	
}
