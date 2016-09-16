/*
 * Copyright (C) 2016 thislooksfun
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tlf.util;

/** @author thislooksfun */
public class TLFUtil
{
	/** Make the constructor private, as it is not needed */
	private TLFUtil()
	{
	}

	/**
	 * A wrapper for {@link java.io.PrintStream#print(java.lang.String) System.out.print(String x);}
	 *
	 * @param s The String to print
	 */
	public static void print(String s)
	{
		System.out.print(s);
	}

	/**
	 * A wrapper for {@link java.io.PrintStream#println(java.lang.String) System.out.println(String x);}
	 *
	 * @param s The String to print
	 */
	public static void println(String s)
	{
		System.out.println(s);
	}
}
