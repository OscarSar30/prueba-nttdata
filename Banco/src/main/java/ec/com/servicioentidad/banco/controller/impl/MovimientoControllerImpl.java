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
import ec.com.servicioentidad.banco.controller.contract.IMovimientoController;
import ec.com.servicioentidad.banco.dto.MovimientosDTO;
import ec.com.servicioentidad.banco.dto.RespuestaDTO;
import ec.com.servicioentidad.banco.enums.TipoMovimientoEnum;
import ec.com.servicioentidad.banco.exceptions.ApplicationException;
import ec.com.servicioentidad.banco.service.contract.IMovimientoService;
import ec.com.servicioentidad.banco.validadores.BancoValidator;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")
@RestController
@CrossOrigin(origins = "*")
public class MovimientoControllerImpl implements IMovimientoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovimientoControllerImpl.class);
    
    @Autowired
    IMovimientoService movimientoSvc;

	@Override
	public ResponseEntity<?> actualizarMovimiento(@Valid MovimientosDTO body) {
		
		ResponseEntity<?> response = null;
		try {	
			LOGGER.info("Inicia proceso de actualizar movimiento controller");
			MovimientosDTO dto = movimientoSvc.actualizarMovimiento(body);
			response = BancoValidator.validarResultadoaByUpdate(dto);
			LOGGER.info("Finaliza proceso de actualizar movimiento controller");
		} catch (ApplicationException e) {
			LOGGER.error("Excepcion de negocio al actualizar movimiento nuevo: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("Error proceso de actualizar movimiento controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Finaliza actualizar movimiento controller");
		return response;
	}

	@Override
	public ResponseEntity<?> crearMovimiento(@Valid MovimientosDTO body) {
		ResponseEntity<?> response = null;
		try {
			LOGGER.info("Inicia creación de movimiento controller");
			MovimientosDTO dto = movimientoSvc.crearMovimiento(body);
			response = BancoValidator.validateResultByCreate(dto);
		} catch (ApplicationException e) {
			LOGGER.error("Excepcion de negocio al crear movimiento nuevo: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("Excepcion al crear movimiento nuevo: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Finaliza creación de movimiento controller");
		return response;
	}

	@Override
	public ResponseEntity<?> eliminarMovimiento(Integer id) {
		try {	
			LOGGER.info("Inicia proceso de eliminar movimiento controller");
			movimientoSvc.eliminarMovimiento(id);
			LOGGER.info("Finaliza proceso de eliminar movimiento controller");
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("200").descripcion(MensajesExcepciones.ELIMINACION_EXISTOSA),
					HttpStatus.OK);
		} catch (ApplicationException e) {
			LOGGER.error("Excepcion de negocio al eliminar movimiento nuevo: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("Error proceso de eliminar movimiento controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> consultarMovimientosPorNumeroCuenta(String numeroCuenta) {
		ResponseEntity<?> response = null;
		try {
			LOGGER.info("Inicia consultar cuentas por identificacion controller");
			List<MovimientosDTO> listDto = movimientoSvc.consultarMovimientosPorNumeroCuenta(numeroCuenta);
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
	public ResponseEntity<?> consultarMovimientosPorCuentaTipoMovimiento(String numeroCuenta, TipoMovimientoEnum tipoMovimiento) {
		ResponseEntity<?> response;
		try {
			LOGGER.info("Inicia consultar movimientos por tipo controller");
			List<MovimientosDTO> listDto = movimientoSvc.consultarMovimientosPorCuentaTipoMovimiento(numeroCuenta, tipoMovimiento);
			response = BancoValidator.validarResultado(listDto);
		} catch (Exception e) {
			LOGGER.error("Error proceso de consultar movimientos por tipo controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Finaliza consultar movimientos por tipo controller");
		return response;
	}

}
