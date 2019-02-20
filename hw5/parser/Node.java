/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;
import java.util.*;

/**
 *
 * @author wildm
 */
public interface Node {
    
    public List <Token> toList();
    
    public String toString();
    
    public List <Node> getChildren();
    
    public boolean isFruitful();
    
    public boolean isOperator();
    
    public boolean isStartedByOperator();
    
    public Optional<Node> firstChild();
    
    public boolean isSingleLeafParent();
    
}
