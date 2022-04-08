/**
 * 
 */
package ec.com.servicioentidad.banco.validadores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ec.com.servicioentidad.banco.constants.MensajesExcepciones;
import ec.com.servicioentidad.banco.dto.ClienteDTO;
import ec.com.servicioentidad.banco.dto.CuentaDTO;
import ec.com.servicioentidad.banco.dto.MovimientosDTO;
import ec.com.servicioentidad.banco.dto.RespuestaDTO;

/**
 * @author osarcos
 *
 */
public class BancoValidator {
	
	private BancoValidator() {
		
	}

	public static ResponseEntity<?> validateResultByCreate(ClienteDTO dto) {
		if (dto == null) {
			return new ResponseEntity<>(
					new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(
				new RespuestaDTO().codigoRespuesta("201")
						.descripcion(String.format(MensajesExcepciones.CREACION_COMPLETADA, dto.getId().toString())),
				HttpStatus.CREATED);
	}
	
	public static ResponseEntity<?> validateResultByCreate(CuentaDTO dto) {
		if (dto == null) {
			return new ResponseEntity<>(
					new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(
				new RespuestaDTO().codigoRespuesta("201")
						.descripcion(String.format(MensajesExcepciones.CREACION_COMPLETADA, dto.getIdCuenta().toString())),
				HttpStatus.CREATED);
	}
	
	public static ResponseEntity<?> validateResultByCreate(MovimientosDTO dto) {
		if (dto == null) {
			return new ResponseEntity<>(
					new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(
				new RespuestaDTO().codigoRespuesta("201")
						.descripcion(String.format(MensajesExcepciones.CREACION_COMPLETADA, dto.getIdMovimiento().toString())),
				HttpStatus.CREATED);
	}

	@SuppressWarnings("null")
	public static ResponseEntity<?> validarResultadoaByUpdate(ClienteDTO dto) {
		if (dto == null) {
			return new ResponseEntity<>(
					new RespuestaDTO().codigoRespuesta("404").descripcion(
							String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, dto.getId().toString())),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("200")
				.descripcion(MensajesExcepciones.ACTUALIZACION_CORRECTA),
				HttpStatus.OK);
	}
	
	@SuppressWarnings("null")
	public static ResponseEntity<?> validarResultadoaByUpdate(CuentaDTO dto) {
		if (dto == null) {
			return new ResponseEntity<>(
					new RespuestaDTO().codigoRespuesta("404").descripcion(
							String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, dto.getIdCuenta().toString())),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("200")
				.descripcion(MensajesExcepciones.ACTUALIZACION_CORRECTA),
				HttpStatus.OK);
	}
	
	@SuppressWarnings("null")
	public static ResponseEntity<?> validarResultadoaByUpdate(MovimientosDTO dto) {
		if (dto == null) {
			return new ResponseEntity<>(
					new RespuestaDTO().codigoRespuesta("404").descripcion(
							String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, dto.getIdMovimiento().toString())),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("200")
				.descripcion(MensajesExcepciones.ACTUALIZACION_CORRECTA),
				HttpStatus.OK);
	}

	public static ResponseEntity<?> validarResultado(ClienteDTO dto) {
		if (dto == null) {
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("404")
					.descripcion("El recurso no fue encontrado"), HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(dto);

	}
	
	public static ResponseEntity<?> validarResultado(List<?> resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500")
					.descripcion("Algo ocurrió, resultado no obtenido"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (resultado.isEmpty()) {
			return new ResponseEntity<>(
					new RespuestaDTO().codigoRespuesta("204").descripcion("No se encontraron resultados"),
					HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(resultado);

	}
	
	public static ResponseEntity<?> validarResultado(CuentaDTO dto) {
		if (dto == null) {
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("404")
					.descripcion("El recurso no fue encontrado"), HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(dto);

	}

}
