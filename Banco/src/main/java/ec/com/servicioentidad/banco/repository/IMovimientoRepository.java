/**
 * 
 */
package ec.com.servicioentidad.banco.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.com.servicioentidad.banco.enums.TipoMovimientoEnum;
import ec.com.servicioentidad.banco.repository.entity.MovimientoEntity;

/**
 * @author osarcos
 *
 */
@Repository
public interface IMovimientoRepository extends JpaRepository<MovimientoEntity, Integer> {

	@Query(value = "select * from movimientos m where m.cuenta_id_cuenta = :id and m.fecha \\:\\:DATE = :fecha order by m.id_movimiento desc limit 1", nativeQuery = true)
	MovimientoEntity findByCuentaIdCuentaAndFecha(Integer id, Date fecha);
	
	@Query (value = "select sum(m.valor) from movimientos m inner join cuentas c on m.cuenta_id_cuenta = c.id_cuenta where m.fecha \\:\\:DATE = :fecha "
			+ "and m.tipo_movimiento = :#{#tipo.name()} and c.numero_cuenta = :numeroCuenta", nativeQuery = true)
	String findValorlByFechaAndTipoAndNCta (Date fecha, TipoMovimientoEnum tipo, String numeroCuenta);

	@Query (value = "select * from movimientos m inner join cuentas c on m.cuenta_id_cuenta = c.id_cuenta where c.numero_cuenta = :numeroCuenta and m.tipo_movimiento = :#{#tipo.name()} and c.estado = :activo", nativeQuery = true)
	List<MovimientoEntity> findByCuentaAndTipoMovimiento(String numeroCuenta, TipoMovimientoEnum tipo, boolean activo);

	@Query (value = "select * from movimientos m inner join cuentas c on m.cuenta_id_cuenta = c.id_cuenta where c.numero_cuenta = :numeroCuenta and c.estado = :activo", nativeQuery = true)
	List<MovimientoEntity> findByNumeroCuenta(String numeroCuenta, boolean activo);

	@Query (value = "select * from movimientos m inner join cuentas c on m.cuenta_id_cuenta = c.id_cuenta inner join clientes c2 on c2.id = c.cliente_id inner join persona p on p.id = c2.id \r\n"
			+ "where p.identificacion = :identificacion and c.estado = :activo and c2.estado = :activo and m.fecha \\:\\: DATE between :fechaDesde and :fechaHasta \\:\\:DATE order by m.fecha desc", nativeQuery = true)
	List<MovimientoEntity> findEstadoCuentaByFechas(String identificacion, Date fechaDesde, Date fechaHasta,
			boolean activo);

}
