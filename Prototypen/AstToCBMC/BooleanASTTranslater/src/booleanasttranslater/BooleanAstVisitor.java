/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanasttranslater;

import booleanasttranslater.AST.AndNode;
import booleanasttranslater.AST.BooleanExpListNode;
import booleanasttranslater.AST.BooleanExpNode;
import booleanasttranslater.AST.BooleanExpNodeVisitor;
import booleanasttranslater.AST.CompareNodes;
import booleanasttranslater.AST.ForAllNode;
import booleanasttranslater.AST.ImplicationNode;
import booleanasttranslater.AST.ThereExistsNode;
import java.util.Stack;

/**
 *
 * @author Holger-Desktop
 */
public class BooleanAstVisitor implements BooleanExpNodeVisitor {
    private String generated;
    private String asString = "assume";
    private Stack<String> booleanVarStack = new Stack<>();
    private int implNum = 0;
    private int scopeLvl = 0;
    
    private void appenText(String s) {
        generated += s;
    } 
    
    public void setPreProp() {
        asString = "assume";
    }
    
    public void setPostProp() {
        asString = "assert";
    }
    
    public String getGeneratedCode() {
        return generated;
    }
    
    public void translate(BooleanExpListNode n) {
        generated = "";
        booleanVarStack.clear();
        implNum = 0;
        visitBooleanExpListNode(n);
    }
    
    @Override
    public void visitBooleanExpListNode(BooleanExpListNode n) {
            for(BooleanExpNode node : n.getNodes()) {
                node.getVisited(this);
            }
    }

    @Override
    public void visitForAllNode(ForAllNode n) {
        String template =   "unsigned int BOOLVAR = 1; \n" +
                            "for(int i = 0; i < MAX && BOOLVAR; i++) { \n";
        String boolVar = "FOREACH_" + n.getVar().id;
        booleanVarStack.push(boolVar);
        String max = n.getVar().type == "Voter" ? "V" : "C";
        template = template.replaceAll("BOOLVAR", boolVar);
        template = template.replaceAll("MAX", max);
        
        appenText(template);
        
        ++scopeLvl;
        n.getFollowing().getVisited(this);
        
        
        appenText(boolVar + " = " + booleanVarStack.pop() + ";\n");
        booleanVarStack.pop();
        appenText("} \n");
        if(booleanVarStack.empty()) appenText(asString + "(" + boolVar + ");\n");
        
        --scopeLvl;
    }

    @Override
    public void visitThereExistsNode(ThereExistsNode n) {
        String template =   "unsigned int BOOLVAR = 0; \n" +
                            "for(int i = 0; i < MAX && !BOOLVAR; i++) { \n";
        String boolVar = "FOREACH_" + n.getVar().id;
        
        String max = n.getVar().type == "Voter" ? "V" : "C";
        template = template.replaceAll("BOOLVAR", boolVar);
        template = template.replaceAll("MAX", max);
        
        appenText(template);
        
        ++scopeLvl;
        n.getFollowing().getVisited(this);
        
        appenText(boolVar + " = " + booleanVarStack.pop() + ";\n");
        appenText("} \n");
        if(booleanVarStack.empty()) appenText(asString + "(" + boolVar + ");\n");
        booleanVarStack.push(boolVar);
        
        --scopeLvl;
    }

    @Override
    public void visitImplicationNode(ImplicationNode n) {
        String template = " = (!LHS || RHS);\n";
        
        String boolVar = "Implication_" + implNum++;
        appenText("unsigned int " + boolVar + "; \n");
        
        
        n.getLhs().getVisited(this);
        n.getRhs().getVisited(this);
        
        String rhs = booleanVarStack.pop();      
        String lhs = booleanVarStack.pop();

        template = template.replace("LHS", lhs);
        template = template.replace("RHS", rhs);
        
        generated += boolVar + template;
        if(booleanVarStack.empty()) appenText(asString + "(" + boolVar + ")" + ";\n");
        booleanVarStack.push(boolVar);
        
    }

    @Override
    public void visitAndNode(AndNode n) {
        String template = " = (LHS && RHS);\n";
        
        String boolVar = "And_" + implNum++;
        
        appenText("unsigned int " + boolVar + "; \n");

        n.getLhs().getVisited(this);
        n.getRhs().getVisited(this);
        
        String rhs = booleanVarStack.pop();      
        String lhs = booleanVarStack.pop();
        
        template = template.replace("LHS", lhs);
        template = template.replace("RHS", rhs);
        
        generated += boolVar + template;
        if(booleanVarStack.empty()) appenText(asString + "(" + boolVar + ")" + ";\n");
        booleanVarStack.push(boolVar);
        
    }

    @Override
    public void visitCompareNode(CompareNodes n) {
        String boolVar = n.getLhs() + " " + n.getSymb() + " " + n.getRhs();
        if(booleanVarStack.empty()) appenText(asString + "(" + boolVar + ")" + ";\n");
        booleanVarStack.push(boolVar);
       
    }
    
}
