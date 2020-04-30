package app;
public class Squirtle extends Pokemon{

    public Squirtle(){

        baseMaxHP   = 12;
        BaseATK     = 4;
        BaseDEF     = 5;
        BaseSPD     = 2;    
        
        HPMultiply   = 3;
        ATKMultiply  = 2;
        DEFMultiply  = 2;
        SPDMultiply  = 1;
        CurrentHP   = getMaxHP();
        
        species = "Squirtle";
    }
}