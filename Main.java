import javax.swing.*;

public class Main{
	JFrame window;
	JTextArea textarea;
	JScrollPane scrollPane;
	
	public static void main(String[] args){
		new Main();
	}
	
	public Main(){
		createWindow();
		createTextArea();
		
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
}