/**
 * 
 */
package ec.com.servicioentidad.banco.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author osarcos
 *
 */
public enum TipoCuentaEnum {

	AHORRO("Ahorro"),

	CORRIENTE("Corriente");

	private String value;

	TipoCuentaEnum(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static TipoCuentaEnum fromValue(String text) {
		for (TipoCuentaEnum b : TipoCuentaEnum.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
