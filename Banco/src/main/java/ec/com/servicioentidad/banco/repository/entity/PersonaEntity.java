/**
 * 
 */
package ec.com.servicioentidad.banco.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.com.servicioentidad.banco.enums.GeneroEnum;
import lombok.Data;

/**
 * @author osarcos
 *
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persona")
public class PersonaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id", unique = true)
	private Integer id;
	
	@NotNull
	@Column(name = "nombres")
	private String nombres;

	@Enumerated(EnumType.STRING)
	@Column(name = "genero")
	private GeneroEnum genero;

	@Size(min = 2, max = 3)
	@Column(name = "edad")
	private Integer edad;

	@NotNull
	@Size(min = 10, max = 13)
	@Column(name = "identificacion", unique = true)
	private String identificacion;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private String telefono;

}
