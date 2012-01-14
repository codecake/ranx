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

public class FloatValueTest extends Assert {

	@Test public void ctor1() {
		FloatValue v = new FloatValue();
		assertEquals(0.0, v.get(), 0.00001);
	}

	@Test public void ctor2() {
		FloatValue v = new FloatValue(123.45);
		assertEquals(123.45, v.get(), 0.00001);
	}

	@Test public void type() {
		FloatValue v = new FloatValue(456.78);
		assertEquals(ValueType.TFloat, v.type());
	}

	@Test public void add() throws InvalidOperation {
		FloatValue lhs = new FloatValue(123.11);
		FloatValue rhs = new FloatValue(456.22);
		Value v = lhs.add(rhs);
		assertNotNull(v);
		assertEquals(ValueType.TFloat, v.type());
		FloatValue result = (FloatValue) v;
		assertEquals(579.33, result.get(), 0.00001);
	}
}
