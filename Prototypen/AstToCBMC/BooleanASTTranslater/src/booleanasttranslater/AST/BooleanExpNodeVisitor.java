/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanasttranslater.AST;

/**
 *
 * @author Holger-Desktop
 */
public interface BooleanExpNodeVisitor {
    public void visitBooleanExpListNode(BooleanExpListNode n);    
    public void visitForAllNode(ForAllNode n);
    public void visitThereExistsNode(ThereExistsNode n);
    public void visitImplicationNode(ImplicationNode n);
    public void visitAndNode(AndNode n);  
    public void visitCompareNode(CompareNodes n);
}
