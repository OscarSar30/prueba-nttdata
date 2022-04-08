/**
 * 
 */
package ec.com.servicioentidad.banco.repository.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DiscriminatorOptions;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

/**
 * @author osarcos
 *
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dytype")
@DiscriminatorOptions(force = true)
@DiscriminatorValue("Cliente")
@Table(name = "clientes")
public class ClienteEntity extends PersonaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cliente_id", unique = true)
	private UUID clienteId;

	@NotNull
	@Column(name = "contrasenia")
	private String contrasenia;

	@Column(name = "estado")
	private boolean estado;

}
