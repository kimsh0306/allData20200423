package foodList.sh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import dbMgr.DBConnectionMgr;

public class FoodDao {

	DBConnectionMgr 	dbMgr 	= DBConnectionMgr.getInstance();
	Connection 			con 	= null; //연결통로 역할
	PreparedStatement 	pstmt 	= null; //실제로 오라클에 요청하러 다녀 오는 역할
	ResultSet 			rs 		= null; //결과를 받아줄 수 있는 커서
	
	
	//여기에서 db연결을 해줄 것이다.
	public List<Map<String, String>> getFoodList() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT f_no, f_name, f_score, f_infor");
		sql.append(" FROM foodList");
				
		List<Map<String, String>> fList = new ArrayList<Map<String,String>>();
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();	//rs에 오라클에서 가지고 온 데이터가 들어간다.
			
			//오라클에서 가지고 온 데이터 == pstmt.executeQuery()
			
			Map<String, String> fMap = null;
					
			//오라클은 결과가 몇 개인지 모른다. 그래서 while문
			//while문이 돌 때마다 fMap을 생성해 준다.
			while(rs.next()) {
				fMap = new HashMap<String, String>();
				fMap.put("no", Integer.toString(rs.getInt("f_no"))); //getInt => 인트 타입을 가져오겠다.
				fMap.put("name", rs.getString("f_name"));
				fMap.put("score", Double.toString(rs.getDouble("f_score")));
				fMap.put("info", rs.getString("f_infor"));
				fList.add(fMap);
				
			}
			//|fMap|fMap|fMap|....이런 식으로 fList에 fMap이 담긴다.
			System.out.println(fList.size());
			
		} catch (SQLException e) {
			System.out.println("SQL오류발생!!!");
			e.printStackTrace();
			e.toString();
			System.out.println(e.getStackTrace());
			
		} catch (Exception e) {//모든 오류를 잡아 준다.
			System.out.println("그 외의 오류발생!!!");
			e.printStackTrace();
		}
		return fList;
	}
	
	//저장버튼을 눌렀을 때 insertRow()실행
	public void insertRow(FoodVO fVO) {
		//System.out.println("insertRow() 호출 성공");
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO foodList VALUES(");
		sql.append("?,?,?,?)");
		
		System.out.println(fVO.getNo());
		System.out.println(fVO.getName());
		System.out.println(fVO.getScore());
		System.out.println(fVO.getInfo());
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			//pstmt.setInt(?,?) => (몇번째 물음표, 오라클에 넣을 사용자가 입력한 값) 물음표를 채워준다.
			
			pstmt.setInt(1, fVO.getNo());
			pstmt.setString(2, fVO.getName());
			pstmt.setDouble(3, fVO.getScore());
			pstmt.setString(4, fVO.getInfo());
			
			int result = pstmt.executeUpdate();//executeUpdate()의 반환타입이 int이다. 실패하면 0, 성공하면 1
			if(result == 0) {
				JOptionPane.showMessageDialog(null, "실패했습니다.");
			}
			else {
				JOptionPane.showMessageDialog(null, "성공했습니다. result: "+result);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL오류발생!!! - insertRow()");
			e.printStackTrace();
			e.toString();
			System.out.println(e.getStackTrace());
			
		} catch (Exception e) {//모든 오류를 잡아 준다.
			System.out.println("그 외의 오류발생!!! - insertRow()");
			e.printStackTrace();
		}
		
	}
	
	/*
		UPDATE 테이블명 SET 컬럼명 = ?, 컬럼명 = ?,,, WHERE 기준컬럼명 = ?
		-------------------------------------------------------
		UPDATE dept set dname = "안녕" 
		WHERE deptno = 10;
		결국 어떤 로우의 어떤 컬럼을 무슨 값으로 바꿀 것인지 알아야 한다.
		어떤 로우 >> 컬럼명, 값이 있어야 한다. 왜냐면 조건이기 때문이다.
		어떤 컬럼을 무슨 값으로 >> 이것도 컬럼명이랑 값이 있어야 한다.
		총 필요한 정보가 네 개이다.
		
		다시 정리하자면
		f_no,f_name,f_score,f_info
		이렇게 컬럼이 네 개 있다.
		수정하는 창이 열리면 그 창에서 사용자가 값을 바꿀 것이다. 그러면 하나만 바꾸는 것이 아니고
		모든 컬럼을 다 바꿀 수도 있다. 그래서 그 사용자가 입력한 값들을 전부 받아와야 한다.
		각각 컬럼에 대한 각각의 값을 구분해서 관리를 해줘야 한다.
		그래서, 사용자가 수정한 값을 가져올 때는 Map을 사용할 것이다.
		근데 여기서 조건이 필요하다.
		오라클에서 생각하면 f_no는 primary key라서 고정되어  있는 값이기 때문에
		f_no를 조건으로 UPDATE문을 실행합시다.
		
		Map을 받아와서 그 안의 값을 꺼내어 UPDATE문을 실행해야겠다고 생각할 수 있다.
		이게 메소드를 구현하는 과정이다.
		내가 어떤 정보를 받아와서 사용할 것인지를 생각해야 된다.
		지금은 여러 값을 받아와서 사용할 거니까 '파라미터로 Map을 사용해야지'하고 결정한 것이다.		
	 */
	public void updateRow(Map<String,Object> pMap) {
		
		StringBuilder sql = new StringBuilder();
		
		//오라클에 직접 명령하는 문이기 때문에 오라클에 저장된 테이블 컬럼명과 같아야 한다.
		sql.append("UPDATE foodList SET f_name=?, f_score=?, f_infor=?");
		sql.append(" WHERE f_no=?");
		Map<String,Object> map = new HashMap<String, Object>();
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			//저장 공간일뿐이기 때문에 이름이 오라클에 저장된 테이블 컬럼명과 달라도 된다.
			pstmt.setString(1, (String)pMap.get("f_name"));
			pstmt.setDouble(2, Double.parseDouble(pMap.get("f_score").toString()));
			pstmt.setString(3, (String)pMap.get("f_info"));
			pstmt.setInt(4, Integer.parseInt(pMap.get("f_no").toString()));		
			
			//실제로 오라클에 갔다 왔는지 여부 테스트
			int result = pstmt.executeUpdate();
			if(result == 0) {
				JOptionPane.showMessageDialog(null, "실패했습니다.");
			}
			else {
				JOptionPane.showMessageDialog(null, "성공했습니다. result: "+result);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public FoodDao() {
		
	}
	
	public static void main(String[] args) {
		FoodDao fDao = new FoodDao();
	}
	
}
