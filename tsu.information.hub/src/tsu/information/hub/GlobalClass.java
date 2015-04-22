package tsu.information.hub;

import android.app.Application;

public class GlobalClass extends Application {
	
	//for user id
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String idNum) {
		userId = idNum;
	}
	
	
	
	//for college
	private String col;
	
	public String getCol() {
		return col;
	}
	public void setCol(String aCol) {
		col = aCol;
	}
	
	
	
	//for year level
	private String yl;
	
	public String getYL() {
		return yl;
	}
	public void setYL(String aYL) {
		yl = aYL;
	}

	
	
	//for category
	private String cat;
	
	public String getCat() {
		return cat;
	}
	public void setCat(String aCat) {
		cat = aCat;
	}
	
	
	//for position
	private String position;
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String aPosition) {
		position = aPosition;
	}
}
