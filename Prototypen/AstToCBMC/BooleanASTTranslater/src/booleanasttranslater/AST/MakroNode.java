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
public abstract class MakroNode extends BooleanExpNode {
    private SymbolicVariable var;
    private BooleanExpNode following;
    
    protected MakroNode(SymbolicVariable var, BooleanExpNode following) {
        this.var = var;
        this.following = following;
    }
    
    public SymbolicVariable getVar() {
        return this.var;
    }
    
    public BooleanExpNode getFollowing() {
        return this.following;
    }
}
