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

public class SubtractNodeExpression extends NodeExpression {

	private Node _lhs;
	private Node _rhs;
	
	public SubtractNodeExpression(Node node_, Node lhs_, Node rhs_) {
		super(node_);
		_lhs = lhs_;
		_rhs = rhs_;
		_lhs.connectTo(node_);
		_rhs.connectTo(node_);
	}

	@Override
	public Value eval() throws InvalidOperation {
		return ValueOps.subtract(_lhs.value(), _rhs.value());
	}
}
