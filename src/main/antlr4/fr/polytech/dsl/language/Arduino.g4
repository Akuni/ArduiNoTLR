// Define a grammar called Hello
grammar Arduino;

// Parser Rules
app      : named (connect)+ (set)+ start (display | when)+ EOF;

named    : NAMED name=NAME;

connect  : CONNECT ac=actuator cpt=ID ON fcd=facade port=INT;

set      : SET ac=ID ON val=ID WHEN state=LABEL;

start    : START ON state=LABEL;

when     : WHEN sensor=ID IS val=ID THEN CHANGE FROM from=LABEL TO to=LABEL;

// static version
// display on  LEC   "TEST"
display  : DISPLAY value=STRING ON cpt=ID (m=morse)?;
morse    : IN MORSE;

actuator : LCD | LED | BUTTON;
facade   : PIN | BUS;

// Lexer Rules

// Keywords
NAMED   : 'named';
CONNECT : 'connect';
SET     : 'set';
LED     : 'led';
START   : 'start';
LCD     : 'lcd';
THEN    : 'then';
CHANGE  : 'change';
FROM    : 'from';
TO      : 'to';
BUTTON  : 'button';
ON      : 'on';
WHEN    : 'when';
IS      : 'is';
STATE   : 'state';
PIN     : 'pin';
BUS     : 'bus';
DISPLAY : 'display';
IN      : 'in';
TOGGLE  : 'toggle';
MORSE   : 'morse';

// Primitives
TRUE    : 'true';
FALSE   : 'false';
INT     : [0-9]+;
DEC     : INT '.' INT;
STRING  : '"'[a-zA-Z0-9_ ]+'"';
ID      : [A-Z_]+;
NAME    : [A-Z][a-zA-Z_]+;
LABEL   : [a-z][a-z_]+;

// Skip spaces, tabs, newlines
WS      : [ \r\n]+ -> skip;

/*
named ArduinoML

connect led toto on pin 12
*/