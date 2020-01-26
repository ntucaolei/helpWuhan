package main.java.Entity;

public class ResponseError {
	public String status="";
	public String reason="";
	
		public ResponseError(String status,String reason){
			this.status=status;
			this.reason=reason;
		}
}
