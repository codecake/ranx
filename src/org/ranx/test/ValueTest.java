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

public class ValueTest extends Assert {
	@Test public void isInt() {
		Value somethingInt = new IntValue(123);
		assertTrue(somethingInt.isInt());
		Value somethingNotInt = new FloatValue(456.786);
		assertFalse(somethingNotInt.isInt());
	}
	
	@Test public void isFloat() {
		Value somethingFloat = new FloatValue(456.789);
		assertTrue(somethingFloat.isFloat());
		Value somethingNotFloat = new StringValue("foobar");
		assertFalse(somethingNotFloat.isFloat());
	}
}
