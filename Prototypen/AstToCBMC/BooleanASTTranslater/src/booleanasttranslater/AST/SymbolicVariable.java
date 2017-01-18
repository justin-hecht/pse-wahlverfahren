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
public class SymbolicVariable {
    public String id;
    public String type;

    public SymbolicVariable(String id, String type) {
        this.type = type;
        this.id = id;
    }
}
