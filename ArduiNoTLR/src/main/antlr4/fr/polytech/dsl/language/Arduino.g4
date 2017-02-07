// Define a grammar called Hello
grammar Arduino;

// Parser Rules
app      : named (connect)+ (monitor)? (set | display)+ start (when)+ (excep)* EOF;

named    : NAMED name=NAME;

connect  : CONNECT ac=actuator cpt=ID ON fcd=facade port=INT;

monitor  : MONITOR sensor=ID ON lcd=ID;

set      : SET ac=ID ON val=ID WHEN state=LABEL;

start    : START ON state=LABEL;

when     : (WHEN sensor=ID IS val=ID THEN)? CHANGE FROM from=LABEL TO to=LABEL;

excep    : THROW EXCEPTION eid=INT ON state=LABEL WHEN sensor=ID IS v=ID;

// static version
// display on  LEC   "TEST"
display  : state=LABEL':' DISPLAY value=STRING ON cpt=ID;

actuator : LED | BUTTON | LCD | THERMO;
facade   : PIN | BUS;

// Lexer Rules

// Keywords
NAMED   : 'named';
CONNECT : 'connect';
MONITOR : 'monitor';
SET     : 'set';
LED     : 'led';
START   : 'start';
LCD     : 'lcd';
THERMO  : 'thermo';
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
THROW   : 'throw';
EXCEPTION: 'exception';

// Primitives
TRUE    : 'true';
FALSE   : 'false';
INT     : [0-9]+;
DEC     : INT '.' INT;
STRING  : '"'[a-zA-Z0-9_ .-]*'"';
ID      : [A-Z_]+;
NAME    : [A-Z][a-zA-Z_]+;
LABEL   : [a-z][a-z0-9_]+;

// Skip spaces, tabs, newlines
WS      : [ \r\n]+       -> skip;
COMMENT : '//' ~('\n')*  -> skip;

/*
named ArduinoML

connect led toto on pin 12
*/