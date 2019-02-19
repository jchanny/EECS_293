/*Jeremy Chan jsc126
  Lennox Wildman law136
  Helper class that contains a Map of different productions to NonTerminalSymbols
*/
package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SymTable {

    private static HashMap<NonTerminalSymbol, List<SymbolSequence>> symSequencesList;

    static{
	symSequencesList = new HashMap<NonTerminalSymbol, List<SymbolSequence>>();
	//NonTerminalSymbol.EXPRESSION symbol sequences
	List<SymbolSequence> exprList = new ArrayList<SymbolSequence>();
	exprList.add(SymbolSequence.build(NonTerminalSymbol.TERM, NonTerminalSymbol.EXPRESSION_TAIL));
	symSequencesList.put(NonTerminalSymbol.EXPRESSION, exprList);

	//NonTerminalSymbol.EXPRESSION_TAIL symbol sequences
	List<SymbolSequence> exprTailList = new ArrayList<SymbolSequence>();
	exprTailList.add(SymbolSequence.build(TerminalSymbol.PLUS, NonTerminalSymbol.TERM, NonTerminalSymbol.EXPRESSION_TAIL));
	exprTailList.add(SymbolSequence.build(TerminalSymbol.MINUS, NonTerminalSymbol.TERM, NonTerminalSymbol.EXPRESSION_TAIL));
	exprTailList.add(SymbolSequence.EPSILON);
	symSequencesList.put(NonTerminalSymbol.EXPRESSION, exprTailList);

	//NonTerminalSymbol.TERM symbol sequences
	List<SymbolSequence> termList = new ArrayList<SymbolSequence>();
	termList.add(SymbolSequence.build(NonTerminalSymbol.UNARY, NonTerminalSymbol.TERM_TAIL));
	symSequencesList.put(NonTerminalSymbol.TERM, termList);

	//NonTerminalSymbol.TERM_TAIL symbol sequences
	List<SymbolSequence> termTailList = new ArrayList<SymbolSequence>();
	termTailList.add(SymbolSequence.build(TerminalSymbol.TIMES, NonTerminalSymbol.UNARY, NonTerminalSymbol.TERM_TAIL));
	termTailList.add(SymbolSequence.build(TerminalSymbol.DIVIDE, NonTerminalSymbol.UNARY, NonTerminalSymbol.TERM_TAIL));
	termTailList.add(SymbolSequence.EPSILON);
	symSequencesList.put(NonTerminalSymbol.TERM_TAIL, termTailList);

	//NonTerminalSymbol.UNARY symbol sequences
	List<SymbolSequence> unaryList = new ArrayList<SymbolSequence>();
	unaryList.add(SymbolSequence.build(TerminalSymbol.MINUS, NonTerminalSymbol.FACTOR));
	unaryList.add(SymbolSequence.build(NonTerminalSymbol.FACTOR));
	symSequencesList.put(NonTerminalSymbol.UNARY, unaryList);

	//NonTerminalSymbol.FACTOR symbol sequences
	List<SymbolSequence> factorList = new ArrayList<SymbolSequence>();
	factorList.add(SymbolSequence.build(TerminalSymbol.OPEN, NonTerminalSymbol.EXPRESSION, TerminalSymbol.CLOSE));
	factorList.add(SymbolSequence.build(TerminalSymbol.VARIABLE));
	symSequencesList.put(NonTerminalSymbol.FACTOR, factorList);
    
    }

    //creates symSequencesList if unpopulated, else returns it
    public static List<SymbolSequence> getSymbolSequence(NonTerminalSymbol nonTerminal){
        return symSequencesList.get(nonTerminal);
    }
}
