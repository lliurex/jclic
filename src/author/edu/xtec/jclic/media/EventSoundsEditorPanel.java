/*
 * File    : EventSoundsEditorPanel.java
 * Created : 10-feb-2004 13:33
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

package edu.xtec.jclic.media;

import edu.xtec.jclic.Constants;
import edu.xtec.jclic.bags.MediaBagEditor;
import edu.xtec.jclic.beans.SoundButton;
import edu.xtec.util.JDomUtility;
import edu.xtec.util.Messages;
import edu.xtec.util.Options;
import edu.xtec.util.StrUtils;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.09.17
 */
public class EventSoundsEditorPanel extends javax.swing.JPanel implements PropertyChangeListener, ActionListener {

  Options options;
  JLabel[] txFields;
  JCheckBox[] chkBoxes;
  SoundButton[] buttons;
  EventSounds evs;

  /** Creates new form EventSoundsEditorPanel */
  public EventSoundsEditorPanel(Options options, MediaBagEditor mbe) {
    this.options = options;
    evs = new EventSounds(null);
    initComponents();
    txFields = new JLabel[] { evStart, evClick, evActionError, evActionOk, evFinishedError, evFinishedOk };
    buttons = new SoundButton[] { evStartBtn, evClickBtn, evActionErrorBtn, evActionOkBtn, evFinishedErrorBtn,
        evFinishedOkBtn };
    chkBoxes = new JCheckBox[] { evStartChk, evClickChk, evActionErrorChk, evActionOkChk, evFinishedErrorChk,
        evFinishedOkChk };
    for (int i = 0; i < buttons.length; i++) {
      buttons[i].setOptions(options);
      buttons[i].setMediaBagEditor(mbe);
      buttons[i].addPropertyChangeListener(SoundButton.PROP_SND_NAME, this);
      chkBoxes[i].addActionListener(this);
      chkBoxes[i].setSelected(true);
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  private void initComponents() { // GEN-BEGIN:initComponents
    java.awt.GridBagConstraints gridBagConstraints;

    evStartLb = new javax.swing.JLabel();
    evStartChk = new javax.swing.JCheckBox();
    evStart = new javax.swing.JLabel();
    evStartBtn = new edu.xtec.jclic.beans.SoundButton();
    evClickLb = new javax.swing.JLabel();
    evClickChk = new javax.swing.JCheckBox();
    evClick = new javax.swing.JLabel();
    evClickBtn = new edu.xtec.jclic.beans.SoundButton();
    evActionOkLb = new javax.swing.JLabel();
    evActionOkChk = new javax.swing.JCheckBox();
    evActionOk = new javax.swing.JLabel();
    evActionOkBtn = new edu.xtec.jclic.beans.SoundButton();
    evActionErrorLb = new javax.swing.JLabel();
    evActionErrorChk = new javax.swing.JCheckBox();
    evActionError = new javax.swing.JLabel();
    evActionErrorBtn = new edu.xtec.jclic.beans.SoundButton();
    evFinishedOkLb = new javax.swing.JLabel();
    evFinishedOkChk = new javax.swing.JCheckBox();
    evFinishedOk = new javax.swing.JLabel();
    evFinishedOkBtn = new edu.xtec.jclic.beans.SoundButton();
    evFinishedErrorLb = new javax.swing.JLabel();
    evFinishedErrorChk = new javax.swing.JCheckBox();
    evFinishedError = new javax.swing.JLabel();
    evFinishedErrorBtn = new edu.xtec.jclic.beans.SoundButton();

    setLayout(new java.awt.GridBagLayout());

    evStartLb.setLabelFor(evStartBtn);
    evStartLb.setText(options.getMsg("edit_evsounds_start"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evStartLb, gridBagConstraints);

    evStartChk.setToolTipText(options.getMsg("edit_evsounds_chk_tooltip"));
    evStartChk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evStartChk, gridBagConstraints);

    evStart.setText(options.getMsg("edit_evsounds_default"));
    evStart.setPreferredSize(new java.awt.Dimension(140, 27));
    evStart.setBorder(new javax.swing.border.TitledBorder(""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evStart, gridBagConstraints);

    evStartBtn.setToolTipText(options.getMsg("edit_evsounds_select_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evStartBtn, gridBagConstraints);

    evClickLb.setLabelFor(evClickBtn);
    evClickLb.setText(options.getMsg("edit_evsounds_click"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evClickLb, gridBagConstraints);

    evClickChk.setToolTipText(options.getMsg("edit_evsounds_chk_tooltip"));
    evClickChk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evClickChk, gridBagConstraints);

    evClick.setText(options.getMsg("edit_evsounds_default"));
    evClick.setPreferredSize(new java.awt.Dimension(140, 27));
    evClick.setBorder(new javax.swing.border.TitledBorder(""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evClick, gridBagConstraints);

    evClickBtn.setToolTipText(options.getMsg("edit_evsounds_select_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evClickBtn, gridBagConstraints);

    evActionOkLb.setLabelFor(evActionOkBtn);
    evActionOkLb.setText(options.getMsg("edit_evsounds_actionOk"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evActionOkLb, gridBagConstraints);

    evActionOkChk.setToolTipText(options.getMsg("edit_evsounds_chk_tooltip"));
    evActionOkChk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evActionOkChk, gridBagConstraints);

    evActionOk.setText(options.getMsg("edit_evsounds_default"));
    evActionOk.setPreferredSize(new java.awt.Dimension(140, 27));
    evActionOk.setBorder(new javax.swing.border.TitledBorder(""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evActionOk, gridBagConstraints);

    evActionOkBtn.setToolTipText(options.getMsg("edit_evsounds_select_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evActionOkBtn, gridBagConstraints);

    evActionErrorLb.setLabelFor(evActionErrorBtn);
    evActionErrorLb.setText(options.getMsg("edit_evsounds_actionError"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evActionErrorLb, gridBagConstraints);

    evActionErrorChk.setToolTipText(options.getMsg("edit_evsounds_chk_tooltip"));
    evActionErrorChk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evActionErrorChk, gridBagConstraints);

    evActionError.setText(options.getMsg("edit_evsounds_default"));
    evActionError.setPreferredSize(new java.awt.Dimension(140, 27));
    evActionError.setBorder(new javax.swing.border.TitledBorder(""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evActionError, gridBagConstraints);

    evActionErrorBtn.setToolTipText(options.getMsg("edit_evsounds_select_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evActionErrorBtn, gridBagConstraints);

    evFinishedOkLb.setLabelFor(evFinishedOkBtn);
    evFinishedOkLb.setText(options.getMsg("edit_evsounds_finishedOk"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evFinishedOkLb, gridBagConstraints);

    evFinishedOkChk.setToolTipText(options.getMsg("edit_evsounds_chk_tooltip"));
    evFinishedOkChk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evFinishedOkChk, gridBagConstraints);

    evFinishedOk.setText(options.getMsg("edit_evsounds_default"));
    evFinishedOk.setPreferredSize(new java.awt.Dimension(140, 27));
    evFinishedOk.setBorder(new javax.swing.border.TitledBorder(""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evFinishedOk, gridBagConstraints);

    evFinishedOkBtn.setToolTipText(options.getMsg("edit_evsounds_select_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evFinishedOkBtn, gridBagConstraints);

    evFinishedErrorLb.setLabelFor(evFinishedErrorBtn);
    evFinishedErrorLb.setText(options.getMsg("edit_evsounds_finishedError"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evFinishedErrorLb, gridBagConstraints);

    evFinishedErrorChk.setToolTipText(options.getMsg("edit_evsounds_chk_tooltip"));
    evFinishedErrorChk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evFinishedErrorChk, gridBagConstraints);

    evFinishedError.setText(options.getMsg("edit_evsounds_default"));
    evFinishedError.setPreferredSize(new java.awt.Dimension(140, 27));
    evFinishedError.setBorder(new javax.swing.border.TitledBorder(""));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evFinishedError, gridBagConstraints);

    evFinishedErrorBtn.setToolTipText(options.getMsg("edit_evsounds_select_tooltip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    add(evFinishedErrorBtn, gridBagConstraints);
  } // GEN-END:initComponents

  public static boolean nameChanged(EventSounds ev, int type, String oldName, String newName) {
    boolean result = false;
    if ((type & (Constants.T_AUDIO | Constants.T_MIDI)) != 0) {
      if (ev.parent != null)
        result |= nameChanged(ev.parent, type, oldName, newName);
      for (int i = 0; i < ev.elements.length; i++) {
        if (ev.elements[i] != null && oldName.equals(ev.elements[i].fileName)) {
          ev.elements[i].fileName = newName;
          result = true;
        }
      }
    }
    return result;
  }

  public void propertyChange(PropertyChangeEvent ev) {
    if (ev != null && ev.getSource() instanceof SoundButton) {
      SoundButton src = (SoundButton) ev.getSource();
      javax.swing.JLabel destLb = null;
      for (int i = 0; i < buttons.length; i++) {
        if (src == buttons[i]) {
          EventSoundsElement evse = evs.createElement(i);
          evse.setFileName(src.getSoundName());
          updateDisplayFor(i);
          break;
        }
      }
    }
  }

  protected void updateDisplayFor(int event) {
    EventSoundsElement evse = evs.getElement(event);
    boolean enabled = true;
    String msgKey = null;
    String msg = null;
    String fName = null;
    if (evse == null) {
      msgKey = "edit_evsounds_default";
    } else {
      enabled = (evse.getEnabled() != JDomUtility.FALSE);
      if (!enabled)
        msgKey = "edit_evsounds_disabled";
      else {
        fName = StrUtils.nullableString(evse.getFileName());
        if (fName == null)
          msgKey = "edit_evsounds_default";
        else
          msg = fName;
      }
    }
    if (msgKey != null)
      msg = options.getMsg(msgKey);
    txFields[event].setText(msg);
    buttons[event].setEnabled(enabled);
    buttons[event].setSoundName(fName);
    chkBoxes[event].setSelected(enabled);
  }

  public void setEventSounds(EventSounds evs) {
    if ((this.evs = evs) == null)
      this.evs = new EventSounds(null);
    for (int i = 0; i < buttons.length; i++) {
      updateDisplayFor(i);
    }
  }

  public EventSounds getEventSounds() {
    return evs;
  }

  private static Map<Options, EventSoundsEditorPanel> dlgPanels = new HashMap<Options, EventSoundsEditorPanel>(1);

  public static EventSounds getEventSounds(EventSounds initialValue, Options options, Component parent,
      MediaBagEditor mbe) {
    EventSounds result = null;
    Messages msg = options.getMessages();
    EventSoundsEditorPanel evsed = dlgPanels.get(options);
    if (evsed == null) {
      evsed = new EventSoundsEditorPanel(options, mbe);
      dlgPanels.put(options, evsed);
    }
    evsed.setEventSounds((EventSounds) initialValue.clone());
    boolean b = msg.showInputDlg(parent, evsed, "edit_evsounds_dlg_title");
    if (b) {
      result = evsed.getEventSounds();
    }
    return result;
  }

  public void actionPerformed(java.awt.event.ActionEvent ev) {
    if (ev != null && ev.getSource() instanceof JCheckBox) {
      for (int i = 0; i < chkBoxes.length; i++) {
        if (chkBoxes[i] == ev.getSource()) {
          EventSoundsElement evse = evs.createElement(i);
          evse.setEnabled(chkBoxes[i].isSelected() ? JDomUtility.DEFAULT : JDomUtility.FALSE);
          updateDisplayFor(i);
          break;
        }
      }
    }
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel evActionError;
  private edu.xtec.jclic.beans.SoundButton evActionErrorBtn;
  private javax.swing.JCheckBox evActionErrorChk;
  private javax.swing.JLabel evActionErrorLb;
  private javax.swing.JLabel evActionOk;
  private edu.xtec.jclic.beans.SoundButton evActionOkBtn;
  private javax.swing.JCheckBox evActionOkChk;
  private javax.swing.JLabel evActionOkLb;
  private javax.swing.JLabel evClick;
  private edu.xtec.jclic.beans.SoundButton evClickBtn;
  private javax.swing.JCheckBox evClickChk;
  private javax.swing.JLabel evClickLb;
  private javax.swing.JLabel evFinishedError;
  private edu.xtec.jclic.beans.SoundButton evFinishedErrorBtn;
  private javax.swing.JCheckBox evFinishedErrorChk;
  private javax.swing.JLabel evFinishedErrorLb;
  private javax.swing.JLabel evFinishedOk;
  private edu.xtec.jclic.beans.SoundButton evFinishedOkBtn;
  private javax.swing.JCheckBox evFinishedOkChk;
  private javax.swing.JLabel evFinishedOkLb;
  private javax.swing.JLabel evStart;
  private edu.xtec.jclic.beans.SoundButton evStartBtn;
  private javax.swing.JCheckBox evStartChk;
  private javax.swing.JLabel evStartLb;
  // End of variables declaration//GEN-END:variables

}
