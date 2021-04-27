//Written by Joshua Harris
public class CompanyClient extends Client {
    String name;
    public CompanyClient(String name){
        super(name);
    }
    public float makeClaim(int polNum){
        if (getPolicy(polNum) == null) {
            return 0f;
        }
        return getPolicy(polNum).handleClaim();

    }
}
