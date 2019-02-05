/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cwru.jsc126_law136.parser;
import java.util.*;

/**
 *
 * @author wildm
 */
public interface Node {
    
    public List <Token> toList();
    
    public String toString();
    
}
