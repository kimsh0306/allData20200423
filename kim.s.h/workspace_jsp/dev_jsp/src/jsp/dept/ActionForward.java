package jsp.dept;
/*
 * 페이지 이동과 흐름제어에 필요한 유틸 클래스이다.(클래스 쪼개기)
 */
public class ActionForward {
	//path정보 url정보에 해당된다.
	private String path = null;//URL정보 req.getRequestURI()
	//true => redirect로 처리하겠다는 뜻, false => forward로 처리하겠다는 뜻
	private boolean isRedirect = true;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
