/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffemakerfine;

/**
 *
 * @author safrolov
 */
public class coffee {
           private int water, milk, coffee_mg;
    private int time=0;
    private static String reasults;
    
    private int min_water, max_water, min_milk, max_milk, min_coffee_mg,max_coffee_mg;
    
    private  boolean check=true;
    
    public coffee (int water, int milk, int coffee_mg){
        this.water=water;
        this.milk=milk;
        this.coffee_mg=coffee_mg;
    }
    
    @Override
    public String toString() {
        return "water: " + water + " ml , milk: " + milk + " ml , coffee_ml: " + coffee_mg + " mg";
    }
    
    public void setMaxMin(int min_water_in, int max_water_in, int min_milk_in, int max_milk_in, 
            int min_coffee_mg_in, int max_coffee_mg_in){
        this.min_water=min_water_in;
        this.max_water= max_water_in;
        this.min_milk=min_milk_in;
        this.max_milk=max_milk_in;
        this.min_coffee_mg=min_coffee_mg_in;
        this.max_coffee_mg=max_coffee_mg_in;
    }
    
    public String checkCoffee(int par_check, int par_min, int par_max){    
        if(par_check<par_min){
            reasults = "Need more ";
                this.check=false;
                }
            else if(par_check>par_max){
                reasults="Too much ";
                this.check=false;
                }
            else {
                reasults="Enough ";
            }
        return reasults;
    }
    
    public String maxMin(){
        return
            (checkCoffee(this.water, this.min_water, this.max_water) + "water; ") +
            (checkCoffee(this.milk, this.min_milk, this.max_milk) + "milk; ")+
            (checkCoffee(this.coffee_mg, this.min_coffee_mg, this.max_coffee_mg) + "coffee;");
    }
    
    //par=0 - add water
    //par=1 - add milk
    //par=2 - add coffee_mg    
    public void add(int par, int amount){
        if (par==0) {
            this.water=this.water+amount;
            this.check=true;
        }
        if (par==1) {
            this.milk=this.milk+amount;
            this.check=true;
        }
        if (par==2) {
            this.coffee_mg=this.coffee_mg+amount;
            this.check=true;
        }
    }
    

    public String prepare_coffee(int water_prep, int milk_prep, int coffee_mg){
        this.maxMin();
        if (this.time<8) {   
            if (this.check==true){
                this.water=this.water-water_prep;
                this.milk=this.milk-milk_prep;
                this.coffee_mg=this.coffee_mg-coffee_mg;
                this.time=this.time+1;
                return "take your cup";
                }
            
            else {
                this.maxMin();        
                return "you cannot make a cup of coffee. Please check materials. " +"\n"+ this.maxMin();                
            }
        }
        else
            return "please clean the coffee maker";
    }
    
    public void clean(){
        this.time=0;
    }
}
