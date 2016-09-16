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

import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.document.OnSaveTask;

/** @author thislooksfun */
@MimeRegistration(mimeType = "text/x-java", service = OnSaveTask.Factory.class, position = 1610)
public class CollapseEmptyBlocksFactory implements OnSaveTask.Factory
{
	@Override
	public OnSaveTask createTask(OnSaveTask.Context cntxt)
	{
		return new CollapseEmptyBlocks(cntxt.getDocument());
	}
}
