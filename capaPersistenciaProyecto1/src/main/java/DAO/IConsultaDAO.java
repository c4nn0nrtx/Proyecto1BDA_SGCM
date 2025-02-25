package DAO;

import Entidades.Cita;
import Entidades.Consulta;
import Exception.PersistenciaException;


/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Consulta.
 *
 * @author Ramon Valencia
 */
public interface IConsultaDAO {

    /**
     * Agrega una nueva consulta médica a la base de datos.
     *
     * @param consulta La consulta médica que se va a agregar.
     * @return La consulta médica agregada, incluyendo el ID generado por la
     * base de datos.
     * @throws PersistenciaException Si ocurre un error durante la persistencia
     * de la consulta.
     */
    public Consulta agregarConsulta(Consulta consulta) throws PersistenciaException;

    /**
     * Obtiene la consulta médica asociada a una cita específica.
     *
     * @param cita La cita cuya consulta se va a obtener.
     * @return La consulta médica asociada a la cita, o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Consulta obtenerConsultasPaciente(Cita cita) throws PersistenciaException;
}
