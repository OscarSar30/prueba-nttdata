/**
 * 
 */
package ec.com.servicioentidad.banco.repository.entity;

import java.io.Serializable;
import java.util.Date;

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

import ec.com.servicioentidad.banco.enums.TipoMovimientoEnum;
import lombok.Data;

/**
 * @author osarcos
 *
 */
@Data
@Entity
@Table(name = "movimientos")
public class MovimientoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id_movimiento", unique = true)
	private Integer idMovimiento;
	
	@Column(name = "fecha")
	private Date fecha;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_movimiento")
	private TipoMovimientoEnum tipoMovimiento;

	@DecimalMin(value = "0.00")
	@Column(name = "valor")
	private double valor;

	@DecimalMin(value = "0.00")
	@Column(name = "saldo")
	private double saldo;
	
	@DecimalMin(value = "0.00")
	@Column(name = "saldo_inicial")
	private double saldoInicial;
	
	@ManyToOne
	private CuentaEntity cuenta;

}
