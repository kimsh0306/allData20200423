package foodList.sh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

//이 클래스 안에서 이벤트 처리를 해 줄 것이다.
public class FoodLogic implements ActionListener{

	FoodView fView = null;
	
	public FoodLogic(FoodView fView) {
		this.fView = fView;	//넘어 온 주소번지를 내가 가진 전역변수 fView에 저장시킨다.
	}
	
	FoodDao fDao = new FoodDao();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("이벤트 발생");
		
		//콜백함수: 시스템이 자동으로 호출해 주는 함수
		//addActionListener의 경우 액션이 발생하면 이 메소드가 호출된다.
		Object obj = e.getSource();
		
		if(obj == fView.jbtn_sel) {
			System.out.println("조회버튼 클릭");
			List<Map<String,String>> foodList = new ArrayList<>();
			foodList = fDao.getFoodList();//ㅁㅁㅁㅁㅁ ㅁ안에는 각각 map이 들어있고, map 안에는 한 row의 정보가 들어있다. fList == foodList
			
			//조회 버튼을 누를 때 데이터가 있다면 지우고 다시 보여주는 기능을 구현해 보자.***
			//dtm_food에 데이터가 있는 지 확인 하는 메소드는 getRowCount()이다.
			//데이터가 0보다 크면 removeRow()를 한다. 처음 행을 지운다는 의미로 파라미터에 0을 넣어 준다.
			while(fView.dtm_food.getRowCount()>0) {
				fView.dtm_food.removeRow(0);
			};
			
			//dtm_food.addRow는 파라미터로 벡터를 받기 때문에 벡터 타입의 변수 aRow에 (DB에서 가져온 값을 담은)foodList를 담아 준다.
			
			Vector<String> aRow = null; 
			
			for(int i=0;i<foodList.size();i++) {
				aRow = new Vector<String>();
				aRow.add(foodList.get(i).get("no"));	//벡터에는 no 정보가 담겼다.
				aRow.add(foodList.get(i).get("name"));	//벡터에는 name의 정보가 담겼다.
				aRow.add(foodList.get(i).get("score"));	//벡터에는 name의 정보가 담겼다.
				aRow.add(foodList.get(i).get("info"));	//벡터에는 info의 정보가 담겼다.
				fView.dtm_food.addRow(aRow);
			}
		}
		else if (obj == fView.jbtn_ins) {
			System.out.println("입력버튼 클릭");
			fView.insertView();
		}
		
		else if (obj == fView.jbtn_save) {
			FoodVO fVO = new FoodVO();
			fVO.setNo(Integer.parseInt(fView.jtf_no.getText()));		//형변환****			
			fVO.setName(fView.jtf_name.getText());						//형변환****			
			fVO.setScore(Double.parseDouble(fView.jtf_score.getText()));//형변환****			
			fVO.setInfo(fView.jta_info.getText());						//형변환****			
			fDao.insertRow(fVO);
		}
		else if (obj == fView.jbtn_upt) {
			//제이테이블에서 선택된 로우가 몇 번째인지 int로 반환값을 받아서 int형 변수에 담았다. 
			int sRow = fView.jt_food.getSelectedRow();
			//dtm에서 선택된 로우와 0번째 컬럼 값을 가져왔다. dtm에 데이터가 있으니까. 그리고 tNo에 담았다.
			String tNo = (String)fView.dtm_food.getValueAt(sRow, 0);
			String tName = (String)fView.dtm_food.getValueAt(sRow, 1);
			String tScore = (String)fView.dtm_food.getValueAt(sRow, 2);
			String tInfo = (String)fView.dtm_food.getValueAt(sRow, 3);
			//해당 텍스트필드에 값을 set해줬다.
			fView.jtf_no.setText(tNo);
			fView.jtf_name.setText(tName);
			fView.jtf_score.setText(tScore);
			fView.jta_info.setText(tInfo);
			fView.updateView();
			
			
		}
		else if (obj == fView.jbtn_uSave) {
			fView.jtf_no.getText();
			fView.jtf_name.getText();
			fView.jtf_score.getText();
			fView.jta_info.getText();
			
			//텍스트필드에서 가져온 값을 uMap에 넣어줬다.
			//updateRow메소드의 파라미터로 uMap을 넣고 호출한다.
			Map<String,Object> uMap = new HashMap<>(); 
			uMap.put("f_no", fView.jtf_no.getText());
			uMap.put("f_name", fView.jtf_name.getText());
			uMap.put("f_score", fView.jtf_score.getText());
			uMap.put("f_info", fView.jta_info.getText());
			fDao.updateRow(uMap);
			
			
		}
		else if (obj == fView.jbtn_can) {
			fView.jd_update.dispose();
			
		}
	}
}