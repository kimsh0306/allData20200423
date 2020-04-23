package athread.emoticon;

import java.awt.Color;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class TalkClientThread extends Thread {
	TalkClient tc = null;
	public TalkClientThread(TalkClient tc) {
		this.tc = tc;
	}
	public SimpleAttributeSet  makeAttribute(String fcolor) {
		SimpleAttributeSet sas = new SimpleAttributeSet();
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				       , new Color(Integer.parseInt(fcolor)));
		return sas;
	}
	/*
	 * 서버에서 말한 내용을 들어봅시다.
	 */
	public void run() {
		boolean isStop = false;
		while(!isStop) {
			try {
				String msg = "";//100#apple
				msg = (String)tc.ois.readObject();
				//tc.jta_display.append(msg+"\n");
				StringTokenizer st = null;
				int protocol = 0;//100|200|201|202|500
				if(msg !=null) {
					st = new StringTokenizer(msg,"#");
					protocol = Integer.parseInt(st.nextToken());//100
				}
				switch(protocol) {
					case Protocol.LOGIN:{//100#apple
						String nickName = st.nextToken();
						try {
							tc.sd_display.insertString(tc.sd_display.getLength()
									                  ,nickName+"님이 입장하였습니다.\n"
									                  ,new SimpleAttributeSet());
						} catch (Exception e) {
							// TODO: handle exception
						}
						tc.jtp_display.setCaretPosition(tc.sd_display.getLength());
						Vector<String> v = new Vector<>();
						v.add(nickName);
						tc.dtm.addRow(v);
					}break;
					case Protocol.ONE:{
						String nickName = st.nextToken();
						String otherName = st.nextToken();
						String message = st.nextToken();
						try {
							tc.sd_display.insertString
							(tc.sd_display.getLength()
							,nickName+"님이 "+otherName+"님에게 "+message+"\n"
							, new SimpleAttributeSet());
						} catch (Exception e) {
							// TODO: handle exception
						}
						tc.jtp_display.setCaretPosition(tc.sd_display.getLength());
					}break;
					case Protocol.MULTI:{
						String nickName = st.nextToken();
						String message = st.nextToken();
						String fontColor = st.nextToken();
						SimpleAttributeSet sas = makeAttribute(fontColor);
						try {
							tc.sd_display.insertString(tc.sd_display.getLength()
									, "["+nickName+"]"+message+"\n"
									, sas);
						} catch (Exception e) {
							// TODO: handle exception
						}
						tc.jtp_display.setCaretPosition(tc.sd_display.getLength());			
					}break;
					case Protocol.CHANGE:{
						String nickName = st.nextToken();
						String afterName = st.nextToken();
						String message = st.nextToken();
						//테이블에 대화명 변경하기
						for(int i=0;i<tc.dtm.getRowCount();i++) {
							String imsi = (String)tc.dtm.getValueAt(i, 0);
							if(nickName.equals(imsi)) {
								tc.dtm.setValueAt(afterName, i, 0);
								break;
							}
						}
						//채팅창에 타이틀바에도 대화명을 변경처리 한다.
						if(nickName.equals(tc.loginForm.nickName)) {
							tc.setTitle(afterName+"님의 대화창");
							tc.loginForm.nickName = afterName;
						}
						try {
							tc.sd_display.insertString(tc.sd_display.getLength()
									, message+"\n"
									, new SimpleAttributeSet());
						} catch (Exception e) {
							// TODO: handle exception
						}
						tc.jtp_display.setCaretPosition(tc.sd_display.getLength());	
					}break;
					case Protocol.EXIT:{
						String nickName = st.nextToken();
						try {
							tc.sd_display.insertString(tc.sd_display.getLength()
									, nickName+"님이 퇴장 하였습니다.\n"
									, new SimpleAttributeSet());
						} catch (Exception e) {
							// TODO: handle exception
						}						
						tc.jtp_display.setCaretPosition(tc.sd_display.getLength());
						for(int i=0;i<tc.dtm.getRowCount();i++) {
							String n =(String)tc.dtm.getValueAt(i, 0);
							if(n.equals(nickName)) {
								tc.dtm.removeRow(i);
							}
						}
					}break;
				}////////////end of switch
			} catch (Exception e) {
				// TODO: handle exception
			}
		}////////////////////end of while
	}////////////////////////end of run
}












