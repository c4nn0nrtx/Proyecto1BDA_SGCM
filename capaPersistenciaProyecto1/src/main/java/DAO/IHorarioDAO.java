package DAO;

import Entidades.Horario;
import Exception.PersistenciaException;
import java.sql.SQLException;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Horario.
 *
 * @author Ramon Valencia
 */
public interface IHorarioDAO {

    /**
     * Consulta un horario por su ID.
     *
     * @param id El ID del horario que se va a consultar.
     * @return El objeto Horario correspondiente al ID, o null si no se
     * encuentra.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Horario consultarHorarioPorId(int id) throws PersistenciaException, SQLException;
}
