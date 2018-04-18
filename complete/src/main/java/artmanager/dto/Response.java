package artmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Response {
	COMPANY_NOT_FOUND("COMPANY_NOT_FOUND", "Empresa no disponible"), 
	OK("OK", "Logueo Exitoso"), 
	EXCEEDED_SESSIONS("EXCEEDED_SESSIONS", "Exede usuarios permitidos"), 
	INVALID_PHONE("INVALID_PHONE","No puede iniciar sesión desde otro teléfono"), 
	ACTIVE_SESSION("ACTIVE_SESSION", "Registra una sesión activa");

	private  String value;
	private  String message;

	Response(String value, String message) {
		this.value = value;
		this.message = message;
	}

	public String getValue() {
		return value;
	}

	public String getMessage() {
		return message;
	}

}
