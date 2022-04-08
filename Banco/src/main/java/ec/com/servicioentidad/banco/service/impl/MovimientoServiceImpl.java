/**
 * 
 */
package ec.com.servicioentidad.banco.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.servicioentidad.banco.constants.MensajesExcepciones;
import ec.com.servicioentidad.banco.dto.MovimientosDTO;
import ec.com.servicioentidad.banco.enums.TipoMovimientoEnum;
import ec.com.servicioentidad.banco.exceptions.ApplicationException;
import ec.com.servicioentidad.banco.repository.ICuentaRepository;
import ec.com.servicioentidad.banco.repository.IMovimientoRepository;
import ec.com.servicioentidad.banco.repository.IPersonaRepository;
import ec.com.servicioentidad.banco.repository.entity.CuentaEntity;
import ec.com.servicioentidad.banco.repository.entity.MovimientoEntity;
import ec.com.servicioentidad.banco.service.contract.IMovimientoService;
import ec.com.servicioentidad.banco.utils.BancoConvert;

/**
 * @author osarcos
 *
 */
@Service
public class MovimientoServiceImpl implements IMovimientoService {

	@Autowired
	ICuentaRepository cuentaRepository;

	@Autowired
	IPersonaRepository personaRepository;

	@Autowired
	IMovimientoRepository movimientoRepository;
	
	boolean activo = true;

	@Override
	public MovimientosDTO crearMovimiento(@Valid MovimientosDTO body) throws ApplicationException {
		String totalValor = null;
		// Consulto los datos de la cuenta del cliente
		CuentaEntity infoCuenta = cuentaRepository.findByNumeroCuentaAndEstado(body.getCuenta().getNumeroCuenta(), activo);
		if (infoCuenta == null) {
			throw new ApplicationException(String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, body.getCuenta().getNumeroCuenta()));
		}
		MovimientoEntity infoMovimiento = movimientoRepository.findByCuentaIdCuentaAndFecha(infoCuenta.getIdCuenta(),
				body.getFecha());
		// Suma el total de valores retirados por el cliente
		totalValor = movimientoRepository.findValorlByFechaAndTipoAndNCta(body.getFecha(),
				TipoMovimientoEnum.RETIRO, infoCuenta.getNumeroCuenta());
		if (totalValor == null) {
			totalValor = "0";
		}
		// Si no hay movimientos, registra el primero
		// Lógica para determinar si el movimiento es RETIRO - DEPOSITO
		if (body.getTipoMovimiento().equals(TipoMovimientoEnum.RETIRO)) {
			if (infoMovimiento == null) {
				// Si el saldo es cero, y va a realizar una transacción débito, debe desplegar
				// mensaje “Saldo no disponible”
				if (infoCuenta.getSaldoInicial() == 0.00)
					throw new ApplicationException(MensajesExcepciones.SALDO_CERO);

				
				// Si el cupo disponible ya se cumplió no debe permitir realizar un debito y
				// debe desplegar un mensaje “Cupo diario Excedido”
				if (Math.abs(Double.parseDouble(totalValor)) >= MensajesExcepciones.VALOR_TOPE) {
					throw new ApplicationException(MensajesExcepciones.CUPO_MAXIMO);
				}
				body.setIdMovimiento(0);
				body.getCuenta().setIdCuenta(infoCuenta.getIdCuenta()); //En caso de venir vacio el idCuenta
				body.setSaldo(infoCuenta.getSaldoInicial() - body.getValor());
				body.setValor(-(body.getValor()));
				body.setSaldoInicial(infoCuenta.getSaldoInicial());

				MovimientoEntity entity = movimientoRepository.save(BancoConvert.dtoToEntity(body));
				return BancoConvert.entityToDto(entity);
				// Si el saldo es cero, y va a realizar una transacción débito, debe desplegar
				// mensaje “Saldo no disponible”
			} else if (infoMovimiento.getSaldo() == 0.00)
				throw new ApplicationException(MensajesExcepciones.SALDO_CERO);

			// Si el cupo disponible ya se cumplió no debe permitir realizar un debito y
			// debe desplegar un mensaje “Cupo diario Excedido”
			if (Math.abs(Double.parseDouble(totalValor)) >= MensajesExcepciones.VALOR_TOPE) {
				throw new ApplicationException(MensajesExcepciones.CUPO_MAXIMO);
			}
			body.setIdMovimiento(0);
			body.getCuenta().setIdCuenta(infoCuenta.getIdCuenta()); //En caso de venir vacio el idCuenta
			body.setSaldo(infoMovimiento.getSaldo() - body.getValor());
			body.setValor(-(body.getValor()));
			body.setSaldoInicial(infoMovimiento.getSaldo());

			MovimientoEntity entity = movimientoRepository.save(BancoConvert.dtoToEntity(body));
			return BancoConvert.entityToDto(entity);
		} else if (body.getTipoMovimiento().equals(TipoMovimientoEnum.DEPOSITO)) {
			if (infoMovimiento == null) {
				body.setIdMovimiento(0);
				body.getCuenta().setIdCuenta(infoCuenta.getIdCuenta()); //En caso de venir vacio el idCuenta
				body.setSaldo(infoCuenta.getSaldoInicial() + body.getValor());
				body.setValor(body.getValor());
				body.setSaldoInicial(infoCuenta.getSaldoInicial());

				MovimientoEntity entity = movimientoRepository.save(BancoConvert.dtoToEntity(body));
				return BancoConvert.entityToDto(entity);
			} else {
				body.setIdMovimiento(0);
				body.getCuenta().setIdCuenta(infoCuenta.getIdCuenta()); //En caso de venir vacio el idCuenta
				body.setSaldo(infoMovimiento.getSaldo() + body.getValor());
				body.setValor(body.getValor());
				body.setSaldoInicial(infoMovimiento.getSaldo());

				MovimientoEntity entity = movimientoRepository.save(BancoConvert.dtoToEntity(body));
				return BancoConvert.entityToDto(entity);
			}
		}
		throw new ApplicationException(MensajesExcepciones.ERROR_INTERNO);
	}

	@Override
	public MovimientosDTO actualizarMovimiento(@Valid MovimientosDTO body) throws ApplicationException {
		if (movimientoRepository.existsById(body.getIdMovimiento())) {
			MovimientoEntity entity = movimientoRepository.save(BancoConvert.dtoToEntity(body));
			return BancoConvert.entityToDto(entity);
		}
		throw new ApplicationException(String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, body.getIdMovimiento()));
	}

	@Override
	public void eliminarMovimiento(Integer id) throws ApplicationException {
		if (movimientoRepository.existsById(id))
			movimientoRepository.deleteById(id);
		else
			throw new ApplicationException(String.format(MensajesExcepciones.BUSQUEDA_SIN_EXITO, id));
	}

	@Override
	public List<MovimientosDTO> consultarMovimientosPorCuentaTipoMovimiento(String numeroCuenta, TipoMovimientoEnum tipoMovimiento) {
		return BancoConvert.listEntityToDTOMvm(movimientoRepository.findByCuentaAndTipoMovimiento(numeroCuenta, tipoMovimiento, activo));
	}

	@Override
	public List<MovimientosDTO> consultarMovimientosPorNumeroCuenta(String numeroCuenta) {
		return BancoConvert.listEntityToDTOMvm(movimientoRepository.findByNumeroCuenta(numeroCuenta, activo));
	}

}
