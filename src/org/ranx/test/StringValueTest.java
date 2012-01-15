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

public class StringValueTest extends Assert {

	private String[] validIntStrings = {
		"123",
		"  22",
		"33  ",
		"   456   ",
		"-123",
		"   -456"
	};
	
	private String[] invalidIntStrings = {
		"abc",
		"123a",
		"V123",
		"aa22bb",
		"11 22"
	};
	
	private String[] validFloatStrings = {
		"123",
		"  22",
		"33  ",
		"   456   ",
		"-123",
		"   -456",
		"123.45",
		"-456.78",
		"0.0",
		"0", 
		"1",
		"-1",
		"123.45e22",
		"123.67E-10",
		"-123.45e15"
	};

	private String[] invalidFloatStrings = {
		"abc",
		"123a",
		"V123",
		"aa22bb",
		"11 22",
		"123.45x55",
		"asb123.45"
	};

	@Test public void ctor1() {
		StringValue v = new StringValue();
		assertEquals("", v.get());
	}

	@Test public void ctor2() {
		StringValue v = new StringValue("foo");
		assertEquals("foo", v.get());
	}

	@Test public void type() {
		StringValue v = new StringValue("bar");
		assertEquals(ValueType.TString, v.type());
	}
	
	@Test public void canCastToInt() {
		for(String s : validIntStrings) {
			assertTrue(new StringValue(s).canCastToInt());
		}
		
		for(String s : invalidIntStrings) {
			assertFalse(new StringValue(s).canCastToInt());
		}
	}
	
	@Test public void castToInt() throws InvalidCast {
		for(String s : validIntStrings) {
			Value v = new StringValue(s).castToInt();
			assertEquals(ValueType.TInt, v.type());
			IntValue i = (IntValue) v;
			assertEquals(Integer.parseInt(s.trim()), i.get());
		}
		
		for(String s : invalidIntStrings) {
			try {
				Value v = new StringValue(s).castToInt();
				fail("Exception expected");
			} catch(InvalidCast e) {
				// expected
			}
		}
	}
	
	@Test public void canCastToFloat() {
		for(String s : validFloatStrings) {
			assertTrue(new StringValue(s).canCastToFloat());
		}
	}
	
	@Test public void cannotCastToFloat() {
		for(String s : invalidFloatStrings) {
			assertFalse(new StringValue(s).canCastToFloat());
		}
	}
	
	@Test public void castToFloat() throws InvalidCast {
		for(String s : validFloatStrings) {
			FloatValue v = new StringValue(s).castToFloat();
			assertEquals(ValueType.TFloat, v.type());
			assertEquals(Double.parseDouble(s.trim()), v.get(), 0.00001);
		}
	}
	
	@Test public void castCastToFloatFail() {
		for(String s : invalidFloatStrings) {
			try {
				FloatValue v = new StringValue(s).castToFloat();
				fail("Exception expected");
			} catch(InvalidCast e) {
				// expected
			}
		}
	}
}
