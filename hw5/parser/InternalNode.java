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
        this.children = Collections.unmodifiableList(new ArrayList<Node>(children));
    }

    //children getter
    public List<Node> getChildren(){
        List<Node> list = new ArrayList<Node>();

        for(Node child : children){
            list.add(child);
        }

        return list;
    }

    public boolean isFruitful(){
        return !children.isEmpty();
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
        Builder simplifier = new Builder();

        for(int i = 0 ; i < attach.size() ; i++){
            simplifier.addChild(attach.get(i));
        }

        return simplifier.build;
    }

    //string for toString output
    private String output = null;
    //String for toString method
    public String toString(){
        if (output == null){
            for (Node element: children){
                output += "[" + (element.toString()) + "]";
            }
            return output;
        }
        //method was previously invoked
        else{
            return output;
        }
    }

    //always false since internal node cannot be operator
    public boolean isOperator(){
        return false;
    }

    //test if first child of node is operator
    public boolean isOperatorLed(){
        return this.firstChild().isOperator();
    }

    //return first child of current node
    public Optional<Node> firstChild(){
        return Optional.of(children.get(0));
    }

    //return if internal node is parent of only one leaf node
    public boolean isSingleLeafParent(){
        return children.size() == 1 && children.get(0) instanceof LeafNode;
    }


    //nested class to simplify parse tree
    public static class Builder{

        private List<Node> children = new ArrayList<Node>();

        //method to add nodes to Children list
        public boolean addChild(Node node){
            Objects.requireNonNull(node, "Cannot add Null Node");
            return children.add(node);
        }

        //method to remove all childless nodes from children
        public Builder simplify(){
            List<Node> simplified = new ArrayList<Node>();


            for(Node child : children){
                if(child.isFruitful()){
                    simplified.add(child);
                }
            }

            for(Node node : simplified){
                if(shouldReplaceWithChildren(node)){
                    node = node.getChildren();
                }
            }

            children = simplified;

            return this;
        }

        //helper method that returns whether InternalNode should be
        //replaced with its children
        private static boolean shouldReplaceWithChildren(Node node){
            if(node.getChildren().size() < 2){
                return false;
            }

            if(node.isStartedByOperator() && !node.getChildren.get(0).isOperator()){
                return true;
            }

            return false;
        }

        //returns new internalNode with simplified list
        public InternalNode build(){
            simplify();
            return new InternalNode(Children);
        }

    }
}
