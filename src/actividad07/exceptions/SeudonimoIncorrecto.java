package actividad07.exceptions;

/** PUNTO 3 - EXCEPCION PROPIA QUE SE LANCE CON MENSAJE EN EL setSeudonimo**/
public class SeudonimoIncorrecto  extends Exception {
    public SeudonimoIncorrecto(String rpl_msg) {
        super (rpl_msg);
    }
}
