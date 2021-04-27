//Written by Joshua Harris
import java.util.*;
    public abstract class Client {
        private static final int MAX_POLICIES_PER_CLIENT = 10;
        private static int NEXT_CLIENT_ID = 1;
        private String name;
        private int id;
        protected Policy[] policies;
        protected int numPolicies;

        public Client(String n) {
            name = n;
            id = NEXT_CLIENT_ID++;
            policies = new Policy[MAX_POLICIES_PER_CLIENT];
            numPolicies = 0;
        }

        public String getName() {return name;}
        public int getId() { return id; }
        public Policy[] getPolicies() { return policies; }
        public int getNumPolicies() { return numPolicies; }

        public String toString() {
            return(this.getClass().getName() + String.format("%04d ",this.getId())+" "+ this.getName());
        }
        public float totalCoverage(){
            float totalCov = 0;
            for (int i = 0; i<numPolicies; i++){
                totalCov+= policies[i].amount;
            }
            return totalCov;
        }
        public Policy addPolicy(Policy p){
            if (numPolicies <MAX_POLICIES_PER_CLIENT ) {
                policies[numPolicies] = p;
                numPolicies++;
                return p;
            }
            return null;
        }
        public Policy openPolicyFor(float amt){
            Policy k = new Policy(amt);
            return addPolicy(k);
        }
        public Policy openPolicyFor(float amt,float rate){
            DepreciatingPolicy l = new DepreciatingPolicy(amt,rate);
            return(addPolicy(l));
        }
        public Policy openPolicyFor(float amt, Date expire){
            ExpiringPolicy e = new ExpiringPolicy(amt,expire);
            return(addPolicy(e));
        }
        public Policy getPolicy(int pol){
            for (int j = 0; j<numPolicies; j++){
                if (policies[j].getPolicyNumber() == pol ){
                    return policies[j];
                }
            }
            return null;
        }
        public boolean cancelPolicy(int polNum){
            for (int j = 0; j<numPolicies; j++){
                    if (policies[j].getPolicyNumber() == polNum ) {
                        if (policies[j] != policies[numPolicies - 1]) {
                            policies[j] = policies[numPolicies - 1];
                            numPolicies -= 1;
                            return true;
                        } else if (policies[j] == policies[numPolicies - 1]) {
                            policies[j] = null;
                            numPolicies -= 1;
                            return true;
                        }
                    }
            }
            return false;
        }
        public abstract float makeClaim(int polNum);
    }

