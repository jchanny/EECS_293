/*Jeremy Chan jsc126
  Lennox Wildman law136

  AbstractToken class
*/
package parser;

public abstract class AbstractToken implements Token{

    /*returns whether or not @param type is equal to Token's type*/
    public final boolean matches(TerminalSymbol type){
	return (type == getType());
    }
}
