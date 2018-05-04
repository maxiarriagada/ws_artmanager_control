package artmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Response {
	COMPANY_NOT_FOUND("COMPANY_NOT_FOUND", "Empresa no disponible"), 
	OK("OK", "Logueo Exitoso"), 
	EXCEEDED_SESSIONS("EXCEEDED_SESSIONS", "Exede usuarios permitidos"), 
	INVALID_PHONE("INVALID_PHONE","No puede iniciar sesión desde otro teléfono"), 
	ACTIVE_SESSION("ACTIVE_SESSION", "Registra una sesión activa"),
	
	CREATER_SUCCESS("CREATER_SUCCESS", "Usuario dado de alta"),
	UPDATE_SUCCESS("UPDATE_SUCCESS", "Usuario guardado"),
	DELETE_SUCCESS("DELETE_SUCCESS", "Usuario eliminado"),
	
	
	VALID_PREVENTOR_NAME("VALID_PREVENTOR_NAME", "Nombre preventor valido"),
	INVALID_PREVENTOR_NAME("INVALID_PREVENTOR_NAME", "Nombre preventor existente"),
	
	RROR_PREVENTORNAME("ERROR_PREVENTORNAME", "Nombre preventor incorrecto"),
	ERROR_USERNAME("ERROR_USERNAME", "Nombre usuario incorrecto"),
	ERROR_PASSWORD("ERROR_PASSWORD", "Contraseña incorrecta");
	

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
