
//----------------------------------------------------
// El siguiente codigo fue generado por  CUP v0.10k
// Sun Nov 09 22:18:38 CET 2014
//----------------------------------------------------

import Paquete.insClass;
import Paquete.storeClass;
import Paquete.descrClass;
import java.io.*;
import java.util.*;
import java_cup.runtime.Symbol;

 /** 
  * CUP v0.10k generador de parser.
  * @version Sun Nov 09 22:18:38 CET 2014
  */
public class parser extends java_cup.runtime.lr_parser {

  /**
   *  Constructor por defecto. 
   */
  public parser() {super();}

  /**
   * Constructor que establece el explorador predeterminado.
   */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** 
   * Tabla de producciones.
   */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\063\000\002\003\007\000\002\002\004\000\002\004" +
    "\006\000\002\004\005\000\002\004\003\000\002\005\005" +
    "\000\002\006\005\000\002\007\006\000\002\007\005\000" +
    "\002\007\003\000\002\011\004\000\002\011\003\000\002" +
    "\010\007\000\002\010\010\000\002\012\005\000\002\014" +
    "\005\000\002\015\003\000\002\015\005\000\002\016\005" +
    "\000\002\017\005\000\002\021\004\000\002\021\003\000" +
    "\002\020\010\000\002\020\011\000\002\022\005\000\002" +
    "\013\005\000\002\013\003\000\002\023\005\000\002\023" +
    "\003\000\002\025\004\000\002\025\003\000\002\024\011" +
    "\000\002\024\010\000\002\024\010\000\002\024\007\000" +
    "\002\026\005\000\002\027\005\000\002\030\003\000\002" +
    "\030\005\000\002\031\005\000\002\032\003\000\002\032" +
    "\003\000\002\032\005\000\002\032\005\000\002\033\007" +
    "\000\002\034\005\000\002\035\005\000\002\035\003\000" +
    "\002\036\005\000\002\037\005\000\002\037\003" });

  /** 
   * Acceso a la tabla de producciones.
   */
  public short[][] production_table() {return _production_table;}

  /** 
   * Tabla de acciones.
   */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\174\000\004\015\005\001\002\000\004\002\176\001" +
    "\002\000\006\003\006\016\007\001\002\000\006\003\ufffd" +
    "\017\ufffd\001\002\000\004\007\164\001\002\000\006\003" +
    "\012\017\011\001\002\000\004\020\112\001\002\000\006" +
    "\003\ufff8\024\ufff8\001\002\000\006\003\014\024\015\001" +
    "\002\000\004\040\uffe5\001\002\000\004\025\022\001\002" +
    "\000\004\040\017\001\002\000\004\002\001\001\002\000" +
    "\006\025\022\047\107\001\002\000\006\025\uffe3\047\uffe3" +
    "\001\002\000\004\026\023\001\002\000\004\064\104\001" +
    "\002\000\010\014\027\027\032\030\031\001\002\000\006" +
    "\014\027\030\031\001\002\000\004\031\056\001\002\000" +
    "\004\062\066\001\002\000\004\014\027\001\002\000\004" +
    "\005\051\001\002\000\004\005\034\001\002\000\004\052" +
    "\050\001\002\000\006\066\041\070\040\001\002\000\006" +
    "\004\036\052\uffdc\001\002\000\004\005\034\001\002\000" +
    "\004\052\uffdb\001\002\000\006\004\046\006\uffd8\001\002" +
    "\000\006\004\044\006\uffd9\001\002\000\004\006\043\001" +
    "\002\000\006\004\uffda\052\uffda\001\002\000\006\066\041" +
    "\070\040\001\002\000\004\006\uffd7\001\002\000\006\066" +
    "\041\070\040\001\002\000\004\006\uffd6\001\002\000\006" +
    "\014\uffdd\030\uffdd\001\002\000\004\067\052\001\002\000" +
    "\004\006\053\001\002\000\004\053\054\001\002\000\004" +
    "\014\uffd5\001\002\000\004\031\056\001\002\000\004\065" +
    "\062\001\002\000\004\050\060\001\002\000\006\025\uffe1" +
    "\047\uffe1\001\002\000\004\054\065\001\002\000\006\004" +
    "\063\054\uffcf\001\002\000\004\065\062\001\002\000\004" +
    "\054\uffd0\001\002\000\004\050\uffd1\001\002\000\006\004" +
    "\uffd2\037\uffd2\001\002\000\006\004\070\037\071\001\002" +
    "\000\004\062\072\001\002\000\004\031\uffd4\001\002\000" +
    "\006\004\uffd3\037\uffd3\001\002\000\004\050\074\001\002" +
    "\000\006\025\uffdf\047\uffdf\001\002\000\004\031\056\001" +
    "\002\000\004\014\027\001\002\000\004\031\056\001\002" +
    "\000\004\050\101\001\002\000\006\025\uffe2\047\uffe2\001" +
    "\002\000\004\050\103\001\002\000\006\025\uffe0\047\uffe0" +
    "\001\002\000\004\051\105\001\002\000\010\014\uffde\027" +
    "\uffde\030\uffde\001\002\000\006\025\uffe4\047\uffe4\001\002" +
    "\000\004\040\uffe6\001\002\000\010\020\ufff6\022\ufff6\042" +
    "\ufff6\001\002\000\010\020\112\022\143\042\140\001\002" +
    "\000\004\011\114\001\002\000\004\012\120\001\002\000" +
    "\004\060\115\001\002\000\004\034\116\001\002\000\004" +
    "\012\ufff3\001\002\000\004\013\127\001\002\000\004\061" +
    "\122\001\002\000\006\004\123\035\124\001\002\000\006" +
    "\004\ufff1\035\ufff1\001\002\000\004\061\125\001\002\000" +
    "\004\013\ufff2\001\002\000\006\004\ufff0\035\ufff0\001\002" +
    "\000\006\021\134\043\132\001\002\000\004\055\130\001" +
    "\002\000\004\036\131\001\002\000\010\021\uffef\043\uffef" +
    "\045\uffef\001\002\000\010\020\ufff5\022\ufff5\042\ufff5\001" +
    "\002\000\004\043\137\001\002\000\004\063\135\001\002" +
    "\000\004\044\136\001\002\000\006\043\uffee\045\uffee\001" +
    "\002\000\010\020\ufff4\022\ufff4\042\ufff4\001\002\000\006" +
    "\003\ufff9\024\ufff9\001\002\000\006\022\143\042\162\001" +
    "\002\000\010\020\ufff7\022\ufff7\042\ufff7\001\002\000\004" +
    "\023\146\001\002\000\006\022\uffec\042\uffec\001\002\000" +
    "\004\011\114\001\002\000\004\060\147\001\002\000\006" +
    "\004\uffe7\046\uffe7\001\002\000\006\004\151\046\152\001" +
    "\002\000\004\060\153\001\002\000\004\011\uffe9\001\002" +
    "\000\006\004\uffe8\046\uffe8\001\002\000\004\012\120\001" +
    "\002\000\004\013\127\001\002\000\006\021\134\045\157" +
    "\001\002\000\006\022\uffeb\042\uffeb\001\002\000\004\045" +
    "\161\001\002\000\006\022\uffea\042\uffea\001\002\000\006" +
    "\003\ufffa\024\ufffa\001\002\000\006\022\uffed\042\uffed\001" +
    "\002\000\004\056\174\001\002\000\006\010\170\041\166" +
    "\001\002\000\006\003\ufffe\017\ufffe\001\002\000\004\041" +
    "\173\001\002\000\004\057\171\001\002\000\004\033\172" +
    "\001\002\000\004\041\ufffb\001\002\000\006\003\uffff\017" +
    "\uffff\001\002\000\004\032\175\001\002\000\006\010\ufffc" +
    "\041\ufffc\001\002\000\004\002\000\001\002" });

  /** 
   * Acceso a la tabla parse-action.
   */
  public short[][] action_table() {return _action_table;}

  /** 
   * Tabla <code>reduce_goto</code>
   */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\174\000\004\003\003\001\001\000\002\001\001\000" +
    "\004\004\007\001\001\000\002\001\001\000\004\005\164" +
    "\001\001\000\004\007\012\001\001\000\006\010\107\011" +
    "\110\001\001\000\002\001\001\000\004\023\015\001\001" +
    "\000\002\001\001\000\006\024\020\025\017\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\024\105\001\001" +
    "\000\002\001\001\000\004\026\023\001\001\000\002\001" +
    "\001\000\010\027\024\033\027\034\025\001\001\000\006" +
    "\033\075\034\074\001\001\000\004\036\072\001\001\000" +
    "\004\035\066\001\001\000\004\034\054\001\001\000\002" +
    "\001\001\000\006\030\032\031\034\001\001\000\002\001" +
    "\001\000\004\032\041\001\001\000\002\001\001\000\006" +
    "\030\036\031\034\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\032\044\001\001\000\002\001\001\000\004\032" +
    "\046\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\036\056\001\001\000\004\037\060\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\037\063\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\036\101\001\001\000" +
    "\004\034\076\001\001\000\004\036\077\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\010\010\141\020" +
    "\143\021\140\001\001\000\004\012\112\001\001\000\004" +
    "\014\116\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\016\125\001\001\000\004\015\120" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\017\132" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\020\162\001\001\000\002\001\001" +
    "\000\004\022\144\001\001\000\002\001\001\000\004\012" +
    "\153\001\001\000\004\013\147\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\014\154\001\001\000\004\016\155" +
    "\001\001\000\004\017\157\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\006\166\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** 
   * Acceso a la tabla <code>reduce_goto</code>
   */
  public short[][] reduce_table() {return _reduce_table;}

  /**
   * Instancia de la clase de encapsulación de acción.
   */
  protected CUP$parser$actions action_obj;

  /**
   * Inicializador de objeto de encapsulación de acción.
   */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /**
   * Invocar una acción de análisis proporcionada por el usuario.
   */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /**
   * Indica el estado inicial.
   */
  public int start_state() {return 0;}
  /**
   * Indica la produccion de comienzo.
   */
  public int start_production() {return 1;}

  /**
   * <code>EOF</code> Symbol index.
   */
  public int EOF_sym() {return 0;}

  /**
   * <code>error</code> Symbol index.
   */
  public int error_sym() {return 1;}



	public static void main (String argv[]) throws Exception
	{
		String nombreArchivo = argv[0];
	  
	  if(nombreArchivo.endsWith(".upd")){
	  	File archivo = new File(nombreArchivo);
	  	if (!archivo.exists()){
	  		System.out.println("El fichero no existe, inserte otra ruta e intentelo de nuevo");
	  		
	  	}else{
	  			FileReader fr = new FileReader(archivo);
	  			UpdComp lex = new UpdComp(fr);
				parser analizador;
				analizador = new parser(lex);
				analizador.parse();
			}
	 }else{
		System.out.println("Error, el archivo debe de ser con extension .upd");
		
  	 }  
	}

	public void syntax_error(Symbol st){
		if(st.value == null) report_error("Error sintactico, se espera algo en linea:"+st.left+", caracter:"+st.right, null);
		else report_error("Error sintactico, valor-->"+st.value+", en linea:"+st.left+", caracter:"+st.right, null);
	}


}

/** 
 * Clase Cup generada para encapsular código de acción proporcionadas por el usuario.
 */
class CUP$parser$actions {
  private final parser parser;

  /** 
   * Constructor 
   */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** 
   * Method with the actual generated action code. 
   */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /** 
       * Objeto de símbolo para volver desde acciones
       */
      java_cup.runtime.Symbol CUP$parser$result;

      /** 
       * Selecciona la acción en función del número de acción
       */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 50: // behavList ::= BEHAV 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 
		Stack t = new Stack();
		t.push(e1);
		RESULT = t;
              CUP$parser$result = new java_cup.runtime.Symbol(29/*behavList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 49: // behavList ::= BEHAV COMA behavList 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Stack e2 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
				e2.push(e1);
				RESULT=e2;
              CUP$parser$result = new java_cup.runtime.Symbol(29/*behavList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 48: // behav ::= APERTURABEHAV behavList CIERREBEHAV 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Stack e1 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
			RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(28/*behav*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 47: // insBitCodeList ::= INSBITCODE 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
		Stack t = new Stack();
		t.push(e1);
		RESULT = t;
              CUP$parser$result = new java_cup.runtime.Symbol(27/*insBitCodeList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // insBitCodeList ::= insBitCodeList COMA INSBITCODE 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Stack e1 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
						e1.push(e2);
						RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(27/*insBitCodeList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // insBitCode ::= APERTURAINSBITCODE insBitCodeList CIERREINSBITCODE 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Stack e1 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
				RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(26/*insBitCode*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // out ::= APERTURAOUT ABRECORCHETE NOMBREOPERANDOOUT CIERRACORCHETE CIERREOUT 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(25/*out*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // operandoList ::= DATAMEM COMA operandoList 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(24/*operandoList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // operandoList ::= NOMBREOPERANDOIN COMA operandoList 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(24/*operandoList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // operandoList ::= DATAMEM 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(24/*operandoList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // operandoList ::= NOMBREOPERANDOIN 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(24/*operandoList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // operando ::= ABRECORCHETE operandoList CIERRACORCHETE 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(23/*operando*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // inList ::= operando COMA inList 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(22/*inList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // inList ::= operando 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(22/*inList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // in ::= APERTURAIN inList CIERREIN 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(21/*in*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // opcode ::= APERTURAOPCODE CODIGOOPERACION CIERREOPCODE 
            {
              String RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
				RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(20/*opcode*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // ins ::= APERTURAINS opcode insBitCode behav CIERREINS 
            {
              insClass RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Stack e2 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Stack e3 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
			insClass insC = new insClass(e1, e2, e3);
			RESULT = insC;
			System.out.println(insC.toString());
			
              CUP$parser$result = new java_cup.runtime.Symbol(18/*ins*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // ins ::= APERTURAINS opcode in insBitCode behav CIERREINS 
            {
              insClass RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Stack e2 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Stack e3 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
			insClass insC = new insClass(e1, e2, e3);
			RESULT = insC;
			System.out.println(insC.toString());
			
              CUP$parser$result = new java_cup.runtime.Symbol(18/*ins*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // ins ::= APERTURAINS opcode out insBitCode behav CIERREINS 
            {
              insClass RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Stack e2 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Stack e3 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
			insClass insC = new insClass(e1, e2, e3);
			RESULT = insC;
			System.out.println(insC.toString());
			
              CUP$parser$result = new java_cup.runtime.Symbol(18/*ins*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // ins ::= APERTURAINS opcode in out insBitCode behav CIERREINS 
            {
              insClass RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Stack e2 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Stack e3 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
			insClass insC = new insClass(e1, e2, e3);
			RESULT = insC;
			System.out.println(insC.toString());
			
              CUP$parser$result = new java_cup.runtime.Symbol(18/*ins*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // insList ::= ins 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(19/*insList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // insList ::= insList ins 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(19/*insList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // insns ::= error 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(17/*insns*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // insns ::= APERTURAINSNS insList CIERREINSNS 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(17/*insns*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // nameList ::= NAME 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 
			Stack t = new Stack();
			t.push(e1);
			RESULT = t;
              CUP$parser$result = new java_cup.runtime.Symbol(9/*nameList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // nameList ::= nameList COMA NAME 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Stack e1 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		e1.push(e2);
										RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(9/*nameList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // registers ::= APERTURAREGISTERS nameList CIERREREGISTERS 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Stack e1 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
				RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(16/*registers*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // group ::= APERTURAGROUP registers name use bitSize regBitCode CIERREGROUP 
            {
              storeClass RESULT = null;
		int e5left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left;
		int e5right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).right;
		Stack e5 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int e4left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int e4right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Stack e4 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e3 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
				storeClass st = new storeClass(e1, e2, e3, e4, e5);
				st.setGroup();
				System.out.println(st.toString());
				RESULT = st;
				
              CUP$parser$result = new java_cup.runtime.Symbol(14/*group*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // group ::= APERTURAGROUP registers name use bitSize CIERREGROUP 
            {
              storeClass RESULT = null;
		int e4left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int e4right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Stack e4 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Stack e3 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Integer e2 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
						storeClass st = new storeClass(e1, e2, e3, e4);
						st.setGroup();
						System.out.println(st.toString());
						RESULT = st;
						
              CUP$parser$result = new java_cup.runtime.Symbol(14/*group*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // groupList ::= group 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(15/*groupList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // groupList ::= groupList group 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(15/*groupList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // regBitCode ::= APERTURAREGBITCODE REGBITCODE CIERREREGBITCODE 
            {
              String RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
					RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(13/*regBitCode*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // bitSize ::= APERTURABITSIZE BITSIZE CIERREBITSIZE 
            {
              Integer RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Integer e1 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
				RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(12/*bitSize*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // useList ::= useList COMA USE 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Stack e1 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
			e1.push(e2);
			RESULT = e1;
			
              CUP$parser$result = new java_cup.runtime.Symbol(11/*useList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // useList ::= USE 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		
			Stack t = new Stack();
			t.push(e1);
			RESULT = t;
			
              CUP$parser$result = new java_cup.runtime.Symbol(11/*useList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // use ::= APERTURAUSE useList CIERREUSE 
            {
              Stack RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Stack e1 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
			RESULT = e1;
			
              CUP$parser$result = new java_cup.runtime.Symbol(10/*use*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // name ::= APERTURANAME NAME CIERRENAME 
            {
              String RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
			RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(8/*name*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // register ::= APERTURAREGISTER name use bitSize regBitCode CIERREREGISTER 
            {
              storeClass RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Stack e2 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Integer e3 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e4left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e4right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e4 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
					storeClass st = new storeClass(e1, e2, e3, e4);
					st.setRegister();
					System.out.println(st.toString());
					RESULT = st;
					
              CUP$parser$result = new java_cup.runtime.Symbol(6/*register*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // register ::= APERTURAREGISTER name use bitSize CIERREREGISTER 
            {
              storeClass RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Stack e2 = (Stack)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Integer e3 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
					storeClass st = new storeClass(e1, e2, e3);
					st.setRegister();
					System.out.println(st.toString());
					RESULT = st;
					
              CUP$parser$result = new java_cup.runtime.Symbol(6/*register*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // registerList ::= register 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(7/*registerList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // registerList ::= registerList register 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(7/*registerList*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // storage ::= error 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(5/*storage*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // storage ::= APERTURASTORAGE registerList CIERRESTORAGE 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(5/*storage*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // storage ::= APERTURASTORAGE registerList groupList CIERRESTORAGE 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(5/*storage*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // date ::= APERTURADATE DATE CIERREDATE 
            {
              String RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
			RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(4/*date*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // ident ::= APERTURAIDENT IDENT CIERREIDENT 
            {
              String RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
			RESULT = e1;
              CUP$parser$result = new java_cup.runtime.Symbol(3/*ident*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // descr ::= error 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(2/*descr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // descr ::= APERTURADESCR ident CIERREDESCR 
            {
              Object RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
				descrClass dc = new descrClass(e1);
				System.out.println(dc.toString());
				
              CUP$parser$result = new java_cup.runtime.Symbol(2/*descr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // descr ::= APERTURADESCR ident date CIERREDESCR 
            {
              Object RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String e1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String e2 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
				descrClass dc = new descrClass(e1, e2);
				System.out.println(dc.toString());
				
              CUP$parser$result = new java_cup.runtime.Symbol(2/*descr*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= upd EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          /* ACCEPTAR */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // upd ::= APERTURAUPD descr storage insns CIERREUPD 
            {
              Object RESULT = null;
		
              CUP$parser$result = new java_cup.runtime.Symbol(1/*upd*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Número de acción no válido en la tabla de análisis interno ");

        }
    }
}

