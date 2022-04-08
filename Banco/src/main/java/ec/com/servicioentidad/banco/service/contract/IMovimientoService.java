/**
 * 
 */
package ec.com.servicioentidad.banco.service.contract;

import java.util.List;

import javax.validation.Valid;

import ec.com.servicioentidad.banco.dto.MovimientosDTO;
import ec.com.servicioentidad.banco.enums.TipoMovimientoEnum;
import ec.com.servicioentidad.banco.exceptions.ApplicationException;

/**
 * @author osarcos
 *
 */
public interface IMovimientoService {

	MovimientosDTO crearMovimiento(@Valid MovimientosDTO body) throws ApplicationException;

	MovimientosDTO actualizarMovimiento(@Valid MovimientosDTO body) throws ApplicationException;

	void eliminarMovimiento(Integer id) throws ApplicationException;

	List<MovimientosDTO> consultarMovimientosPorCuentaTipoMovimiento(String numeroCuenta, TipoMovimientoEnum tipoMovimiento);

	List<MovimientosDTO> consultarMovimientosPorNumeroCuenta(String numeroCuenta);

}
