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

/**
 * Expression that represents operation on values 
 *
 */
public abstract class Expression {
	/**
	 * Perform the operation
	 * @return result of the operation
	 * @throws InvalidOperation exception thrown if the operation cannot be performed, for whatever reason
	 */
	public abstract Value eval() throws InvalidOperation;
}

