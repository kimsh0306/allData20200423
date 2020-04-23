package athread.emoticon;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener {
	String imgPath = "src\\image\\talk\\";
	ImageIcon ig 		= new ImageIcon(imgPath+"main.png");
	JLabel jlb_id 		= new JLabel("아이디");
	JTextField jtf_id 	= new JTextField("test");
	JLabel jlb_pw 		= new JLabel("비밀번호");
	JPasswordField jtf_pw 	= new JPasswordField("123");
	Font font = new Font("휴먼매직체",Font.BOLD, 17);
	JButton jbtn_login = 
			new JButton(
					new ImageIcon(imgPath+"login.png"));
	JButton jbtn_join = 
			new JButton(
					new ImageIcon(imgPath+"confirm.png"));
	TalkDao tDao = new TalkDao();
	String 				nickName= null;//닉네임 등록
	LoginForm(){
		
	}
	//내부 클래스로 배경 이미지 처리
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			g.drawImage(ig.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
	public void initDisplay() {
		jbtn_login.addActionListener(this);
		this.setContentPane(new MyPanel());
		this.setLayout(null);//디폴트 - BorderLayout
		jlb_id.setBounds(45, 200, 80, 40);
		jlb_id.setFont(font);
		jtf_id.setBounds(110, 200, 185, 40);	
		this.add(jlb_id);
		this.add(jtf_id);
		jlb_pw.setBounds(45, 240, 80, 40);
		jlb_pw.setFont(font);
		jtf_pw.setBounds(110, 240, 185, 40);	
		this.add(jlb_pw);
		this.add(jtf_pw);
		jbtn_join.setBounds(45, 285, 120, 40);
		this.add(jbtn_join);
		jbtn_login.setBounds(175, 285, 120, 40);
		this.add(jbtn_login);
		this.setTitle("자바채팅 Ver2.0");
		this.setLocation(500, 100);
		this.setSize(350, 600);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		LoginForm login = new LoginForm();
		login.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(jbtn_login==obj) {
			if("".equals(jtf_id.getText()) || "".equals(jtf_pw.getText())) {
				JOptionPane.showMessageDialog(this, "아이디와 비번을 확인하세요");
				return;//더 이상 진행할 필요없다.
			}
			try {
				String mem_id= jtf_id.getText();
				String mem_pw= jtf_pw.getText();
				int result = 2;
				//result = Integer.valueOf(tDao.login(mem_id, mem_pw));
				String mem_name = tDao.login(mem_id, mem_pw);
				if("비밀번호가 맞지 않습니다.".equals(mem_name)) {
					JOptionPane.showMessageDialog(this, "비밀번호가 맞지 않습니다.");
					jtf_pw.setText("");
					return;
				}
				else if("아이디가 존재하지 않습니다.".equals(mem_name)) {
					JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다.");
					jtf_pw.setText("");
					return;
				}
				else {
					//DB에서 가져온 값과 전역변수 값 초기화 하기
					nickName = mem_name;
					this.setVisible(false);//로그인 화면은 비활성화시킴
					jtf_id.setText("");//입력한 아이디 초기화
					jtf_pw.setText("");//입력한 비번 초기화
					TalkClient tc = new TalkClient(this);//생성자 호출
				}
				System.out.println("mem_name:"+mem_name);
			} catch (Exception e2) {
				System.out.println("Exception:"+e2.toString());
			}
		}
		
	}

}
