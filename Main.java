import javax.swing.*;

public class Main{
	JFrame window;
	JTextArea textarea;
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
		textarea = new JTextArea("");
		scrollPane = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
		
		itemOpen = new JMenuItem("Open File");
		menuFile.add(itemOpen);
		
		itemSave = new JMenuItem("Save");
		menuFile.add(itemSave);
		
		itemSaveAs = new JMenuItem("Save As");
		menuFile.add(itemSaveAs);
		
		itemExit = new JMenuItem("Exit");
		menuFile.add(itemExit);
	}
}
