/**
 * 
 */
package ec.com.servicioentidad.banco.service.impl;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.servicioentidad.banco.constants.MensajesExcepciones;
import ec.com.servicioentidad.banco.dto.ClienteDTO;
import ec.com.servicioentidad.banco.exceptions.ApplicationException;
import ec.com.servicioentidad.banco.repository.IClienteRepository;
import ec.com.servicioentidad.banco.repository.IPersonaRepository;
import ec.com.servicioentidad.banco.repository.entity.ClienteEntity;
import ec.com.servicioentidad.banco.service.contract.IClienteService;
import ec.com.servicioentidad.banco.utils.BancoConvert;

/**
 * @author osarcos
 *
 */
@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	IClienteRepository clienteRepository;
	
	@Autowired
	IPersonaRepository personaRepository;
	
	boolean activo = true;

	@Override
	public ClienteDTO crearCliente(@Valid ClienteDTO body) throws ApplicationException {
		body.setClienteId(UUID.randomUUID());
		body.setId(0);
		if (clienteRepository.findByIdentificacionUnica(body.getIdentificacion())) {
			throw new ApplicationException(String.format(MensajesExcepciones.CEDULA_EXISTENTE, body.getIdentificacion()));
		}
		ClienteEntity entity = clienteRepository.save(BancoConvert.dtoToEntity(body));
		return BancoConvert.entityToDto(entity);
	}

	@Override
	public ClienteDTO actualizarCliente(@Valid ClienteDTO body) throws ApplicationException {
		if (personaRepository.existsById(body.getId())) {
			String identificacion  = clienteRepository.findIdentificacionById(body.getId());
			 if (!(identificacion.equals(body.getIdentificacion())) && 
					 clienteRepository.findByIdentificacionUnica(body.getIdentificacion())) {
				 throw new ApplicationException(String.format(MensajesExcepciones.CEDULA_EXISTENTE, body.getIdentificacion()));
			}
			ClienteEntity entity = clienteRepository.save(BancoConvert.dtoToEntity(body));
			return BancoConvert.entityToDto(entity);
		}
		throw new ApplicationException(String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, body.getId().toString()));
	}

	@Override
	public void eliminarCliente(Integer id) throws ApplicationException {
		if (personaRepository.existsById(id)) 
			personaRepository.deleteById(id);
		else
			throw new ApplicationException(String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, id));
	}

	@Override
	public ClienteDTO consultarClientePorIdentificacion(String identificacion) {
		ClienteEntity entity = clienteRepository.findByIdentificacionAndEstado(identificacion, activo);
		return entity == null ? null : BancoConvert.entityToDto(entity);
	}

	@Override
	public List<ClienteDTO> consultarClientes() {
		return BancoConvert.listEntityToDTOClts(clienteRepository.findByEstado(activo));
	}

}
