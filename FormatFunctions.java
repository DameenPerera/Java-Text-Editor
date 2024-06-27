import javax.swing.*;
import java.awt.*;

class FormatFunctions{

	Main mainClass;
	
	FormatFunctions(Main mainC){
		this.mainClass = mainC;
	}
	
	public void changeWordWrap(){
		if (mainClass.textArea.getLineWrap() == false){
			mainClass.textArea.setLineWrap(true);
			mainClass.itemWordWrap.setText("Word Wrap : ON");
		}else{
			mainClass.textArea.setLineWrap(false);
			mainClass.itemWordWrap.setText("Word Wrap : OFF");
		}
	}
	
	public void changeFont(String fontName){
		Font newFont = new Font(fontName, Font.PLAIN, mainClass.textArea.getFont().getSize());
		mainClass.textArea.setFont(newFont);
	}
	
	public void changeSize(int size){
		Font newFont = new Font(mainClass.textArea.getFont().getFontName(), Font.PLAIN, size);
		mainClass.textArea.setFont(newFont);
	}
}