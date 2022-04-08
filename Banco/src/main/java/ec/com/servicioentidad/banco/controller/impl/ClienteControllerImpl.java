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
import ec.com.servicioentidad.banco.controller.contract.IClienteController;
import ec.com.servicioentidad.banco.dto.ClienteDTO;
import ec.com.servicioentidad.banco.dto.RespuestaDTO;
import ec.com.servicioentidad.banco.exceptions.ApplicationException;
import ec.com.servicioentidad.banco.service.contract.IClienteService;
import ec.com.servicioentidad.banco.validadores.BancoValidator;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")
@RestController
@CrossOrigin(origins = "*")
public class ClienteControllerImpl implements IClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteControllerImpl.class);
    
    @Autowired
    IClienteService clienteSvc;

	@Override
	public ResponseEntity<?> actualizarCliente(@Valid ClienteDTO body) {
		ResponseEntity<?> response = null;
		try {	
			LOGGER.info("Inicia proceso de actualizar cliente controller");
			ClienteDTO dto = clienteSvc.actualizarCliente(body);
			response = BancoValidator.validarResultadoaByUpdate(dto);
			LOGGER.info("Finaliza proceso de actualizar cliente controller");
		} catch (ApplicationException e) {
			LOGGER.error("Excepcion de negocio al actualizar cliente nuevo: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("404").descripcion(e.getMessage()),
					HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			LOGGER.error("Error proceso de actualizar cliente controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Finaliza actualizar cliente controller");
		return response;
	}

	@Override
	public ResponseEntity<?> consultarClientePorIdentificacion(String identificacion) {
		ResponseEntity<?> response = null;
		try {
			LOGGER.info("Inicia consultar cliente por identificacion controller");
			ClienteDTO dto = clienteSvc.consultarClientePorIdentificacion(identificacion);
			response = BancoValidator.validarResultado(dto);
		}catch (Exception e) {
			LOGGER.error("Error en exception al consultar cliente por identificacion controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOGGER.info("Finaliza consulta cliente por identificacion controller");
		return response;
	}

	@Override
	public ResponseEntity<?> crearCliente(@Valid ClienteDTO body) {
		ResponseEntity<?> response = null;
		try {
			LOGGER.info("Inicia creación de cliente controller");
			ClienteDTO dto = clienteSvc.crearCliente(body);
			response = BancoValidator.validateResultByCreate(dto);
		} catch (ApplicationException e) {
			LOGGER.error("Excepcion de negocio al crear cliente controller: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("Excepcion al crear cliente nuevo: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Finaliza creación de cliente controller");
		return response;
	}

	@Override
	public ResponseEntity<?> eliminarCliente(Integer id) {
		try {	
			LOGGER.info("Inicia proceso de eliminar cliente controller");
			clienteSvc.eliminarCliente(id);
			LOGGER.info("Finaliza proceso de eliminar cliente controller");
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("200").descripcion(MensajesExcepciones.ELIMINACION_EXISTOSA),
					HttpStatus.OK);
		} catch (ApplicationException e) {
			LOGGER.error("Excepcion de negocio al eliminar cliente controller: {}", e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.error("Error proceso de eliminar cliente controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> consultarClientes() {
		ResponseEntity<?> response = null;
		try {
			LOGGER.info("Inicia consulta de clientes controller");
			List<ClienteDTO> listDto = clienteSvc.consultarClientes();
			response = BancoValidator.validarResultado(listDto);
		}catch (Exception e) {
			LOGGER.error("Error en exception al consulta de clientes controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOGGER.info("Finaliza consulta de clientes controller");
		return response;
	}

}
