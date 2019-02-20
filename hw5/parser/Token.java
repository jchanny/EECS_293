/*Jeremy Chan jsc126
  Lennox Wildman law136
  Token interface
*/
package parser;

public interface Token{

    /*return type of Token*/
    TerminalSymbol getType();

    /*Determines whether parameter argument matches token's type*/
    boolean matches(TerminalSymbol type);

    boolean isOperator();
}
