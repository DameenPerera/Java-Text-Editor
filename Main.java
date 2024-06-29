import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.undo.*;

public class Main implements ActionListener{
	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	JMenuBar menubar;
	JMenu menuFile, menuEdit, menuFormat, menuColor, menuFont, menuFontSize;
	JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit, itemWordWrap,
		itemFontTNR, item10, item11, item12, color1, color2, itemUndo, itemRedo;
		
	UndoManager undoManager = new UndoManager();
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		createWindow();
		createTextAreaAndMenu();
		createFileMenu();
		createFormatMenu();
		createColorMenu();
		createEditMenu();
		window.setVisible(true);
	}
	
	public void createWindow(){
		window = new JFrame("Text Editor");
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextAreaAndMenu(){
		textArea = new JTextArea("");
		textArea.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));
        
        // Create undo action
        Action undoAction = new AbstractAction("Undo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            }
        };
        
        // Create redo action
        Action redoAction = new AbstractAction("Redo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canRedo()) {
                    undoManager.redo();
                }
            }
        };
        
		textArea.setBorder(new EmptyBorder(3, 3, 3, 3));
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
		
		menubar = new JMenuBar();
		window.setJMenuBar(menubar);
		
		menuFile = new JMenu("File");
		menubar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menubar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menubar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menubar.add(menuColor);
		
		itemUndo = new JMenuItem(undoAction);
		menuEdit.add(itemUndo);
		
		itemRedo = new JMenuItem(redoAction);
		menuEdit.add(itemRedo);
		
		// Bind undo action to Ctrl+Z
        textArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control Z"), "Undo");
        textArea.getActionMap().put("Undo", undoAction);
        
        // Bind redo action to Ctrl+Y
        textArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control Y"), "Redo");
        textArea.getActionMap().put("Redo", redoAction);
	}
	
	public void createFileMenu(){
		itemNew = new JMenuItem("New");
		menuFile.add(itemNew);
		itemNew.addActionListener(this);
		itemNew.setActionCommand("New");
		
		itemOpen = new JMenuItem("Open File");
		menuFile.add(itemOpen);
		itemOpen.addActionListener(this);
		itemOpen.setActionCommand("Open");
		
		itemSave = new JMenuItem("Save");
		menuFile.add(itemSave);
		itemSave.addActionListener(this);
		itemSave.setActionCommand("Save");
		
		itemSaveAs = new JMenuItem("Save As");
		menuFile.add(itemSaveAs);
		itemSaveAs.addActionListener(this);
		itemSaveAs.setActionCommand("SaveAs");
		
		itemExit = new JMenuItem("Exit");
		menuFile.add(itemExit);
		itemExit.addActionListener(this);
		itemExit.setActionCommand("Exit");
	}
	
	public void createFormatMenu(){
		itemWordWrap = new JMenuItem("Word Wrap : OFF");
		menuFormat.add(itemWordWrap);
		itemWordWrap.addActionListener(this);
		itemWordWrap.setActionCommand("ww");
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		itemFontTNR = new JMenuItem("Time New Roman");
		menuFont.add(itemFontTNR);
		itemFontTNR.addActionListener(this);
		itemFontTNR.setActionCommand("TNR");
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		item10 = new JMenuItem("10");
		menuFontSize.add(item10);
		item10.addActionListener(this);
		item10.setActionCommand("10");
		
		item11 = new JMenuItem("11");
		menuFontSize.add(item11);
		item11.addActionListener(this);
		item11.setActionCommand("11");
		
		item12 = new JMenuItem("12");
		menuFontSize.add(item12);
		item12.addActionListener(this);
		item12.setActionCommand("12");
	}
	
	public void createColorMenu(){
		color1 = new JMenuItem("Dark");
		menuColor.add(color1);
		color1.addActionListener(this);
		color1.setActionCommand("Dark");
		
		color2 = new JMenuItem("Light");
		menuColor.add(color2);
		color2.addActionListener(this);
		color2.setActionCommand("Light");
	}
	
	public void createEditMenu(){
		
	}
	
	Functions function = new Functions(this);
	FormatFunctions format = new FormatFunctions(this);
	Theme theme = new Theme(this);
	EditFunctions edit = new EditFunctions(this);
	
	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()){
			case "New" : function.newFile(); break;
			case "Open" : function.openFile(); break;
			case "Save" : function.saveFile(); break;
			case "SaveAs" : function.saveAsFile(); break;
			case "Exit" : function.exit(); break;
			case "ww" : format.changeWordWrap(); break;
			case "TNR" : format.changeFont("Times New Roman"); break;
			case "10" : format.changeSize(10); break;
			case "11" : format.changeSize(11); break;
			case "12" : format.changeSize(12); break;
			case "Dark" : theme.dark(); break;
			case "Light" : theme.light(); break;
		}
	}
}
