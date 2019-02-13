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
    private InternalNode(List<Node> children){
        this.children = new ArrayList<Node>(children);
    }

    //children getter
    public List<Node> getChildren(){
        List<Node> output = new ArrayList<Node>(children);
        return output;
    }
    
    public boolean isFruitful(){
        return children != null;
    }

    public List<Token> toList()
    {
        List<Token> internal = new LinkedList<Token>();
        for (Node element: children){
            for(Token t : element.toList()){
                internal.add(t);
            }
        }
        return internal;
    }

    public static InternalNode build(List<Node> attach){
        Objects.requireNonNull(attach, "Children nodes are null.");
        return new InternalNode(attach);
    }

    //string for toString output
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
    
    //nested class to simplify parse tree
    public static class Builder{
        
        private List<Node> Children = new ArrayList<Node>();
        
        //method to add nodes to Children list
        public boolean addChild(Node node){
            Objects.requireNonNull(node, "Cannot add Null Node");
            return Children.add(node); 
        }
        
        //method to remove all childless nodes from children
        public Builder simplify(){
            for (Node child: Children){
                if (!child.isFruitful()){
                    child = null;
                }
            }
            soloReformat(Children);
            return this;
        }
        
        //helper method
        //if @param contains only 1 internalNode, replace with children of the internalNode
        private void soloReformat(List<Node> children){
            if (children.size() == 1 && children.get(0) instanceof InternalNode){
                children = children.get(0).getChildren();
            }
        }
        
        //returns new internalNode with simplified list
        public InternalNode build(){
            simplify();
            return new InternalNode(Children);
        }
        
    }
}
