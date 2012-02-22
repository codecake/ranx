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

/**
 * Constructs node expressions
 *
 */
public class NodeExpressionFactory {
	
	// non-instantiatable class
	private NodeExpressionFactory() {}

	/**
	 * Constructs add node expression
	 * @param lhs_ left hand side
	 * @param rhs_ right hand side
	 * @return add node expression
	 */
	public static Node add(Node lhs_, Node rhs_) {
		Node n = new Node();
		n.expression(new AddExpression(lhs_, rhs_));
		return n;
	}
	
	/**
	 * Constructs subtract node expression
	 * @param lhs_ left hand side
	 * @param rhs_ right hand side
	 * @return subtract node expression
	 */
	public static Node subtract(Node lhs_, Node rhs_) {
		Node n = new Node();
		n.expression(new SubtractExpression(lhs_, rhs_));
		return n;
	}
	
	/**
	 * Constructs multiply node expression
	 * @param lhs_ left hand side
	 * @param rhs_ right hand side
	 * @return multiply node expression
	 */
	public static Node multiply(Node lhs_, Node rhs_) {
		Node n = new Node();
		n.expression(new MultiplyExpression(lhs_, rhs_));
		return n;
	}
	
	/**
	 * Constructs divide node expression
	 * @param lhs_ left hand side
	 * @param rhs_ right hand side
	 * @return divide node expression
	 */
	public static Node divide(Node lhs_, Node rhs_) {
		Node n = new Node();
		n.expression(new DivideExpression(lhs_, rhs_));
		return n;
	}
}
