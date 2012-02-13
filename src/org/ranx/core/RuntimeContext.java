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

package org.ranx.core;

import java.util.Stack;
import java.util.HashSet;

public class RuntimeContext {
	
	private static ThreadLocal<Stack<RuntimeContext>> _context = new ThreadLocal<Stack<RuntimeContext>>() {
		@Override protected Stack<RuntimeContext> initialValue() {
			Stack<RuntimeContext> s = new Stack<RuntimeContext>();
			s.push(new RuntimeContext());
			return s;
		}
	};
	
	public static RuntimeContext current() {
		return _context.get().peek();
	}
	
	public static void push() {
		_context.get().push(new RuntimeContext());
	}
	
	public static void pop() {
		_context.get().pop();
	}
	
	private HashSet<Node> _nodes = new HashSet<Node>();
	
	public void registerNode(Node node) {
		_nodes.add(node);
	}
	
	public HashSet<Node> getRegistered() {
		return _nodes;
	}
	
	public void clear() {
		_nodes.clear();
	}
}
