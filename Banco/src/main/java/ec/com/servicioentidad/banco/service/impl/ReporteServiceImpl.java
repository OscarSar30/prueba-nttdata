/**
 * 
 */
package ec.com.servicioentidad.banco.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.servicioentidad.banco.dto.EstadoCuentaDTO;
import ec.com.servicioentidad.banco.repository.IMovimientoRepository;
import ec.com.servicioentidad.banco.repository.entity.MovimientoEntity;
import ec.com.servicioentidad.banco.service.contract.IReporteService;
import ec.com.servicioentidad.banco.utils.BancoConvert;

/**
 * @author osarcos
 *
 */
@Service
public class ReporteServiceImpl implements IReporteService {
	
	@Autowired
	IMovimientoRepository movimientoRepository;
	
	boolean activo = true;

	@Override
	public List<EstadoCuentaDTO> consultarEstadoCuenta(String identificacion, Date fechaDesde, Date fechaHasta) {
		List<MovimientoEntity> listEntity = movimientoRepository.findEstadoCuentaByFechas(identificacion, fechaDesde, fechaHasta, activo);
		return BancoConvert.mappEstadoCuenta(listEntity);
	}

}
