// Define a grammar called Hello
grammar Arduino;

// Parser Rules
app : named (connect)+ EOF;

named: NAMED name=STRING;

connect: CONNECT component cpt=STRING ON fcd=facade port=INT;

component: LED | LCD;

facade: PIN | BUS;

// Lexer Rules

// Keywords
NAMED: 'named';
CONNECT: 'connect';
LED: 'led';
LCD: 'lcd';
ON: 'on';
PIN: 'pin';
BUS: 'bus';

// Primitives
TRUE    : 'true';
FALSE   : 'false';
INT     : [0-9]+;
DEC     : INT '.' INT;
STRING  : [a-zA-Z0-9]+;

// Skip spaces, tabs, newlines
WS      : [ \r\n]+ -> skip;

/*
named ArduinoML

connect led toto on pin 12
*/