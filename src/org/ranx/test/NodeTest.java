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

public class NodeTest extends Assert {

	@Test public void addRemoveIns() {
		Node n = new Node();
		Node in1 = new Node();
		Node in2 = new Node();
		n.addIn(in1);
		n.addIn(in2);
		assertNotNull(n.ins());
		assertEquals(2, n.ins().length);
		n.removeIn(in1);
		assertEquals(1, n.ins().length);
	}
	
	@Test public void addRemoveOuts() {
		Node n = new Node();
		Node out1 = new Node();
		Node out2 = new Node();
		n.addOut(out1);
		n.addOut(out2);
		assertNotNull(n.outs());
		assertEquals(2, n.outs().length);
		n.removeOut(out1);
		assertEquals(1, n.outs().length);
	}
	
	@Test public void eval() throws InvalidOperation, InvalidCast {
		Node n = new Node(new ValueExpression(new IntValue(123)));
		assertFalse(n.valid());
		assertEquals(123, n.value().toInt().get());
		assertTrue(n.valid());
	}
}
