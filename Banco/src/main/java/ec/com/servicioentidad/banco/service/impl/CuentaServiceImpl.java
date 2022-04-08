/**
 * 
 */
package ec.com.servicioentidad.banco.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.servicioentidad.banco.constants.MensajesExcepciones;
import ec.com.servicioentidad.banco.dto.CuentaDTO;
import ec.com.servicioentidad.banco.exceptions.ApplicationException;
import ec.com.servicioentidad.banco.repository.ICuentaRepository;
import ec.com.servicioentidad.banco.repository.IPersonaRepository;
import ec.com.servicioentidad.banco.repository.entity.CuentaEntity;
import ec.com.servicioentidad.banco.service.contract.ICuentaService;
import ec.com.servicioentidad.banco.utils.BancoConvert;

/**
 * @author osarcos
 *
 */
@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	ICuentaRepository cuentaRepository;

	@Autowired
	IPersonaRepository personaRepository;

	boolean activo = true;

	@Override
	public CuentaDTO crearCuenta(@Valid CuentaDTO body) throws ApplicationException {
		body.setIdCuenta(0);
		if (!personaRepository.existsById(body.getCliente().getId())) {
			throw new ApplicationException(
					String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, body.getCliente().getId().toString()));
		}
		CuentaEntity entity = cuentaRepository.save(BancoConvert.dtoToEntity(body));
		return BancoConvert.entityToDto(entity);
	}

	@Override
	public CuentaDTO actualizarCuenta(@Valid CuentaDTO body) throws ApplicationException {
		if (cuentaRepository.existsById(body.getIdCuenta())) {
			String numeroCuenta = cuentaRepository.findNCuentaByIdCuenta(body.getIdCuenta());
			if (!(numeroCuenta.equals(body.getNumeroCuenta()))
					&& cuentaRepository.findByNCuenta(body.getNumeroCuenta())) {
				throw new ApplicationException(
						String.format(MensajesExcepciones.CUENTA_EXISTENTE, body.getNumeroCuenta()));
			}
			CuentaEntity entity = cuentaRepository.save(BancoConvert.dtoToEntity(body));
			return BancoConvert.entityToDto(entity);
		}
		throw new ApplicationException(String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, body.getIdCuenta()));
	}

	@Override
	public void eliminarCuenta(Integer id) throws ApplicationException {
		if (cuentaRepository.existsById(id))
			cuentaRepository.deleteById(id);
		else
			throw new ApplicationException(String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, id));
	}

	@Override
	public List<CuentaDTO> consultarCuentas() {
		return BancoConvert.listEntityToDTOCta(cuentaRepository.findByEstado(activo));
	}

	@Override
	public CuentaDTO consultarCuentaPorNumeroCuenta(String numeroCuenta) {
		CuentaEntity entity = cuentaRepository.findByNumeroCuentaAndEstado(numeroCuenta, activo);
		return entity == null ? null : BancoConvert.entityToDto(entity);
	}

	@Override
	public List<CuentaDTO> consultarCuentasPorIdentificacion(String identificacion) {
		return BancoConvert.listEntityToDTOCta(cuentaRepository.findByIdentificacion(identificacion, activo));
	}

}
