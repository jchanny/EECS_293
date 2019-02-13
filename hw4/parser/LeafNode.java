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
    
    
    public String toString(){
        return  token.toString();
    }

    public List<Token> toList(){
        List<Token> leaf = new LinkedList<Token>();
        leaf.add(token);
        return leaf;
    }

}
