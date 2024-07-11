

public class Charizard extends PokemonPadre{
    
    
    int poderAleatorio=(int)(Math.random()*+15+5);
    
    public Charizard(){
        
    }
    
    public Charizard(int vidarandom){
        this.vida=vidarandom;
    }
    
    public void pokemon(){
        pokemon="Charizard";
    }
    
    public void nombre(){
        nombre = "Charizard";
    }
    

    
    public void vida(){
        int vidarandom=(int)(Math.random()*15+10);
        System.out.println(""+vidarandom);
        vida=vidarandom;
    }
    
    public void estado(){
        estado=true;
    }
    

    
    
    public PokemonPadre atacar(int select_ataque, PokemonPadre pokemon_atacar){
        switch (select_ataque){
            case 1:
                pokemon_atacar.vida-=poderAleatorio;
                break;
            default:
                break;         
        }if(pokemon_atacar.getVida() < 0)
            pokemon_atacar.setEstado(false);
        return pokemon_atacar;
    }
    
    public void mostrarPokemon(){
        System.out.println("Nombre: Charizard");        
        System.out.println("Ataque: "+poderAleatorio);
          System.out.println("                                                             \n" +
        "                     ./,,,      ....                        ,/*,                \n" +
        "                  #*,,,,,      ,,,,,,,..#,*                 #,*,,               \n" +
        "           *##(, *******,.     *,/,,,,,.,,,.#&             #*****.,,            \n" +
        "         **,,************,*      % ,,,,,,,, /(,,         *# **.*****,,# &       \n" +
        "       .,******////******,,          * ..,,,*           ##,************ ,,#     \n" +
        "    /,,,****///////*,.***,,,*          ,,,,,*          .#,***.***////*****,,*   \n" +
        "   %,,****////////********** ,,*,/      ,,,,,*      *#*,,,******/////////**,,*  \n" +
        "  ,,.***//////////****************,,.,  ,,,,,, &/(#*,******/*,**///////////**,# \n" +
        "  ,,**////////////*****//////*******,,,*,,,,*.,,,,*******///***/////////////**,*\n" +
        " ..**///*       *//.*///////.,,  *,,,,,,,,,,,,,,,,,,*.***////*///    ,./////***,\n" +
        "/,**.             /**//.  .,,,.,,,.,,.,,,,,,,,,,,,,..,,,,,,#/*/     (...( ./***,\n" +
        ".**/              .., %,,,,,, /( .,,,,,,, ////// ,,.   //.,,,,,,,   ,..**   .**,\n" +
        "/.                  (,,,,,,,*,    ,,,,,(///////////,%      ,,,,,** ,.,**&    ** \n" +
        "                      .,,#*,/   #,,,,,//////////////,      *,/%,  %...***.,  /* \n" +
        "                      %*##.,( ###,,,,(///////////////,(,          &.*****&   // \n" +
        "                   .,**/*. ,.##,,,,,,,////////////**/,,(##/         ***/        \n" +
        "                /,,,,,,,,,,#,,,,,,,,,,***///******* ,,,,,,##*   *./**(          \n" +
        "                *,,,,,,,,, ,,,,,,,,,,************,,,,,,,,,,,#,,,**/             \n" +
        "                 .********,,,,,,,, ******.,.* ****,.,,,,,,,** *                 \n" +
        "                    ***.,/,,,,,,,*                .,,,,,,,,**                   \n" +
        "                         (&,&,,%&                      ,,*%.&                     "
                                + "\n"
                                + "\n"
                                + "\n"
                                + "\n"
                                + "\n"
                                + "\n"
                                + "\n");
    }
}
