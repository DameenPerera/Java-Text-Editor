import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;

class Functions{
	
	Main mainClass;
	String fileName, fileLoc;
	
	Functions(Main mainC){
		this.mainClass = mainC;
	}
	
	public void newFile(){
		mainClass.textArea.setText("");
		mainClass.window.setTitle("Text Editor");
	}
	
	public void openFile(){
		FileDialog fd = new FileDialog(mainClass.window, "Select a File to Open", FileDialog.LOAD);
		fd.setVisible(true);
		if (fd.getFile() != null){
			fileName = fd.getFile();
			fileLoc = fd.getDirectory();
		}
		else
			return;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileLoc + fileName));
			newFile();
			mainClass.window.setTitle(fileName);
			String line = null;
			while ((line = br.readLine()) != null){
				mainClass.textArea.append(line + "\n");
			}
			br.close();
		}catch (Exception e){
			JOptionPane.showMessageDialog(mainClass.textArea, e);
		}
	}
	
}

public class Main implements ActionListener{
	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	JMenuBar menubar;
	JMenu menuFile, menuEdit, menuFormat, menuColor;
	JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		window.setVisible(true);
	}
	
	public void createWindow(){
		window = new JFrame("Text Editor");
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createTextArea(){
		textArea = new JTextArea("");
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}
	
	public void createMenuBar(){
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
		
		itemSaveAs = new JMenuItem("Save As");
		menuFile.add(itemSaveAs);
		
		itemExit = new JMenuItem("Exit");
		menuFile.add(itemExit);
	}
	
	Functions function = new Functions(this);
	
	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()){
			case "New" : function.newFile(); break;
			case "Open" : function.openFile(); break;
		}
	}
}
