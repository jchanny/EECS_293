/*Jeremy Chan jsc126
  Lennox Wildman law136
  Helper class that contains a Map of different productions to NonTerminalSymbols
 */
package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SymTable {

    private static HashMap<NonTerminalSymbol, List<SymbolSequence>> symSequencesList = new HashMap<NonTerminalSymbol, List<SymbolSequence>>();

    //creates symSequencesList if unpopulated, else returns it
    public static List<SymbolSequence> getSymbolSequence(NonTerminalSymbol nonTerminal){
        if(symSequencesList.size() == 0){

            //NonTerminalSymbol.EXPRESSION symbol sequences
            List<Symbol> expr = new ArrayList<Symbol>();
            expr.add(NonTerminalSymbol.TERM); expr.add(NonTerminalSymbol.EXPRESSION_TAIL);
            List<SymbolSequence> exprList = new ArrayList<SymbolSequence>();
            exprList.add(SymbolSequence.build(expr));
            symSequencesList.put(NonTerminalSymbol.EXPRESSION, exprList);

            //NonTerminalSymbol.EXPRESSION_TAIL symbol sequences
            List<Symbol> exprTail = new ArrayList<Symbol>();
            exprTail.add(TerminalSymbol.PLUS); exprTail.add(NonTerminalSymbol.TERM); exprTail.add(NonTerminalSymbol.EXPRESSION_TAIL);
            List<Symbol> exprTailMinus = new ArrayList<Symbol>();
            exprTailMinus.add(TerminalSymbol.MINUS); exprTailMinus.add(NonTerminalSymbol.TERM); exprTailMinus.add(NonTerminalSymbol.EXPRESSION_TAIL);
            List<SymbolSequence> exprTailList = new ArrayList<SymbolSequence>();
            exprTailList.add(SymbolSequence.build(exprTail));
            exprTailList.add(SymbolSequence.build(exprTailMinus));
            exprTailList.add(SymbolSequence.EPSILON);
            symSequencesList.put(NonTerminalSymbol.EXPRESSION,exprTailList);

            //NonTerminalSymbol.TERM symbol sequences
            List<Symbol> term = new ArrayList<Symbol>();
            term.add(NonTerminalSymbol.UNARY); term.add(NonTerminalSymbol.TERM_TAIL);
            List<SymbolSequence> termList = new ArrayList<SymbolSequence>();
            termList.add(SymbolSequence.build(term));
            symSequencesList.put(NonTerminalSymbol.TERM, termList);

            //NonTerminalSymbol.TERM_TAIL symbol sequences
            List<Symbol> termTailMult = new ArrayList<Symbol>();
            termTailMult.add(TerminalSymbol.TIMES); termTailMult.add(NonTerminalSymbol.UNARY); termTailMult.add(NonTerminalSymbol.TERM_TAIL);
            List<Symbol> termTailDivide = new ArrayList<Symbol>();
            termTailDivide.add(TerminalSymbol.DIVIDE); termTailDivide.add(NonTerminalSymbol.UNARY); termTailDivide.add(NonTerminalSymbol.TERM_TAIL);
            List<SymbolSequence> termTailList = new ArrayList<SymbolSequence>();
            termTailList.add(SymbolSequence.build(termTailMult));
            termTailList.add(SymbolSequence.build(termTailDivide));
            termTailList.add(SymbolSequence.EPSILON);
            symSequencesList.put(NonTerminalSymbol.TERM_TAIL, termTailList);

            //NonTerminalSymbol.UNARY symbol sequences
            List<Symbol> minusFactor = new ArrayList<Symbol>();
            minusFactor.add(TerminalSymbol.MINUS); minusFactor.add(NonTerminalSymbol.FACTOR);
            List<Symbol> factorPlain = new ArrayList<Symbol>();
            factorPlain.add(NonTerminalSymbol.FACTOR);
            List<SymbolSequence> unaryList = new ArrayList<SymbolSequence>();
            unaryList.add(SymbolSequence.build(minusFactor));
            unaryList.add(SymbolSequence.build(factorPlain));
            symSequencesList.put(NonTerminalSymbol.UNARY, unaryList);

            //NonTerminalSymbol.FACTOR symbol sequences
            List<Symbol> factorParen = new ArrayList<Symbol>();
            factorParen.add(TerminalSymbol.OPEN); factorParen.add(NonTerminalSymbol.EXPRESSION);
            factorParen.add(TerminalSymbol.CLOSE);
            List<Symbol> factorVar = new ArrayList<Symbol>();
            factorVar.add(TerminalSymbol.VARIABLE);
            List<SymbolSequence> factorList = new ArrayList<SymbolSequence>();
            factorList.add(SymbolSequence.build(factorParen));
            factorList.add(SymbolSequence.build(factorVar));
            symSequencesList.put(NonTerminalSymbol.FACTOR, factorList);
        }

        return symSequencesList.get(nonTerminal);
    }
}
