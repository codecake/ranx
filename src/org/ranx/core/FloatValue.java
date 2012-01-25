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


public class FloatValue extends NumericValue {

	private double _value = -6.66;
	
	public FloatValue() { _value = 0.0; }
	
	public FloatValue(double value_) { _value = value_; }
	
	public double get() { return _value; }

	@Override public ValueType type() { return ValueType.TFloat; }
	
	@Override public boolean canCastTo(ValueType target) { 
		switch(target) {
			case TInt : return false;
			case TFloat : return true;
			case TBool : return true;
			case TString : return true;
		}
		return false;
	}
	
	@Override public Value castTo(ValueType target) throws InvalidCast { 
		switch(target) {
			case TInt : throw new InvalidCast("can't cast float to int");
			case TFloat : return this;
			case TBool : return new BoolValue(Math.abs(_value - 0.0) < 0.00001); // TODO: is this correct?
			case TString : return new StringValue(new Double(_value).toString());
		}
		throw new InvalidCast("don't know this type");
	}
	
	@Override public String toString() { return new Double(_value).toString(); }
}
