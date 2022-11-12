package actividad07;

import actividad07.exceptions.*;

/**PUNTO 1. CLASE Musico CON ATRIBUTOS - CONSTRUCTOR - GETTERS Y SETTERS**/

public class Musico {
    private String rpl_seudonimo;
    private int rpl_tiempoFormacion;
    private String rpl_dni;


    /*** CONSTRUCTOR ***/

    public Musico(String rpl_seudonimo, int rpl_tiempoFormacion, String rpl_dni) throws SeudonimoIncorrecto, TiempoFormacionIncorrecta, DniIncorrecto {
        setRpl_seudonimo(rpl_seudonimo);
        setRpl_tiempoFormacion(rpl_tiempoFormacion);
        setRpl_dni(rpl_dni);
    }

    /*** GETTERS AND SETTERS ***/
    public String getRpl_seudonimo() { //getter seudonimo
        return rpl_seudonimo;
    }

    public void setRpl_seudonimo(String rpl_seudonimo) throws SeudonimoIncorrecto{//setter seudonimo donde se lanza error SeudonimoIncorrecto
        if (rpl_seudonimo.length() <3){//si la longitud del atributo seudonimo es menor de 3 se lanza el error de abajo
            throw new SeudonimoIncorrecto("El seudónimo debe tener mínimo 3 letras");
        } else if (rpl_seudonimo.matches(".*\\d.*")) {//si contiene digitos el atributo seudonimo se lanza error
            throw new SeudonimoIncorrecto("El seudónimo no puede tener dígitos");
        }
            this.rpl_seudonimo = rpl_seudonimo;
    }

    public int getRpl_tiempoFormacion() {//getter de timpo de formacion
        return rpl_tiempoFormacion;
    }

    //setter tiempo formacio, se lanza error TiempoFormacionInconrrecta
    public void setRpl_tiempoFormacion(int rpl_tiempoFormacion) throws TiempoFormacionIncorrecta {
        if(rpl_tiempoFormacion < 1 || rpl_tiempoFormacion > 110){//si pasa esto se lanza el error de abajo
            throw new TiempoFormacionIncorrecta("El tiempo de formación debe ser entre 1 y 110");
        }
            this.rpl_tiempoFormacion = rpl_tiempoFormacion;//aqui tendríamos el timpoFormación para usarlo en el constructor
    }

    public String getRpl_dni() {//getter dni
        return rpl_dni;//devuelve el dni, para eso son los getter
    }

    //setter dni, se lanza la excepcion DniIncorrecto
    public void setRpl_dni(String rpl_dni) throws DniIncorrecto {
        if(rpl_dni.length() != 9) {
            throw new DniIncorrecto("El DNI tiene que ser un string de 9 valores");
        }
        this.rpl_dni = rpl_dni;
    }

    /*** TOSTRING ***/

    @Override
    public String toString() { //metodo toString de la clase Músico, lo que queremos que se imprima
        return "Musico: " + rpl_seudonimo + "|| Tiempo de formación " + rpl_tiempoFormacion;
    }
}

