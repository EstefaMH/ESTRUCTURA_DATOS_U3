package controlturnos;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class ControlTurnos {

    public static void main(String[] args) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Queue<String> colaDeAsesores = llamarAsesores();
        Queue<Turno> colaTurnos = new LinkedList();
        int decision = 1;
        
        while(decision != 0){
            System.out.println("*******************************************************************");
            System.out.println("Bienvenido");
            System.out.println("Control de turnos para solicitar asesoría");
            System.out.println("Digite 0 para salir");
            System.out.println("Digite 1 para pedir un turno");
            System.out.println("Digite 2 llamar siguente turno");

            Scanner scanner = new Scanner(System.in);
            decision = scanner.nextInt();
            
            switch(decision){
                case 0:
                        System.out.println("fin de la applicacion");
                        break;
                case 1:
                        System.out.println("Digite su nombre: ");
                        String estudiante = scanner.next();
                        char letra = letras.charAt(numAleatorio(0,letras.length()-1));
                        int numero = numAleatorio(1,1000);
                        String codigo = letra + Integer.toString(numero);
                        //Añadir a la cola de Turnos
                        if(colaDeAsesores.isEmpty()){
                            colaDeAsesores = llamarAsesores();
                        }
                        String asesor = colaDeAsesores.poll();
                        colaTurnos.add(new Turno(codigo,estudiante,asesor));
                        System.out.println("Turno creado");
                        System.out.println("Código: "+codigo+"- Estudiante: "+estudiante+"- Asesor: "+asesor);
                        break;
                case 2:
                        
                        if(!colaTurnos.isEmpty()){
                            System.out.println("Pasa a ser antedido: ");
                            Turno turnoActual = colaTurnos.poll();
                            System.out.println("Código: "+turnoActual.Codigo+"- Estudiante: "+turnoActual.Estudiante+"- Asesor: "+turnoActual.Asesor);
                        }else{
                            System.out.println("No hay nadie en la cola");
                        }
                        break;
                default:
                        System.out.println("Menu incorrecto");
                        break;
            }
            System.out.println("Presione Enter para continuar");
            try{
                System.in.read();
            }
            catch(Exception e){
            }
        }
        
    }
    
    public static Queue llamarAsesores(){
        Queue<String> colaDeAsesores = new LinkedList();
        colaDeAsesores.add("Pedro");
        colaDeAsesores.add("Alejandra");
        colaDeAsesores.add("William");
        return colaDeAsesores;
    }
    
    public static int numAleatorio(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
}
