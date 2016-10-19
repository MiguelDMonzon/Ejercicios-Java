
import java_cup.runtime.Symbol;
%%

   
  

%cup
%unicode
%state COMMENT, OPCODE, IN, OUT, BEHAV
%line
%char
%class UpdComp

%%


[\r\t \n] 			{/*No hace nada, hay que obviarlo*/ }
<YYINITIAL>, {/*Palabra reservada*/ return new Symbol(sym.COMA, (yyline+1), yychar);}
<IN>, {/*Palabra reservada*/ return new Symbol(sym.COMA, (yyline+1), yychar);}
<IN>"[" {/*Palabra reservada*/ return new Symbol(sym.ABRECORCHETE, (yyline+1), yychar);}
<IN>"]" {/*Palabra reservada*/ return new Symbol(sym.CIERRACORCHETE, (yyline+1), yychar);}
<OUT>"[" {/*Palabra reservada*/ return new Symbol(sym.ABRECORCHETE, (yyline+1), yychar);}
<OUT>"]" {/*Palabra reservada*/ return new Symbol(sym.CIERRACORCHETE, (yyline+1), yychar);}
<BEHAV>, {/*Palabra reservada*/ return new Symbol(sym.COMA, (yyline+1), yychar);}
<BEHAV>"[" {/*Palabra reservada*/ return new Symbol(sym.ABRECORCHETE, (yyline+1), yychar);}
<BEHAV>"]" {/*Palabra reservada*/ return new Symbol(sym.CIERRACORCHETE, (yyline+1), yychar);}

<YYINITIAL> "<"(ident)">"  {/*Palabra reservada*/ return new Symbol(sym.APERTURAIDENT, (yyline+1), yychar);}
<YYINITIAL> "<"(date)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURADATE, (yyline+1), yychar);}
<YYINITIAL> "<"(comment)">"  {/*Palabra reservada, entra en el estado COMMENT*/yybegin(COMMENT);}
<YYINITIAL> "<"(name)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURANAME, (yyline+1), yychar);}
<YYINITIAL> "<"(use)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURAUSE, (yyline+1), yychar);}
<YYINITIAL> "<"(bitsize)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURABITSIZE, (yyline+1), yychar);}
<YYINITIAL> "<"(insbitcode)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURAINSBITCODE, (yyline+1), yychar);}
<YYINITIAL> "<"(upd)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURAUPD, (yyline+1), yychar);}
<YYINITIAL> "<"(descr)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURADESCR, (yyline+1), yychar);}
<YYINITIAL> "<"(storage)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURASTORAGE, (yyline+1), yychar);}
<YYINITIAL> "<"(name)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURANAME, (yyline+1), yychar);}
<YYINITIAL> "<"(register)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURAREGISTER, (yyline+1), yychar);}
<YYINITIAL> "<"(regbitcode)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURAREGBITCODE, (yyline+1), yychar);}
<YYINITIAL> "<"(group)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURAGROUP, (yyline+1), yychar);}
<YYINITIAL> "<"(registers)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURAREGISTERS, (yyline+1), yychar);}
<YYINITIAL> "<"(insns)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURAINSNS, (yyline+1), yychar);}
<YYINITIAL> "<"(ins)">"  {/*Palabra reservada*/return new Symbol(sym.APERTURAINS, (yyline+1), yychar);}
<YYINITIAL> "<"(opcode)">"  {/*Palabra reservada*/yybegin(OPCODE); return new Symbol(sym.APERTURAOPCODE, (yyline+1), yychar);}
<YYINITIAL> "<"(in)">"  {/*Palabra reservada*/yybegin(IN); return new Symbol(sym.APERTURAIN, (yyline+1), yychar);}
<YYINITIAL> "<"(out)">"  {/*Palabra reservada*/yybegin(OUT); return new Symbol(sym.APERTURAOUT, (yyline+1), yychar);}
<YYINITIAL> "<"(behav)">"  {/*Palabra reservada*/yybegin(BEHAV); return new Symbol(sym.APERTURABEHAV, (yyline+1), yychar);}


<YYINITIAL> "<"(/ident)">"  {/*Palabra reservada*/ return new Symbol(sym.CIERREIDENT, (yyline+1), yychar);}
<YYINITIAL> "<"(/date)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREDATE, (yyline+1), yychar);}
<YYINITIAL> "<"(/name)">"  {/*Palabra reservada*/return new Symbol(sym.CIERRENAME, (yyline+1), yychar);}
<YYINITIAL> "<"(/use)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREUSE, (yyline+1), yychar);}
<YYINITIAL> "<"(/bitsize)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREBITSIZE, (yyline+1), yychar);}
<YYINITIAL> "<"(/insbitcode)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREINSBITCODE, (yyline+1), yychar);}
<YYINITIAL> "<"(/upd)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREUPD, (yyline+1), yychar);}
<YYINITIAL> "<"(/descr)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREDESCR, (yyline+1), yychar);}
<YYINITIAL> "<"(/storage)">"  {/*Palabra reservada*/return new Symbol(sym.CIERRESTORAGE, (yyline+1), yychar);}
<YYINITIAL> "<"(/name)">"  {/*Palabra reservada*/return new Symbol(sym.CIERRENAME, (yyline+1), yychar);}
<YYINITIAL> "<"(/register)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREREGISTER, (yyline+1), yychar);}
<YYINITIAL> "<"(/regbitcode)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREREGBITCODE, (yyline+1), yychar);}
<YYINITIAL> "<"(/group)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREGROUP, (yyline+1), yychar);}
<YYINITIAL> "<"(/registers)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREREGISTERS, (yyline+1), yychar);}
<YYINITIAL> "<"(/insns)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREINSNS, (yyline+1), yychar);}
<YYINITIAL> "<"(/ins)">"  {/*Palabra reservada*/return new Symbol(sym.CIERREINS, (yyline+1), yychar);}
<OPCODE> "<"(/opcode)">"  {/*Palabra reservada*/yybegin(YYINITIAL); return new Symbol(sym.CIERREOPCODE, (yyline+1), yychar); }
<IN> "<"(/in)">"  {/*Palabra reservada*/yybegin(YYINITIAL); return new Symbol(sym.CIERREIN, (yyline+1), yychar); }
<OUT> "<"(/out)">"  {/*Palabra reservada*/yybegin(YYINITIAL); return new Symbol(sym.CIERREOUT, (yyline+1), yychar); }
<BEHAV> "<"(/behav)">"  {/*Palabra reservada*/yybegin(YYINITIAL); return new Symbol(sym.CIERREBEHAV, (yyline+1), yychar); }



<YYINITIAL> [a-zA-Z][a-zA-Z0-9]* {return new Symbol(sym.IDENT, (yyline+1), yychar, yytext());}
<YYINITIAL> [0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9] {return new Symbol(sym.DATE, (yyline+1), yychar, yytext());}
<YYINITIAL> '[a-zA-Z][a-zA-Z]?' {return new Symbol(sym.NAME, (yyline+1), yychar, yytext());}
<YYINITIAL> \"(AllPurpose)\"|\"(Accumulator)\"|\"(ProgramPC)\"|\"(Index)\"|\"(FlagVector)\"|\"(StackPointer)\" {return new Symbol(sym.USE, (yyline+1), yychar, yytext());}
<YYINITIAL> [0-9]+ {return new Symbol(sym.BITSIZE, (yyline+1), yychar, new Integer(yytext()));}
<YYINITIAL> [0-9]+b {return new Symbol(sym.REGBITCODE, (yyline+1), yychar, yytext());}

<YYINITIAL> [0|1]+([x]+|[x]+[y]+|[x]+[y]+[z]+)? {return new Symbol(sym.INSBITCODE, (yyline+1), yychar, yytext());}

<OPCODE> [a-zA-Z]+ {return new Symbol(sym.CODIGOOPERACION, (yyline+1), yychar, yytext());}
<IN> [a-zA-Z][a-zA-Z]? {return new Symbol(sym.NOMBREOPERANDOIN, (yyline+1), yychar, yytext());}
<IN> DATA|MEM {return new Symbol(sym.DATAMEM, (yyline+1), yychar, yytext());}
<OUT> [a-zA-Z][a-zA-Z]? {return new Symbol(sym.NOMBREOPERANDOOUT, (yyline+1), yychar, yytext());}
<BEHAV> \[[a-zA-Z0-9+=*-/]+\] {return new Symbol(sym.BEHAV, (yyline+1), yychar, yytext());}


<COMMENT>   "<"(/comment)">" {}
<COMMENT>   .  	{/*No se hace nada, se obvia*/}

.          				{ System.out.println("Error lexico!!!: "+yytext());}
