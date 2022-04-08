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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import ec.com.servicioentidad.banco.enums.TipoCuentaEnum;
import lombok.Data;

/**
 * @author osarcos
 *
 */
@Data
@Entity
@Table(name = "cuentas")
public class CuentaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id_cuenta", unique = true)
	private Integer idCuenta;
	
	@NotNull
	@Pattern(regexp = "[0-9]*")
	@Column(name = "numero_cuenta")
	private String numeroCuenta = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_cuenta")
	private TipoCuentaEnum tipoCuenta = null;

	@DecimalMin(value = "0.00")
	@Column(name = "saldo_inicial")
	private double saldoInicial;

	@Column(name = "estado")
	private boolean estado;
	
	@ManyToOne
	private ClienteEntity cliente;

}
