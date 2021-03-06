/*
 * File    : CrossWordEditor.java
 * Created : 28-apr-2004 18:06
 * By      : fbusquets
 *
 * JClic - Authoring and playing system for educational activities
 *
 * Copyright (C) 2000 - 2018 Francesc Busquets & Departament
 * d'Educacio de la Generalitat de Catalunya
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details (see the LICENSE file).
 */

package edu.xtec.jclic.activities.textGrid;

import edu.xtec.jclic.Activity;
import edu.xtec.jclic.ActivityEditor;
import edu.xtec.jclic.ActivityEditorPanel;

/**
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.08.29
 */
public class CrossWordEditor extends ActivityEditor {

  /** Creates a new instance of CrossWordEditor */
  public CrossWordEditor(Activity act) {
    super(act);
  }

  @Override
  protected void createPanels(ActivityEditorPanel panel) {
    panel.addInternalPanel(ActivityEditorPanel.TEXTGRID_CRW, null, null);
  }
}
