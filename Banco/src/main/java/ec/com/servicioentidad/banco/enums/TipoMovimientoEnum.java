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
public enum TipoMovimientoEnum {

	RETIRO("Retiro"),

	DEPOSITO("Deposito");

	private String value;

	TipoMovimientoEnum(String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static TipoMovimientoEnum fromValue(String text) {
		for (TipoMovimientoEnum b : TipoMovimientoEnum.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
