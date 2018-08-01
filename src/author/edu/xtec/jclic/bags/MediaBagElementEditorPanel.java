/*
 * File    : MediaBagElementEditorPanel.java
 * Created : 02-feb-2004 13:50
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
package edu.xtec.jclic.bags;

import edu.xtec.jclic.edit.Editor;
import edu.xtec.jclic.edit.EditorPanel;
import edu.xtec.jclic.fileSystem.FileSystem;
import edu.xtec.jclic.fileSystem.ZipFileSystem;
import edu.xtec.jclic.misc.Utils;
import edu.xtec.jclic.project.JClicProjectEditor;
import edu.xtec.util.Messages;
import edu.xtec.util.Options;
import edu.xtec.util.ProgressDialog;
import edu.xtec.util.StreamIO;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.EventObject;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.08.14
 */
public class MediaBagElementEditorPanel extends EditorPanel {

  protected ZipFileSystem.ExtendedZipEntry zipEntry;
  protected ZipFileSystem zipFileSystem;

  /** Creates new form MediaBagElementEditorPanel */
  public MediaBagElementEditorPanel(Options options) {
    super(options);
    initComponents();
    refList.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          editActBtn.setEnabled(e.getFirstIndex() >= 0);
        }
      }
    });
    postInit(250, false, false);
  }

  @Override
  protected String getTitle() {
    return options.getMsg("edit_media_title");
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
    settingsPanel = new javax.swing.JPanel();
    javax.swing.JLabel nameLb = new javax.swing.JLabel();
    nameText = new javax.swing.JLabel();
    chNameBtn = new javax.swing.JButton();
    chNameBtn.addActionListener(this);
    javax.swing.JLabel fileLb = new javax.swing.JLabel();
    fileText = new javax.swing.JLabel();
    chFileBtn = new javax.swing.JButton();
    chFileBtn.addActionListener(this);
    saveFileBtn = new javax.swing.JButton();
    refreshFileBtn = new javax.swing.JButton();
    refreshFileBtn.addActionListener(this);
    javax.swing.JLabel typeLb = new javax.swing.JLabel();
    typeTx = new javax.swing.JLabel();
    javax.swing.JLabel sizeLb = new javax.swing.JLabel();
    sizeTx = new javax.swing.JLabel();
    zipIncludeChk = new javax.swing.JCheckBox();
    zipIncludeChk.addActionListener(this);
    refPanel = new javax.swing.JPanel();
    refScroll = new javax.swing.JScrollPane();
    refList = new javax.swing.JList<>();
    editActBtn = new javax.swing.JButton();
    editActBtn.addActionListener(this);

    setLayout(new java.awt.BorderLayout());

    mainPanel.setLayout(new java.awt.GridBagLayout());

    settingsPanel.setLayout(new java.awt.GridBagLayout());

    nameLb.setText(options.getMsg("edit_name"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(nameLb, gridBagConstraints);

    nameText.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    nameText.setMinimumSize(new java.awt.Dimension(200, 21));
    nameText.setPreferredSize(new java.awt.Dimension(200, 21));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(nameText, gridBagConstraints);

    chNameBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/edit.gif"))); // NOI18N
    chNameBtn.setToolTipText(options.getMsg("edit_media_change_name"));
    chNameBtn.setText("");
    chNameBtn.setMargin(new java.awt.Insets(2, 2, 2, 2));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(chNameBtn, gridBagConstraints);

    fileLb.setText(options.getMsg("edit_file"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(fileLb, gridBagConstraints);

    fileText.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    fileText.setMinimumSize(new java.awt.Dimension(200, 21));
    fileText.setPreferredSize(new java.awt.Dimension(200, 21));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(fileText, gridBagConstraints);

    chFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/file_open.gif"))); // NOI18N
    chFileBtn.setToolTipText(options.getMsg("edit_media_change_file"));
    chFileBtn.setText("");
    chFileBtn.setMargin(new java.awt.Insets(2, 2, 2, 2));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(chFileBtn, gridBagConstraints);

    saveFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/file_save.gif"))); // NOI18N
    saveFileBtn.setToolTipText(options.getMsg("edit_media_save_file"));
    saveFileBtn.setText("");
    saveFileBtn.setMargin(new java.awt.Insets(2, 2, 2, 2));
    saveFileBtn.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(saveFileBtn, gridBagConstraints);

    refreshFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/reset.gif"))); // NOI18N
    refreshFileBtn.setToolTipText(options.getMsg("edit_media_refresh_file"));
    refreshFileBtn.setText("");
    refreshFileBtn.setMargin(new java.awt.Insets(2, 2, 2, 2));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(refreshFileBtn, gridBagConstraints);

    typeLb.setText(options.getMsg("edit_media_type"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(typeLb, gridBagConstraints);

    typeTx.setText("-");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(typeTx, gridBagConstraints);

    sizeLb.setText(options.getMsg("edit_media_size"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(sizeLb, gridBagConstraints);

    sizeTx.setText("0 Kb");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(sizeTx, gridBagConstraints);

    zipIncludeChk.setText(options.getMsg("edit_media_includeInZip"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    settingsPanel.add(zipIncludeChk, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(settingsPanel, gridBagConstraints);

    refPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(options.getMsg("edit_media_referencedBy")));
    refPanel.setMinimumSize(new java.awt.Dimension(180, 100));
    refPanel.setPreferredSize(new java.awt.Dimension(180, 100));
    refPanel.setLayout(new java.awt.BorderLayout());

    refList.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        refListMouseClicked(evt);
      }
    });
    refScroll.setViewportView(refList);

    refPanel.add(refScroll, java.awt.BorderLayout.CENTER);

    editActBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/miniclic.png"))); // NOI18N
    editActBtn.setToolTipText(options.getMsg("edit_act_editActivity_tooltip"));
    editActBtn.setText(options.getMsg("edit_act_editActivity"));
    editActBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    refPanel.add(editActBtn, java.awt.BorderLayout.SOUTH);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(refPanel, gridBagConstraints);

    add(mainPanel, java.awt.BorderLayout.CENTER);
  } // </editor-fold>//GEN-END:initComponents

  private void refListMouseClicked(java.awt.event.MouseEvent evt) { // GEN-FIRST:event_refListMouseClicked

    if (refList.getSelectedValue() != null && evt.getClickCount() == 2) {
      editActivity(refList.getSelectedValue().toString());
    }
  } // GEN-LAST:event_refListMouseClicked

  protected void editActivity(String activityName) {
    MediaBagElementEditor mbed = getMediaBagElementEditor();
    if (mbed != null && activityName != null) {
      JClicProjectEditor prjed = (JClicProjectEditor) mbed.getFirstParent(JClicProjectEditor.class);
      if (prjed != null && prjed.getTestPlayerContainer() != null) {
        prjed.getTestPlayerContainer().editActivity(activityName);
      }
    }
  }

  public boolean checkIfEditorValid(Editor e) {
    return e instanceof MediaBagElementEditor;
  }

  protected MediaBagElementEditor getMediaBagElementEditor() {
    return (MediaBagElementEditor) editor;
  }

  protected MediaBagElement getMediaBagElement() {
    if (editor == null) {
      return null;
    } else {
      return getMediaBagElementEditor().getMediaBagElement();
    }
  }

  protected MediaBag getMediaBag() {
    if (editor == null) {
      return null;
    } else {
      return getMediaBagElementEditor().getMediaBag();
    }
  }

  @Override
  public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
    if (!enabled) {
      chNameBtn.setEnabled(false);
      chFileBtn.setEnabled(false);
      saveFileBtn.setEnabled(false);
      refreshFileBtn.setEnabled(false);
      zipIncludeChk.setEnabled(false);
    }
    refList.setEnabled(enabled);
  }

  protected FileSystem fileSystem;

  protected void fillData() {

    MediaBagElementEditor mbed = getMediaBagElementEditor();
    String fileName = mbed == null ? "" : mbed.getMediaBagElement().getFileName();
    fileSystem = (mbed == null || mbed.getMediaBag() == null ? null : mbed.getMediaBag().getProject().getFileSystem());
    if (fileSystem instanceof edu.xtec.jclic.fileSystem.ZipFileSystem) {
      zipFileSystem = (edu.xtec.jclic.fileSystem.ZipFileSystem) fileSystem;
      zipEntry = zipFileSystem.getEntry(fileName);
    } else {
      zipFileSystem = null;
      zipEntry = null;
    }
    String name = (mbed == null ? "" : mbed.getName());
    nameText.setText(name);
    nameText.setToolTipText(name);
    chNameBtn.setEnabled(mbed != null);

    fileText.setText(fileName);
    fileText.setToolTipText(fileName);
    chFileBtn.setEnabled(mbed != null);
    saveFileBtn.setEnabled(zipEntry != null);
    refreshFileBtn.setEnabled(mbed != null);

    typeTx.setText(mbed == null ? "" : mbed.getDescription(options));

    long fSize = -1;
    if (mbed != null) {
      fSize = mbed.getFileSize();
    }
    sizeTx.setText(fSize < 0 ? "" : options.getMessages().fileSize(fSize));

    zipIncludeChk.setSelected(mbed == null ? true : mbed.getMediaBagElement().saveFlag);
    zipIncludeChk.setEnabled(mbed != null);

    checkReferences();
  }

  protected void checkReferences() {
    MediaBagElementEditor mbed = getMediaBagElementEditor();
    List references = null;
    if (mbed != null) {
      references = mbed.listReferences();
    }
    refList.setListData(references == null ? new String[0] : references.toArray());

    refList.setSelectedIndex(-1);
    editActBtn.setEnabled(false);
  }

  /*
   * public boolean isModified(){ MediaBagElement mbe=getMediaBagElement(); return
   * mbe!=null && mbe.saveFlag!=zipIncludeChk.isSelected(); }
   */
  protected void saveData() {
    MediaBagElementEditor mbed = getMediaBagElementEditor();
    if (mbed != null) {
      mbed.getMediaBagElement().saveFlag = zipIncludeChk.isSelected();
    }
  }

  @Override
  public boolean eventPerformed(EventObject ev) {
    if (ev != null) {
      if (ev.getSource() == refreshFileBtn) {
        refreshFile();
      } else if (ev.getSource() == saveFileBtn) {
        saveFile();
      } else if (ev.getSource() == chFileBtn) {
        changeFileName();
      } else if (ev.getSource() == chNameBtn) {
        changeName();
      } else if (ev.getSource() == editActBtn && refList.getSelectedValue() != null) {
        editActivity(refList.getSelectedValue().toString());
        return false;
      }
    }
    return true;
  }

  private void refreshFile() {
    MediaBagElementEditor mbed = getMediaBagElementEditor();
    if (mbed != null) {
      if (zipEntry != null) {

        if (!zipFileSystem.realFileExists(getMediaBagElement().getFileName())) {
          options.getMessages().showAlert(this, "edit_media_warn_zipFileNotExternal");
          return;
        }
        zipEntry.ignore = true;
        zipEntry = null;

        mbed.updateContent(this);
        notifyChangesToParentPanel();
        getEditor().setModified(true);
      }
      getMediaBagElement().setData(null);
    }
  }

  private void saveFile() {
    if (zipEntry != null) {
      String fName = getMediaBagElement().getFileName();
      String fNameDest = zipFileSystem.chooseFile(fName, true, null, options, "FILE_SAVE", this, false);
      if (fNameDest != null) {
        try {
          OutputStream os = zipFileSystem.createSecureFileOutputStream(fNameDest);
          int len = (int) zipFileSystem.getFileLength(fName);
          InputStream is = zipFileSystem.getInputStream(fName);
          StreamIO.writeStreamDlg(is, os, len, options.getMessages().get("filesystem_copyFile"), this, options);
        } catch (Exception ex) {
          options.getMessages().showErrorWarning(this, "FILE_ERR_SAVING", ex);
        }
      }
    }
  }

  private void changeFileName() {
    MediaBagElementEditor mbed = getMediaBagElementEditor();
    if (mbed != null) {
      MediaBagElement mbe = mbed.getMediaBagElement();
      Messages msg = options.getMessages();
      String oldFileName = mbe.getFileName();
      FileSystem fs = mbed.getMediaBag().getProject().getFileSystem();
      int[] fileFilters = new int[] { Utils.getFileFilterCode(oldFileName) };
      String newFileName = fs.chooseFile(oldFileName.replace('/', File.separatorChar), false, fileFilters, options,
          "edit_find_media", this, true);
      if (newFileName != null) {
        newFileName = newFileName.replace(File.separatorChar, '/');
        if (mbed.changeFileName(newFileName, this, msg)) {
          notifyChangesToParentPanel();
        }
      }
    }
  }

  private void changeName() {
    final MediaBagElementEditor mbed = getMediaBagElementEditor();
    if (mbed != null) {
      Messages msg = options.getMessages();
      final String oldName = getMediaBagElement().getName();
      final String newName = msg.showInputDlg(MediaBagElementEditorPanel.this, "edit_media_rename",
          "edit_media_rename_prompt", oldName, "edit_media_rename_title", false);
      if (newName != null) {
        final ProgressDialog progressDialog = new ProgressDialog(this, options);
        edu.xtec.util.SwingWorker sw = new edu.xtec.util.SwingWorker() {

          @Override
          public Object construct() {
            mbed.rename(newName, MediaBagElementEditorPanel.this, options.getMessages());
            return null;
          }

          @Override
          public void finished() {
            notifyChangesToParentPanel();
            progressDialog.setVisible(false);
          }
        };
        progressDialog.start("edit_media_rename", "edit_media_renaming", sw, false, false, false);
      }
    }
  }

  private void notifyChangesToParentPanel() {
    MediaBagMultiEditorPanel mbep = (MediaBagMultiEditorPanel) getAWTAncestor(MediaBagMultiEditorPanel.class);
    if (mbep != null) {
      mbep.editorDataChanged(getEditor());
    }
  }

  @Override
  public void focusGained(java.awt.event.FocusEvent focusEvent) {
    super.focusGained(focusEvent);
    checkReferences();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton chFileBtn;
  private javax.swing.JButton chNameBtn;
  private javax.swing.JButton editActBtn;
  private javax.swing.JLabel fileText;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JLabel nameText;
  private javax.swing.JList<Object> refList;
  private javax.swing.JPanel refPanel;
  private javax.swing.JScrollPane refScroll;
  private javax.swing.JButton refreshFileBtn;
  private javax.swing.JButton saveFileBtn;
  private javax.swing.JPanel settingsPanel;
  private javax.swing.JLabel sizeTx;
  private javax.swing.JLabel typeTx;
  private javax.swing.JCheckBox zipIncludeChk;
  // End of variables declaration//GEN-END:variables

}
