// Define a grammar called Hello
grammar Hello;

// general rule
r : d=defs  s=setup l=loop {System.out.println($d.texte +'\n'+ $s.texte+'\n' + $l.texte); Database.print();};


setup returns [String texte] : SETUP  ss=sets {$texte = "void setup(){ " +  $ss.texte + "}";};
loop returns [String texte] : LOOP  as=actions {$texte = "void loop(){ " +  $as.texte + "}";};

set returns [String texte] :
    label=ID INPUT {Database.add($label.text, "INPUT"); $texte = "pinMode(" +$label.text + ", INPUT);";}
    | label=ID OUTPUT {Database.add($label.text, "OUTPUT"); $texte = "pinMode(" +$label.text + ", OUTPUT);";}
;

sets returns [String texte] :
    s=set ss=sets {$texte = $s.texte + " "  + $ss.texte;}
    | {$texte = "";}
    ;

// list of actions
actions returns [String texte]: a=action as=actions {$texte = $a.texte + "\n" + $as.texte; }
| {$texte = "";} // if nothing print nothing
;

action returns [String texte] :
        a=affect {$texte = $a.texte;}
          | e=event {$texte = $e.texte;}
          | c=ifcond {$texte = $c.texte;}
;

// AFFECTATION
affect returns [String texte]:
     label=ID value=status {$texte = $label.text + "=" + $value.text + ";";}
;

// EVENT
event  returns [String texte]:
     WHEN ex=expr body=action {$texte = "if(" + $ex.texte + "){\n" + $body.texte +"\n}";}
;

// CONDITION
ifcond   returns [String texte]:
      IF e=expr body=action s=elsecond {$texte = "if(" + $e.texte + "){\n" + $body.texte +"\n}" + $s.texte;}
;

elsecond returns [String texte] :
    ELSE bod=action { $texte = "else{\n" + $bod.texte+ "\n}";}
    | {$texte = "";}
;
// EXPRESSION
expr returns [String texte] :
    left=exp op=operator right=exp { $texte = $left.texte + " " +  $op.texte + " " + $right.texte ;}
     | '(' e=expr ')' {$texte = "(" + $e.texte + ")";}
;

status returns [String texte] :
    ON {$texte = "HIGH";}
    | OFF {$texte = "LOW";}
;

//
exp returns [String texte] :
    ID {$texte = $ID.text;}
    //| STATUS {$texte = $STATUS.text;}
    | s=status {$texte = $s.texte;}
    | INT {$texte = $INT.text;}
    | DEC {$texte = $DEC.text;}
    | TRUE {$texte = "true";}
    | FALSE {$texte = "false";}
;

operator returns [String texte] :
    EQ      {$texte = $EQ.text;}
    | DIF   {$texte = $DIF.text;}
    | INF   {$texte = $INF.text;}
    | INFEQ {$texte = $INFEQ.text;}
    | SUP   {$texte = $SUP.text;}
    | SUPEQ {$texte = $SUPEQ.text;}
    | IS    {$texte = "==";}
;

// list of definitions
defs returns [ String texte] : d=def ds=defs {$texte = $d.texte + " " + $ds.texte;}
     | {$texte = "";} // if nothing print nothing
;
// defintion
def returns [String texte] : label=ID value=INT {$texte = "int " + $label.text + " = " + $value.text + ";"; }
;

// | label=STATUS value=STATUS {$texte = "int " + $label.text + " = " + $value.text + ";";}




// basic  tokens definition
// operators
EQ      : '==';
DIF     : '!=';
INF     : '<';
INFEQ   : '<=';
SUP     : '>';
SUPEQ   : '>=';

// bool
TRUE    : 'true';
FALSE   : 'false';

// keywords
COLON   : ':' ;
SETUP   : 'setup:';
LOOP    : 'loop:' ;
LINE    : '\n';
WHEN    : 'when ';
IF      : 'if';
IS      : 'is';
ELSE    : 'else';

ON      : 'ON' ;
OFF     : 'OFF' ;

INPUT   : 'INPUT';
OUTPUT  : 'OUTPUT';

// variables
ID      : [a-z]+;
//STATUS  : [A-Z]+ ;
INT     : [0-9]+ ;
DEC     : INT '.' INT;

// skip spaces, tabs, newlines
WS      : [ \r\n]+ -> skip ;


/*
loop:
    when button is ON
        if led is ON
            led is OFF
        else led is ON
*/