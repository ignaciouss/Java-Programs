//Written by Joshua Harris
public class DepreciatingPolicy extends Policy {
    private float rate;

    public DepreciatingPolicy(float amt, float rt){
        super(amt);
        rate = rt;

    }
    public float getRate(){return rate;}

    public String toString(){
        return "Depreciating" + super.toString() +" rate: " + getRate()*100 + "%";
    }

    public boolean isExpired(){
        return(amount < 0.01);
    }

    public float depreciate(){
        amount -= amount*rate;
        return amount;
    }

}
