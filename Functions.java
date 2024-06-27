import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

class Functions{
	
	Main mainClass;
	String fileName, fileLoc;
	
	Functions(Main mainC){
		this.mainClass = mainC;
	}
	
	public void newFile(){
		clearTextArea();
		fileName = null;
		fileLoc = null;
	}
	
	public void clearTextArea(){
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
		else return;

		try{
			BufferedReader br = new BufferedReader(new FileReader(fileLoc + fileName));
			clearTextArea();
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
	
	public void saveFile(){
		if (fileName==null) saveAsFile();
		else{
			try{
				FileWriter fw = new FileWriter(fileLoc + fileName);
				fw.write(mainClass.textArea.getText());
				fw.close();
				mainClass.window.setTitle(fileName);
			}catch (Exception e){
				JOptionPane.showMessageDialog(mainClass.textArea, e);
			}
		}
	}
	
	public void saveAsFile(){
		FileDialog fd = new FileDialog(mainClass.window, "Save File As", FileDialog.SAVE);
		fd.setVisible(true);
		
		if (fd.getFile() != null){
			fileName = fd.getFile();
			fileLoc = fd.getDirectory();
		}
		else return;
		
		try{
			FileWriter fw = new FileWriter(fileLoc + fileName);
			fw.write(mainClass.textArea.getText());
			fw.close();
			mainClass.window.setTitle(fileName);
		}catch (Exception e){
			JOptionPane.showMessageDialog(mainClass.textArea, e);
		}
	}
	
	public void exit(){
		System.exit(0);
	}
}