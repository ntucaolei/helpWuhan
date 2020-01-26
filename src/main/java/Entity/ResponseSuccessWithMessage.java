package main.java.Entity;

public class ResponseSuccessWithMessage {
	public String status = "";
	public String message = "";

	public ResponseSuccessWithMessage(String status, String message){
		this.status=status;
		this.message=message;
	}
}
