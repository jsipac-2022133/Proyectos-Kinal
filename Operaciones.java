
import java.util.Scanner;

public class Operaciones {
    
 
        
        Scanner entrada=new Scanner(System.in);
        int opcion=0;
        
        
        int pikachuContador=0;
        int charmanderContador=0;
        int blastoiseContador=0;
        int onyxContador=0;
        int charizardContador=0;
        int groudonContador=0;      
        int partidasContador=0;
        
         Menu menu=new Menu();           
         int pokemon1_1;
         int pokemon2_1;
         int pokemon1_2;
         int pokemon2_2;
         String nom1;
         String nom2;  
          
       
          //OPCION 3 DEL SWITCH DE LA CLASE PRINCIPAL
             public void comenzarBatalla(){
                  Scanner jugador1_1=new Scanner(System.in);
                    
                    do{
                        System.out.println("///////////////////////////////////");
                        System.out.println("Ingrese el nombre del jugador 1");
                        System.out.println("///////////////////////////////////");
                        nom1=jugador1_1.nextLine();
                        
                        System.out.println(nom1+", selecciona a tu primer pokemon");
                        
                        menu.mostrarNombres();
                        pokemon1_1=jugador1_1.nextInt();
                    }while(pokemon1_1<1 || pokemon1_1>6);
                    
                    
                    PokemonPadre pokemon1jugador1=null;
                    
                    int vidaPokemon1_1=(int)(Math.random()*35+10);
                    
                    switch(pokemon1_1){
                        case 1:
                            System.out.println("***********************");
                            System.out.println("Seleccionaste a Pikachu");
                            System.out.println("***********************");
                            pokemon1jugador1=new Pikachu(vidaPokemon1_1);
                            pikachuContador++;
                            break;
                        case 2:
                            System.out.println("*************************");
                            System.out.println("Seleccionaste a Charmander");
                            System.out.println("*************************");
                            pokemon1jugador1=new Charmander(vidaPokemon1_1);
                            charmanderContador++;
                            break;
                        case 3:
                            System.out.println("*************************");
                            System.out.println("Seleccionaste a Blastoise");
                            System.out.println("*************************");
                            pokemon1jugador1=new Blastoise(vidaPokemon1_1);
                            blastoiseContador++;
                            break;
                        case 4:
                            System.out.println("********************");
                            System.out.println("Seleccionaste a Onyx");
                            System.out.println("********************");
                            pokemon1jugador1=new Onyx(vidaPokemon1_1);
                            onyxContador++;
                            break;
                        case 5:
                            System.out.println("*************************");
                            System.out.println("Seleccionaste a Charizard");
                            System.out.println("*************************");
                            pokemon1jugador1=new Charizard(vidaPokemon1_1);
                            charizardContador++;
                            break;
                        case 6:
                            System.out.println("***********************");
                            System.out.println("Seleccionaste a Groudon");
                            System.out.println("***********************");
                            pokemon1jugador1=new Groudon(vidaPokemon1_1);
                            groudonContador++;
                            break;                         
                    }
                    
                    
                    Scanner judador1_2=new Scanner(System.in);
                    
                    do{
                        
                        System.out.println(nom1+", selecciona a tu segundo pokemon");
                        
                        menu.mostrarNombres();
                        pokemon2_1=judador1_2.nextInt();
                    }while(pokemon2_1<1 || pokemon2_1>6);
                    
                    PokemonPadre pokemon2jugador1=null;
                    int vidaPokemon2_1=(int)(Math.random()*35+10);
                    
                    switch(pokemon2_1){
                        case 1:
                            System.out.println("***********************");
                            System.out.println("Seleccionaste a Pikachu");
                            System.out.println("***********************");
                            pokemon2jugador1=new Pikachu(vidaPokemon2_1);
                            pikachuContador++;
                            break;
                        case 2:
                            System.out.println("**************************");
                            System.out.println("Seleccionaste a Charmander");
                            System.out.println("**************************");
                            pokemon2jugador1=new Charmander(vidaPokemon2_1);
                            charmanderContador++;
                            break;
                        case 3:
                            System.out.println("*************************");
                            System.out.println("Seleccionaste a Blastoise");
                            System.out.println("*************************");
                            pokemon2jugador1=new Blastoise(vidaPokemon2_1);
                            blastoiseContador++;
                            break;
                        case 4:
                            System.out.println("********************");
                            System.out.println("Seleccionaste a Onyx");
                            System.out.println("********************");
                            pokemon2jugador1=new Onyx(vidaPokemon2_1);
                            onyxContador++;
                            break;
                        case 5:
                            System.out.println("*************************");
                            System.out.println("Seleccionaste a Charizard");
                            System.out.println("*************************");
                            pokemon2jugador1=new Charizard(vidaPokemon2_1);
                            charizardContador++;
                            break;
                        case 6:
                            System.out.println("***********************");
                            System.out.println("Seleccionaste a Groudon");
                            System.out.println("***********************");
                            pokemon2jugador1=new Groudon(vidaPokemon2_1);
                            groudonContador++;
                            break;
                      
                        }
                    
                    
                    
                    
                    
                    
                    Scanner jugador2_1=new Scanner(System.in);
                    
                    do{
                        System.out.println("///////////////////////////////");
                        System.out.println("Ingrese el nombre del jugador 2");
                        System.out.println("///////////////////////////////");
                        nom2=jugador2_1.nextLine();
                        
                        System.out.println(nom2+", selecciona a tu primer pokemon");
                        
                        menu.mostrarNombres();
                        pokemon1_2=jugador2_1.nextInt();                    
                    }while(pokemon1_2<1 || pokemon1_2>6);
                    
                    PokemonPadre pokemon1jugador2=null;
                    int vidaPokemon1_2=(int)(Math.random()*35+10);
                    
                    switch(pokemon1_2){
                        case 1:
                            System.out.println("***********************");
                            System.out.println("Seleccionaste a Pikachu");
                            System.out.println("***********************");
                            pokemon1jugador2=new Pikachu(vidaPokemon1_2);
                            pikachuContador++;
                            break;
                        case 2:
                            System.out.println("**************************");
                            System.out.println("Seleccionaste a Charmander");
                            System.out.println("**************************");
                            pokemon1jugador2=new Charmander(vidaPokemon1_2);
                            charmanderContador++;
                            break;
                        case 3:
                            System.out.println("*************************");
                            System.out.println("Seleccionaste a Blastoise");
                            System.out.println("*************************");
                            pokemon1jugador2=new Blastoise(vidaPokemon1_2);
                            blastoiseContador++;
                            break;
                        case 4:
                            System.out.println("********************");
                            System.out.println("Seleccionaste a Onyx");
                            System.out.println("********************");
                            pokemon1jugador2=new Onyx(vidaPokemon1_2);
                            onyxContador++;
                            break;
                        case 5:
                            System.out.println("*************************");
                            System.out.println("Seleccionaste a Charizard");
                            System.out.println("*************************");
                            pokemon1jugador2=new Charizard(vidaPokemon1_2);
                            charizardContador++;
                            break;
                        case 6:
                            System.out.println("***********************");
                            System.out.println("Seleccionaste a Groudon");
                            System.out.println("***********************");
                            pokemon1jugador2=new Groudon(vidaPokemon1_2);
                            groudonContador++;
                            break;                       
                    }
                    
                    
                    
                    
                    
                    
                    Scanner jugador2_2=new Scanner(System.in);
                    
                    do{
                        
                        System.out.println(nom2+", selecciona tu segundo pokemon");
                        
                        menu.mostrarNombres();
                        pokemon2_2=jugador2_2.nextInt();
                    }while(pokemon2_2<1 || pokemon2_2>6);
                    
                    PokemonPadre pokemon2jugador2=null;
                    int vidaPokemon2_2=(int)(Math.random()*35+10);
                    
                    switch(pokemon2_2){
                        case 1:
                            System.out.println("***********************");
                            System.out.println("Seleccionaste a Pikachu");
                            System.out.println("***********************");
                            pokemon2jugador2= new Pikachu(vidaPokemon2_2);
                            pikachuContador++;
                            break;
                        case 2:
                            System.out.println("**************************");
                            System.out.println("Seleccionaste a Charmander");
                            System.out.println("**************************");
                            pokemon2jugador2=new Charmander(vidaPokemon2_2);
                            charmanderContador++;
                            break;
                        case 3:
                            System.out.println("*************************");
                            System.out.println("Seleccionaste a Blastoise");
                            System.out.println("*************************");
                            pokemon2jugador2=new Blastoise(vidaPokemon2_2);
                            blastoiseContador++;
                            break;
                        case 4:
                            System.out.println("********************");
                            System.out.println("Seleccionaste a Onyx");
                            System.out.println("********************");
                            pokemon2jugador2=new Onyx(vidaPokemon2_2);
                            onyxContador++;
                            break;
                        case 5:
                            System.out.println("*************************");
                            System.out.println("Seleccionaste a Charizard");
                            System.out.println("*************************");
                            pokemon2jugador2=new Charizard(vidaPokemon2_2);
                            charizardContador++;
                            break;
                        case 6:
                            System.out.println("***********************");
                            System.out.println("Seleccionaste a Groudon");
                            System.out.println("***********************");
                            pokemon2jugador2=new Groudon(vidaPokemon2_2);
                            groudonContador++;
                            break;                    
                    }
                    
                    
                    System.out.println("\n");
                    System.out.println("\n");

                    pokemon1jugador1.nombre();
                    pokemon2jugador1.nombre();
                    
                    pokemon1jugador2.nombre();
                    pokemon2jugador2.nombre();
                    
                    pokemon1jugador1.getEstado();
                    pokemon2jugador1.getEstado();
                    
                    pokemon1jugador2.getEstado();
                    pokemon2jugador2.getEstado();
                    
                    
                    PokemonPadre pokemonFijoj1=null;
                    PokemonPadre pokemonFijoj2=null;
                    
                    
                        System.out.println("*********************");
                        System.out.println("RESUMEN DE ELECCIONES");
                        System.out.println("*********************");
                        System.out.println("\n");
                        System.out.println("////////////////////////////////////////////////////////////////////////////");
                        System.out.println("Pokemones de "+nom1);
                        System.out.println("////////////////////////////////////////////////////////////////////////////");
                        pokemon1jugador1.mostrarPokemon();
                        pokemon2jugador1.mostrarPokemon();
                        System.out.println("\n");
                        System.out.println("////////////////////////////////////////////////////////////////////////////");
                        System.out.println("Pokemones de "+nom2);
                        System.out.println("////////////////////////////////////////////////////////////////////////////");
                        pokemon1jugador2.mostrarPokemon();
                        pokemon2jugador2.mostrarPokemon();
                    
                    do{
                        System.out.println("***********************");
                        System.out.println("Turno de "+nom1);
                        System.out.println("***********************");
                        
                        System.out.println("Pokemones elegidos de "+nom1+": "+pokemon1jugador1.getNombre()+" y "+pokemon2jugador1.getNombre());
                        
                       
                        
                        
                    
                         if(pokemon1jugador1.getVida() < 0 ){
                          
	                	System.out.println("Puntos de vida de su primer pokemon: "+pokemon1jugador1.getNombre()+"=0 (Estado: muerto) ");
                        System.out.println(pokemon1jugador1.getNombre()+", ya no puede ser utilizado en la batalla");
                        
                        }else if(pokemon2jugador1.getVida() < 0){
                       
	        	        System.out.println("Puntos de vida de su segundo pokemon: "+pokemon2jugador1.getNombre()+" = 0 (Estado: muerto)" );
                        System.out.println(pokemon2jugador1.getNombre()+", ya no puede ser utilizado en la batalla");
                        
                         } else if(pokemon1jugador1.getVida() < 0 && pokemon2jugador1.getVida() < 0){
                         System.out.println("Puntos de vida de sus pokemones "+pokemon1jugador1.getNombre()+"= 0 (Estado: muerto)"+pokemon2jugador1.getNombre()+"= 0 (Estado: muerto)");
                         }
                        
                        System.out.println("/////////////////////////////////");
                        System.out.println("Selecciona el pokemon que atacara");
                        
                        Scanner pokeatacar1 = new Scanner(System.in);
                        int atacaraJugador1;
                        do{
                           if(pokemon1jugador1.getVida()>0){
                               
                               System.out.println("1=");
                               System.out.println("Vida: "+pokemon1jugador1.getVida());
                               pokemon1jugador1.mostrarPokemon();
                               
                               
                           } 
                           if(pokemon2jugador1.getVida()>0){
                            
                               System.out.println("2=");
                               System.out.println("Vida: "+pokemon2jugador1.getVida());
                               pokemon2jugador1.mostrarPokemon();
                               
                           }
                           
                           
                           atacaraJugador1=pokeatacar1.nextInt();
                           
                           switch(atacaraJugador1){
                               case 1:
                                   System.out.println("/////////////////////////////////");
                                   System.out.println("Este pokemon sera el que atacara:");
                                   System.out.println("Vida: "+pokemon1jugador1.getVida());
                                   pokemon1jugador1.mostrarPokemon();
                               
                                   pokemonFijoj1=pokemon1jugador1;
                                   break;
                               case 2:
                                   System.out.println("/////////////////////////////////");
                                   System.out.println("Este pokemon sera el que atacara:");                                   
                                   System.out.println("Vida: "+pokemon2jugador1.getVida());
                                   pokemon2jugador1.mostrarPokemon();
                                   
                                   pokemonFijoj1=pokemon1jugador1;
                                   break;
                           }
                           
                           
                        }while(atacaraJugador1<0 && atacaraJugador1>2 && pokemonFijoj1.getVida()<0);   
                        
                        
                        System.out.println("////////////////////////////////////////");
                        System.out.println("Selecciona al pokemon rival que atacaras");
                        System.out.println("////////////////////////////////////////");
                        do{
                            if(pokemon1jugador2.getVida()>0){
                                
                                System.out.println("1=");
                                System.out.println("Vida: "+pokemon1jugador2.getVida());
                                pokemon1jugador2.mostrarPokemon();
                                
                            }
                            
                            if(pokemon2jugador2.getVida()>0){
                                
                                System.out.println("2=");
                                System.out.println("Vida: "+pokemon2jugador2.getVida());
                                pokemon2jugador2.mostrarPokemon();
                                
                            }
                            
                            int atacadoJugador2=pokeatacar1.nextInt();
                            
                            switch(atacadoJugador2){
                                case 1:
                                    System.out.println("////////////////////////////////");
                                    System.out.println("Este pokemon sera atacado:");
                                    System.out.println("Vida: "+pokemon1jugador2.getVida());
                                    pokemon1jugador2.mostrarPokemon();
                                    
                                    pokemonFijoj2=pokemon1jugador2;
                                    break;
                                case 2:
                                    System.out.println("/////////////////////////////////");
                                    System.out.println("Este pokemon sera atacado:");
                                    System.out.println("Vida: "+pokemon2jugador2.getVida());
                                     pokemon2jugador2.mostrarPokemon();
                                    
                                    pokemonFijoj2=pokemon2jugador2;                                    
                                    
                                    break;
                            }
                        }while(atacaraJugador1<0 && atacaraJugador1>2 && pokemonFijoj2.getVida()<0);
                        
                        
                        pokemonFijoj1.atacar();
                        
                        pokemonFijoj2=pokemonFijoj1.atacar(1, pokemonFijoj2);
                        
                        if(pokemonFijoj2.getVida()>0){
                            System.out.println("Puntos de vida de "+pokemonFijoj2.getNombre()+" :"+pokemonFijoj2.getVida());
                        }else if(pokemonFijoj2.getVida()<0){
                            System.out.println("Puntos de vida de "+pokemonFijoj2.getNombre()+"=0 (Estado muerto)");
                        }
                        
                        if(pokemon1jugador2.getVida()<= 0 && pokemon2jugador2.getVida()<=0){
                            System.out.println(nom1+" es el ganador de esta batalla!!!");
                          
                            break;
                        }
                        
                        
                        
                        
                        
                        System.out.println("*********************************");
                        System.out.println("Turno de "+nom2);
                        System.out.println("*********************************");
                                               
                        System.out.println("Pokemones elegidos: "+pokemon1jugador2.getNombre()+" y "+pokemon2jugador2.getNombre());
                        
                        
                        
                        
                         if(pokemon1jugador2.getVida() < 0 ){
                           
	           	        System.out.println("Puntos de vida de su primer pokemon : "+pokemon1jugador2.getNombre()+"=0 (Estado: muerto) ");
                        System.out.println(pokemon1jugador2.getNombre()+", ya no puede ser utilizado en la batalla");
                        
                        }else if(pokemon2jugador2.getVida() < 0){
                       
	        	        System.out.println("Puntos de vida de su segundo pokemon : "+pokemon2jugador2.getNombre()+" = 0 (Estado: muerto)" );
                        System.out.println(pokemon2jugador2.getNombre()+", ya no puede ser utilizado en la batalla");
                        
                         } else if(pokemon1jugador2.getVida() < 0 && pokemon2jugador2.getVida() < 0){
                        
                         System.out.println("Puntos de vida de sus pokemones: "+pokemon1jugador2.getNombre()+"= 0 (Estado: muerto)"+pokemon2jugador2.getNombre()+"= 0 (Estado: muerto)");
                   
                         }
                        
                        System.out.println("/////////////////////////////////"); 
                        System.out.println("Selecciona al pokemon que atacara");
                        System.out.println("/////////////////////////////////"); 
                        Scanner pokeatacar2=new Scanner(System.in);
                        
                        
                        do{
                            if(pokemon1jugador2.getVida()>0){
                               
                                System.out.println("1=");
                                System.out.println("Vida: "+pokemon1jugador2.getVida());
                                pokemon1jugador2.mostrarPokemon();
                                
                            }
                            if(pokemon2jugador2.getVida()>0){
                              
                                System.out.println("2=");
                                System.out.println("Vida: "+pokemon2jugador2.getVida());
                                pokemon2jugador2.mostrarPokemon();
                                 
                            }
                            
                            
                            
                            
                            int atacaraJugador2=pokeatacar2.nextInt();
                            
                            switch(atacaraJugador2){
                                case 1:
                                    System.out.println("/////////////////////////////////"); 
                                    System.out.println("Este pokemon sera el que atacara:");
                                    System.out.println("Vida: "+pokemon1jugador2.getVida());
                                    pokemon1jugador2.mostrarPokemon();
                                    
                                    pokemonFijoj2=pokemon1jugador2;
                                    break;
                                case 2:
                                    System.out.println("/////////////////////////////////"); 
                                    System.out.println("Este pokemon sera el que atacara:");
                                    System.out.println("VIda: "+pokemon2jugador2.getVida());
                                    pokemon2jugador2.mostrarPokemon();
                                    
                                    pokemonFijoj2=pokemon2jugador2;
                                    break;                                
                            }
                            
                        }while(atacaraJugador1<0 && atacaraJugador1>2 && pokemonFijoj2.getVida()<0);
                        
                        
                        System.out.println("////////////////////////////////////////////"); 
                        System.out.println("Selecciona al pokemon rival que sera atacado");
                        System.out.println("////////////////////////////////////////////"); 
                        do{
                            if(pokemon1jugador1.getVida()>0){
                                
                                System.out.println("1=");
                                System.out.println("Vida: "+pokemon1jugador1.getVida());
                                 pokemon1jugador1.mostrarPokemon();
                                  
                            }
                            if(pokemon2jugador1.getVida()>0){
                                
                                System.out.println("2=");
                                System.out.println("Vida: "+pokemon2jugador1.getVida());
                                pokemon2jugador1.mostrarPokemon();
                                
                            }
                            
                            
                            
                            int atacadoJugador1=pokeatacar2.nextInt();
                            
                            switch(atacadoJugador1){
                                case 1:
                                    System.out.println("/////////////////////////////////"); 
                                    System.out.println("Este pokemon sera atacado:");
                                    System.out.println("Vida: "+pokemon1jugador1.getVida());
                                     pokemon1jugador1.mostrarPokemon();
                                     
                                    pokemonFijoj1=pokemon1jugador1;
                                    break;
                                case 2:
                                    System.out.println("/////////////////////////////////"); 
                                    System.out.println("Este pokemon sera atacado:");
                                    System.out.println("Vida: "+pokemon2jugador1.getVida());
                                    pokemon2jugador1.mostrarPokemon();
                                    
                                    pokemonFijoj1=pokemon2jugador1;
                                    break;
                            }
                            
                        }while(atacaraJugador1<0 && atacaraJugador1>2 && pokemonFijoj2.getVida()<0);
                        
                        
                        
                        pokemonFijoj2.mostrarPokemon();

                        
                        pokemonFijoj2.atacar();
                        
                        pokemonFijoj1=pokemonFijoj2.atacar(1, pokemonFijoj1);
                        
                        if(pokemonFijoj1.getVida()>0){
                            System.out.println("Puntos de vida de "+pokemonFijoj1.getNombre()+": "+pokemonFijoj1.getVida());
                        }else if(pokemonFijoj1.getVida()<0){
                            System.out.println("Puntos de vida de "+pokemonFijoj1.getNombre()+": "+pokemonFijoj1.getVida());
                        }
                        
                        if(pokemon1jugador1.getVida()<=0  &&  pokemon2jugador1.getVida()<=0){
                            System.out.println(nom2+" es el ganador de esta batalla!!!");
                            
                            break;
                        }                      
                   
                        
                    }while(pokemon1jugador1.getVida()>=0 || pokemon2jugador1.getVida()>=0 || pokemon1jugador2.getVida()>=0 || pokemon2jugador2.getVida()>=0);
               }
               
                   
                //OPCION 2 DEL SWITCH DE LA CLASE PRINCIPAL
            public void registroDePartidas(){
                 partidasContador++;
                 System.out.println("***************************");
                 System.out.println("Partida: "+partidasContador);
                 System.out.println(nom1+" VS "+nom2);
                 System.out.println("***************************");
                 System.out.println("\n");
                 System.out.println("\n");
                 System.out.println("\n");
            }
            
                      //OPCION 4 DEL SWITCH DE LA CLASE PRINCIPAL
            public void mostrarEstadisticas(){
                System.out.println("*****************************************");
                System.out.println("---Estadisticas de uso de cada pokemon---");
                System.out.println("*****************************************");
                System.out.println("Pikachu: "+pikachuContador);
                System.out.println("Charmander: "+charmanderContador);
                System.out.println("Blastoise: "+blastoiseContador);
                System.out.println("Onyx: "+onyxContador);
                System.out.println("Charizard: "+charizardContador);
                System.out.println("Groudon: "+groudonContador);
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("\n");
             
                 }
                
                   
}

     