package artmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Response {
	//SESSION
	LOG_OK("LOG_OK", "Logueo Exitoso"),
	LOG_ERROR("LOG_ERROR", "Logueo fallido"), 
	COMPANY_NOT_FOUND("COMPANY_NOT_FOUND", "Empresa no disponible"), 
	EXCEEDED_SESSIONS("EXCEEDED_SESSIONS", "Exede usuarios permitidos"), 
	INVALID_PHONE("INVALID_PHONE","No puede iniciar sesión desde otro teléfono"), 
	ACTIVE_SESSION("ACTIVE_SESSION", "Registra una sesión activa"),
	
	/*USER*/
	
	ERROR_USERNAME("ERROR_USERNAME", "Nombre usuario incorrecto"),
	ERROR_PASSWORD("ERROR_PASSWORD", "Contraseña incorrecta"),
	USER_CREATE_SUCCESS("USER_CREATE_SUCCESS", "Usuario dado de alta"),
	USER_CREATE_ERROR("USER_CREATE_ERROR", "Alta usuario fallida"),
	USER_UPDATE_SUCCESS("USER_UPDATE_SUCCESS", "Usuario actualizado"),
	USER_UPDATE_ERROR("USER_UPDATE_ERROR", "Actualización fallida"),
	USER_DELETE_SUCCESS("USER_DELETE_SUCCESS", "Usuario eliminado"),
	USER_DELETE_ERROR("USER_DELETE_ERROR", "Eliminación fallida"),
	
	//VALIDATOR
	VALID_PREVENTOR_NAME("VALID_PREVENTOR_NAME", "Nombre preventor valido"),
	INVALID_PREVENTOR_NAME("INVALID_PREVENTOR_NAME", "Nombre preventor existente"),
	
	ERROR_PREVENTORNAME("ERROR_PREVENTORNAME", "Nombre preventor incorrecto"),
	SUCCESS_PREVENTORNAME("SUCCESS_PREVENTORNAME", "Nombre preventor correcto"),
	
	//GENERAL
	SUCCESS_UPDATE("SUCCESS_UPDATE", "Actualizado"),
	ERROR_UPDATE("ERROR_UPDATE", "No se actualizo"),
	SUCCESS_SAVE("SUCCESS_SAVE", "Guardo"),
	ERROR_SAVE("ERROR_SAVE", "No Guardo"),
	SUCCESS_DELETE("SUCCESS_DELETE", "Eliminado"),
	ERROR_DELETE("ERROR_DELETE", "No se elimino"),;
	

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
