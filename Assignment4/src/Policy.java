public class Policy {
    private static int NEXT_POLICY_NUMBER = 1;
    private int policyNumber;
    protected float amount;
    public Policy(float amt) {
        amount = amt;
        policyNumber = NEXT_POLICY_NUMBER++;
    }
    public int getPolicyNumber() { return policyNumber; }
    public float getAmount() { return amount; }
    public String toString() {
        return String.format("Policy: %04d amount: $%1.2f", policyNumber, amount);
    }
    public boolean isExpired() {
        return false;
    }
    public float handleClaim(){
        if (this instanceof DepreciatingPolicy){
            float amt = this.getAmount();
            ((DepreciatingPolicy)this).depreciate();
            return amt;
        }
        if (this instanceof  ExpiringPolicy){
            if (this.isExpired()){
                return 0;
            } else{
                return this.getAmount();
            }
        } else{
            return this.getAmount();
        }
    }
}
