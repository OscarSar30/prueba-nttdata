/**
 * 
 */
package ec.com.servicioentidad.banco.controller.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import ec.com.servicioentidad.banco.constants.MensajesExcepciones;
import ec.com.servicioentidad.banco.controller.contract.IReporteController;
import ec.com.servicioentidad.banco.dto.EstadoCuentaDTO;
import ec.com.servicioentidad.banco.dto.RespuestaDTO;
import ec.com.servicioentidad.banco.service.contract.IReporteService;
import ec.com.servicioentidad.banco.validadores.BancoValidator;

/**
 * @author osarcos
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class ReporteControllerImpl implements IReporteController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(MovimientoControllerImpl.class);
    
    @Autowired
    IReporteService reporteSvc;

	@Override
	public ResponseEntity<?> consultarEstadoCuenta(String identificacion, Date fechaDesde, Date fechaHasta) {
		ResponseEntity<?> response;
		try {
			LOGGER.info("Inicia consultar estado de cuenta controller");
			List<EstadoCuentaDTO> listDto = reporteSvc.consultarEstadoCuenta(identificacion, fechaDesde, fechaHasta);
			response = BancoValidator.validarResultado(listDto);
		} catch (Exception e) {
			LOGGER.error("Error proceso de consultar estado de cuenta controller: {}",e.getMessage());
			return new ResponseEntity<>(new RespuestaDTO().codigoRespuesta("500").descripcion(MensajesExcepciones.ERROR_INTERNO),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("Finaliza consultar estado de cuenta controller");
		return response;
	}

}
