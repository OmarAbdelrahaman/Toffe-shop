import java.util.*;
public class Payment {
    private static int paymentid = 0;
    private String phonenumber ;
    private String Address ;
    private double total ;
    Payment(){
        ++paymentid;
    }
    public Payment(String phn,String name, double price){
        this.phonenumber = phn;
        this.Address = name;
        this.total = price;
    }

    public void setPhonenumber(String name) {
        this.phonenumber = name;
    }
    public void setAddress(String name) {
        this.Address = name;
    }
    public void setTotal(double name) {this.total = name; }
    public String getaddress(){return Address;}

  public void end(){
      System.out.println("thank you for using our shop\n payment id: " + paymentid + "\nTotal Price has been paid: "
                        + total + "\nAddress you choose " + getaddress() + "\nwe hope to see you later \n");
  }


}
