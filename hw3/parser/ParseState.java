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
final class ParseState {
            
    private final boolean success;
    private final Node node;
    private final List<Token> remainder;
    
    
    //constructor
    private ParseState(boolean complete, Node mod, List<Token> leftOver){
        success = complete;
        node = mod;
        remainder = leftOver;
    }
    
    //getter returns value
    public boolean successful(){
        return success;
    }
    
    //getter returns value
    public Node getNode(){
        return node;
    }
    
    //getter return copy of remainder
    public List<Token> getRemainder(){
        if (!hasNoRemainder()){
            List<Token> output = new ArrayList<Token>(remainder);
            return output;
        }
        return null;
    }
    
    public final static ParseState FAILURE(){
        return new ParseState(false, null, null);
    }
    
    public final boolean hasNoRemainder(){
        if (remainder == null)
            return true;
        else
            return false;
    }
    
}
