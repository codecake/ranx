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
package org.ranx.runner.test;

import org.ranx.core.*;
import org.ranx.runner.Runner;

import org.junit.Assert;
import org.junit.Test;

public class RunnerTest extends Assert {
	private void checkOutput(String out, String[] expected) {
		String[] actual = out.split("\n");
		assertEquals(expected.length, actual.length);
		for(int i = 0; i < actual.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
	
	@Test public void assignReadIntVar() {
		String[] input = { "a=123", "?a", "??a" };
		MockConsole console = new MockConsole(input);
		org.ranx.core.Runtime runtime = new org.ranx.core.Runtime(console);
		Runner runner = new Runner(runtime);
		runner.run();
		checkOutput(console.out(), new String[] { "123", "TInt"} );
	}

	@Test public void assignReadStringVar() {
		String[] input = { "a=\"foo\"", "?a", "??a" };
		MockConsole console = new MockConsole(input);
		org.ranx.core.Runtime runtime = new org.ranx.core.Runtime(console);
		Runner runner = new Runner(runtime);
		runner.run();
		checkOutput(console.out(), new String[] { "\"foo\"", "TString"} );
	}

	@Test public void assignReadFloatVar() {
		String[] input = { "a=123.45", "?a", "??a" };
		MockConsole console = new MockConsole(input);
		org.ranx.core.Runtime runtime = new org.ranx.core.Runtime(console);
		Runner runner = new Runner(runtime);
		runner.run();
		checkOutput(console.out(), new String[] { "123.45", "TFloat"} );
	}

	@Test public void assignReadBoolVar() {
		String[] input = { "a=true", "?a", "??a" };
		MockConsole console = new MockConsole(input);
		org.ranx.core.Runtime runtime = new org.ranx.core.Runtime(console);
		Runner runner = new Runner(runtime);
		runner.run();
		checkOutput(console.out(), new String[] { "true", "TBool"} );
	}
}
