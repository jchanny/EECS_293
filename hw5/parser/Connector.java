/*Jeremy Chan jsc126
  Lennox Wildman law136

  Connector class*/
package parser;

import java.util.HashMap;
import java.util.Map;

public final class Connector extends AbstractToken{

    TerminalSymbol type;

    private static Cache<TerminalSymbol, Connector> cache;

    private static HashMap<TerminalSymbol, String> validConnectors = new HashMap<TerminalSymbol, String>();

    private Connector(TerminalSymbol type){
        this.type = type;
    }

    public TerminalSymbol getType(){
        return type;
    }

    //private method that returns a Map of valid Connector types
    private static Map<TerminalSymbol, String> getValidConnectorTypes(){
        if(validConnectors.size() == 0){
            validConnectors.put(TerminalSymbol.PLUS, "+");
            validConnectors.put(TerminalSymbol.MINUS, "-");
            validConnectors.put(TerminalSymbol.TIMES, "*");
            validConnectors.put(TerminalSymbol.DIVIDE, "/");
            validConnectors.put(TerminalSymbol.OPEN, "(");
            validConnectors.put(TerminalSymbol.CLOSE, ")");
        }

        return validConnectors;
    }

    /*creates new Connector of type if doesn't already exist in cache*/
    public static final Connector build(TerminalSymbol type){
        if(type == null){
            throw new NullPointerException("Type is null.");
        }
        if(!getValidConnectorTypes().containsKey(type)){
            throw new IllegalArgumentException("Invalid connector type.");
        }

        return cache.get(type, (t) -> new Connector(t));
    }

    public String toString(){
        return getValidConnectorTypes().get(getType());
    }
}
