package actividad07.exceptions;

public class DemasiadosObjetos extends Exception{
    public DemasiadosObjetos(){
    }
    public DemasiadosObjetos(String rpl_msg) { //constructor que recibe parametro tipo String
        super (rpl_msg);//llamamos al constructor de la clase padre "Exception" y le estamos pasando el rpl_msg
    }
}
