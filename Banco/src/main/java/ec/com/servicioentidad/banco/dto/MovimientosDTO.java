package ec.com.servicioentidad.banco.dto;

import java.util.Date;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import ec.com.servicioentidad.banco.enums.TipoMovimientoEnum;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Modelo Canónico de Movimiento
 */
@Schema(description = "Modelo Canónico de Movimiento")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")

public class MovimientosDTO {
	
	@JsonProperty("idMovimiento")
	private Integer idMovimiento = null;
	
	@JsonProperty("fecha")
	private Date fecha = null;

	@JsonProperty("tipoMovimiento")
	private TipoMovimientoEnum tipoMovimiento = null;

	@JsonProperty("valor")
	@DecimalMin(value = "0.00")
	private Double valor = null;

	@JsonProperty("saldo")
	@DecimalMin(value = "0.00")
	private Double saldo = null;
	
	private Double saldoInicial;
	
	private CuentaDTO cuenta;

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public CuentaDTO getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaDTO cuenta) {
		this.cuenta = cuenta;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public MovimientosDTO fecha(Date fecha) {
		this.fecha = fecha;
		return this;
	}

	/**
	 * Get fecha
	 * 
	 * @return fecha
	 **/
	@Schema(description = "")

	@Valid
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public MovimientosDTO tipoMovimiento(TipoMovimientoEnum tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
		return this;
	}

	/**
	 * Get tipoMovimiento
	 * 
	 * @return tipoMovimiento
	 **/
	@Schema(description = "")

	public TipoMovimientoEnum getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimientoEnum tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public MovimientosDTO valor(Double valor) {
		this.valor = valor;
		return this;
	}

	/**
	 * Get valor
	 * 
	 * @return valor
	 **/
	@Schema(description = "")

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public MovimientosDTO saldo(Double saldo) {
		this.saldo = saldo;
		return this;
	}

	/**
	 * Get saldo
	 * 
	 * @return saldo
	 **/
	@Schema(description = "")

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MovimientosDTO movimientosDTO = (MovimientosDTO) o;
		return Objects.equals(this.fecha, movimientosDTO.fecha)
				&& Objects.equals(this.tipoMovimiento, movimientosDTO.tipoMovimiento)
				&& Objects.equals(this.valor, movimientosDTO.valor) && Objects.equals(this.saldo, movimientosDTO.saldo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, tipoMovimiento, valor, saldo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MovimientosDTO {\n");

		sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
		sb.append("    tipoMovimiento: ").append(toIndentedString(tipoMovimiento)).append("\n");
		sb.append("    valor: ").append(toIndentedString(valor)).append("\n");
		sb.append("    saldo: ").append(toIndentedString(saldo)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
