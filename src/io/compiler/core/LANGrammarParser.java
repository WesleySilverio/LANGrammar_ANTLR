// Generated from LANGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

	import io.compiler.types.*;
	import java.util.ArrayList;
	import java.util.HashMap;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LANGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, PROGRAMA=6, FIMPROG=7, SE=8, SENAO=9, 
		DECLARE=10, LEIA=11, ESCREVA=12, ENTAO=13, WHILE=14, DO=15, ID=16, NUMDECIMAL=17, 
		NUM=18, TEXTO=19, WS=20, AD=21, SUB=22, DIV=23, MULT=24, OP_REL=25, OP_AT=26, 
		DP=27, PV=28, VIRG=29, AP=30, FP=31;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_bloco = 2, RULE_cmd = 3, RULE_cmdLeitura = 4, 
		RULE_cmdEscrita = 5, RULE_cmdIf = 6, RULE_cmdExpr = 7, RULE_cmdWhile = 8, 
		RULE_cmdDoWhile = 9, RULE_expr = 10, RULE_exprl = 11, RULE_termo = 12, 
		RULE_termol = 13, RULE_fator = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declara", "bloco", "cmd", "cmdLeitura", "cmdEscrita", "cmdIf", 
			"cmdExpr", "cmdWhile", "cmdDoWhile", "expr", "exprl", "termo", "termol", 
			"fator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'NUMBER'", "'STRING'", "'REALNUMBER'", "'{'", "'}'", "'programa'", 
			"'fimprog;'", "'\"se\"'", "'\"senao\"'", "'declare'", "'leia'", "'escreva'", 
			"'entao'", "'enquanto'", "'realize'", null, null, null, null, null, "'+'", 
			"'-'", "'/'", "'*'", null, "':='", "':'", "';'", "','", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "PROGRAMA", "FIMPROG", "SE", "SENAO", 
			"DECLARE", "LEIA", "ESCREVA", "ENTAO", "WHILE", "DO", "ID", "NUMDECIMAL", 
			"NUM", "TEXTO", "WS", "AD", "SUB", "DIV", "MULT", "OP_REL", "OP_AT", 
			"DP", "PV", "VIRG", "AP", "FP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LANGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public LANGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode PROGRAMA() { return getToken(LANGrammarParser.PROGRAMA, 0); }
		public TerminalNode ID() { return getToken(LANGrammarParser.ID, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode FIMPROG() { return getToken(LANGrammarParser.FIMPROG, 0); }
		public List<DeclaraContext> declara() {
			return getRuleContexts(DeclaraContext.class);
		}
		public DeclaraContext declara(int i) {
			return getRuleContext(DeclaraContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(PROGRAMA);
			setState(31);
			match(ID);

							program.setName(_input.LT(-1).getText());
							stack.push(new ArrayList<Command>());			
					   
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				declara();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DECLARE );
			setState(38);
			bloco();

				    	confirmedUsed();
				    
			setState(40);
			match(FIMPROG);

				  		program.setSymbolTable(symbolTable);
				  	 	program.setCommandList(stack.pop());
				  	
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaraContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(LANGrammarParser.DECLARE, 0); }
		public List<TerminalNode> ID() { return getTokens(LANGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LANGrammarParser.ID, i);
		}
		public TerminalNode DP() { return getToken(LANGrammarParser.DP, 0); }
		public TerminalNode PV() { return getToken(LANGrammarParser.PV, 0); }
		public List<TerminalNode> VIRG() { return getTokens(LANGrammarParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(LANGrammarParser.VIRG, i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(DECLARE);

									currentDecl.clear();
								
			setState(45);
			match(ID);

					 			currentDecl.add(new Var(_input.LT(-1).getText()));
					 	   
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(47);
				match(VIRG);
				setState(48);
				match(ID);

						 			currentDecl.add(new Var(_input.LT(-1).getText()));
						 	   
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(DP);
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(56);
				match(T__0);
				currentType = Types.NUMBER;
				}
				break;
			case T__1:
				{
				setState(58);
				match(T__1);
				currentType = Types.STRING;
				}
				break;
			case T__2:
				{
				setState(60);
				match(T__2);
				currentType = Types.REALNUMBER;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			updateType();
			setState(65);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				cmd();
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 121088L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdExprContext cmdExpr() {
			return getRuleContext(CmdExprContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdDoWhileContext cmdDoWhile() {
			return getRuleContext(CmdDoWhileContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmd);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEIA:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				cmdLeitura();
				}
				break;
			case ESCREVA:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				cmdEscrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				cmdExpr();
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				cmdIf();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				cmdWhile();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
				cmdDoWhile();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode LEIA() { return getToken(LANGrammarParser.LEIA, 0); }
		public TerminalNode AP() { return getToken(LANGrammarParser.AP, 0); }
		public TerminalNode ID() { return getToken(LANGrammarParser.ID, 0); }
		public TerminalNode FP() { return getToken(LANGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(LANGrammarParser.PV, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(LEIA);
			setState(81);
			match(AP);
			setState(82);
			match(ID);

						 		if(!isDeclared(_input.LT(-1).getText())){
						 			throw new UFABCSemanticException("A seguinte variável não foi declarada " +_input.LT(-1).getText());
						 		}
						 		symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
						 		symbolTable.get(_input.LT(-1).getText()).setUsed(true);
						 		Command cmdRead = new readCommand(symbolTable.get(_input.LT(-1).getText()));
						 		stack.peek().add(cmdRead);
						    
			setState(84);
			match(FP);
			setState(85);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode ESCREVA() { return getToken(LANGrammarParser.ESCREVA, 0); }
		public TerminalNode AP() { return getToken(LANGrammarParser.AP, 0); }
		public TerminalNode FP() { return getToken(LANGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(LANGrammarParser.PV, 0); }
		public TerminalNode TEXTO() { return getToken(LANGrammarParser.TEXTO, 0); }
		public TerminalNode ID() { return getToken(LANGrammarParser.ID, 0); }
		public TerminalNode AD() { return getToken(LANGrammarParser.AD, 0); }
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdEscrita);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(ESCREVA);
			setState(88);
			match(AP);
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTO:
				{
				setState(89);
				match(TEXTO);
				StrTextId += _input.LT(-1).getText();
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AD) {
					{
					setState(91);
					match(AD);
					StrTextId += _input.LT(-1).getText();
					setState(93);
					match(ID);
								 		
								 		symbolTable.get(_input.LT(-1).getText()).setUsed(true);
								 		StrTextId += symbolTable.get(_input.LT(-1).getText()).getId();
								 	
					}
				}

					WriteCommand cmdWrite = new WriteCommand(StrTextId);
							 		stack.peek().add(cmdWrite);
							 		StrTextId = "";
							   
				}
				break;
			case ID:
				{
				setState(98);
				match(ID);

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
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(102);
			match(FP);
			setState(103);
			match(PV);
			rightType = null;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIfContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(LANGrammarParser.SE, 0); }
		public TerminalNode AP() { return getToken(LANGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(LANGrammarParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(LANGrammarParser.FP, 0); }
		public TerminalNode ENTAO() { return getToken(LANGrammarParser.ENTAO, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(LANGrammarParser.SENAO, 0); }
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterCmdIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitCmdIf(this);
		}
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(SE);

							stack.push(new ArrayList<Command>());
							ifCommandStack.push(new IfCommand());
							exprStack.push("");
					   
			setState(108);
			match(AP);
			setState(109);
			expr();
			exprStack.push(_input.LT(-1).getText());
			setState(111);
			match(OP_REL);

								    String leftExpr = exprStack.pop();
			            			exprStack.push(leftExpr + _input.LT(-1).getText());
				   		   
			setState(113);
			expr();
			  String rightExpr = _input.LT(-1).getText();
			            	String fullExpr = exprStack.pop() + rightExpr;
			            	exprStack.push(fullExpr);
			            	ifCommandStack.peek().setExpression(fullExpr); 
			             
			setState(115);
			match(FP);
			setState(116);
			match(ENTAO);
			setState(117);
			match(T__3);
			setState(119); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(118);
				cmd();
				}
				}
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 121088L) != 0) );

				   		ifCommandStack.peek().setTrueList(stack.pop());	
				   	
			setState(124);
			match(T__4);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(125);
				match(SENAO);
				stack.push(new ArrayList<Command>());
				setState(127);
				match(T__3);
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(128);
					cmd();
					}
					}
					setState(131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 121088L) != 0) );

					   		ifCommandStack.peek().setFalseList(stack.pop());
					   	
				setState(134);
				match(T__4);
				}
			}


				   		stack.peek().add(ifCommandStack.pop());
				   	
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LANGrammarParser.ID, 0); }
		public TerminalNode OP_AT() { return getToken(LANGrammarParser.OP_AT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PV() { return getToken(LANGrammarParser.PV, 0); }
		public CmdExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterCmdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitCmdExpr(this);
		}
	}

	public final CmdExprContext cmdExpr() throws RecognitionException {
		CmdExprContext _localctx = new CmdExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(ID);

						 	if(!isDeclared(_input.LT(-1).getText())){
						 			throw new UFABCSemanticException("A seguinte variável não foi declarada " +_input.LT(-1).getText());
						 	}
						 	symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
						 	leftType = symbolTable.get(_input.LT(-1).getText()).getType();
						 	atrib = "";	
						 	currentAtrib = new ExprCommand();
						 	currentAtrib.setVar(symbolTable.get(_input.LT(-1).getText()));
						 
			setState(142);
			match(OP_AT);
			setState(143);
			expr();
			setState(144);
			match(PV);

					  	//System.out.println("left: " + leftType);
					  	//System.out.println("right: " +rightType);
					  	if(leftType.getValue() < rightType.getValue()){
					  		throw new UFABCSemanticException("tipo incompatível na atribuição da variavel " +"'"+currentAtrib.getVar().getId()+"'");
					  	}
					  	currentAtrib.setFatores(atrib);
					  	stack.peek().add(currentAtrib);
					  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LANGrammarParser.WHILE, 0); }
		public TerminalNode AP() { return getToken(LANGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(LANGrammarParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(LANGrammarParser.FP, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(WHILE);

								stack.push(new ArrayList<Command>());
								exprWhile.push("");
								whileStack.push(new WhileCommand());
							 
			setState(149);
			match(AP);
			setState(150);
			expr();
			exprWhile.push(_input.LT(-1).getText());
			setState(152);
			match(OP_REL);

								    String leftWhile = exprWhile.pop();
			            			exprWhile.push(leftWhile + _input.LT(-1).getText());
				   		      
			setState(154);
			expr();

					   			String rightWhile = _input.LT(-1).getText();
			            		String fullWhile = exprWhile.pop() + rightWhile;
			            		exprWhile.push(fullWhile);
			            		whileStack.peek().setExpression(fullWhile); 
					   	    
			setState(156);
			match(FP);
			setState(157);
			match(T__3);
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(158);
				cmd();
				}
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 121088L) != 0) );
			whileStack.peek().setWhileList(stack.pop());
			setState(164);
			match(T__4);
			stack.peek().add(whileStack.pop());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdDoWhileContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(LANGrammarParser.DO, 0); }
		public TerminalNode WHILE() { return getToken(LANGrammarParser.WHILE, 0); }
		public TerminalNode AP() { return getToken(LANGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(LANGrammarParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(LANGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(LANGrammarParser.PV, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdDoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDoWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterCmdDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitCmdDoWhile(this);
		}
	}

	public final CmdDoWhileContext cmdDoWhile() throws RecognitionException {
		CmdDoWhileContext _localctx = new CmdDoWhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdDoWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(DO);

									stack.push(new ArrayList<>());
									exprDoWhile.push("");
									doWhileStack.push(new DoWhileCommand());
							 
			setState(169);
			match(T__3);
			setState(171); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(170);
				cmd();
				}
				}
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 121088L) != 0) );
			doWhileStack.peek().setDowhileList(stack.pop());
			setState(176);
			match(T__4);
			setState(177);
			match(WHILE);
			setState(178);
			match(AP);
			setState(179);
			expr();
			exprDoWhile.push(_input.LT(-1).getText());
			setState(181);
			match(OP_REL);

								    String leftDoWhile = exprDoWhile.pop();
			            			exprDoWhile.push(leftDoWhile + _input.LT(-1).getText());
				   		         
			setState(183);
			expr();

					   				String rightDoWhile = _input.LT(-1).getText();
			            			String fullDoWhile = exprDoWhile.pop() + rightDoWhile;
			            			exprDoWhile.push(fullDoWhile);
			            			doWhileStack.peek().setExpression(fullDoWhile); 
					   	       
			setState(185);
			match(FP);
			setState(186);
			match(PV);
			stack.peek().add(doWhileStack.pop());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			termo();
			setState(190);
			exprl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprlContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> AD() { return getTokens(LANGrammarParser.AD); }
		public TerminalNode AD(int i) {
			return getToken(LANGrammarParser.AD, i);
		}
		public List<TerminalNode> SUB() { return getTokens(LANGrammarParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(LANGrammarParser.SUB, i);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AD || _la==SUB) {
				{
				{
				setState(192);
				_la = _input.LA(1);
				if ( !(_la==AD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				atrib += _input.LT(-1).getText();
				setState(194);
				termo();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermolContext termol() {
			return getRuleContext(TermolContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			fator();
			atrib += _input.LT(-1).getText();
			setState(202);
			termol();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermolContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(LANGrammarParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(LANGrammarParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(LANGrammarParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LANGrammarParser.DIV, i);
		}
		public TermolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterTermol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitTermol(this);
		}
	}

	public final TermolContext termol() throws RecognitionException {
		TermolContext _localctx = new TermolContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIV || _la==MULT) {
				{
				{
				setState(204);
				_la = _input.LA(1);
				if ( !(_la==DIV || _la==MULT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				atrib += _input.LT(-1).getText();
				setState(206);
				fator();
				atrib += _input.LT(-1).getText();
				}
				}
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(LANGrammarParser.NUM, 0); }
		public TerminalNode NUMDECIMAL() { return getToken(LANGrammarParser.NUMDECIMAL, 0); }
		public TerminalNode ID() { return getToken(LANGrammarParser.ID, 0); }
		public TerminalNode TEXTO() { return getToken(LANGrammarParser.TEXTO, 0); }
		public TerminalNode AP() { return getToken(LANGrammarParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(LANGrammarParser.FP, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGrammarListener ) ((LANGrammarListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fator);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(NUM);

								if(rightType == null){
									rightType = Types.NUMBER;
								}
								else{
									if(rightType.getValue() < Types.NUMBER.getValue()){
										rightType = Types.NUMBER;
									}
								}
							
				}
				break;
			case NUMDECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(NUMDECIMAL);

						
										if(rightType == null){
											rightType = Types.REALNUMBER;
										}
										else{
											if(rightType.getValue() < Types.REALNUMBER.getValue()){
												rightType = Types.REALNUMBER;
											}
										}
								  
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				match(ID);

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
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				match(TEXTO);

							 		if(rightType == null){
							 			rightType = Types.STRING;
							 		}
							 		else{
							 			if(rightType.getValue() < Types.STRING.getValue()){
							 			rightType = Types.STRING;
							 		}
							 	 }
							  
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 5);
				{
				setState(222);
				match(AP);
				atrib += _input.LT(-1).getText();
				setState(224);
				expr();
				setState(225);
				match(FP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00e6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0004\u0000#\b\u0000\u000b\u0000\f\u0000"+
		"$\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00013\b\u0001\n\u0001\f\u00016\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"?\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002"+
		"E\b\u0002\u000b\u0002\f\u0002F\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005`\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005e\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006x\b\u0006\u000b\u0006\f\u0006y\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006"+
		"\u0082\b\u0006\u000b\u0006\f\u0006\u0083\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u0089\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0004\b\u00a0\b\b\u000b\b\f\b\u00a1\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00ac\b\t\u000b"+
		"\t\f\t\u00ad\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00c4\b\u000b\n\u000b"+
		"\f\u000b\u00c7\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0005\r\u00d2\b\r\n\r\f\r\u00d5\t\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00e4\b\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0002"+
		"\u0001\u0000\u0015\u0016\u0001\u0000\u0017\u0018\u00ed\u0000\u001e\u0001"+
		"\u0000\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000"+
		"\u0000\u0006N\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\nW\u0001"+
		"\u0000\u0000\u0000\fj\u0001\u0000\u0000\u0000\u000e\u008c\u0001\u0000"+
		"\u0000\u0000\u0010\u0093\u0001\u0000\u0000\u0000\u0012\u00a7\u0001\u0000"+
		"\u0000\u0000\u0014\u00bd\u0001\u0000\u0000\u0000\u0016\u00c5\u0001\u0000"+
		"\u0000\u0000\u0018\u00c8\u0001\u0000\u0000\u0000\u001a\u00d3\u0001\u0000"+
		"\u0000\u0000\u001c\u00e3\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0006"+
		"\u0000\u0000\u001f \u0005\u0010\u0000\u0000 \"\u0006\u0000\uffff\uffff"+
		"\u0000!#\u0003\u0002\u0001\u0000\"!\u0001\u0000\u0000\u0000#$\u0001\u0000"+
		"\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0001"+
		"\u0000\u0000\u0000&\'\u0003\u0004\u0002\u0000\'(\u0006\u0000\uffff\uffff"+
		"\u0000()\u0005\u0007\u0000\u0000)*\u0006\u0000\uffff\uffff\u0000*\u0001"+
		"\u0001\u0000\u0000\u0000+,\u0005\n\u0000\u0000,-\u0006\u0001\uffff\uffff"+
		"\u0000-.\u0005\u0010\u0000\u0000.4\u0006\u0001\uffff\uffff\u0000/0\u0005"+
		"\u001d\u0000\u000001\u0005\u0010\u0000\u000013\u0006\u0001\uffff\uffff"+
		"\u00002/\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u000064\u0001"+
		"\u0000\u0000\u00007>\u0005\u001b\u0000\u000089\u0005\u0001\u0000\u0000"+
		"9?\u0006\u0001\uffff\uffff\u0000:;\u0005\u0002\u0000\u0000;?\u0006\u0001"+
		"\uffff\uffff\u0000<=\u0005\u0003\u0000\u0000=?\u0006\u0001\uffff\uffff"+
		"\u0000>8\u0001\u0000\u0000\u0000>:\u0001\u0000\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0006\u0001\uffff\uffff\u0000"+
		"AB\u0005\u001c\u0000\u0000B\u0003\u0001\u0000\u0000\u0000CE\u0003\u0006"+
		"\u0003\u0000DC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FD\u0001"+
		"\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\u0005\u0001\u0000\u0000"+
		"\u0000HO\u0003\b\u0004\u0000IO\u0003\n\u0005\u0000JO\u0003\u000e\u0007"+
		"\u0000KO\u0003\f\u0006\u0000LO\u0003\u0010\b\u0000MO\u0003\u0012\t\u0000"+
		"NH\u0001\u0000\u0000\u0000NI\u0001\u0000\u0000\u0000NJ\u0001\u0000\u0000"+
		"\u0000NK\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000"+
		"\u0000\u0000O\u0007\u0001\u0000\u0000\u0000PQ\u0005\u000b\u0000\u0000"+
		"QR\u0005\u001e\u0000\u0000RS\u0005\u0010\u0000\u0000ST\u0006\u0004\uffff"+
		"\uffff\u0000TU\u0005\u001f\u0000\u0000UV\u0005\u001c\u0000\u0000V\t\u0001"+
		"\u0000\u0000\u0000WX\u0005\f\u0000\u0000Xd\u0005\u001e\u0000\u0000YZ\u0005"+
		"\u0013\u0000\u0000Z_\u0006\u0005\uffff\uffff\u0000[\\\u0005\u0015\u0000"+
		"\u0000\\]\u0006\u0005\uffff\uffff\u0000]^\u0005\u0010\u0000\u0000^`\u0006"+
		"\u0005\uffff\uffff\u0000_[\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000ae\u0006\u0005\uffff\uffff\u0000bc\u0005"+
		"\u0010\u0000\u0000ce\u0006\u0005\uffff\uffff\u0000dY\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0005\u001f"+
		"\u0000\u0000gh\u0005\u001c\u0000\u0000hi\u0006\u0005\uffff\uffff\u0000"+
		"i\u000b\u0001\u0000\u0000\u0000jk\u0005\b\u0000\u0000kl\u0006\u0006\uffff"+
		"\uffff\u0000lm\u0005\u001e\u0000\u0000mn\u0003\u0014\n\u0000no\u0006\u0006"+
		"\uffff\uffff\u0000op\u0005\u0019\u0000\u0000pq\u0006\u0006\uffff\uffff"+
		"\u0000qr\u0003\u0014\n\u0000rs\u0006\u0006\uffff\uffff\u0000st\u0005\u001f"+
		"\u0000\u0000tu\u0005\r\u0000\u0000uw\u0005\u0004\u0000\u0000vx\u0003\u0006"+
		"\u0003\u0000wv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yw\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{|\u0006\u0006\uffff\uffff\u0000|\u0088\u0005\u0005\u0000\u0000}~\u0005"+
		"\t\u0000\u0000~\u007f\u0006\u0006\uffff\uffff\u0000\u007f\u0081\u0005"+
		"\u0004\u0000\u0000\u0080\u0082\u0003\u0006\u0003\u0000\u0081\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0081\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0006\u0006\uffff\uffff\u0000\u0086\u0087"+
		"\u0005\u0005\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088}\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0006\u0006\uffff\uffff\u0000\u008b\r\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0005\u0010\u0000\u0000\u008d\u008e\u0006"+
		"\u0007\uffff\uffff\u0000\u008e\u008f\u0005\u001a\u0000\u0000\u008f\u0090"+
		"\u0003\u0014\n\u0000\u0090\u0091\u0005\u001c\u0000\u0000\u0091\u0092\u0006"+
		"\u0007\uffff\uffff\u0000\u0092\u000f\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0005\u000e\u0000\u0000\u0094\u0095\u0006\b\uffff\uffff\u0000\u0095\u0096"+
		"\u0005\u001e\u0000\u0000\u0096\u0097\u0003\u0014\n\u0000\u0097\u0098\u0006"+
		"\b\uffff\uffff\u0000\u0098\u0099\u0005\u0019\u0000\u0000\u0099\u009a\u0006"+
		"\b\uffff\uffff\u0000\u009a\u009b\u0003\u0014\n\u0000\u009b\u009c\u0006"+
		"\b\uffff\uffff\u0000\u009c\u009d\u0005\u001f\u0000\u0000\u009d\u009f\u0005"+
		"\u0004\u0000\u0000\u009e\u00a0\u0003\u0006\u0003\u0000\u009f\u009e\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u009f\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0006\b\uffff\uffff\u0000\u00a4\u00a5\u0005"+
		"\u0005\u0000\u0000\u00a5\u00a6\u0006\b\uffff\uffff\u0000\u00a6\u0011\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0005\u000f\u0000\u0000\u00a8\u00a9\u0006"+
		"\t\uffff\uffff\u0000\u00a9\u00ab\u0005\u0004\u0000\u0000\u00aa\u00ac\u0003"+
		"\u0006\u0003\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b0\u0006"+
		"\t\uffff\uffff\u0000\u00b0\u00b1\u0005\u0005\u0000\u0000\u00b1\u00b2\u0005"+
		"\u000e\u0000\u0000\u00b2\u00b3\u0005\u001e\u0000\u0000\u00b3\u00b4\u0003"+
		"\u0014\n\u0000\u00b4\u00b5\u0006\t\uffff\uffff\u0000\u00b5\u00b6\u0005"+
		"\u0019\u0000\u0000\u00b6\u00b7\u0006\t\uffff\uffff\u0000\u00b7\u00b8\u0003"+
		"\u0014\n\u0000\u00b8\u00b9\u0006\t\uffff\uffff\u0000\u00b9\u00ba\u0005"+
		"\u001f\u0000\u0000\u00ba\u00bb\u0005\u001c\u0000\u0000\u00bb\u00bc\u0006"+
		"\t\uffff\uffff\u0000\u00bc\u0013\u0001\u0000\u0000\u0000\u00bd\u00be\u0003"+
		"\u0018\f\u0000\u00be\u00bf\u0003\u0016\u000b\u0000\u00bf\u0015\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0007\u0000\u0000\u0000\u00c1\u00c2\u0006\u000b"+
		"\uffff\uffff\u0000\u00c2\u00c4\u0003\u0018\f\u0000\u00c3\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u0017\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00c9\u0003\u001c"+
		"\u000e\u0000\u00c9\u00ca\u0006\f\uffff\uffff\u0000\u00ca\u00cb\u0003\u001a"+
		"\r\u0000\u00cb\u0019\u0001\u0000\u0000\u0000\u00cc\u00cd\u0007\u0001\u0000"+
		"\u0000\u00cd\u00ce\u0006\r\uffff\uffff\u0000\u00ce\u00cf\u0003\u001c\u000e"+
		"\u0000\u00cf\u00d0\u0006\r\uffff\uffff\u0000\u00d0\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d1\u00cc\u0001\u0000\u0000\u0000\u00d2\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d4\u001b\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0005\u0012\u0000\u0000\u00d7\u00e4\u0006\u000e\uffff"+
		"\uffff\u0000\u00d8\u00d9\u0005\u0011\u0000\u0000\u00d9\u00e4\u0006\u000e"+
		"\uffff\uffff\u0000\u00da\u00db\u0005\u0010\u0000\u0000\u00db\u00e4\u0006"+
		"\u000e\uffff\uffff\u0000\u00dc\u00dd\u0005\u0013\u0000\u0000\u00dd\u00e4"+
		"\u0006\u000e\uffff\uffff\u0000\u00de\u00df\u0005\u001e\u0000\u0000\u00df"+
		"\u00e0\u0006\u000e\uffff\uffff\u0000\u00e0\u00e1\u0003\u0014\n\u0000\u00e1"+
		"\u00e2\u0005\u001f\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3"+
		"\u00d6\u0001\u0000\u0000\u0000\u00e3\u00d8\u0001\u0000\u0000\u0000\u00e3"+
		"\u00da\u0001\u0000\u0000\u0000\u00e3\u00dc\u0001\u0000\u0000\u0000\u00e3"+
		"\u00de\u0001\u0000\u0000\u0000\u00e4\u001d\u0001\u0000\u0000\u0000\u000f"+
		"$4>FN_dy\u0083\u0088\u00a1\u00ad\u00c5\u00d3\u00e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}