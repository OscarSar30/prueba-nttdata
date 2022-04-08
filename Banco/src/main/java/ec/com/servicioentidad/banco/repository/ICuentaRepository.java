/**
 * 
 */
package ec.com.servicioentidad.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.com.servicioentidad.banco.repository.entity.CuentaEntity;

/**
 * @author osarcos
 *
 */
@Repository
public interface ICuentaRepository extends JpaRepository<CuentaEntity, Integer>{
	
	@Query (value = "select count(c.numero_cuenta) > 0 from cuentas c where c.numero_cuenta = :numCuenta", nativeQuery = true)
	boolean findByNCuenta(String numCuenta);
	
	@Query (value = "select c.numero_cuenta from cuentas c where c.id_cuenta = :id", nativeQuery = true)
	String findNCuentaByIdCuenta(Integer id);
	
	CuentaEntity findByNumeroCuentaAndEstado(String numeroCuenta, boolean estado);

	List<CuentaEntity> findByEstado(boolean activo);

	@Query (value = "select * from cuentas c inner join persona p on c.cliente_id = p.id where p.identificacion = :identificacion and c.estado = :activo", nativeQuery = true)
	List<CuentaEntity> findByIdentificacion(String identificacion, boolean activo);

}
