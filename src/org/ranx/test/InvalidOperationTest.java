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

public class InvalidOperationTest extends Assert {

	@Test public void testCtor1() {
		try {
			throw new InvalidOperation();
		} catch (InvalidOperation e) {
			assertEquals(null, e.getMessage());
			assertEquals(null, e.getCause());
		}
	}
	
	@Test public void testCtor2() {
		try {
			throw new InvalidOperation("foo");
		} catch (InvalidOperation e) {
			assertEquals("foo", e.getMessage());
			assertEquals(null, e.getCause());
		}
	}

	@Test public void testCtor3() {
		try {
			Exception e = new Exception("bar");
			throw new InvalidOperation("foo", e);
		} catch (InvalidOperation e) {
			assertEquals("foo", e.getMessage());
			assertEquals("bar", e.getCause().getMessage());
		}
	}
	
	@Test public void testCtor4() {
		try {
			Exception e = new Exception("bar");
			throw new InvalidOperation(e);
		} catch (InvalidOperation e) {
			assertEquals("java.lang.Exception: bar", e.getMessage());
			assertEquals("bar", e.getCause().getMessage());
		}
	}
}
