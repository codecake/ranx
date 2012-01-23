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
 * Defines operations on values
 * @author codecake
 *
 */
public class ValueOps {

	/**
	 * Adds two values
	 * @param lhs first value to add
	 * @param rhs second value to add
	 * @return result
	 * @throws InvalidOperation if values cannot be added
	 */
	public static Value add(Value lhs, Value rhs) throws InvalidOperation {
		try {
			if(lhs.canCastToInt() && rhs.canCastToInt()) {
				return new IntValue(lhs.toInt().get() + rhs.toInt().get());
			} else if(lhs.canCastToFloat() && rhs.canCastToFloat()) {
				return new FloatValue(lhs.toFloat().get() + rhs.toFloat().get());
			}
		} catch(InvalidCast e) {
			throw new InvalidOperation(e);
		}
		throw new InvalidOperation();
	}
	
	/**
	 * Subtracts two values
	 * @param lhs value to subtract from
	 * @param rhs value being subtracted
	 * @return result
	 * @throws InvalidOperation if values cannot be subtracted
	 */
	public static Value subtract(Value lhs, Value rhs) throws InvalidOperation {
		try {
			if(lhs.canCastToInt() && rhs.canCastToInt()) {
				return new IntValue(lhs.toInt().get() - rhs.toInt().get());
			} else if(lhs.canCastToFloat() && rhs.canCastToFloat()) {
				return new FloatValue(lhs.toFloat().get() - rhs.toFloat().get());
			}
		} catch(InvalidCast e) {
			throw new InvalidOperation(e);
		}
		throw new InvalidOperation();
	}
	
	/**
	 * Multiplies two values
	 * @param lhs first value to multiply
	 * @param rhs second value to multiply
	 * @return result
	 * @throws InvalidOperation if values cannot be multiplied
	 */
	public static Value multiply(Value lhs, Value rhs) throws InvalidOperation {
		try {
			if(lhs.canCastToInt() && rhs.canCastToInt()) {
				return new IntValue(lhs.toInt().get() * rhs.toInt().get());
			} else if(lhs.canCastToFloat() && rhs.canCastToFloat()) {
				return new FloatValue(lhs.toFloat().get() * rhs.toFloat().get());
			}
		} catch(InvalidCast e) {
			throw new InvalidOperation(e);
		}
		throw new InvalidOperation();
	}
	
	/**
	 * Divides two values
	 * @param lhs value to divide
	 * @param rhs value to divide by
	 * @return result
	 * @throws InvalidOperation if values cannot be divided
	 */
	public static Value divide(Value lhs, Value rhs) throws InvalidOperation {
		try {
			if(lhs.canCastToInt() && rhs.canCastToInt()) {
				return new IntValue(lhs.toInt().get() / rhs.toInt().get());
			} else if(lhs.canCastToFloat() && rhs.canCastToFloat()) {
				return new FloatValue(lhs.toFloat().get() / rhs.toFloat().get());
			}
		} catch(InvalidCast e) {
			throw new InvalidOperation(e);
		}
		throw new InvalidOperation();
	}
	
	/**
	 * Concatenates two values as strings
	 * @param one first string to concatenate
	 * @param two second string to concatenate
	 * @return concatenated string
	 * @throws InvalidOperation that really shouldn't happen
	 */
	public static Value concat(Value one, Value two) throws InvalidOperation {
		try {
			return new StringValue(one.asString().concat(two.asString()));
		} catch(InvalidCast e) {
			throw new InvalidOperation(e);
		}
	}
}
