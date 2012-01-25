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

public class MockConsole extends Console {
	
	private String[] _input;
	private int _inputPos = 0;
	private StringBuilder _out = new StringBuilder();
	private StringBuilder _err = new StringBuilder();
	private StringBuilder _dbg = new StringBuilder();

	public MockConsole(String[] input_) {
		_input = input_;
	}
	
	@Override
	public void print(String s) {
		_out.append(s);
	}

	@Override
	public void printError(String s) {
		_err.append(s);
	}

	@Override
	public String readLine() {
		if(_inputPos < _input.length) {
			return _input[_inputPos++];
		}
		return null;
	}

	@Override
	public void printDebug(String s) {
		_dbg.append(s);
	}
	
	public String out() { return _out.toString(); }
	public String err() { return _err.toString(); }
	public String dbg() { return _dbg.toString(); }

}
