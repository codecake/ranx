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


package org.ranx;

import java.util.HashSet;

public class Node {
	private Value _value;
	private Expression _expr = null;
	private boolean _valid = false;
	
	public Node() {}
	public Node(Expression expr_) { _expr = expr_; }
	
	public Expression expression() { return _expr; }
	public void expression(Expression expr_) { _expr = expr_; }
	
	public boolean valid() { return _valid; }

	private HashSet<Node> _ins = new HashSet<Node>();
	private HashSet<Node> _outs = new HashSet<Node>();

	public Node[] ins() { return _ins.toArray(new Node[0]); }
	public Node[] outs() { return _outs.toArray(new Node[0]); }
	
	public void addIn(Node in) { _ins.add(in); }
	public void addOut(Node out) { _outs.add(out); }
	public void connectTo(Node that) { this.addOut(that); that.addIn(this); }
	public void removeIn(Node in) { _ins.remove(in); }
	public void removeOut(Node out) { _outs.remove(out); }
	public void disconnect(Node that) {
		if(_ins.remove(that)) {
			that.removeOut(this);
		} else if(_outs.remove(that)) {
			that.removeIn(this);
		}
	}
	
	public boolean isConnectedTo(Node that) { return _outs.contains(that); }
	public boolean isConnectedFrom(Node that) { return _ins.contains(that); }
	
	
	public Value value() throws InvalidOperation { 
		if(_valid) {
			return _value;
		}
		_value = _expr.eval();
		_valid = true;
		return _value;
	}
	
	public void invalidate() {
		_valid = false;
		for(Node n : _outs) {
			n.invalidate();
		}
	}
}
