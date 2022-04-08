package ec.com.servicioentidad.banco.dto;

import java.util.Objects;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import ec.com.servicioentidad.banco.enums.TipoCuentaEnum;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Modelo Canónico de Cuenta
 */
@Schema(description = "Modelo Canónico de Cuenta")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")

public class CuentaDTO {
	
	@JsonProperty("idCuenta")
	private Integer idCuenta = null;
	
	@JsonProperty("numeroCuenta")
	@Pattern(regexp = "[0-9]*")
	private String numeroCuenta = null;

	@JsonProperty("tipoCuenta")
	private TipoCuentaEnum tipoCuenta = null;

	@JsonProperty("saldoInicial")
	@DecimalMin(value = "0.00")
	private Double saldoInicial = null;

	@JsonProperty("estado")
	private Boolean estado = null;
	
	private ClienteDTO cliente;
	
	public CuentaDTO idCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
		return this;
	}

	/**
	 * Get idCuenta
	 * 
	 * @return idCuenta
	 **/
	@Schema(description = "")

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public CuentaDTO numeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
		return this;
	}

	/**
	 * Get numeroCuenta
	 * 
	 * @return numeroCuenta
	 **/
	@Schema(description = "")

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public CuentaDTO tipoCuenta(TipoCuentaEnum tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
		return this;
	}

	/**
	 * Get tipoCuenta
	 * 
	 * @return tipoCuenta
	 **/
	@Schema(description = "")

	public TipoCuentaEnum getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuentaEnum tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public CuentaDTO saldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
		return this;
	}

	/**
	 * Get saldoInicial
	 * 
	 * @return saldoInicial
	 **/
	@Schema(description = "")

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public CuentaDTO estado(Boolean estado) {
		this.estado = estado;
		return this;
	}

	/**
	 * Get estado
	 * 
	 * @return estado
	 **/
	@Schema(description = "")

	public Boolean isEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CuentaDTO cuentaDTO = (CuentaDTO) o;
		return Objects.equals(this.idCuenta, cuentaDTO.idCuenta)
				&& Objects.equals(this.numeroCuenta, cuentaDTO.numeroCuenta)
				&& Objects.equals(this.tipoCuenta, cuentaDTO.tipoCuenta)
				&& Objects.equals(this.saldoInicial, cuentaDTO.saldoInicial)
				&& Objects.equals(this.estado, cuentaDTO.estado);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCuenta, numeroCuenta, tipoCuenta, saldoInicial, estado);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CuentaDTO {\n");

		sb.append("    idCuenta: ").append(toIndentedString(idCuenta)).append("\n");
		sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
		sb.append("    tipoCuenta: ").append(toIndentedString(tipoCuenta)).append("\n");
		sb.append("    saldoInicial: ").append(toIndentedString(saldoInicial)).append("\n");
		sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
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
