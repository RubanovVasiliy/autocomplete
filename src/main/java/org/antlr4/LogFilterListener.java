package org.antlr4;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LogFilterParser}.
 */
public interface LogFilterListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LogFilterParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter(LogFilterParser.FilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogFilterParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter(LogFilterParser.FilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LogFilterParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogFilterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LogFilterParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogFilterParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(LogFilterParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogFilterParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(LogFilterParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogFilterParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(LogFilterParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogFilterParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(LogFilterParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogFilterParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(LogFilterParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogFilterParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(LogFilterParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogFilterParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(LogFilterParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogFilterParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(LogFilterParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogFilterParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(LogFilterParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogFilterParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(LogFilterParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogFilterParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(LogFilterParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogFilterParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(LogFilterParser.ValueContext ctx);
}