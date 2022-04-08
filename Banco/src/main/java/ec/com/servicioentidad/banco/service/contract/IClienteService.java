/**
 * 
 */
package ec.com.servicioentidad.banco.service.contract;

import java.util.List;

import javax.validation.Valid;

import ec.com.servicioentidad.banco.dto.ClienteDTO;
import ec.com.servicioentidad.banco.exceptions.ApplicationException;

/**
 * @author osarcos
 *
 */
public interface IClienteService {

	ClienteDTO crearCliente(@Valid ClienteDTO body) throws ApplicationException;

	ClienteDTO actualizarCliente(@Valid ClienteDTO body) throws ApplicationException;

	void eliminarCliente(Integer id) throws ApplicationException;

	ClienteDTO consultarClientePorIdentificacion(String identificacion);

	List<ClienteDTO> consultarClientes();

}
