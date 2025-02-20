/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mapper;

import DTO.Direccion_PacienteNuevaDTO;
import DTO.PacienteNuevoDTO;
import DTO.UsuarioNuevoDTO;
import Entidades.Direccion_Paciente;
import Entidades.Paciente;
import Entidades.Usuario;

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
                paciente.getNombre(),
                paciente.getApellidoPaterno(),
                paciente.getApellidoMaterno(),
                paciente.getCorreo(),
                paciente.getFechaNacimiento(),
                paciente.getTelefono()
        );
    }
    
    /**
     * 
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
     * 
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
}
