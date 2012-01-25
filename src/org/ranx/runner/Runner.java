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
package org.ranx.runner;

import org.ranx.parser.*;

import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Runner {
	private org.ranx.core.Runtime _runtime;
	public Runner(org.ranx.core.Runtime runtime_) {
		_runtime = runtime_;
	}
	
	public org.ranx.core.Runtime runtime() {
		return _runtime;
	}
	
	private void runLine(String line) {
		try {
	        RanxLexer lex = new RanxLexer(new ANTLRStringStream(line));
	        CommonTokenStream tokens = new CommonTokenStream(lex);
	 
	        RanxParser parser = new RanxParser(tokens); 
	        RanxParser.formula_return r = parser.formula(); 
	        if ( r!=null ) System.out.println(((CommonTree)r.getTree()).toStringTree());
	 
	        CommonTreeNodeStream nodes = new CommonTreeNodeStream((Tree)r.getTree());
	        nodes.setTokenStream(tokens);
	        Eval walker = new Eval(nodes); 
	        walker.setRuntime(_runtime);
	        walker.prog();
		} catch (RecognitionException ex) {
			_runtime.console().printErrorLine(ex.toString());
		}
	}
	
	public void run() {
		String line = _runtime.console().readLine();
		while(line != null) {
			runLine(line);
			line = _runtime.console().readLine();
		}
	}
	
	public void printHeader() {
		_runtime.console().printLine("ranx v0.1");
		_runtime.console().printLine("Copyright (c) 2012 codec4ke@gmail.com");
		_runtime.console().printLine("");
		_runtime.console().printLine("This program is free software: you can redistribute it and/or modify");
		_runtime.console().printLine("it under the terms of the GNU General Public License as published by");
		_runtime.console().printLine("the Free Software Foundation, version 3 of the License.");
		_runtime.console().printLine("");
		_runtime.console().printLine("This program is distributed in the hope that it will be useful,");
		_runtime.console().printLine("but WITHOUT ANY WARRANTY; without even the implied warranty of");
		_runtime.console().printLine("MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the");
		_runtime.console().printLine("GNU General Public License for more details.");
		_runtime.console().printLine("");
		_runtime.console().printLine("You should have received a copy of the GNU General Public License");
		_runtime.console().printLine("along with this program.  If not, see <http://www.gnu.org/licenses/>.");
		_runtime.console().printLine("");
	}
	
    public static void main(String args[]) throws Exception {
    	org.ranx.core.Runtime runtime = new org.ranx.core.Runtime();
    	Runner runner = new Runner(runtime);
    	InputStreamReader converter = new InputStreamReader(System.in);
    	BufferedReader reader = new BufferedReader(converter);
		runner.printHeader();
    	while(true) {
    		System.out.print("ranx> ");
    		String line = reader.readLine();
    		if(line.equals("quit")) {
    			break;
    		}
    		runner.runLine(line);
    	}    	
    }
}
