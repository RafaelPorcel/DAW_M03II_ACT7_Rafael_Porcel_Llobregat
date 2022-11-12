package actividad07;

//IMPORT DEL PAQUETE EXCEPTIONS DONDE HE CREADO LAS 5 EXCEPCIONES PROPIAS QUE HEREDAN DE LA CLASE Exception
import actividad07.exceptions.*;

//IMPORTS DEL PAQUETE java.util para poder usar ArrayList, HashMap, Iterator, Scanner
import java.util.*;

//import static actividad07.functions.Funciones.*;


/** PUNTO 5 - CLASE GestionaMusicos **/
public class GestionaMusicos {//

    /** HashMap con índice String y valor Musico (clase con diferentes atributos). PUNTO 5.a **/
    static HashMap<String, Musico> rpl_musicos = new HashMap<String, Musico>();//indice: String - valor: Musico
    //se define el HashMap y se inicializa

    /** ArrayList de Músicos de la clase Músico - PUNTO 5.b **/
    static ArrayList<Musico> rpl_grupoMusica = new ArrayList<Musico>();//tipo de dato: Musico
    //se define Array y se inicializa


    //método main con las intrucciones throws de las excepciones
    public static void main(String[] args) throws TiempoFormacionIncorrecta, DniIncorrecto, SeudonimoIncorrecto{

        /** crear 2 objetos de la clase Musico  **/
        Musico rpl_musico1 = new Musico("Rafa", 19, "12345678R");//creo un musico con sus atributos
        Musico rpl_musico2 = new Musico("Mozart", 13, "45678912D");


        /** añado al HashMap dos musico "rpl_musicoX" creados anteriormente y sus claves son el dni que lo cojo con el getRpl_dni de la clase musico **/
        rpl_musicos.put(rpl_musico1.getRpl_dni(), rpl_musico1);//mediante metodo .put añadimos el objeto Músico al HashMap
        rpl_musicos.put(rpl_musico2.getRpl_dni(), rpl_musico2);


        int rpl_option = 0; //variable para guardar la opcion a elegir
        do { //haz esto "bucle do-while"
            rpl_menu(); //llamada a la funcion para que imprima el menú
            rpl_option = rpl_pideEntero(); //llamada a la funcion para pedir un numero entero para utilzarlo en el switch case
            switch (rpl_option) {
                case 1:
                    crearMusico();//llamada a la funcion para crear musicO
                    mostrarHashMap();//llamada a la función para mostrar el hashmap con los musicos
                    mostrarGupoMusica();//llamada a la funcion que muestra el ArrayList
                    break;
                case 2:
                    borraMusico();//llamada a la funcion para borrar musico
                    mostrarHashMap();//llamada a la función para mostrar el hashmap con los musicos
                    mostrarGupoMusica();//llamada a la funcion que muestra el ArrayList
                    break;
                case 3:
                    try {//probamos a llamar la funcion addMusico que tiene un if y se lanza un error
                        addMusico();
                    }catch (DemasiadosObjetos e){//captura el error que se lanza en la funcion y escribe el mensaje
                        System.out.println("El ArrayList no puede contener más de 2 músicos");
                    }
                    mostrarHashMap();//llamada a la función para mostrar el hashmap con los musicos
                    mostrarGupoMusica();//llamada a la funcion que muestra el ArrayList
                    break;
                case 4:
                    mostrarGupoMusica();//llamada a la funcion que muestra el ArrayList
                    try {
                        borraMusicoGrupoMusica();//llamada a la funcion para borrar elemento del ArrayList
                    }catch (PosicionIncorrecta e){
                        System.out.println("Debes introducir una posición correcta para borrar");
                    }
                    mostrarHashMap();//llamada a la función para mostrar el hashmap con los musicos
                    mostrarGupoMusica();//llamada a la funcion que muestra el ArrayList
                    break;
                case 0:
                    System.out.println("ADIOS");
                    break;
                default://si no se introduce un valor del 0 al 4 salta este mensaje
                    System.out.println("tiene que ser un numero de 0 a 4");
            }
        } while (rpl_option != 0); //do (haz) mientras esta variable sea distinta de 0, si es 0 imprime
        //lo que pone en case: 0 y sale del bucle do-while
    }



    /**************************************** FUNCIONES ****************************************/

    //funcion para mostrar opciones de menú
    public static void rpl_menu() {
        System.out.println("\n***** OPCIONES *****" +
                "\n 1 - CREA MÚSICO" +
                "\n 2 - BORRA MÚSICO" +
                "\n 3 - AÑADE UN MÚSICO AL GRUPO DE MÚSICA" +
                "\n 4 - BORRA MÚSICO DEL GRUPO DE MÚSICA" +
                "\n 0 - SALIR");
    }

    //funcion para pedir entero al usuario justo despues de que le aparezca el menu
    public static int rpl_pideEntero() {//nos devuelve un entero
        System.out.println("\nINTRODUCE VALOR ENTRE 0 Y 4");
        Scanner rpl_entero = new Scanner(System.in);
        try {//prueba a devolver el entero
            return rpl_entero.nextInt();
        } catch (Exception i) {//si no, captura esta excepcion y retorna de nuevo a la función pideEntero (recursiva)
            System.out.println("Introduce un número");
            return rpl_pideEntero();//recursivamente te devuelve a esta funcion
        }
    }

    //funcion para mostrar el HashMap
    public static void mostrarHashMap() {
        Iterator rpl_it = rpl_musicos.keySet().iterator();
        System.out.println("\nLos musicos que hay dentro de rpl_musicos (HashMap) son: ");
        while (rpl_it.hasNext()) {
            String rpl_key = (String) rpl_it.next();
            System.out.println("Dni: " + rpl_key + " -> " + rpl_musicos.get(rpl_key));
        }
    }

    //funcion para crear el musico, pide primero dni luego seudonimo y tiempo formacion
    public static void crearMusico() throws TiempoFormacionIncorrecta, DniIncorrecto, SeudonimoIncorrecto {
        //se lanzan estas 3 funciones y cada una nos devuelve el dato y lo guarda en la variable para luego crear Musico
        String rpl_dni = pideDni();
        String rpl_seudonimo = pideSeudonimo();
        int rpl_tiempoFormacion = pideTiempoFormacion();

        //aquí usamos los datos que devuelven las funciones, guardados en variables para usarlos en el constructor
        Musico m1 = new Musico (rpl_seudonimo, rpl_tiempoFormacion, rpl_dni);

        rpl_musicos.put(m1.getRpl_dni(), m1);//añade al HashMap el musico creado antes con indice dni y con valor Musico
    }


                        /**** FUNCIONES PARA PEDIR ATRIBUTOS ****/

    public static String pideDni() {//devuelve el dni
        System.out.println("Añade dni del musico");
        Scanner sc = new Scanner(System.in);
        String rpl_dni = sc.nextLine();
        return rpl_dni;
    }

    public static String pideSeudonimo() {//devuelve el seudonimo
        System.out.println("Añade seudonimo del musico");
        Scanner sc = new Scanner(System.in);
        String rpl_seudonimo = sc.nextLine();
        return rpl_seudonimo;
    }

    public static int pideTiempoFormacion() {//devuelve el tiempo de formacion
        System.out.println("Añade tiempo formacion del musico");
        Scanner sc = new Scanner(System.in);
        int rpl_tiempo_form = sc.nextInt();
        return rpl_tiempo_form;
    }

    public static void borraMusico() { //FUNCION PARA BORRAR MUSICO DEL HASHMAP
        System.out.println("¿Qué músico quieres borrar? Introduce el dni");
        mostrarHashMap();
        Scanner sc = new Scanner(System.in);
        String rpl_dni = sc.nextLine();
        rpl_musicos.remove(rpl_dni);
    }

    public static void addMusico() throws DemasiadosObjetos {
        System.out.println("¿Qué músico quieres añadir al rpl_grupoMusica? Introduce dni");
        mostrarHashMap();
        Scanner sc = new Scanner(System.in);
        String rpl_dni = sc.nextLine();
        if (rpl_grupoMusica.size() > 1) {//si el array tiene mas de 1 elemento, lanza la excepcion DemasiadosObjetos
            throw new DemasiadosObjetos();
        } else {//y si tiene menos pues añade un valor al array
            rpl_grupoMusica.add(rpl_musicos.get(rpl_dni));
        }
    }

    public static void mostrarGupoMusica() {//funcion para mostrar el ArrayList
        if (rpl_grupoMusica.size() == 0){//si el tamaño es 0 que imprima que no hay aun ningun musico en el ArrayList
            System.out.println("\nAun no hay musicos en el ArrayList rpl_grupoMusica");
        }else {//sino que recorra el ArrayList y lo imprima
            System.out.println("\nLos musicos que hay dentro de rpl_grupoMusica (ArrayList) son: ");
            for (int i = 0; i < rpl_grupoMusica.size(); i++) {
                System.out.println("El musico numero " + (i + 1) + " es: " + rpl_grupoMusica.get(i).getRpl_seudonimo());
            }
        }
    }

    public static void borraMusicoGrupoMusica() throws PosicionIncorrecta {
        System.out.println("¿Qué músico quierer borrar? Introduce el número de músico.");
        Scanner sc = new Scanner(System.in);
        int rpl_num_musico = sc.nextInt();
        for (int i = 0; i < rpl_grupoMusica.size(); i++) {
            if (rpl_num_musico != (i + 1)) {
                throw new PosicionIncorrecta();
            } else {
                rpl_grupoMusica.remove(rpl_num_musico - 1);
            }
        }
    }


}


