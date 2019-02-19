/*Jeremy Chan jsc126
  Lennox Wildman law136
  Helper class that defines a Map of NonTerminalSymbols->Map of TerminalSequence->SymbolSequence
*/

package parser;

import java.util.*;

class ProductionsMap {

	private static HashMap<NonTerminalSymbol, Map<TerminalSymbol, SymbolSequence>> productions;

	static{
            productions = new HashMap<NonTerminalSymbol, Map<TerminalSymbol, SymbolSequence>>();

            //lookup table for NonTerminalSymbol.EXPRESSION
            HashMap<TerminalSymbol, SymbolSequence> expMap = new HashMap<TerminalSymbol, SymbolSequence>();
            expMap.put(TerminalSymbol.OPEN, SymbolSequence.build(NonTerminalSymbol.TERM, NonTerminalSymbol.EXPRESSION_TAIL));
            productions.put(NonTerminalSymbol.EXPRESSION, expMap);

            //lookup table for NonTerminalSymbol.EXPRESSION_TAIL
            HashMap<TerminalSymbol, SymbolSequence> expTailMap = new HashMap<TerminalSymbol, SymbolSequence>();
            expTailMap.put(TerminalSymbol.PLUS, SymbolSequence.build(TerminalSymbol.PLUS, NonTerminalSymbol.TERM, NonTerminalSymbol.EXPRESSION_TAIL));
            expTailMap.put(TerminalSymbol.MINUS, SymbolSequence.build(TerminalSymbol.MINUS, NonTerminalSymbol.TERM, NonTerminalSymbol.EXPRESSION_TAIL));
            expTailMap.put(null, SymbolSequence.EPSILON);
            productions.put(NonTerminalSymbol.EXPRESSION_TAIL, expTailMap);

            //lookup table for NonTerminalSymbol.TERM
            HashMap<TerminalSymbol, SymbolSequence> termMap = new HashMap<TerminalSymbol, SymbolSequence>();
            termMap.put(TerminalSymbol.MINUS, SymbolSequence.build(NonTerminalSymbol.UNARY, NonTerminalSymbol.TERM_TAIL));
            productions.put(NonTerminalSymbol.TERM, termMap);

            //lookup table for NonTerminalSybmol.TERM_TAIL
            HashMap<TerminalSymbol, SymbolSequence> termTailMap = new HashMap<TerminalSymbol, SymbolSequence>();
            termTailMap.put(TerminalSymbol.TIMES, SymbolSequence.build(TerminalSymbol.TIMES, NonTerminalSymbol.UNARY, NonTerminalSymbol.TERM_TAIL));
            termTailMap.put(TerminalSymbol.DIVIDE, SymbolSequence.build(TerminalSymbol.DIVIDE, NonTerminalSymbol.UNARY, NonTerminalSymbol.TERM_TAIL));
            termTailMap.put(null, SymbolSequence.EPSILON);
            productions.put(NonTerminalSymbol.TERM_TAIL, termTailMap);

            //lookup table for NonTerminalSymbol.UNARY
            HashMap<TerminalSymbol, SymbolSequence> unaryMap = new HashMap<TerminalSymbol, SymbolSequence>();
            unaryMap.put(TerminalSymbol.MINUS, SymbolSequence.build(TerminalSymbol.MINUS, NonTerminalSymbol.FACTOR));
            unaryMap.put(TerminalSymbol.OPEN, SymbolSequence.build(NonTerminalSymbol.FACTOR));
            productions.put(NonTerminalSymbol.UNARY, unaryMap);

            //lookup table for factor
            HashMap<TerminalSymbol, SymbolSequence> factorMap = new HashMap<TerminalSymbol, SymbolSequence>();
            factorMap.put(TerminalSymbol.OPEN, SymbolSequence.build(TerminalSymbol.OPEN, NonTerminalSymbol.EXPRESSION, TerminalSymbol.CLOSE));
            factorMap.put(TerminalSymbol.VARIABLE, SymbolSequence.build(TerminalSymbol.VARIABLE));
            productions.put(NonTerminalSymbol.FACTOR, factorMap);

	}

	public static HashMap<NonTerminalSymbol, Map<TerminalSymbol, SymbolSequence>> getProductionsMap(){
            return productions;
	}

	public static SymbolSequence lookup(NonTerminalSymbol symbol, TerminalSymbol lookAhead){
            return productions.get(symbol).get(lookAhead);
	}
}
