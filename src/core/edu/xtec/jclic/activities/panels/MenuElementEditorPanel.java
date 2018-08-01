/*
 * File    : MenuElementEditorPanel.java
 * Created : 05-jun-2002 12:17
 * By      : fbusquets
 *
 * JClic - Authoring and playing system for educational activities
 *
 * Copyright (C) 2000 - 2005 Francesc Busquets & Departament
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

package edu.xtec.jclic.activities.panels;

import edu.xtec.jclic.edit.*;
import edu.xtec.util.SmallButton;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.09.16
 */
public class MenuElementEditorPanel extends EditorPanel {

  private static List<ImageIcon> standardIcons;
  private List<ImageIcon> icons;

  /** Creates new form MenuElementEditPanel */
  public MenuElementEditorPanel(edu.xtec.util.Options options) {
    super(options);
    MenuEditor.createActions(options);
    MenuElementEditor.createActions(options);
    buildIconList();
    initComponents();
    postInit(250, true, true);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    mainPanel = new javax.swing.JPanel();
    javax.swing.JLabel projectLabel = new javax.swing.JLabel();
    projectText = new javax.swing.JTextField();
    projectText.getDocument().addDocumentListener(this);
    btFindProject = new SmallButton(MenuElementEditor.findProjectAction);
    javax.swing.JLabel iconLabel = new javax.swing.JLabel();
    iconCombo = new javax.swing.JComboBox<Object>(
        new DefaultComboBoxModel<Object>(icons.toArray(new ImageIcon[icons.size()])));
    iconCombo.addActionListener(this);
    btFindIcon = new SmallButton(MenuElementEditor.findIconAction);
    javax.swing.JLabel captionLabel = new javax.swing.JLabel();
    captionText = new javax.swing.JTextField();
    captionText.getDocument().addDocumentListener(this);
    javax.swing.JLabel descLabel = new javax.swing.JLabel();
    descText = new javax.swing.JTextField();
    descText.getDocument().addDocumentListener(this);

    setPreferredSize(new java.awt.Dimension(350, 300));
    setLayout(new java.awt.BorderLayout());

    mainPanel.setOpaque(false);
    mainPanel.setLayout(new java.awt.GridBagLayout());

    projectLabel.setText(options.getMsg("menuElement_dlg_project"));
    projectLabel.setToolTipText(options.getMsg("menuElement_dlg_project_tooltip"));
    projectLabel.setLabelFor(projectText);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 2);
    mainPanel.add(projectLabel, gridBagConstraints);

    projectText.setToolTipText(options.getMsg("menuElement_dlg_project_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    mainPanel.add(projectText, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    mainPanel.add(btFindProject, gridBagConstraints);

    iconLabel.setText(options.getMsg("menuElement_dlg_icon"));
    iconLabel.setToolTipText(options.getMsg("menuElement_dlg_icon_tooltip"));
    iconLabel.setLabelFor(iconCombo);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 2);
    mainPanel.add(iconLabel, gridBagConstraints);

    iconCombo.setToolTipText(options.getMsg("menuElement_dlg_icon_tooltip"));
    iconCombo.setRenderer(new edu.xtec.util.CustomListCellRenderer());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 4);
    mainPanel.add(iconCombo, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    mainPanel.add(btFindIcon, gridBagConstraints);

    captionLabel.setText(options.getMsg("edit_text"));
    captionLabel.setToolTipText(options.getMsg("menuElement_dlg_text_tooltip"));
    captionLabel.setLabelFor(captionText);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 2);
    mainPanel.add(captionLabel, gridBagConstraints);

    captionText.setToolTipText(options.getMsg("menuElement_dlg_text_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 4);
    mainPanel.add(captionText, gridBagConstraints);

    descLabel.setText(options.getMsg("menuElement_dlg_description"));
    descLabel.setToolTipText(options.getMsg("menuElement_dlg_description_tooltip"));
    descLabel.setLabelFor(descText);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 4, 2, 2);
    mainPanel.add(descLabel, gridBagConstraints);

    descText.setToolTipText(options.getMsg("menuElement_dlg_description_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 4);
    mainPanel.add(descText, gridBagConstraints);

    add(mainPanel, java.awt.BorderLayout.CENTER);
  } // </editor-fold>//GEN-END:initComponents

  public boolean checkIfEditorValid(Editor e) {
    return e instanceof MenuElementEditor;
  }

  public void fillData() {
    MenuElement me = getMenuElement();
    captionText.setText(me == null ? "" : me.caption);
    projectText.setText(me == null ? "" : me.projectPath);
    descText.setText(me == null ? "" : me.description);
    if (getMeIcon() != null && !icons.contains(getMeIcon())) {
      DefaultComboBoxModel<Object> model = (DefaultComboBoxModel<Object>) iconCombo.getModel();
      model.addElement(getMeIcon());
    }
    iconCombo.setSelectedItem(getMeIcon());
  }

  protected MenuElement getMenuElement() {
    if (editor == null)
      return null;
    else
      return (getMeEditor().getMenuElement());
  }

  public void saveData() {
    MenuElement me = getMenuElement();
    if (me != null) {
      me.caption = captionText.getText();
      me.projectPath = projectText.getText();
      me.description = descText.getText();
      getMeEditor().meIcon = (ImageIcon) iconCombo.getSelectedItem();
      if (getMeIcon() != null)
        me.icon = getMeIcon().getDescription();
    }
  }

  @Override
  protected void setEditor(Editor e) {
    super.setEditor(e);
    if (e != null) {
      icons = new ArrayList<ImageIcon>(standardIcons);
      iconCombo.setModel(new DefaultComboBoxModel<Object>(icons.toArray(new ImageIcon[icons.size()])));
    }
  }

  @Override
  protected javax.swing.Icon getIcon() {
    return MenuElementEditor.getIcon();
  }

  protected MenuElementEditor getMeEditor() {
    return (MenuElementEditor) editor;
  }

  protected ImageIcon getMeIcon() {
    MenuElementEditor mee = getMeEditor();
    return mee == null ? null : mee.meIcon;
  }

  @Override
  protected String getTitle() {
    return options.getMsg("menuElement_dlg_title");
  }

  @Override
  protected void addActionsTo(Container cnt) {
    cnt.add(new SmallButton(MenuEditor.newMenuElementAction));
    cnt.add(new SmallButton(MenuEditor.newMenuAction));
    cnt.add(new SmallButton(Editor.moveUpAction));
    cnt.add(new SmallButton(Editor.moveDownAction));
    cnt.add(new SmallButton(Editor.copyAction));
    cnt.add(new SmallButton(Editor.cutAction));
    cnt.add(new SmallButton(Editor.pasteAction));
    cnt.add(new SmallButton(Editor.deleteAction));
  }

  protected void buildIconList() {
    if (standardIcons == null) {
      standardIcons = new ArrayList<ImageIcon>();
      for (int i = 0; i < 4; i++) {
        // String s="ico0"+i+".gif";
        String s = "ico0" + i + ".png";
        ImageIcon ii = edu.xtec.util.ResourceManager.getImageIcon("icons/" + s);
        if (ii != null)
          standardIcons.add(ii);
      }
    }
    icons = new ArrayList<ImageIcon>(standardIcons);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btFindIcon;
  private javax.swing.JButton btFindProject;
  private javax.swing.JTextField captionText;
  private javax.swing.JTextField descText;
  private javax.swing.JComboBox<Object> iconCombo;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JTextField projectText;
  // End of variables declaration//GEN-END:variables

}
