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
}

@members {
}

expr 
	: ^('+' a=expr b=expr) {}
	| ^('-' a=expr b=expr) {}
	| ^('*' a=expr b=expr) {}
	| ^('/' a=expr b=expr) {}
	| var {}
	| ^(':' c=var d=var) {}
	| val {}
	;
	
var 
	: ^(VAR SCALAR ID_SCALAR) {}
	| ^(VAR A1 ID_A1) {}
	| ^(VAR RC ID_RC) {}
	;
	
val 
	: ^(VALUE INT_TYPE INT) {}
	| ^(VALUE FLOAT_TYPE INT) {}
	| ^(VALUE STRING_TYPE INT) {}
	| ^(VALUE BOOL_TYPE INT) {}
	;
	
prog 
	: printExpr
	| assignExpr
	| deps
	| sysSet
	;
	
printExpr 
	: ^('?' expr) {}
	;
	
assignExpr
	: ^('=' var expr) {}
	;
	
deps
	: ^('deps' var) {}
	;
	
sysSet
	: ^('set' ID_SCALAR val) {}
	;
	
	