package actividad07.exceptions;

/** PUNTO 5.h - EXCEPCION PROPIA QUE SE LANCE CON MENSAJE Y SE CAPTURE EN EL MAIN **/
public class PosicionIncorrecta extends Exception {
    public PosicionIncorrecta(){
    }
    public PosicionIncorrecta(String rpl_msg){
        super (rpl_msg);
    }
}
