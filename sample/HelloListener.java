// Generated from Hello.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(HelloParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(HelloParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#setup}.
	 * @param ctx the parse tree
	 */
	void enterSetup(HelloParser.SetupContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#setup}.
	 * @param ctx the parse tree
	 */
	void exitSetup(HelloParser.SetupContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(HelloParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(HelloParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(HelloParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(HelloParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#sets}.
	 * @param ctx the parse tree
	 */
	void enterSets(HelloParser.SetsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#sets}.
	 * @param ctx the parse tree
	 */
	void exitSets(HelloParser.SetsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#actions}.
	 * @param ctx the parse tree
	 */
	void enterActions(HelloParser.ActionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#actions}.
	 * @param ctx the parse tree
	 */
	void exitActions(HelloParser.ActionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(HelloParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(HelloParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#affect}.
	 * @param ctx the parse tree
	 */
	void enterAffect(HelloParser.AffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#affect}.
	 * @param ctx the parse tree
	 */
	void exitAffect(HelloParser.AffectContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(HelloParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(HelloParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#ifcond}.
	 * @param ctx the parse tree
	 */
	void enterIfcond(HelloParser.IfcondContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#ifcond}.
	 * @param ctx the parse tree
	 */
	void exitIfcond(HelloParser.IfcondContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#elsecond}.
	 * @param ctx the parse tree
	 */
	void enterElsecond(HelloParser.ElsecondContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#elsecond}.
	 * @param ctx the parse tree
	 */
	void exitElsecond(HelloParser.ElsecondContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(HelloParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(HelloParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#status}.
	 * @param ctx the parse tree
	 */
	void enterStatus(HelloParser.StatusContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#status}.
	 * @param ctx the parse tree
	 */
	void exitStatus(HelloParser.StatusContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(HelloParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(HelloParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(HelloParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(HelloParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#defs}.
	 * @param ctx the parse tree
	 */
	void enterDefs(HelloParser.DefsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#defs}.
	 * @param ctx the parse tree
	 */
	void exitDefs(HelloParser.DefsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(HelloParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(HelloParser.DefContext ctx);
}