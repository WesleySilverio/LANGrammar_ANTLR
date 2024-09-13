// Generated from LANGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

	import io.compiler.types.*;
	import java.util.ArrayList;
	import java.util.HashMap;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
	import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LANGrammarParser}.
 */
public interface LANGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LANGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LANGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(LANGrammarParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(LANGrammarParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(LANGrammarParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(LANGrammarParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(LANGrammarParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(LANGrammarParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(LANGrammarParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(LANGrammarParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(LANGrammarParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(LANGrammarParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(LANGrammarParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(LANGrammarParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#cmdExpr}.
	 * @param ctx the parse tree
	 */
	void enterCmdExpr(LANGrammarParser.CmdExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#cmdExpr}.
	 * @param ctx the parse tree
	 */
	void exitCmdExpr(LANGrammarParser.CmdExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(LANGrammarParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(LANGrammarParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdDoWhile(LANGrammarParser.CmdDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdDoWhile(LANGrammarParser.CmdDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LANGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LANGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(LANGrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(LANGrammarParser.ExprlContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(LANGrammarParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(LANGrammarParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#termol}.
	 * @param ctx the parse tree
	 */
	void enterTermol(LANGrammarParser.TermolContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#termol}.
	 * @param ctx the parse tree
	 */
	void exitTermol(LANGrammarParser.TermolContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGrammarParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(LANGrammarParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGrammarParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(LANGrammarParser.FatorContext ctx);
}