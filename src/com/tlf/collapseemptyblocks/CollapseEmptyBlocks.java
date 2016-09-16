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
package com.tlf.collapseemptyblocks;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.netbeans.spi.editor.document.OnSaveTask;

import static com.tlf.util.TLFUtil.println;

/** @author thislooksfun */
public class CollapseEmptyBlocks implements OnSaveTask
{
	private static final long serialVersionUID = 1L;
	private final Document document;

	public CollapseEmptyBlocks(Document document)
	{
		this.document = document;
		println("Well, things are happening...");
	}

	@Override
	public void performTask()
	{
		try {
			char[] chars = document.getText(0, document.getLength()).toCharArray();

			println("chars.length = " + chars.length);
			println("document.getLength() = " + document.getLength());

			int lastNonSpace = chars.length - 1;
			int openingBrace = -1;
			int closingBrace = -1;

			for (int i = chars.length - 1; i > 0; i--) {
				char c = chars[i];
				switch (c) {
					case '{':
						openingBrace = i;
						break;
					case '}':
						closingBrace = i;
						break;
					case ' ':
					case '\t':
					case '\r':
					case '\n':
						break;
					default:
						if (openingBrace >= 0 && closingBrace >= openingBrace + 1) {
							{
								int start = openingBrace + 1;
								int len = closingBrace - start;
								document.remove(start, len);
							}
							{
								int start = i + 1;
								int len = openingBrace - start;
								document.remove(start, len);
								document.insertString(start, " ", null);
							}
						}
						lastNonSpace = i;
						openingBrace = -1;
						closingBrace = -1;
						break;
				}
			}
		} catch (BadLocationException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void runLocked(Runnable r)
	{
		// I honestly don't know why this is needed,
		// but for some reason it is.
		r.run();
	}

	@Override
	public boolean cancel()
	{
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}
