import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import bnfc.r_exp.Yylex;
import bnfc.r_exp.parser;

class Main {
    public static void main(String[] args) {
        Yylex l;
        parser p;
        Reader input = new InputStreamReader(System.in);
        l = new Yylex(input);
        p = new parser(l, l.getSymbolFactory());
        bnfc.r_exp.Absyn.RegExp ast;
        try {
            ast = p.pRegExp1();
        } catch (IOException e) {
            System.err.println("i/o error! oh no!");
            System.exit(1);
        } catch (Throwable e) {
            System.err.println("parse error (or something else)! try testing with the bnfc generated modules (`make parse`)");
            e.printStackTrace();
            System.exit(1);
        }
    }
}