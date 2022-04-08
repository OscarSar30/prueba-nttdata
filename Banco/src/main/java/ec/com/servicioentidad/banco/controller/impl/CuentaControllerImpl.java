package ec.com.servicioentidad.banco.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import ec.com.servicioentidad.banco.constants.MensajesExcepciones;
import ec.com.servicioentidad.banco.controller.contract.ICuentaController;
import ec.com.servicioentidad.banco.dto.CuentaDTO;
import ec.com.servicioentidad.banco.dto.RespuestaDTO;
import ec.com.servicioentidad.banco.exceptions.ApplicationException;
import ec.com.servicioentidad.banco.service.contract.ICuentaService;
import ec.com.servicioentidad.banco.validadores.BancoValidator;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")
@RestController
@CrossOrigin(origins = "*")
public class CuentaControllerImpl implements ICuentaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CuentaControllerImpl.class);
    
    @Autowired
    ICuentaService cuentaSvc;

	@Override
	public ResponseEntity<?> actualizarCuenta(@Valid CuentaDTO body) {
		
		ResponseEntity<?> response = null;
		try {	
			LOGGER.info("Inicia proceso de actualizar cuenta controller");
			CuentaDTO dto = cuentaSvc.actualizarCuenta(body);
			response = BancoValidator.validarResultadoaByUpdate(dto);
			LOGGER.info("Finaliza proceso de actualizar cuenta controller");
		} catch (ApplicationException e) {
			LOGGER.error("Excepcion de negocio al actualizar cuenta nuevo: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("Error proceso de actualizar cuenta controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Finaliza actualizar cuenta controller");
		return response;
	}

	@Override
	public ResponseEntity<?> consultarCuentasPorIdentificacion(String identificacion) {
		ResponseEntity<?> response = null;
		try {
			LOGGER.info("Inicia consultar cuentas por identificacion controller");
			List<CuentaDTO> listDto = cuentaSvc.consultarCuentasPorIdentificacion(identificacion);
			response = BancoValidator.validarResultado(listDto);
		}catch (Exception e) {
			LOGGER.error("Error en exception al consultar cuentas por identificacion controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOGGER.info("Finaliza consulta cuentas por identificacion controller");
		return response;
	}

	@Override
	public ResponseEntity<?> crearCuenta(@Valid CuentaDTO body) {
		ResponseEntity<?> response = null;
		try {
			LOGGER.info("Inicia creación de cuenta controller");
			CuentaDTO dto = cuentaSvc.crearCuenta(body);
			response = BancoValidator.validateResultByCreate(dto);
		} catch (ApplicationException e) {
			LOGGER.error("Excepcion de negocio al crear cuenta nuevo: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("Excepcion al crear cuenta nuevo controller: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Finaliza creación de cuenta controller");
		return response;
	}

	@Override
	public ResponseEntity<?> eliminarCuenta(Integer id) {
		try {	
			LOGGER.info("Inicia proceso de eliminar cuenta controller");
			cuentaSvc.eliminarCuenta(id);
			LOGGER.info("Finaliza proceso de eliminar cuenta controller");
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("200").descripcion(MensajesExcepciones.ELIMINACION_EXISTOSA),
					HttpStatus.OK);
		} catch (ApplicationException e) {
			LOGGER.error("Excepcion de negocio al eliminar cuenta controller: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("Error proceso de eliminar cuenta controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> consultarCuentaPorNumeroCuenta(String numeroCuenta) {
		ResponseEntity<?> response = null;
		try {
			LOGGER.info("Inicia consultar cuenta por numero cuenta controller");
			CuentaDTO dto = cuentaSvc.consultarCuentaPorNumeroCuenta(numeroCuenta);
			response = BancoValidator.validarResultado(dto);
		}catch (Exception e) {
			LOGGER.error("Error en exception al consultar cuenta por numero cuenta controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOGGER.info("Finaliza consulta cuenta por numero cuenta controller");
		return response;
	}

	@Override
	public ResponseEntity<?> consultarCuentas() {
		ResponseEntity<?> response = null;
		try {
			LOGGER.info("Inicia consulta de cuentas controller");
			List<CuentaDTO> listDto = cuentaSvc.consultarCuentas();
			response = BancoValidator.validarResultado(listDto);
		}catch (Exception e) {
			LOGGER.error("Error en exception al consulta de cuentas controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOGGER.info("Finaliza consulta de cuentas controller");
		return response;
	}

}
