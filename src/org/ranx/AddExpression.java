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

public class AddExpression extends Expression {

	private Expression _lhs;
	private Expression _rhs;
	
	public AddExpression(Expression lhs_, Expression rhs_) { 
		_lhs = lhs_;
		_rhs = rhs_;
	}

	@Override public Value eval() throws InvalidOperation {
		return ValueOps.add(_lhs.eval(), _rhs.eval());
	}
}

