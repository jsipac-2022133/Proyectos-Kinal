
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Principal {
    
    public static void main(String[] args){
        
        JOptionPane.showMessageDialog(null,"Estan listos?");
        
        //Instancias y variables
        Scanner entrada = new Scanner(System.in);
        Operaciones operacion=new Operaciones();        
        
        
        Menu menu =new Menu();
        int opcionMenu;
        boolean repetir=true;
        
        
        while(repetir==true){
            
            System.out.println("><><><><><><><><><><><><><><><><><><");
            System.out.println("Elija una opcion");
            System.out.println("1=Listar a todos los pokemones");
            System.out.println("2=Registro de partidas");
            System.out.println("3=Batallar");
            System.out.println("4=Estadisticas");
            System.out.println("5=Salir");
            System.out.println("><><><><><><><><><><><><><><><><><><");
            opcionMenu = entrada.nextInt();
            
            switch(opcionMenu){
                case 1:
                    menu.mostrarDibujos();
                    break;
                case 2:
                    operacion.registroDePartidas();
                    break;
                case 3:
                    operacion.comenzarBatalla();
                    break;
                case 4:
                    operacion.mostrarEstadisticas();
                    break;                    
                case 5:
                    System.exit(0);
                    break;
                    
                    
            }
        }
    }
    
}
