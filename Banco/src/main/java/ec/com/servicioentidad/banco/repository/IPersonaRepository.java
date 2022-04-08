/**
 * 
 */
package ec.com.servicioentidad.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.servicioentidad.banco.repository.entity.PersonaEntity;

/**
 * @author osarcos
 *
 */
@Repository
public interface IPersonaRepository extends JpaRepository<PersonaEntity, Integer>{

}
