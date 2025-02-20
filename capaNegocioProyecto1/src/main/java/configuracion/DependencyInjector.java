/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuracion;

import BO.UsuarioBO;
import Conexion.ConexionBD;
import Conexion.IConexionBD;

/**
 *
 * @author Sebastian Moreno
 */
public class DependencyInjector {

    public static UsuarioBO crearUsuarioBO() {
        // Crear una instancia de la conexión a la base de datos, utilizando la implementación de IConexionBD
        IConexionBD conexion = new ConexionBD();

        // Inyectar la dependencia de conexión a la instancia de ActivistaBO
        UsuarioBO usuarioBO = new UsuarioBO(conexion);

        // Retornar la instancia completamente configurada
        return usuarioBO;
    }
}
