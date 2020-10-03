package testDataTypes;

import java.io.Serializable;

public class  Address implements Serializable {

public String streetAddress;
public String city;
public String postCode;
public String state;
public String country;
public String county;

void setvalues(String streetAddress,String city,String postCode,String state,String country,String county)
{
	 this.streetAddress = streetAddress;
	 this.city =city;
	 this.postCode=postCode;
	 this.state =state;
	 this.country=country;
	 this.county =county;
}
public  void getvalues()
{
	System.out.println(this.streetAddress + this.city + this.postCode + this.state + this.country + this.county);
}

}