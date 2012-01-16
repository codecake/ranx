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

public class IntValue extends NumericValue {
	private int _value = -1;
	
	public IntValue() { _value = 0; }
	
	public IntValue(int value_) {_value = value_;}
	
	public int get() { return _value; }
	
	@Override public ValueType type() { return ValueType.TInt; }
	
	@Override public boolean canCastTo(ValueType target) { return true; }
	@Override public Value castTo(ValueType target) throws InvalidCast { 
		switch(target) {
			case TInt : return this; 
			case TFloat : return new FloatValue(_value);
			case TString : return new StringValue(new Integer(_value).toString());
			case TBool : return new BoolValue(_value != 0);
		}
		throw new InvalidCast();
	}
}
