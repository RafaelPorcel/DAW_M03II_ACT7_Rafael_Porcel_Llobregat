package actividad07.exceptions;

/** PUNTO 2 - EXCEPCION PROPIA QUE SE LANCE CON MENSAJE en en setTiempoFormacion **/
public class TiempoFormacionIncorrecta extends Exception {
    public TiempoFormacionIncorrecta(String rpl_msg) {
        super (rpl_msg);
    }
}
