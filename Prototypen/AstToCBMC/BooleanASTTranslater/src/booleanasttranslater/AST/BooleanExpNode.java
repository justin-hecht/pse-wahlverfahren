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
public abstract class BooleanExpNode {
    public abstract void getVisited(BooleanExpNodeVisitor vis);
}
