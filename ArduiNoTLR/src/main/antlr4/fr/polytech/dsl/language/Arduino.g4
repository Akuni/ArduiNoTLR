// Define a grammar called Hello
grammar Arduino;

// Parser Rules
app : named (connect | display)+ EOF;

named: NAMED name=NAME;

connect : CONNECT itype=input_type cpt=ID ON fcd=facade port=INT
        | CONNECT otype=output_type cpt=ID ON fdc=facade port=INT;


// static version
// display on  LEC   "TEST"
display : DISPLAY ON cpt=ID value=STRING (m=morse)?;
morse   : IN MORSE;

//component: input_type |output_type;
input_type : BUTTON;
output_type: LED | LCD ;
facade: PIN | BUS;

// Lexer Rules

// Keywords
NAMED   : 'named';
CONNECT : 'connect';
LED     : 'led';
LCD     : 'lcd';
BUTTON  : 'button';
ON      : 'on';
PIN     : 'pin';
BUS     : 'bus';
DISPLAY : 'display';
IN      : 'in';
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