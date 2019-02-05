/*Jeremy Chan jsc126
  Lennox Wildman law136
  Token interface
*/
package edu.cwru.jsc126_law136.parser;

public interface Token{

    /*return type of Token*/
    TerminalSymbol getType();


    /*Determines whether parameter argument matches token's type*/
    boolean matches(TerminalSymbol type);
    
}
