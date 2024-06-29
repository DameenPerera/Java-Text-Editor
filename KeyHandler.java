import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	Main mainClass;
	
	KeyHandler(Main mainC){
		this.mainClass = mainC;
	}

	public void keyTyped(KeyEvent e){
		//pass
	}
	
	public void keyPressed(KeyEvent e){
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S)
			mainClass.function.saveFile();
		if (e.isShiftDown() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S)
			mainClass.function.saveAsFile();
		if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F)
			mainClass.menuFile.doClick();
	}
	
	public void keyReleased(KeyEvent e){
		//Pass
	}
}