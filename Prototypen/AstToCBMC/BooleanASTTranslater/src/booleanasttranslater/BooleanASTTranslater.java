/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanasttranslater;

import booleanasttranslater.AST.BooleanExpListNode;
import booleanasttranslater.AST.BooleanExpNode;
import booleanasttranslater.AST.CompareNodes;
import booleanasttranslater.AST.ForAllNode;
import booleanasttranslater.AST.ImplicationNode;
import booleanasttranslater.AST.SymbolicVariable;
import booleanasttranslater.AST.ThereExistsNode;

/**
 *
 * @author Holger-Desktop
 */
public class BooleanASTTranslater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BooleanAstVisitor vis = new BooleanAstVisitor();
        
        // FOR_ALL_VOTER(v) : (EXISTS_ONE_CANDIDATE(c) : c == Votes1(v) ) ==> Votes1(v) != 0 
        
        CompareNodes uneqNode = new CompareNodes("!=", "votes1[v]", "0");
        CompareNodes eqNode = new CompareNodes("==", "votes1[v]", "c");
        ThereExistsNode exNode = new ThereExistsNode(new SymbolicVariable("c", "Candidate"), eqNode);
        ImplicationNode implNode = new ImplicationNode(exNode, uneqNode);
        ForAllNode fAllNode = new ForAllNode(new SymbolicVariable("v", "Voter"), implNode);
        
        BooleanExpNode[] nodes = new BooleanExpNode[1];
        nodes[0] = fAllNode;
        BooleanExpListNode listnode = new BooleanExpListNode(nodes);
        
        vis.setPostProp();    
        vis.translate(listnode);
        System.out.print(vis.getGeneratedCode());
    }
    
}
