// Define a grammar called Morse
grammar Morse;

// Parser Rules
app : connect (display)+ EOF;

// connect a single LCD on a given bus
connect : CONNECT LCD ON BUS port=INT;

// display the value on the screen
display : EMIT value=STRING;

// Lexer Rules
// Keywords
CONNECT : 'connect';
LCD     : 'lcd';
ON      : 'on';
BUS     : 'bus';
EMIT    : 'emit';

// Primitives
INT     : [0-9]+;
STRING  : '"'[a-zA-Z0-9_ ]+'"';

// Skip spaces, tabs, newlines
WS      : [ \r\n]+ -> skip;
