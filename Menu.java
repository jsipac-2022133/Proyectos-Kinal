

public class Menu {
    
    Pikachu pikachu=new Pikachu();
    Charmander charmander=new Charmander();
    Blastoise blastoise=new Blastoise();
    Onyx onyx=new Onyx();
    Charizard charizard=new Charizard();
    Groudon groudon=new Groudon();
    

    public static void mostrarNombres(){
        
        System.out.println("1=Pikachu");
        System.out.println("2=Charmander");
        System.out.println("3=Blastoise");
        System.out.println("4=Onyx");
        System.out.println("5=Charizard");
        System.out.println("6=Groudon");
        
    }    
    
    
    public void mostrarDibujos(){        
        pikachu.mostrarPokemon();
        charmander.mostrarPokemon();
        blastoise.mostrarPokemon();
        onyx.mostrarPokemon();
        charizard.mostrarPokemon();
        groudon.mostrarPokemon();
        
    }
    
    
}
