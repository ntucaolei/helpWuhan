package main.java.Entity;

public class ResponseError {
	public String status = "";
	public String reason = "";
	public String error_code = "0000";
	
	/*
	 * 
	 0000   --- 未初始化
	 1000   --- DB 链接错误或DB异常
	 2222   --- 发生未知错误
	 * 
	 */
	
	

	public ResponseError(String status, String reason, String error_code) {
		this.status = status;
		this.reason = reason;
		this.error_code = error_code;
	}

}
