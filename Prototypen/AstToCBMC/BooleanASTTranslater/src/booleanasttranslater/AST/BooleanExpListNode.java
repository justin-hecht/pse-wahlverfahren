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
public class BooleanExpListNode {

    private BooleanExpNode[] nodes;

    public BooleanExpListNode(BooleanExpNode[] nodes) {
        this.nodes = nodes;
    }

    public BooleanExpNode[] getNodes() {
        return this.nodes;
    }
}
