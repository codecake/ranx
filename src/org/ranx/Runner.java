/*
    ranx - general purpose reactive language
    Copyright (C) 2012  codec4ke@gmail.com

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.ranx;

import org.ranx.parser.*;

import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Runner {
	private static void runLine(String line) {
		try {
	        RanxLexer lex = new RanxLexer(new ANTLRStringStream(line));
	        CommonTokenStream tokens = new CommonTokenStream(lex);
	 
	        RanxParser parser = new RanxParser(tokens); // created from T.g
	        RanxParser.formula_return r = parser.formula(); // launch parsing
	        if ( r!=null ) System.out.println(((CommonTree)r.getTree()).toStringTree());
	 
	        CommonTreeNodeStream nodes = new CommonTreeNodeStream((Tree)r.getTree());
	        nodes.setTokenStream(tokens);
	        Eval walker = new Eval(nodes); // created from TP.g
	        walker.prog();
		} catch (RecognitionException ex) {
			System.err.println(ex.toString());
		}
	}
	
	public static void printHeader() {
		System.out.print("ranx v0.1");
	}
	
    public static void main(String args[]) throws Exception {
    	InputStreamReader converter = new InputStreamReader(System.in);
    	BufferedReader reader = new BufferedReader(converter);
    	while(true) {
    		printHeader();
    		System.out.print("ranx> ");
    		String line = reader.readLine();
    		if(line.equals("quit")) {
    			break;
    		}
    		runLine(line);
    	}    	
    }
}
