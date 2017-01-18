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
public abstract class BinaryExpresionNode extends BooleanExpNode {
    private BooleanExpNode lhs;
    private BooleanExpNode rhs;
    
    protected BinaryExpresionNode(BooleanExpNode lhs, BooleanExpNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    
    public BooleanExpNode getLhs() {
        return this.lhs;
    }
    
    public BooleanExpNode getRhs() {
        return this.rhs;
    }
    
}
