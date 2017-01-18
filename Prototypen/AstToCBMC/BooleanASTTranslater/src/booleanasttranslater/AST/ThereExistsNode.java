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
public class ThereExistsNode extends MakroNode {

    public ThereExistsNode(SymbolicVariable var, BooleanExpNode following) {
        super(var, following);
    }

    @Override
    public void getVisited(BooleanExpNodeVisitor vis) {
        vis.visitThereExistsNode(this);
    }
    
}
