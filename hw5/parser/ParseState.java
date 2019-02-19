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
    final static ParseState FAILURE = new ParseState(null, null);

    //constructor
    private ParseState(Node nod, List<Token> leftOver){
        if (nod == null || leftOver == null){
            success = false;
        }
        else{
            success = true;
        }
        node = nod;
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

    public final boolean hasNoRemainder(){
        if (remainder == null){
            return true;
        }
        else{
            return false;
        }
    }

    public static ParseState build(Node node, List<Token> remain){
        if (node == null || remain == null){
            throw new NullPointerException("Parameters must not be null");
        }
        else {
            List<Token> list = new ArrayList<Token>(remain);
            return new ParseState(node, list);
        }
    }

   
}
