/*Jeremy Chan jsc126
  Lennox Wildman law136
  enum class representing TerminalSymbol node builders
*/
package parser;

import java.util.Arrays;
import java.util.List;

public enum TerminalSymbol implements Symbol{
    
    VARIABLE,PLUS,MINUS,TIMES,DIVIDE,OPEN,CLOSE;

    public ParseState parse(List<Token>input){
	if(input.get(0).getType() == this){
	    //parsing success
	    Node leafNode = LeafNode.build(input.get(0));
	    List <Token> remainderList = Arrays.asList(input).remove(0);
	    return ParseState.build(leafNode, remainderList);
	}
	//else
	return ParseState.FAILURE;

    }   
 
}
