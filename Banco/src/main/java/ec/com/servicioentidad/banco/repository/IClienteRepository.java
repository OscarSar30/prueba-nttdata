/**
 * 
 */
package ec.com.servicioentidad.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.com.servicioentidad.banco.repository.entity.ClienteEntity;

/**
 * @author osarcos
 *
 */
@Repository
public interface IClienteRepository extends JpaRepository<ClienteEntity, Integer>{
	
	@Query (value = "select count(p.identificacion) > 0 from persona p where p.identificacion = :identificacion", nativeQuery = true)
	boolean findByIdentificacionUnica(String identificacion);
	
	@Query (value = "select p.identificacion from persona p where p.id = :id", nativeQuery = true)
	String findIdentificacionById(Integer id);

	List<ClienteEntity> findByEstado(boolean activo);
	
	ClienteEntity findByIdentificacionAndEstado(String identificacion, boolean estado);

}
