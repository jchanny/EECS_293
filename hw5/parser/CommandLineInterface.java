/*Jeremy Chan jsc126
  Lennox Wildman law136
  Class for command line interface for parser
 */
package parser;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandLineInterface {

    private static HashMap<String, TerminalSymbol> terminalMap;

    static {
	terminalMap = new HashMap<String, TerminalSymbol>();
	terminalMap.put("(", TerminalSymbol.OPEN);
	terminalMap.put(")", TerminalSymbol.CLOSE);
	terminalMap.put("+", TerminalSymbol.PLUS);
	terminalMap.put("-", TerminalSymbol.MINUS);
	terminalMap.put("*", TerminalSymbol.TIMES);
	terminalMap.put("/", TerminalSymbol.DIVIDE);9
    }
    
    //helper method for converting string of expressions to Token list
    private static ArrayList<Token> stringToTokenList(String input){
        ArrayList<Token> list = new ArrayList<Token>();

        for(int i = 0 ; i < input.length(); i++){
	    if(terminalMap.contains(input.charAt(i))){
		list.add(Connector.build(input.charAt(i)));
	    }
	    else{
		list.add(Variable.build(input.charAt(i)));
	    }
        }

        return list;
    }

    private static void printOutTree(ParseState result){
	Node root = result.getNode();
	System.out.print(root.toString());	
    }

    public static void main(String [] args){
        String input = args[0];

        List<Token> inputList = stringToTokenList(input);

	ParseState parseResult = NonTerminalSymbol.parseInput(inputList);

	if(parseResult == ParseState.FAILURE){
	    System.out.println("Parsing failed.");
	}
	else{
	    printOutTree(parseResult);
	}
	
    }

}
