// Generated from LANGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

	import io.compiler.types.*;
	import java.util.ArrayList;
	import java.util.HashMap;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LANGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, PROGRAMA=6, FIMPROG=7, SE=8, SENAO=9, 
		DECLARE=10, LEIA=11, ESCREVA=12, ENTAO=13, WHILE=14, DO=15, ID=16, NUMDECIMAL=17, 
		NUM=18, TEXTO=19, WS=20, AD=21, SUB=22, DIV=23, MULT=24, OP_REL=25, OP_AT=26, 
		DP=27, PV=28, VIRG=29, AP=30, FP=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "PROGRAMA", "FIMPROG", "SE", 
			"SENAO", "DECLARE", "LEIA", "ESCREVA", "ENTAO", "WHILE", "DO", "ID", 
			"NUMDECIMAL", "NUM", "TEXTO", "WS", "AD", "SUB", "DIV", "MULT", "OP_REL", 
			"OP_AT", "DP", "PV", "VIRG", "AP", "FP"
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


	public LANGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LANGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001f\u00ed\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0003\u000f"+
		"\u00a9\b\u000f\u0001\u000f\u0005\u000f\u00ac\b\u000f\n\u000f\f\u000f\u00af"+
		"\t\u000f\u0001\u0010\u0004\u0010\u00b2\b\u0010\u000b\u0010\f\u0010\u00b3"+
		"\u0001\u0010\u0001\u0010\u0004\u0010\u00b8\b\u0010\u000b\u0010\f\u0010"+
		"\u00b9\u0001\u0011\u0004\u0011\u00bd\b\u0011\u000b\u0011\f\u0011\u00be"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u00c3\b\u0012\n\u0012\f\u0012\u00c6"+
		"\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u00df\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0000\u0000\u001f\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d;\u001e=\u001f\u0001\u0000\u0006\u0002\u0000AZaz\u0003\u0000"+
		"09AZaz\u0001\u000009\u0001\u0000\"\"\u0003\u0000\t\n\r\r  \u0002\u0000"+
		"<<>>\u00f5\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0000=\u0001\u0000\u0000\u0000\u0001?\u0001\u0000\u0000\u0000\u0003"+
		"F\u0001\u0000\u0000\u0000\u0005M\u0001\u0000\u0000\u0000\u0007X\u0001"+
		"\u0000\u0000\u0000\tZ\u0001\u0000\u0000\u0000\u000b\\\u0001\u0000\u0000"+
		"\u0000\re\u0001\u0000\u0000\u0000\u000fn\u0001\u0000\u0000\u0000\u0011"+
		"s\u0001\u0000\u0000\u0000\u0013{\u0001\u0000\u0000\u0000\u0015\u0083\u0001"+
		"\u0000\u0000\u0000\u0017\u0088\u0001\u0000\u0000\u0000\u0019\u0090\u0001"+
		"\u0000\u0000\u0000\u001b\u0096\u0001\u0000\u0000\u0000\u001d\u009f\u0001"+
		"\u0000\u0000\u0000\u001f\u00a8\u0001\u0000\u0000\u0000!\u00b1\u0001\u0000"+
		"\u0000\u0000#\u00bc\u0001\u0000\u0000\u0000%\u00c0\u0001\u0000\u0000\u0000"+
		"\'\u00c9\u0001\u0000\u0000\u0000)\u00cd\u0001\u0000\u0000\u0000+\u00cf"+
		"\u0001\u0000\u0000\u0000-\u00d1\u0001\u0000\u0000\u0000/\u00d3\u0001\u0000"+
		"\u0000\u00001\u00de\u0001\u0000\u0000\u00003\u00e0\u0001\u0000\u0000\u0000"+
		"5\u00e3\u0001\u0000\u0000\u00007\u00e5\u0001\u0000\u0000\u00009\u00e7"+
		"\u0001\u0000\u0000\u0000;\u00e9\u0001\u0000\u0000\u0000=\u00eb\u0001\u0000"+
		"\u0000\u0000?@\u0005N\u0000\u0000@A\u0005U\u0000\u0000AB\u0005M\u0000"+
		"\u0000BC\u0005B\u0000\u0000CD\u0005E\u0000\u0000DE\u0005R\u0000\u0000"+
		"E\u0002\u0001\u0000\u0000\u0000FG\u0005S\u0000\u0000GH\u0005T\u0000\u0000"+
		"HI\u0005R\u0000\u0000IJ\u0005I\u0000\u0000JK\u0005N\u0000\u0000KL\u0005"+
		"G\u0000\u0000L\u0004\u0001\u0000\u0000\u0000MN\u0005R\u0000\u0000NO\u0005"+
		"E\u0000\u0000OP\u0005A\u0000\u0000PQ\u0005L\u0000\u0000QR\u0005N\u0000"+
		"\u0000RS\u0005U\u0000\u0000ST\u0005M\u0000\u0000TU\u0005B\u0000\u0000"+
		"UV\u0005E\u0000\u0000VW\u0005R\u0000\u0000W\u0006\u0001\u0000\u0000\u0000"+
		"XY\u0005{\u0000\u0000Y\b\u0001\u0000\u0000\u0000Z[\u0005}\u0000\u0000"+
		"[\n\u0001\u0000\u0000\u0000\\]\u0005p\u0000\u0000]^\u0005r\u0000\u0000"+
		"^_\u0005o\u0000\u0000_`\u0005g\u0000\u0000`a\u0005r\u0000\u0000ab\u0005"+
		"a\u0000\u0000bc\u0005m\u0000\u0000cd\u0005a\u0000\u0000d\f\u0001\u0000"+
		"\u0000\u0000ef\u0005f\u0000\u0000fg\u0005i\u0000\u0000gh\u0005m\u0000"+
		"\u0000hi\u0005p\u0000\u0000ij\u0005r\u0000\u0000jk\u0005o\u0000\u0000"+
		"kl\u0005g\u0000\u0000lm\u0005;\u0000\u0000m\u000e\u0001\u0000\u0000\u0000"+
		"no\u0005\"\u0000\u0000op\u0005s\u0000\u0000pq\u0005e\u0000\u0000qr\u0005"+
		"\"\u0000\u0000r\u0010\u0001\u0000\u0000\u0000st\u0005\"\u0000\u0000tu"+
		"\u0005s\u0000\u0000uv\u0005e\u0000\u0000vw\u0005n\u0000\u0000wx\u0005"+
		"a\u0000\u0000xy\u0005o\u0000\u0000yz\u0005\"\u0000\u0000z\u0012\u0001"+
		"\u0000\u0000\u0000{|\u0005d\u0000\u0000|}\u0005e\u0000\u0000}~\u0005c"+
		"\u0000\u0000~\u007f\u0005l\u0000\u0000\u007f\u0080\u0005a\u0000\u0000"+
		"\u0080\u0081\u0005r\u0000\u0000\u0081\u0082\u0005e\u0000\u0000\u0082\u0014"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005l\u0000\u0000\u0084\u0085\u0005"+
		"e\u0000\u0000\u0085\u0086\u0005i\u0000\u0000\u0086\u0087\u0005a\u0000"+
		"\u0000\u0087\u0016\u0001\u0000\u0000\u0000\u0088\u0089\u0005e\u0000\u0000"+
		"\u0089\u008a\u0005s\u0000\u0000\u008a\u008b\u0005c\u0000\u0000\u008b\u008c"+
		"\u0005r\u0000\u0000\u008c\u008d\u0005e\u0000\u0000\u008d\u008e\u0005v"+
		"\u0000\u0000\u008e\u008f\u0005a\u0000\u0000\u008f\u0018\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0005e\u0000\u0000\u0091\u0092\u0005n\u0000\u0000\u0092"+
		"\u0093\u0005t\u0000\u0000\u0093\u0094\u0005a\u0000\u0000\u0094\u0095\u0005"+
		"o\u0000\u0000\u0095\u001a\u0001\u0000\u0000\u0000\u0096\u0097\u0005e\u0000"+
		"\u0000\u0097\u0098\u0005n\u0000\u0000\u0098\u0099\u0005q\u0000\u0000\u0099"+
		"\u009a\u0005u\u0000\u0000\u009a\u009b\u0005a\u0000\u0000\u009b\u009c\u0005"+
		"n\u0000\u0000\u009c\u009d\u0005t\u0000\u0000\u009d\u009e\u0005o\u0000"+
		"\u0000\u009e\u001c\u0001\u0000\u0000\u0000\u009f\u00a0\u0005r\u0000\u0000"+
		"\u00a0\u00a1\u0005e\u0000\u0000\u00a1\u00a2\u0005a\u0000\u0000\u00a2\u00a3"+
		"\u0005l\u0000\u0000\u00a3\u00a4\u0005i\u0000\u0000\u00a4\u00a5\u0005z"+
		"\u0000\u0000\u00a5\u00a6\u0005e\u0000\u0000\u00a6\u001e\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a9\u0007\u0000\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ad\u0001\u0000\u0000\u0000\u00aa\u00ac\u0007\u0001\u0000"+
		"\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ae \u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b2\u0007\u0002\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b7\u0005.\u0000\u0000\u00b6\u00b8\u0007\u0002\u0000\u0000\u00b7"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba"+
		"\"\u0001\u0000\u0000\u0000\u00bb\u00bd\u0007\u0002\u0000\u0000\u00bc\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bc"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf$\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c4\u0005\"\u0000\u0000\u00c1\u00c3\b\u0003"+
		"\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c8\u0005\"\u0000\u0000\u00c8&\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0007\u0004\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cc\u0006\u0013\u0000\u0000\u00cc(\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0005+\u0000\u0000\u00ce*\u0001\u0000\u0000\u0000\u00cf\u00d0"+
		"\u0005-\u0000\u0000\u00d0,\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005/"+
		"\u0000\u0000\u00d2.\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005*\u0000\u0000"+
		"\u00d40\u0001\u0000\u0000\u0000\u00d5\u00df\u0007\u0005\u0000\u0000\u00d6"+
		"\u00d7\u0005<\u0000\u0000\u00d7\u00df\u0005=\u0000\u0000\u00d8\u00d9\u0005"+
		">\u0000\u0000\u00d9\u00df\u0005=\u0000\u0000\u00da\u00db\u0005=\u0000"+
		"\u0000\u00db\u00df\u0005=\u0000\u0000\u00dc\u00dd\u0005!\u0000\u0000\u00dd"+
		"\u00df\u0005=\u0000\u0000\u00de\u00d5\u0001\u0000\u0000\u0000\u00de\u00d6"+
		"\u0001\u0000\u0000\u0000\u00de\u00d8\u0001\u0000\u0000\u0000\u00de\u00da"+
		"\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00df2\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e1\u0005:\u0000\u0000\u00e1\u00e2\u0005=\u0000"+
		"\u0000\u00e24\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005:\u0000\u0000\u00e4"+
		"6\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005;\u0000\u0000\u00e68\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0005,\u0000\u0000\u00e8:\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0005(\u0000\u0000\u00ea<\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ec\u0005)\u0000\u0000\u00ec>\u0001\u0000\u0000\u0000\t\u0000\u00a8"+
		"\u00ab\u00ad\u00b3\u00b9\u00be\u00c4\u00de\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}