/*Jeremy Chan jsc126
  Lennox Wildman law136
  Interface for parsing input into a node*/
package parser;

import java.util.List;

interface Symbol{

    ParseState parse(List<Token> input);

}
