//Written by Joshua Harris
public class IndividualClient extends Client {

    public IndividualClient(String name){
        super(name);
    }

    public float makeClaim(int polNum){
        for(int i =0; i< numPolicies; i++){
            if((polNum!=policies[i].getPolicyNumber())||( policies[i].isExpired())){
                return 0;
            }
            //DEPCRECIATEING
            System.out.println("Looking over Depreciating policies");
            if(polNum == policies[i].getPolicyNumber()){
                if (policies[i] instanceof DepreciatingPolicy){
                    ((DepreciatingPolicy)policies[i]).depreciate();
                    return (policies[i].getAmount());
                }
            }

            //EXPIRING POLICY
            if(polNum == policies[i].getPolicyNumber()&&(policies[i] instanceof ExpiringPolicy)){
                    return(policies[i].amount);
            }


            //Policies
            if ((polNum == policies[i].getPolicyNumber())&&(policies[i] instanceof Policy)){
                (policies[i]).handleClaim();
                return(policies[i].amount);
            }
        }
        return 0;
    }

}
