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

public class ConstNodeExpression extends NodeExpression {

	private Node _source;
	
	public ConstNodeExpression(Node node_, Node source_) { 
		super(node_);
		_source = source_;
		_source.connectTo(node_);
	}

	@Override public Value eval() throws InvalidOperation {
		return _source.value();
	}

}