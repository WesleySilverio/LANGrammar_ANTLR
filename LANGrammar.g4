grammar LANGrammar;
@header {
	import io.compiler.types.*;
	import java.util.ArrayList;
	import java.util.HashMap;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
	import java.util.Stack;
}

@members {
	private HashMap<String, Var> symbolTable = new HashMap<String, Var>();
	private ArrayList<Var> currentDecl = new ArrayList<Var>();
	private Types currentType;
	private Types leftType = null, rightType = null;
	private Program program = new Program();
	private ArrayList<Command> commandList = new ArrayList<Command>();
	private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
	private ExprCommand currentAtrib;
	private String atrib = "";
	private Stack<IfCommand> ifCommandStack = new Stack<IfCommand>();
	private Stack<String> exprStack = new Stack<String>();
	private Stack<WhileCommand> whileStack = new Stack<WhileCommand>();
	private Stack<String> exprWhile = new Stack<String>();
	private Stack<DoWhileCommand> doWhileStack = new Stack<DoWhileCommand>();
	private Stack<String> exprDoWhile = new Stack<String>();
	private String StrTextId = "";
	
	
	public void updateType(){
		for (Var v: currentDecl){
			v.setType(currentType);
			symbolTable.put(v.getId(), v);
		}
	}
	
	public void exibirVar(){
		for (String id: symbolTable.keySet()){
			System.out.println(symbolTable.get(id));
		}
	}
	
	public boolean isDeclared(String id){
		return symbolTable.get(id) != null;
	}
		
	public void confirmedUsed(){
		for(String key: symbolTable.keySet()){
	    		if (!symbolTable.get(key).isUsed()){
	    			throw new UFABCSemanticException("A variável " + "'"+key+"'" + " não está sendo usada");
	    		}
	    	}
	}
	
	public Program getProgram(){
		return this.program;
	}
}

prog :	PROGRAMA
		ID {
				program.setName(_input.LT(-1).getText());
				stack.push(new ArrayList<Command>());			
		   }
      	declara+ 
	  	bloco 
	    {
	    	confirmedUsed();
	    }
	  	FIMPROG
	  	{
	  		program.setSymbolTable(symbolTable);
	  	 	program.setCommandList(stack.pop());
	  	}
	 ;

declara :	DECLARE {
						currentDecl.clear();
					}
		 	ID {
		 			currentDecl.add(new Var(_input.LT(-1).getText()));
		 	   }
		 	(VIRG 
		 	ID {
		 			currentDecl.add(new Var(_input.LT(-1).getText()));
		 	   }
		 	)* 
		 	DP (
		 	'NUMBER' {currentType = Types.NUMBER;}
		 	| 
		 	'STRING' {currentType = Types.STRING;}
		 	|
		 	'REALNUMBER' {currentType = Types.REALNUMBER;}
		 	){updateType();}
		 	PV
		; 	

bloco   : (cmd)+
        ;
        
cmd     :	cmdLeitura
		|	cmdEscrita
		|   cmdExpr
		|   cmdIf
		|   cmdWhile
		|   cmdDoWhile
		;  

cmdLeitura : LEIA 
			 AP 
			 ID	{
			 		if(!isDeclared(_input.LT(-1).getText())){
			 			throw new UFABCSemanticException("A seguinte variável não foi declarada " +_input.LT(-1).getText());
			 		}
			 		symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			 		symbolTable.get(_input.LT(-1).getText()).setUsed(true);
			 		Command cmdRead = new readCommand(symbolTable.get(_input.LT(-1).getText()));
			 		stack.peek().add(cmdRead);
			    } 
			 FP 
			 PV
		   ; 
        
cmdEscrita : ESCREVA 
			 AP 
			 (TEXTO {StrTextId += _input.LT(-1).getText();}
			 (AD 	{StrTextId += _input.LT(-1).getText();}
			 ID	{			 		
			 		if(!isDeclared(_input.LT(-1).getText())){
			 			throw new UFABCSemanticException("A seguinte variável não foi declarada " +_input.LT(-1).getText());
			 		symbolTable.get(_input.LT(-1).getText()).setUsed(true);
			 		StrTextId += symbolTable.get(_input.LT(-1).getText()).getId();
			 	}
			 )
			 ? {	WriteCommand cmdWrite = new WriteCommand(StrTextId);
			 		stack.peek().add(cmdWrite);
			 		StrTextId = "";
			   }

			 | 
			 ID {
			 		if(!isDeclared(_input.LT(-1).getText())){
			 			throw new UFABCSemanticException("A seguinte variável não foi declarada " +_input.LT(-1).getText());
			 		}
			 		if(!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
			 			throw new UFABCSemanticException("Não houve inicialização da variável "+"'" +_input.LT(-1).getText()+"'");
			 		}
			 		symbolTable.get(_input.LT(-1).getText()).setUsed(true);
			 		Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			 		stack.peek().add(cmdWrite);
			    } 
			 ) 
			 FP 
			 PV
			 {rightType = null;}
		   ;
        
cmdIf :	SE {
				stack.push(new ArrayList<Command>());
				ifCommandStack.push(new IfCommand());
				exprStack.push("");
		   }
	   	AP 
	   	expr {exprStack.push(_input.LT(-1).getText());}
	   	
	   	
	   	OP_REL {
					    String leftExpr = exprStack.pop();
            			exprStack.push(leftExpr + _input.LT(-1).getText());
	   		   }
	   	expr {  String rightExpr = _input.LT(-1).getText();
            	String fullExpr = exprStack.pop() + rightExpr;
            	exprStack.push(fullExpr);
            	ifCommandStack.peek().setExpression(fullExpr); 
             }
	   	FP 
	   	ENTAO 
	   	'{' 
	   	cmd+
	   	{
	   		ifCommandStack.peek().setTrueList(stack.pop());	
	   	}
	   	
	   	
	   	'}'
	   	(SENAO 
	   	{stack.push(new ArrayList<Command>());}
	   	'{'
	   	cmd+
	   	{
	   		ifCommandStack.peek().setFalseList(stack.pop());
	   	}
	   	'}')?
	   	{
	   		stack.peek().add(ifCommandStack.pop());
	   	}
      ;

cmdExpr : ID {
			 	if(!isDeclared(_input.LT(-1).getText())){
			 			throw new UFABCSemanticException("A seguinte variável não foi declarada " +_input.LT(-1).getText());
			 	}
			 	symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			 	leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			 	atrib = "";	
			 	currentAtrib = new ExprCommand();
			 	currentAtrib.setVar(symbolTable.get(_input.LT(-1).getText()));
			 } 
		  OP_AT 
		  expr		
		  PV
		  {
		  	//System.out.println("left: " + leftType);
		  	//System.out.println("right: " +rightType);
		  	if(leftType.getValue() < rightType.getValue()){
		  		throw new UFABCSemanticException("tipo incompatível na atribuição da variavel " +"'"+currentAtrib.getVar().getId()+"'");
		  	}
		  	currentAtrib.setFatores(atrib);
		  	stack.peek().add(currentAtrib);
		  }
        ;
        
cmdWhile : WHILE {
					stack.push(new ArrayList<Command>());
					exprWhile.push("");
					whileStack.push(new WhileCommand());
				 }
		   AP 
		   expr {exprWhile.push(_input.LT(-1).getText());}
		   OP_REL {
					    String leftWhile = exprWhile.pop();
            			exprWhile.push(leftWhile + _input.LT(-1).getText());
	   		      }
		   expr {
		   			String rightWhile = _input.LT(-1).getText();
            		String fullWhile = exprWhile.pop() + rightWhile;
            		exprWhile.push(fullWhile);
            		whileStack.peek().setExpression(fullWhile); 
		   	    }
		   FP 
		   '{' 
		   cmd+ 
		   {whileStack.peek().setWhileList(stack.pop());}
		   '}'
		   {stack.peek().add(whileStack.pop());}
		 ;    
 
cmdDoWhile	: DO {
						stack.push(new ArrayList<>());
						exprDoWhile.push("");
						doWhileStack.push(new DoWhileCommand());
				 }
		      '{' 
		      cmd+ 
		      {doWhileStack.peek().setDowhileList(stack.pop());}
		      '}' 
		      WHILE 
		      AP 
		      expr {exprDoWhile.push(_input.LT(-1).getText());}
		      OP_REL {
					    String leftDoWhile = exprDoWhile.pop();
            			exprDoWhile.push(leftDoWhile + _input.LT(-1).getText());
	   		         }
		      expr {
		   				String rightDoWhile = _input.LT(-1).getText();
            			String fullDoWhile = exprDoWhile.pop() + rightDoWhile;
            			exprDoWhile.push(fullDoWhile);
            			doWhileStack.peek().setExpression(fullDoWhile); 
		   	       }
		      FP 
		      PV
		      {stack.peek().add(doWhileStack.pop());}
			;     
        
expr : termo exprl
	 ;

exprl : ((AD  | SUB) {atrib += _input.LT(-1).getText();}
		termo 
	    )* 
	 ;
	   
termo : fator {atrib += _input.LT(-1).getText();}
		termol
	  ;
termol : ((MULT | DIV) {atrib += _input.LT(-1).getText();}
	     fator {atrib += _input.LT(-1).getText();}
	     )*	  
       ;
             
fator : NUM {
				if(rightType == null){
					rightType = Types.NUMBER;
				}
				else{
					if(rightType.getValue() < Types.NUMBER.getValue()){
						rightType = Types.NUMBER;
					}
				}
			}
		|
		NUMDECIMAL{
		
						if(rightType == null){
							rightType = Types.REALNUMBER;
						}
						else{
							if(rightType.getValue() < Types.REALNUMBER.getValue()){
								rightType = Types.REALNUMBER;
							}
						}
				  }				
	    | 
	    ID {
			 	if(!isDeclared(_input.LT(-1).getText())){
			 			throw new UFABCSemanticException("A seguinte variável não foi declarada "+"'" +_input.LT(-1).getText()+"'");
			 	}
			 	if(!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
			 		throw new UFABCSemanticException("Não houve inicialização da variável "+"'" +_input.LT(-1).getText()+"'");
			 	}
			 	symbolTable.get(_input.LT(-1).getText()).setUsed(true);
			 	if(rightType == null){
			 		rightType = symbolTable.get(_input.LT(-1).getText()).getType();
			 	}
			 	else{
			 		if(symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
			 			rightType = symbolTable.get(_input.LT(-1).getText()).getType();
			 		}
			 	}
		   } 
		|
		TEXTO {
			 		if(rightType == null){
			 			rightType = Types.STRING;
			 		}
			 		else{
			 			if(rightType.getValue() < Types.STRING.getValue()){
			 			rightType = Types.STRING;
			 		}
			 	 }
			  }     
	    | 
	    AP {atrib += _input.LT(-1).getText();}
	    expr 
	    FP 
	  ;	        

PROGRAMA : 'programa'
     	 ;
     	 
FIMPROG  : 'fimprog;'
		 ;     	 
		 
SE		 : '"se"'
		 ;		 

SENAO    : '"senao"'
	     ;

DECLARE  : 'declare'
		 ;
		 
LEIA     : 'leia'
	     ;		 
	     
ESCREVA  : 'escreva'
		 ;	     

ENTAO    : 'entao'
		 ;
		 
WHILE 	 : 'enquanto'
		 ;

DO		 :	'realize'
		 ;		 

ID  :  ([a-z] | [A-Z])([a-z] | [A-Z] | [0-9])*
	;
	
NUMDECIMAL : [0-9]+'.'[0-9]+
		   ;    	
	
NUM : [0-9]+
    ;
    
    
TEXTO : '"' (~["])* '"'
      ; 

WS  : ('\n' | '\r' | '\t' | ' ' ) -> skip
    ;
    
AD  : '+'
	;
	
SUB : '-'
	;	
	
DIV : '/'
	;
	
MULT : '*'
     ;		

OP_REL : '<' | '>' | '<=' | '>=' | '==' | '!='
       ;

OP_AT :	':='
      ;

DP  : ':'
    ;

PV  : ';'
	;
	
VIRG : ','
	 ;

AP : '('
   ;

FP : ')'
   ;
   