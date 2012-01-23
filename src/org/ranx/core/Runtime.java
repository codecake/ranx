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

import java.util.HashMap;

public class Runtime {
	private static HashMap<String, Node> _vars = new HashMap<String, Node>();
	
	public static Node var(String name_) {
		return _vars.get(name_);
	}
	
	public static void var(String name_, Node node_) {
		_vars.put(name_, node_);
	}
}
