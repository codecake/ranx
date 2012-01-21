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
	/**
	 * Returns the type of the value
	 * @return type of the value
	 */
	public abstract ValueType type();
	
	/**
	 * Returns true of the value can be cast to the given type
	 * @param target type to be cast to
	 * @return true of the value can be cast to the given type
	 */
	public abstract boolean canCastTo(ValueType target);
	
	/**
	 * Performs cast to the given type
	 * @param target type to be cast to
	 * @return Value of the given type, if the cast is successful
	 * @throws InvalidCast if the cast cannot be done
	 */
	public abstract Value castTo(ValueType target) throws InvalidCast;
	
	/**
	 * Checks if this value is of type int
	 * @return true if this is int
	 */
	public boolean isInt() { return type() == ValueType.TInt; }
	
	/**
	 * Checks if this value is of type float
	 * @return true if this is float
	 */
	public boolean isFloat() { return type() == ValueType.TFloat; }
	public boolean isBool() { return type() == ValueType.TBool; }
	public boolean isString() { return type() == ValueType.TString; }
	public boolean isNumeric() { return isInt() || isFloat(); }
	
	public boolean canCastToInt() { return canCastTo(ValueType.TInt); }
	public boolean canCastToFloat() { return canCastTo(ValueType.TFloat); }
	public boolean canCastToBool() { return canCastTo(ValueType.TBool); }
	
	public IntValue toInt() throws InvalidCast { return (IntValue) castTo(ValueType.TInt); }
	public FloatValue toFloat() throws InvalidCast { return (FloatValue) castTo(ValueType.TFloat); }
	public BoolValue toBool() throws InvalidCast { return (BoolValue) castTo(ValueType.TBool); }
	public StringValue toStr() throws InvalidCast { return (StringValue) castTo(ValueType.TString); }
	
	public int asInt() throws InvalidCast { return toInt().get(); }
	public double asDouble() throws InvalidCast { return toFloat().get(); }
	public boolean asBool() throws InvalidCast { return toBool().get(); }
	public String asString() throws InvalidCast { return toStr().get(); }
	
	//TODO: test
	public static Value of(int value_) { return new IntValue(value_); }
	//TODO: test
	public static Value of(double value_) { return new FloatValue(value_); }
	//TODO: test
	public static Value of(String value_) { return new StringValue(value_); }
	//TODO: test
	public static Value of(boolean value_) { return new BoolValue(value_); }
}
