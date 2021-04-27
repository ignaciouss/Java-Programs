//Written by Joshua HArris
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class ExpiringPolicy extends Policy {
    private Date expiryDate;
    private SimpleDateFormat simpleDate = new SimpleDateFormat("MMMM dd,yyyy (hh:mma)");


    public ExpiringPolicy(float amt,Date expdate){
        super(amt);
        expiryDate = expdate;
    }
    public ExpiringPolicy(float amt){
        super(amt);
        GregorianCalendar aCalendar = new GregorianCalendar();
        aCalendar.add(Calendar.YEAR,1);
        expiryDate = aCalendar.getTime();
    }
    public Date getExpiryDate(){return expiryDate;}

    public String toString(){
        if(this.isExpired()) {
            return "Expiring" +super.toString() + " expires on: " + simpleDate.format(getExpiryDate());
        }
        return ("Expiring" +super.toString()+ " expires: " + simpleDate.format(getExpiryDate()));
    }
    public boolean isExpired(){
        if (new Date().after(expiryDate) || new Date().equals(expiryDate)){
            return true;
        }
        return false;
    }
    public float handleClaim(){
        if (isExpired() == false){
            return getAmount();
        }
        return 0;
    }
}
