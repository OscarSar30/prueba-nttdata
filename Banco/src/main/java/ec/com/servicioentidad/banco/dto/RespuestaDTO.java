package ec.com.servicioentidad.banco.dto;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Modelo Canónico de Respuesta
 */
@Schema(description = "Modelo Canónico de Respuesta")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")

public class RespuestaDTO {
	@JsonProperty("codigoRespuesta")
	private String codigoRespuesta = null;

	@JsonProperty("descripcion")
	private String descripcion = null;

	public RespuestaDTO codigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
		return this;
	}

	/**
	 * Get codigoRespuesta
	 * 
	 * @return codigoRespuesta
	 **/
	@Schema(description = "")

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public RespuestaDTO descripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	/**
	 * Get descripcion
	 * 
	 * @return descripcion
	 **/
	@Schema(description = "")

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RespuestaDTO respuestaDTO = (RespuestaDTO) o;
		return Objects.equals(this.codigoRespuesta, respuestaDTO.codigoRespuesta)
				&& Objects.equals(this.descripcion, respuestaDTO.descripcion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoRespuesta, descripcion);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RespuestaDTO {\n");

		sb.append("    codigoRespuesta: ").append(toIndentedString(codigoRespuesta)).append("\n");
		sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
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
