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

tree grammar Eval;

options {
	tokenVocab = Ranx;
	ASTLabelType = CommonTree;
}

@header {
package org.ranx.parser;

import org.ranx.core.*;
}

@members {
}

expr returns [Node value]
	: ^('+' a=expr b=expr) { $value = NodeExpressionFactory.add(a, b); }
	| ^('-' a=expr b=expr) { $value = NodeExpressionFactory.subtract(a, b); }
	| ^('*' a=expr b=expr) { $value = NodeExpressionFactory.multiply(a, b); }
	| ^('/' a=expr b=expr) { $value = NodeExpressionFactory.divide(a, b); }
	| var { $value = org.ranx.core.Runtime.var($var.value); }
	| ^(':' c=var d=var) {}
	| val { $value = new ValueNode($val.value); }
	;
	
var returns [String value]
	: ^(VAR SCALAR ID_SCALAR) { $value = $ID_SCALAR.text; }
	| ^(VAR A1 ID_A1) { $value = $ID_A1.text; }
	| ^(VAR RC ID_RC) { $value = $ID_RC.text; }
	;
	
val returns [Value value]
	: ^(VALUE INT_TYPE INT) { $value = new IntValue(Integer.parseInt($INT.text)); }
	| ^(VALUE FLOAT_TYPE FLOAT) { $value = new FloatValue(Double.parseDouble($FLOAT.text)); }
	| ^(VALUE STRING_TYPE STRING) { $value = new StringValue($STRING.text); }
	| ^(VALUE BOOL_TYPE BOOL) { $value = new BoolValue(Boolean.parseBoolean($BOOL.text)); }
	;
	
prog 
	: printExpr
	| assignExpr
	| deps
	| sysSet
	;
	
printExpr 
	: ^('?' expr) {
			try { 
				System.out.println($expr.value.value());
			} catch (InvalidOperation e) {
				System.err.println(e.toString());
			} 
		}
	;
	
assignExpr
	: ^('=' var expr) { org.ranx.core.Runtime.var($var.value, $expr.value); }
	;
	
deps
	: ^('deps' var) {}
	;
	
sysSet
	: ^('set' ID_SCALAR val) {}
	;
	
	