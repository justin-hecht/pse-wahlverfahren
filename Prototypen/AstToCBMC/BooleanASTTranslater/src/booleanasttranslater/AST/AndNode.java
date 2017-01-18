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
public class AndNode extends BinaryExpresionNode {

    public AndNode(BooleanExpNode lhs, BooleanExpNode rhs) {
        super(lhs, rhs);
    }

    @Override
    public void getVisited(BooleanExpNodeVisitor vis) {
        vis.visitAndNode(this);
    }
    
}
