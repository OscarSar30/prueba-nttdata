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
public enum GeneroEnum {
    MASCULINO("Masculino"),
    
    FEMENINO("Femenino"),
    
    NO_ESPECIFICADO("No especificado");

    private String value;

    GeneroEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GeneroEnum fromValue(String text) {
      for (GeneroEnum b : GeneroEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
