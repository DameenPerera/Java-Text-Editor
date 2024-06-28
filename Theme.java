import javax.swing.*;
import java.awt.*;

class Theme{
	
	Main mainClass;
	
	Theme(Main mainC){
		this.mainClass = mainC;
	}
	
	public void dark(){
		mainClass.window.getContentPane().setBackground(new Color(64,64,64));
		mainClass.textArea.setBackground(new Color(64,64,64));
		mainClass.textArea.setForeground(Color.white);
	}
	
	public void light(){
		mainClass.window.getContentPane().setBackground(new Color(230,230,230));
		mainClass.textArea.setBackground(new Color(240,240,240));
		mainClass.textArea.setForeground(Color.black);
	}
}