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

public class DivideNodeExpressionTest extends Assert {
	@Test public void evalInvalidate() throws InvalidCast, InvalidOperation {
		ValueNode in1 = new ValueNode(new FloatValue(123));
		ValueNode in2 = new ValueNode(new FloatValue(456));
		Node result = new Node();
		result.expression(new DivideNodeExpression(result, in1, in2));
		assertFalse(result.valid());
		assertEquals(0.269736842, result.eval().asDouble(), 0.00001);
		assertTrue(result.valid());
		in1.invalidate();
		assertFalse(result.valid());
		in1.set(222);
		assertEquals(0.486842105, result.eval().asDouble(), 0.00001);
		assertTrue(result.valid());
	}
}
