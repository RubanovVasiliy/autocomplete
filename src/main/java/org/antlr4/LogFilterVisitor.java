package org.antlr4;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LogFilterParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LogFilterVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LogFilterParser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(LogFilterParser.FilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogFilterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LogFilterParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogFilterParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(LogFilterParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogFilterParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(LogFilterParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogFilterParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(LogFilterParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogFilterParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(LogFilterParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogFilterParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(LogFilterParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LogFilterParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(LogFilterParser.ValueContext ctx);
}