package Entidades;

/**
 * Esta clase representa la relación entre un horario y un médico.
 *
 * @author Ramon Valencia
 */
public class Horario_Medico {

    private int idHorMed;
    private Horario horario;
    private Medico medico;

    /**
     * Constructor vacío de la clase Horario_Medico.
     */
    public Horario_Medico() {
    }

    /**
     * Constructor de la clase Horario_Medico con todos los atributos,
     * incluyendo el ID.
     *
     * @param idHorMed El ID de la relación horario-médico.
     * @param horario El horario asociado.
     * @param medico El médico asociado.
     */
    public Horario_Medico(int idHorMed, Horario horario, Medico medico) {
        this.idHorMed = idHorMed;
        this.horario = horario;
        this.medico = medico;
    }

    /**
     * Constructor de la clase Horario_Medico sin el ID. Se usa para crear
     * nuevas relaciones horario-médico.
     *
     * @param horario El horario asociado.
     * @param medico El médico asociado.
     */
    public Horario_Medico(Horario horario, Medico medico) {
        this.horario = horario;
        this.medico = medico;
    }

    /**
     * Obtiene el ID de la relación horario-médico.
     *
     * @return El ID de la relación horario-médico.
     */
    public int getIdHorMed() {
        return idHorMed;
    }

    /**
     * Establece el ID de la relación horario-médico.
     *
     * @param idHorMed El ID de la relación horario-médico.
     */
    public void setIdHorMed(int idHorMed) {
        this.idHorMed = idHorMed;
    }

    /**
     * Obtiene el horario asociado.
     *
     * @return El horario asociado.
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * Establece el horario asociado.
     *
     * @param horario El horario asociado.
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /**
     * Obtiene el médico asociado.
     *
     * @return El médico asociado.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Establece el médico asociado.
     *
     * @param medico El médico asociado.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Devuelve una representación en cadena del objeto Horario_Medico.
     *
     * @return Una cadena que representa al objeto Horario_Medico.
     */
    @Override
    public String toString() {
        return "Horario_Medico{" + "idHorMed=" + idHorMed + ", horario=" + horario + ", medico=" + medico + '}';
    }

}
