/**
 * 
 */
package ec.com.servicioentidad.banco.service.contract;

import java.util.List;

import javax.validation.Valid;

import ec.com.servicioentidad.banco.dto.CuentaDTO;
import ec.com.servicioentidad.banco.exceptions.ApplicationException;

/**
 * @author osarcos
 *
 */
public interface ICuentaService {

	CuentaDTO crearCuenta(@Valid CuentaDTO body) throws ApplicationException;

	CuentaDTO actualizarCuenta(@Valid CuentaDTO body) throws ApplicationException;

	void eliminarCuenta(Integer id) throws ApplicationException;

	List<CuentaDTO> consultarCuentas();

	CuentaDTO consultarCuentaPorNumeroCuenta(String numeroCuenta);

	List<CuentaDTO> consultarCuentasPorIdentificacion(String identificacion);

}
