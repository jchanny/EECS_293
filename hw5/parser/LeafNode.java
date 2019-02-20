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
public final class LeafNode implements Node {

    private final Token token;

    //constructor
    private LeafNode (Token coin){
        token = coin;
    }

    //token getter
    public Token getToken(){
        return token;
    }

    public static LeafNode build(Token t){
        Objects.requireNonNull(t, "Cannont Build with null node");            
        return new LeafNode(t);
    }
    
    public List<Node> getChildren(){
        return null;
    }
    
    public boolean isFruitful(){
        return true;
    }
    
    //compare with each type of operator
    public boolean isOperator(){
        return token.isOperator();
    }
    
    //always false since leaf nodes dont have children
    public boolean isStartedByOperator(){
        return false;
    }
    
    //returns empty optional since leaf nodes dont have children
    public Optional<Node> firstChild(){
        return Optional.ofNullable(null);
    }
    
    //always false since leaf nodes dont have children
    public boolean isSingleLeafParent(){
        return false;
    }
    
    public String toString(){
        return  token.toString();
    }

    public List<Token> toList(){
        List<Token> leaf = new LinkedList<Token>();
        leaf.add(token);
        return leaf;
    }

}
