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

public abstract class Console {
	public abstract void print(String s);
	public void printLine(String s) {
		print(s);
		print("\n");
	}
	
	public abstract void printError(String s);
	public void printErrorLine(String s) {
		printError(s);
		printError("\n");
	}
	
	public abstract String readLine();
	
	public abstract void printDebug(String s);
	public void printDebugLine(String s) {
		printDebug(s);
		printDebug("\n");
	}
}
