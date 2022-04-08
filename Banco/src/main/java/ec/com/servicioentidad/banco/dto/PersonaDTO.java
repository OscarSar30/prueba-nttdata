package ec.com.servicioentidad.banco.dto;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import ec.com.servicioentidad.banco.enums.GeneroEnum;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Modelo Canónico de Persona
 */
@Schema(description = "Modelo Canónico de Persona")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T16:08:17.424-05:00[America/Bogota]")

public class PersonaDTO {

	@JsonProperty("id")
	@NotNull
	private Integer id = null;

	@JsonProperty("nombres")
	private String nombres = null;

	@JsonProperty("genero")
	private GeneroEnum genero = null;

	@JsonProperty("edad")
	@Size(min = 2, max = 3)
	private Integer edad = null;

	@JsonProperty("identificacion")
	@NotNull
	@Size(min = 10, max = 13)
	private String identificacion = null;

	@JsonProperty("direccion")
	private String direccion = null;

	@JsonProperty("telefono")
	private String telefono = null;

	public PersonaDTO id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@Schema(description = "")

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PersonaDTO nombres(String nombres) {
		this.nombres = nombres;
		return this;
	}

	/**
	 * Get nombres
	 * 
	 * @return nombres
	 **/
	@Schema(description = "")

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public PersonaDTO genero(GeneroEnum genero) {
		this.genero = genero;
		return this;
	}

	/**
	 * Get genero
	 * 
	 * @return genero
	 **/
	@Schema(description = "")

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	public PersonaDTO edad(Integer edad) {
		this.edad = edad;
		return this;
	}

	/**
	 * Get edad
	 * 
	 * @return edad
	 **/
	@Schema(description = "")

	@Valid
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public PersonaDTO identificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	/**
	 * Get identificacion
	 * 
	 * @return identificacion
	 **/
	@Schema(description = "")

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public PersonaDTO direccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	/**
	 * Get direccion
	 * 
	 * @return direccion
	 **/
	@Schema(description = "")

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public PersonaDTO telefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	/**
	 * Get telefono
	 * 
	 * @return telefono
	 **/
	@Schema(description = "")

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PersonaDTO personaDTO = (PersonaDTO) o;
		return Objects.equals(this.id, personaDTO.id) && Objects.equals(this.nombres, personaDTO.nombres)
				&& Objects.equals(this.genero, personaDTO.genero) && Objects.equals(this.edad, personaDTO.edad)
				&& Objects.equals(this.identificacion, personaDTO.identificacion)
				&& Objects.equals(this.direccion, personaDTO.direccion)
				&& Objects.equals(this.telefono, personaDTO.telefono);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombres, genero, edad, identificacion, direccion, telefono);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonaDTO {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    nombres: ").append(toIndentedString(nombres)).append("\n");
		sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
		sb.append("    edad: ").append(toIndentedString(edad)).append("\n");
		sb.append("    identificacion: ").append(toIndentedString(identificacion)).append("\n");
		sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
		sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
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
