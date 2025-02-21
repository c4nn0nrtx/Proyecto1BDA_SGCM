
package Mapper;

import DTO.CitaNuevoDTO;
import DTO.Direccion_PacienteNuevaDTO;
import DTO.PacienteNuevoDTO;
import DTO.UsuarioNuevoDTO;
import Entidades.Cita;
import Entidades.Direccion_Paciente;
import Entidades.Paciente;
import Entidades.Usuario;
import java.time.LocalDateTime;

/**
 *
 * @author Sebastian Moreno
 */
public class Mapper {

    /**
     * Convierte un UsuarioNuevoDTO a una entidad Usuario
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
     * Convierte una entidad Usuario a un UsuarioNuevoDTO
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
     * Convierte un UsuarioNuevoDTO a una entidad Usuario
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
     * Convierte una entidad Usuario a un UsuarioNuevoDTO
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
     * Conviere una DireccionDTO a una entidad.
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
     * Convierte una entidad a una DireccionDTO.
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
     * Convierte una CitaDTO a una entidad.
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
     * Convierte una entidad a una CitaDTO.
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
}
