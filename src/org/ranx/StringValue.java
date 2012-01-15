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

import java.util.regex.*;

public class StringValue extends Value {
	private String _value = "undef";
	public StringValue() { _value = ""; }
	public StringValue(String value_) { _value = value_; }
	
	public String get() { return _value; }

	@Override public ValueType type() { return ValueType.TString; }
	
	@Override public Value add(Value that) throws InvalidOperation {
		try {
			switch(that.type()) {
				case TInt : {
					if(canCastToInt()) {
						return toInt().add(that);
					} else if(canCastToFloat()) {
						return toFloat().add(that);
					} else {
						return new StringValue(_value.concat(that.toStr().get()));
					}
				}
			
				case TFloat : {
					if(canCastToInt() && that.canCastToInt()) {
						return toInt().add(that);
					} else if(canCastToFloat()) {
						return toFloat().add(that);
					} else {
						return new StringValue(_value.concat(that.toStr().get()));
					}
				}
				case TString : return new StringValue(_value.concat(that.toStr().get()));
			}
		} catch (InvalidCast e) {
			throw new InvalidOperation(e);
		}
		throw new InvalidOperation("don't know how to add that");
	}
	
	@Override public Value subtract(Value that) throws InvalidOperation { return null; }
	@Override public Value multiply(Value that) throws InvalidOperation { return null; }
	@Override public Value divide(Value that) throws InvalidOperation { return null; }
	
	@Override public boolean canCastTo(ValueType target) { 
		switch(target) {
			case TInt: return intRegex.matcher(_value).find();
			case TFloat: return floatRegex.matcher(_value).find();
		}
		return false;
	}
	
	@Override public Value castTo(ValueType target) throws InvalidCast { 
		try {
			switch(target) {
				case TInt : return new IntValue(Integer.parseInt(_value.trim()));
				case TFloat : return new FloatValue(Double.parseDouble(_value.trim()));
				case TString : return this;
			}
		} catch(RuntimeException e) {
			throw new InvalidCast(e);
		}
		throw new InvalidCast();
	}
	
	private Pattern intRegex = Pattern.compile("\\A\\s*-?\\s*\\d+\\s*\\z");
	private Pattern floatRegex = Pattern.compile("\\A\\s*-?\\s*\\d+(\\.\\d+)?([eE]-?\\d+)?\\s*\\z");
}
