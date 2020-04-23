package athread.emoticon;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

public class EmoticonView extends JDialog implements ActionListener{
	JButton emot1 = new JButton();
	JButton emot2 = new JButton();
	JButton emot3 = new JButton();
	JButton emot4 = new JButton();
	JButton emot5 = new JButton();
	JButton emot6 = new JButton();
	String imgFile[] = {"lion11.png","lion22.png","lion33.png"
			           ,"lion44.png","lion55.png","lion66.png"};
	JButton emots[] = {emot1,emot2,emot3,emot4,emot5,emot6};
	ImageIcon imgs[] = new ImageIcon[imgFile.length];
	String path = "src//emoticon//";
	String imgChoice = "default";
	public void initDisplay() {
		this.setLayout(new GridLayout(2,3,2,2));
		for(int i=0;i<emots.length;i++) {
			imgs[i] = new ImageIcon(path+imgFile[i]);
			emots[i].setIcon(imgs[i]);
			this.add(emots[i]);
		}
		this.setTitle("이모티콘");
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		EmoticonView emot = new EmoticonView();
		emot.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == emot1) {
			imgChoice = "lion11.png";
		}
		else if(obj == emot2) {
			imgChoice = "lion22.png";
		}
		else if(obj == emot3) {
			imgChoice = "lion33.png";
		}
		else if(obj == emot4) {
			imgChoice = "lion44.png";
		}
		else if(obj == emot5) {
			imgChoice = "lion55.png";
		}
		else if(obj == emot6) {
			imgChoice = "lion66.png";
		}
	}

}










