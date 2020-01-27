package main.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import main.java.Entity.ResponseError;

public class CommonShared {

	public static void main(String args[]) {
		String pic_base64 = convertImageToBase64Str("/Users/Tony/buffett_02.png");
		System.out.println(pic_base64);
	}

	public static Gson gson = new Gson();

	public static final boolean is_debug = true;

	public static final String db_hostname = "localhost";
	public static final String db_username = "root";
	public static final String db_password = "help5HanDev@2020";

//	 0000   --- 未初始化
//	 1000   --- DB 链接错误或DB异常
//	 2222   --- 发生未知错误
//   404    --- 找不到相关的对象

	public static final String ERROR_CODE_NEVER_INIT = "0000";
	public static final String ERROR_CODE_DB = "1000";
	public static final String ERROR_CODE_UNKNOWN = "2222";
	public static final String ERROR_CODE_NOT_FOUND = "404";

	public static final String ERROR_CODE_INVALID_INPUT = "4000";

	public static DBHelper localdbhelper = null;

	public static DBHelper getLocalDBHelper() {

		if (localdbhelper == null) {
			localdbhelper = new DBHelper(db_hostname, db_username, db_password);
		}

		return localdbhelper;
	}

	public static Response returnNotFoundError() {

		ResponseError resp = new ResponseError("error", "没找到", CommonShared.ERROR_CODE_NOT_FOUND);

		String result = gson.toJson(resp);

		return Response.status(500).entity(result).build();

	}

	public static Response returnDBError() {

		ResponseError resp = new ResponseError("error", "数据库连接遇到错误，请您稍后重试。", CommonShared.ERROR_CODE_DB);

		String result = gson.toJson(resp);

		Utils.log("[Error] Return: " + result);

		return Response.status(500).entity(result).build();
	}

	public static Response returnUnknownError() {
		ResponseError resp = new ResponseError("error", "系统遇到错误，请您稍后重试.", CommonShared.ERROR_CODE_UNKNOWN);

		String result = gson.toJson(resp);

		return Response.status(500).entity(result).build();
	}

	public static Response returnInvalidInputError() {
		ResponseError resp = new ResponseError("error", "请输入有效的参数。", CommonShared.ERROR_CODE_INVALID_INPUT);

		String result = gson.toJson(resp);

		return Response.status(500).entity(result).build();
	}

	public static String convertImageToBase64Str(String filePath) {

		File file = new File(filePath);
		if (!file.exists()) {
			return "";
		}
		byte[] byteArr;
		try {
			byteArr = Files.readAllBytes(file.toPath());
			String encodedBase64File = Base64.getEncoder().encodeToString(byteArr);

			return encodedBase64File;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
