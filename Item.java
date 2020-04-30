package app;
import java.util.Random;
public class Item{

    private int HPBoosteramount = 0;     //HP Booster is boost max hp
    private int ATKBoosteramount = 0;  //ATKBooster is boost atk
    private int DEFBooster = 0;     //DEF Booster is boost def
    private int SPDBoosteramount = 0;   //SPDBooster is boost spd
    private int Elixiramount = 0;   //Elixir is use to restore CurrentHP in battle
    private int pokeballamount = 0; //use to catch pokemon

    private Random rand = new Random();
    public Item(){
        Elixiramount = 4; // Starter's Item
        pokeballamount = 4;
    }
    public void getitem(){
        // items can be get multiple at once
        if(rand.nextInt(4) == 1){ 
            HPBoosteramount += 1;
        }
        if(rand.nextInt(4) == 1){
            ATKBoosteramount += 1;
        }
        if(rand.nextInt(4) == 1){
            DEFBooster += 1;
        }
        if(rand.nextInt(4) == 1){
            SPDBoosteramount += 1;
        }
        if(rand.nextInt(4) == 1){
            Elixiramount += 1;
        }
        if(rand.nextInt(4) == 1){
            pokeballamount += 1;
        }
    }
    public void useHPBooster(Pokemon target){
        target.MaxHPincrease(3);
        HPBoosteramount -= 1;
    }
    public void useATKBooster(Pokemon target){
        target.atkincrease(2);
        ATKBoosteramount -= 1;
    }
    public void useDEFBooster(Pokemon target){
        target.defincrease(1);
        DEFBooster -= 1;
    }
    public void usecarbos(Pokemon target){
        target.spdincrease(1);
        SPDBoosteramount -= 1;
    }
    public boolean usepokeball(Pokemon target){
        pokeballamount -= 1;
        if(rand.nextInt(4)==1){//25% to catch
            return true;
        }
        else return false;
    }
    public void useElixir(Pokemon target){
        if( (target.getMaxHP() - target.getCurrentHP()) >= 0 ){ //  Full Restore
            target.CurrentHPChange(target.getMaxHP() - target.getCurrentHP());
        }
        Elixiramount-=1;
    }
    public int getHPBoosterAmount(){
        return HPBoosteramount;
    }
    public int getATKBoosterAmount(){
        return ATKBoosteramount;
    }
    public int getDEFBoosterAmount(){
        return DEFBooster;
    }
    public int getSPDBoosteramount(){
        return SPDBoosteramount;
    }
    public int getElixirAmount(){
        return Elixiramount;
    }
    public int getPokeballAmount(){
        return pokeballamount;
    }
    public int getTotalItem(){
        return HPBoosteramount + DEFBooster + ATKBoosteramount + SPDBoosteramount + Elixiramount + pokeballamount;
    }
}