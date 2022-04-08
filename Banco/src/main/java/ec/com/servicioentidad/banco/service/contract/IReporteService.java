/**
 * 
 */
package ec.com.servicioentidad.banco.service.contract;

import java.util.Date;
import java.util.List;

import ec.com.servicioentidad.banco.dto.EstadoCuentaDTO;

/**
 * @author osarcos
 *
 */
public interface IReporteService {

	List<EstadoCuentaDTO> consultarEstadoCuenta(String identificacion, Date fechaDesde, Date fechaHasta);

}
