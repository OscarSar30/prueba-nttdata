package ec.com.servicioentidad.banco.dto;

import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Modelo Canónico de Cliente
 */
@Schema(description = "Modelo Canónico de Cliente")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")

public class ClienteDTO extends PersonaDTO {
	@JsonProperty("clienteId")
	private UUID clienteId = null;

	@JsonProperty("contrasenia")
	@NotNull
	private String contrasenia = null;

	@JsonProperty("estado")
	private Boolean estado = null;

	public ClienteDTO clienteId(UUID clienteId) {
		this.clienteId = clienteId;
		return this;
	}

	/**
	 * Get clienteId
	 * 
	 * @return clienteId
	 **/
	@Schema(description = "")

	public UUID getClienteId() {
		return clienteId;
	}

	public void setClienteId(UUID clienteId) {
		this.clienteId = clienteId;
	}

	public ClienteDTO contrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
		return this;
	}

	/**
	 * Get contrasenia
	 * 
	 * @return contrasenia
	 **/
	@Schema(description = "")

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public ClienteDTO estado(Boolean estado) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ClienteDTO clienteDTO = (ClienteDTO) o;
		return Objects.equals(this.clienteId, clienteDTO.clienteId)
				&& Objects.equals(this.contrasenia, clienteDTO.contrasenia)
				&& Objects.equals(this.estado, clienteDTO.estado);
	}

	@Override
	public int hashCode() {
		return Objects.hash(clienteId, contrasenia, estado);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ClienteDTO {\n");

		sb.append("    clienteId: ").append(toIndentedString(clienteId)).append("\n");
		sb.append("    contrasenia: ").append(toIndentedString(contrasenia)).append("\n");
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
