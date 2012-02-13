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

public class RuntimeContextTest extends Assert {
	
	@After public void clearRegisteredNodes() {
		RuntimeContext.current().clear();
	}
	
	@Test public void getCurrent() {
		assertNotNull(RuntimeContext.current());
	}

	@Test public void register() {
		RuntimeContext rc = RuntimeContext.current();
		assertEquals(0, rc.getRegistered().size());
		Node n1 = new Node();
		Node n2 = new Node();
		rc.registerNode(n1);
		rc.registerNode(n2);
		assertEquals(2, rc.getRegistered().size());
		assertTrue(rc.getRegistered().contains(n1));
		assertTrue(rc.getRegistered().contains(n2));
		Node n3 = new Node();
		assertFalse(rc.getRegistered().contains(n3));
	}
	
	@Test public void deepenStack() {
		RuntimeContext rc = RuntimeContext.current();
		assertEquals(0, rc.getRegistered().size());
		Node n1 = new Node();
		Node n2 = new Node();
		rc.registerNode(n1);
		rc.registerNode(n2);
		assertEquals(2, rc.getRegistered().size());
		RuntimeContext.push();
		Node n3 = new Node();
		RuntimeContext rc1 = RuntimeContext.current();
		assertTrue(rc != rc1);
		rc1.registerNode(n3);
		assertEquals(1, rc1.getRegistered().size());
		RuntimeContext.pop();
		assertEquals(rc, RuntimeContext.current());
		assertEquals(2, rc.getRegistered().size());
	}

}
