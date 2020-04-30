package app;
public class Charlizard extends Pokemon{

    public Charlizard(){

        baseMaxHP   = 12;
        BaseATK     = 5;
        BaseDEF     = 3;
        BaseSPD     = 3;    
        
        HPMultiply   = 4;
        ATKMultiply  = 4;
        DEFMultiply  = 2;
        SPDMultiply  = 2;
        CurrentHP   = getMaxHP();

        species = "Charlizard";
    }
}