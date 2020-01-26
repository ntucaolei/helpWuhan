package main.java;

public class CommonShared {

	public static final boolean is_debug = true;

	public static final String db_hostname = "localhost";
	public static final String db_username = "root";
	public static final String db_password = "";
	
	public static DBHelper localdbhelper = null;
	
	
	public static DBHelper getLocalDBHelper() {
		
		if(localdbhelper==null) {
			localdbhelper=new DBHelper(db_hostname,db_username,db_password);
		}
		
		return localdbhelper;
	}

}
