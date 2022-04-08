package ec.com.servicioentidad.banco.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;

import ec.com.servicioentidad.banco.dto.ClienteDTO;
import ec.com.servicioentidad.banco.dto.CuentaDTO;
import ec.com.servicioentidad.banco.dto.EstadoCuentaDTO;
import ec.com.servicioentidad.banco.dto.MovimientosDTO;
import ec.com.servicioentidad.banco.repository.entity.ClienteEntity;
import ec.com.servicioentidad.banco.repository.entity.CuentaEntity;
import ec.com.servicioentidad.banco.repository.entity.MovimientoEntity;

/**
 * 
 * @author osarcos
 *
 */

public final class BancoConvert {
	
	private BancoConvert() {
		
	}
	
	public static ClienteDTO entityToDto(ClienteEntity entity) {
		return new ModelMapper().map(entity, ClienteDTO.class);
	}
	
	public static ClienteEntity dtoToEntity(@Valid ClienteDTO dto) {
		return new ModelMapper().map(dto, ClienteEntity.class);
	}
	
	public static CuentaDTO entityToDto(CuentaEntity entity) {
		return new ModelMapper().map(entity, CuentaDTO.class);
	}
	
	public static CuentaEntity dtoToEntity(@Valid CuentaDTO dto) {
		return new ModelMapper().map(dto, CuentaEntity.class);
	}
	
	public static MovimientosDTO entityToDto(MovimientoEntity entity) {
		return new ModelMapper().map(entity, MovimientosDTO.class);
	}
	
	public static MovimientoEntity dtoToEntity(@Valid MovimientosDTO dto) {
		return new ModelMapper().map(dto, MovimientoEntity.class);
	}

	public static List<ClienteDTO> listEntityToDTOClts(List<ClienteEntity> clientes) {
		return clientes.stream().map(entity -> (entityToDto(entity))).collect(Collectors.toList());
	}
	
	public static List<CuentaDTO> listEntityToDTOCta(List<CuentaEntity> cuentas) {
		return cuentas.stream().map(entity -> (entityToDto(entity))).collect(Collectors.toList());
	}
	
	public static List<MovimientosDTO> listEntityToDTOMvm(List<MovimientoEntity> movimientos) {
		return movimientos.stream().map(entity -> (entityToDto(entity))).collect(Collectors.toList());
	}
	
	//Mapper manual para setear los valores de MovimientoEntity con EstadoCuentaDTO
	public static List<EstadoCuentaDTO> mappEstadoCuenta (List<MovimientoEntity> movimientos) {
		List<EstadoCuentaDTO> datosEstado = new ArrayList<>();
		for (int i = 0; i < movimientos.size(); i++) {
			EstadoCuentaDTO dto = new EstadoCuentaDTO();
			dto.setFecha(movimientos.get(i).getFecha());
			dto.setCliente(movimientos.get(i).getCuenta().getCliente().getNombres());
			dto.setNumeroCuenta(movimientos.get(i).getCuenta().getNumeroCuenta());
			dto.setTipo(movimientos.get(i).getTipoMovimiento().toString());
			dto.setSaldoInicial(movimientos.get(i).getSaldoInicial());
			dto.setEstado(true);
			dto.setMovimiento(movimientos.get(i).getValor());
			dto.setSaldoDisponible(movimientos.get(i).getSaldo());
			
			datosEstado.add(dto);
			
		}
		return datosEstado;
	}

}
