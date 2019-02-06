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
public final class InternalNode implements Node {
    
    private final List<Node> children;
    
    //constructor
    private InternalNode(List<Node> kids){
        children = new ArrayList<Node>(kids);
    }
    
    //children getter
    public List<Node> getChildren(){
        List<Node> output = new ArrayList<Node>(children);
        return output;
    }
    
    public List<Token> toList(){
        List<Token> internal = new LinkedList<Token>();
        for (Node element: children){
            for(Token t : element.toList()){
                internal.add(t);
            }
        }
        return internal;
    }

    public static InternalNode build(List<Node> attach){
        if(attach == null){
            throw new NullPointerException("Children nodes are null.");
        }
        return new InternalNode(attach);
    }

    private String output = null;
    //String for toString method
    public String toString(){
        if (output != null){
            for (Node element: children)
                output += "[" + (element.toString()) + "]";
            
            return output;
        }
        //method was previously invoked
        else
            return output;
    }    
}
