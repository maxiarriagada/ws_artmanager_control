package artmanager.util;
import java.util.Base64;

public class UtilBase64 {
	
	public static String encode(String value){
		return new String(Base64.getEncoder().encode(value.getBytes()));
	}

	public static String decode(String value){
		return  new String(Base64.getDecoder().decode(value.getBytes()));
	}
}
