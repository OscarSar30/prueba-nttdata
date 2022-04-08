/**
 * 
 */
package ec.com.servicioentidad.banco.constants;

/**
 * @author osarcos
 *
 */
public class MensajesExcepciones {
	
	private MensajesExcepciones() {
	}
	
	public static final String ERROR_INTERNO = "Estimado usuario, ocurrio un error en el servicio, por favor contactese con el Administrador";
	public static final String CREACION_COMPLETADA = "Se ha creado el recurso con el ID %s";
	public static final String BUSQUEDA_SIN_EXITO = "Estimado usuario, el recurso con ID %s no existe";
	public static final String ELIMINACION_EXISTOSA = "Su registro fue eliminado con éxito";
	public static final String ACTUALIZACION_CORRECTA = "Información actualizada correctamente";
	public static final String CEDULA_EXISTENTE = "Estimado cliente, el número de identificación %s ya se encuentra registrado.";
	public static final String CUENTA_EXISTENTE = "Estimado cliente, el número de cuenta %s ya se encuentra registrado.";	
	public static final Double VALOR_TOPE = 1000.00;
	public static final String SALDO_CERO = "Saldo no disponible";
	public static final String CUPO_MAXIMO = "Cupo diario Excedido";

}
