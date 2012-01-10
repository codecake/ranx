grammar ranx;

options {
	output=AST;
	ASTLabelType=CommonTree;
}

tokens {
	VAR;
	SCALAR;
	A1;
	RC;
	VALUE;
	INT_TYPE;
	FLOAT_TYPE;
	STRING_TYPE;
	BOOL_TYPE;
}

formula :	(def | print | deps | sysCmd ) *;

def : varName '=' expr+ -> ^('=' varName expr);

print	:	'?' varName -> ^('?' varName);

expr 	:	multExpr (('+'^|'-'^) multExpr)*;

multExpr	:	atom ('*'^ atom)*;

atom	:	value
		|	varName
		|	'('! expr ')'!
		;

range	:	a=varName ':' b=varName -> ^(':' $a $b);

varName 	:	varScalar | varA1 | varRC;

varScalar 	:	ID_SCALAR -> ^(VAR SCALAR ID_SCALAR);

varA1		:	ID_A1 -> ^(VAR A1 ID_A1);

varRC		:	ID_RC -> ^(VAR RC ID_RC);

deps		:	'deps' varName -> ^('deps' varName);

value		:	int_ | float_ | string_ | bool_;

int_		: 	INT -> ^(VALUE INT_TYPE INT);

float_		:	FLOAT -> ^(VALUE FLOAT_TYPE FLOAT);

string_		:	STRING -> ^(VALUE STRING_TYPE STRING);

bool_		:	BOOL -> ^(VALUE BOOL_TYPE BOOL);

sysCmd		:	sysGet | sysSet;

sysGet 		:	'get' sysName -> ^('get' sysName);

sysSet		:	'set' sysName '=' sysVal -> ^('set' sysName sysVal);

sysName		: 	ID_SCALAR;

sysVal		:	value;

BOOL		:	'true' | 'false';

ID_SCALAR 	:	('a'..'z'|'A'..'Z')
			|	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*('a'..'z'|'A'..'Z');
			
ID_A1		:	('a'..'z'|'A'..'Z')+('0'..'9')*;

ID_RC		:	'R'('0'..'9')+'C'('0'..'9')+;

INT			:	('0'..'9')+;

FLOAT		:	('0'..'9')+ '.' ('0'..'9')* EXPONENT?
			| 	'.' ('0'..'9')+ EXPONENT?
			|	('0'..'9')+ EXPONENT?
			;
			
STRING		:	'"' ('\\' . | ~('\\'|'"'))* '"'
			|	'\'' ('\\' . | ~('\\'|'\''))* '\'';
			
EXPONENT 	:	('e' | 'E') ('+'|'-')? ('0'..'9')+;

WS			:	(' ' | '\t' | '\n' | '\r' )+ {skip();};

ML_COMMENT	:	'/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;};