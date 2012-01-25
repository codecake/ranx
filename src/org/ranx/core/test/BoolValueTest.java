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

public class BoolValueTest extends Assert {

	@Test public void ctor1() {
		BoolValue v = new BoolValue();
		assertEquals(false, v.get());
	}

	@Test public void ctor2() {
		BoolValue v = new BoolValue(true);
		assertEquals(true, v.get());
	}

	@Test public void type() {
		BoolValue v = new BoolValue(false);
		assertEquals(ValueType.TBool, v.type());
	}
	
	@Test public void canCastTo() {
		BoolValue v = new BoolValue(true);
		assertTrue(v.canCastTo(ValueType.TString));
		assertTrue(v.canCastTo(ValueType.TBool));
		assertFalse(v.canCastTo(ValueType.TInt));
		assertFalse(v.canCastTo(ValueType.TFloat));
	}
}
