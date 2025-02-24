
package Mapper;

import DTO.CitaNuevoDTO;
import DTO.ConsultaNuevaDTO;
import DTO.Direccion_PacienteNuevaDTO;
import DTO.HorarioMedicoNuevoDTO;
import DTO.MedicoNuevoDTO;
import DTO.PacienteNuevoDTO;
import DTO.UsuarioNuevoDTO;
import Entidades.Cita;
import Entidades.Consulta;
import Entidades.Direccion_Paciente;
import Entidades.Horario_Medico;
import Entidades.Medico;
import Entidades.Paciente;
import Entidades.Usuario;
import java.time.LocalDateTime;

/**
 * Clase Mapper para convertir entre DTOs y entidades.
 * Esta clase contiene métodos para convertir objetos DTO (Data Transfer Object)
 * a entidades de la base de datos y viceversa. Esto facilita la transferencia
 * de datos entre las capas de la aplicación y la persistencia de datos.
 *
 * @author Sebastian Moreno
 */
public class Mapper {

    /**
     * Convierte un UsuarioNuevoDTO a una entidad Usuario.
     *
     * @param usuarioNuevo El DTO de usuario.
     * @return La entidad Usuario correspondiente, o null si el DTO es null.
     */
    public Usuario DTOUsuarioToEntity(UsuarioNuevoDTO usuarioNuevo) {
        if (usuarioNuevo == null) {
            return null;
        }
        return new Usuario(
                usuarioNuevo.getUsuario(),
                usuarioNuevo.getContrasenha()
        );
    }

    /**
     * Convierte una entidad Usuario a un UsuarioNuevoDTO.
     *
     * @param usuario La entidad Usuario.
     * @return El DTO de usuario correspondiente, o null si la entidad es null.
     */
    public UsuarioNuevoDTO UsuarioToNuevoDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioNuevoDTO(
                usuario.getNombreUsuario(),
                usuario.getContrasenha()
        );
    }

    /**
     * Convierte un PacienteNuevoDTO a una entidad Paciente.
     *
     * @param pacienteNuevo El DTO de paciente.
     * @return La entidad Paciente correspondiente, o null si el DTO es null.
     */
    public Paciente DTOPacienteToEntity(PacienteNuevoDTO pacienteNuevo) {
        if (pacienteNuevo == null) {
            return null;
        }
        return new Paciente(
                pacienteNuevo.getUsuario(),
                pacienteNuevo.getDireccion(),
                pacienteNuevo.getNombre(),
                pacienteNuevo.getApellidoPaterno(),
                pacienteNuevo.getApellidoMaterno(),
                pacienteNuevo.getCorreo(),
                pacienteNuevo.getFechaNacimiento(),
                pacienteNuevo.getTelefono()
        );
    }

    /**
     * Convierte una entidad Paciente a un PacienteNuevoDTO.
     *
     * @param paciente La entidad Paciente.
     * @return El DTO de paciente correspondiente, o null si la entidad es null.
     */
    public PacienteNuevoDTO PacienteToNuevoDTO(Paciente paciente) {
        if (paciente == null) {
            return null;
        }
        return new PacienteNuevoDTO(
                paciente.getUsuario(),
                paciente.getDireccion(),
                paciente.getNombre(),
                paciente.getApellidoPaterno(),
                paciente.getApellidoMaterno(),
                paciente.getCorreo(),
                paciente.getFechaNacimiento(),
                paciente.getTelefono()
        );
    }

    /**
     * Convierte un Direccion_PacienteNuevaDTO a una entidad Direccion_Paciente.
     *
     * @param direccionNueva El DTO de dirección.
     * @return La entidad Direccion_Paciente correspondiente, o null si el DTO es null.
     */
    public Direccion_Paciente DTODireccion_PacienteToEntity(Direccion_PacienteNuevaDTO direccionNueva) {
        if (direccionNueva == null) {
            return null;
        }
        return new Direccion_Paciente(
                direccionNueva.getCalle(),
                direccionNueva.getColonia(),
                direccionNueva.getCp(),
                direccionNueva.getNumero()
        );
    }

    /**
     * Convierte una entidad Direccion_Paciente a un Direccion_PacienteNuevaDTO.
     *
     * @param direccion La entidad Direccion_Paciente.
     * @return El DTO de dirección correspondiente, o null si la entidad es null.
     */
    public Direccion_PacienteNuevaDTO Direccion_PacienteToNuevaDTO(Direccion_Paciente direccion) {
        if (direccion == null) {
            return null;
        }
        return new Direccion_PacienteNuevaDTO(
                direccion.getCalle(),
                direccion.getColonia(),
                direccion.getCp(),
                direccion.getNumero()
        );
    }
    
   /**
     * Convierte un CitaNuevoDTO a una entidad Cita.
     *
     * @param citaNueva El DTO de cita.
     * @return La entidad Cita correspondiente, o null si el DTO es null.
     */
    public Cita DTOCitaToEntity(CitaNuevoDTO citaNueva) {
        if (citaNueva == null) {
            return null;
        }
        return new Cita(
                citaNueva.getEstado(),
                citaNueva.getFechaHora(),
                citaNueva.getFolio(),
                citaNueva.getTipo(),
                citaNueva.getMedico(),
                citaNueva.getPaciente()
        );
    }
    
    /**
     * Convierte una entidad Cita a un CitaNuevoDTO.
     *
     * @param cita La entidad Cita.
     * @return El DTO de cita correspondiente, o null si la entidad es null.
     */
    public CitaNuevoDTO CitaToNuevaDTO(Cita cita) {
        if (cita == null) {
            return null;
        }
        return  new CitaNuevoDTO(
                cita.getEstado(), 
                cita.getFechaHora(), 
                cita.getFolio(), 
                cita.getTipo(), 
                cita.getMedico(), 
                cita.getPaciente()
        );
    }
    
    /**
     * Convierte una ConsultaNuevaDTO a una entidad Consulta.
     *
     * @param consultaNueva El DTO de consulta.
     * @return La entidad Consulta correspondiente, o null si el DTO es null.
     */
    public Consulta DTOConsultaToEntity(ConsultaNuevaDTO consultaNueva) {
        if (consultaNueva == null) {
            return null;
        }
        return new Consulta(
                consultaNueva.getCita(),
                consultaNueva.getEstado(),
                consultaNueva.getDiagnostico(),
                consultaNueva.getTratamiento(),
                consultaNueva.getObservaciones(),
                consultaNueva.getFechaHora()
        );
    }
    
    /**
     * Convierte una entidad Consulta a una ConsultaNuevaDTO.
     *
     * @param consulta La entidad Consulta.
     * @return El DTO de consulta correspondiente, o null si la entidad es null.
     */
    public ConsultaNuevaDTO ConsultaToNuevaDTO(Consulta consulta) {
        if (consulta == null) {
            return null;
        }
        return new ConsultaNuevaDTO(
                consulta.getCita(),
                consulta.getEstado(),
                consulta.getDiagnostico(),
                consulta.getTratamiento(),
                consulta.getObservaciones(),
                consulta.getFechaHora()
        );
    }

    /**
     * Convierte un MedicoNuevoDTO a una entidad Medico.
     *
     * @param medicoNuevo El DTO de médico.
     * @return La entidad Medico correspondiente, o null si el DTO es null.
     */
    public Medico DTOMedicoToEntity(MedicoNuevoDTO medicoNuevo) {
        if (medicoNuevo == null) {
            return null;
        }
        return new Medico(
                medicoNuevo.getUsuario(),
                medicoNuevo.getNombre(),
                medicoNuevo.getApellidoPaterno(),
                medicoNuevo.getApellidoMaterno(),
                medicoNuevo.getCedulaProfesional(),
                medicoNuevo.getEspecialidad(),
                medicoNuevo.getEstado()
        );
    }

    /**
     * Convierte una entidad Medico a un MedicoNuevoDTO.
     *
     * @param medico La entidad Medico.
     * @return El DTO de médico correspondiente, o null si la entidad es null.
     */
    public MedicoNuevoDTO MedicoToNuevoDTO(Medico medico) {
        if (medico == null) {
            return null;
        }
        return new MedicoNuevoDTO(
                medico.getUsuario(),
                medico.getNombre(),
                medico.getApellidoPaterno(),
                medico.getApellidoMaterno(),
                medico.getCedulaProfesional(),
                medico.getEspecialidad(),
                medico.getEstado()
        );
    }

    /**
     * Convierte un HorarioMedicoNuevoDTO a una entidad Horario_Medico.
     *
     * @param horMedNuevo El DTO de horario médico.
     * @return La entidad Horario_Medico correspondiente, o null si el DTO es null.
     */
    public Horario_Medico DTOHorMedToEntity(HorarioMedicoNuevoDTO horMedNuevo) {
        if (horMedNuevo == null) {
            return null;
        }
        return new Horario_Medico(
                horMedNuevo.getHorario(),
                horMedNuevo.getMedico()
        );
    }

    /**
     * Convierte una entidad Horario_Medico a un HorarioMedicoNuevoDTO.
     *
     * @param horMed La entidad Horario_Medico.
     * @return El DTO de horario médico correspondiente, o null si la entidad es null.
     */
    public HorarioMedicoNuevoDTO Horario_MedicoToNuevoDTO(Horario_Medico horMed) {
        if  (horMed == null) {
            return null;
        }
        return new HorarioMedicoNuevoDTO(
                horMed.getMedico(),
                horMed.getHorario()
        );
    }
}
