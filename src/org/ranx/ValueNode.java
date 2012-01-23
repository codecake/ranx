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

public class ValueNode extends Node {
	public ValueNode(Value value_) {
		super(new ValueExpression(value_));
	}
	
	public void set(Value value_) {
		expression(new ValueExpression(value_));
	}
	
	public void set(int value_) { set(new IntValue(value_)); }
	public void set(double value_) { set(new FloatValue(value_)); }
	public void set(String value_) { set(new StringValue(value_)); }
	public void set(boolean value_) { set(new BoolValue(value_)); }
}
