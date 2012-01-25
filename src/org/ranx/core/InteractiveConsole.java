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
package org.ranx.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveConsole extends Console {

	InputStreamReader converter = new InputStreamReader(System.in);
	BufferedReader reader = new BufferedReader(converter);

	@Override
	public void print(String s) {
		System.out.print(s);
	}

	@Override
	public void printError(String s) {
		System.err.print(s);
	}

	@Override
	public String readLine() {
		try {
			return reader.readLine();
		} catch(IOException e) {
			return e.toString();
		}
	}

	@Override
	public void printDebug(String s) {
		System.out.println(s);
	}

}
