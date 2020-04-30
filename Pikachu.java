package app;
public class Pikachu extends Pokemon{

    public Pikachu(){

        baseMaxHP   = 14;
        BaseATK     = 4;
        BaseDEF     = 3;
        BaseSPD     = 3;    
       
        HPMultiply   = 5;
        ATKMultiply  = 3;
        DEFMultiply  = 2;
        SPDMultiply  = 2;
        CurrentHP   = getMaxHP();
        
        species = "Pikachu";
    }
}
