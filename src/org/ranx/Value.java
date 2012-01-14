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

public abstract class Value {
	public abstract ValueType type();
	public abstract Value add(Value that) throws InvalidOperation;
	public abstract Value subtract(Value that) throws InvalidOperation;
	public abstract Value multiply(Value that) throws InvalidOperation;
	public abstract Value divide(Value that) throws InvalidOperation;
	public abstract boolean canCastTo(ValueType target);
	public abstract Value castTo(ValueType target) throws InvalidCast;
	
	public boolean canCastToInt() { return canCastTo(ValueType.TInt); }
	public boolean canCastToFloat() { return canCastTo(ValueType.TFloat); }
	public boolean canCastToBool() { return canCastTo(ValueType.TBool); }
}