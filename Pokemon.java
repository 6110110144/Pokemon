package app;
abstract class Pokemon implements PokemonInterface{
    // it's stat will be (base + mul*lvl)
    protected String name;

    protected int baseMaxHP;
    protected int CurrentHP;
    protected int BaseATK;
    protected int BaseDEF;
    protected int BaseSPD;

    protected double HPMultiply; // stat + per level
    protected double ATKMultiply;
    protected double DEFMultiply;
    protected double SPDMultiply;

    protected int exp=0;
    protected int exptolvlup=10;
    protected int lvl=1;
    protected String species;
    
    public Pokemon(){
        CurrentHP = getMaxHP();
    }

    public void namechange(String inputname){ // naming pokemon 
        name = inputname;
    }

    public void expup(int winexp){ // when win battle
        exp += winexp;
        if(exp >= exptolvlup){
            while(exp >= exptolvlup){
                lvlchange(1) ;
                exp -= exptolvlup;
                System.out.println(name + " grew to Lv." + lvl + "!");
            }
        }
    }

    public void lvlchange(int amount){ //when lvl up
        lvl += amount;
        for(int i = 0 ; i <= amount ; i++){
            exptolvlup *= 1.2;
        }
        CurrentHP = getMaxHP();
    }

    public void damagecal(int oatk){ //damage cal part
        int damage = oatk - getdef();
        if(damage <= 0) //if def is higher than other one's attack then damage = 1
        {
            CurrentHP -= 1;
        }
        else{
            CurrentHP -= damage;
        }
        if(CurrentHP <= 0){//CurrentHP can't be less than 0
            CurrentHP = 0; 
        }
    }
    
    public void CurrentHPChange(int amount){
        CurrentHP += amount;
        System.out.println("Your "+ name + " HP is " + CurrentHP + " now!");
        if(CurrentHP > getMaxHP()){
            CurrentHP = getMaxHP();
            System.out.println(name + " HP is full!");
        }
    }
    public int getspd(){
        return BaseSPD + (int)(lvl*SPDMultiply);
    }
    public int getMaxHP(){
        return baseMaxHP + (int)(lvl*HPMultiply);
    }
    public int getCurrentHP(){
        return CurrentHP;
    }
    public int getatk(){
        return BaseATK + (int)(lvl*ATKMultiply);
    }
    public int getdef(){
        return BaseDEF + (int)(lvl*DEFMultiply);
    }
    public String getname(){
        return name;
    }
    public int getlvl(){
        return lvl;
    }
    public String getspecies(){
        return species;
    }
    public int getexp(){
        return exp;
    }
    public int getexptolvl(){
        return exptolvlup;
    }
    public void MaxHPincrease(int amount){ //item use only
        baseMaxHP += amount;
    }
    public void atkincrease(int amount){ //item use only
        BaseATK += amount;
    }
    public void defincrease(int amount){ //item use only 
        BaseDEF += amount;
    }
    public void spdincrease(int amount){ //item use only
        BaseSPD += amount;
    }
}