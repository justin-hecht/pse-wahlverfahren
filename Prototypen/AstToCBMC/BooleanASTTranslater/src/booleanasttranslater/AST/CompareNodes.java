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
public class CompareNodes extends BooleanExpNode {

    private String symb;
    private String lhs;    
    private String rhs;    
    
    public CompareNodes(String symb, String lhs, String rhs) {
        this.symb = symb;
        this.lhs = lhs;
        this.rhs = rhs;
    }
    @Override
    public void getVisited(BooleanExpNodeVisitor vis) {
        vis.visitCompareNode(this);
    }
    
    public String getSymb() {
        return this.symb;
    }

    public String getLhs() {
        return lhs;
    }
    
    public String getRhs() {
        return rhs;
    }
    
}
