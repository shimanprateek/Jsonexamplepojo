import java.io.*;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import testDataTypes.Address;
import testDataTypes.Customer;

public class Mazedarmain {

	private static List<Customer> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			FileReader fn = new FileReader(new File("C:\\\\Users\\shima\\workspace\\JsonMazedar\\testDataResources\\Customer.json"));
			bufferReader = new BufferedReader(fn);
			Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
			return Arrays.asList(customers);
			
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : ");
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
	
	public static  Object  deserialize_object (Object Obj,String Classname) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		FileOutputStream  fout = new FileOutputStream("f.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		
		out.writeObject(Obj);
		out.flush();
		System.out.println("success");
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
		Class<?> c = Class.forName(Classname);
		Object o = c.newInstance();
		o =  in.readObject();
		return o;
		//System.out.println(s.streetAddress + ":" + s.city);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		List <Customer> list = Mazedarmain.getCustomerData();
		for(Customer c : list)
		{
			System.out.println("------------------------------------------");
			System.out.println(c.firstName);
			System.out.println(c.lastName);
			System.out.println(c.emailAddress);
			System.out.println(c.age);
			System.out.println(c.address);
			Address Obj1 = c.address;
			Obj1.getvalues();
			Address Obj = (Address) deserialize_object (c.address,"testDataTypes.Address");
			System.out.println(Obj.city + " : " +Obj.country);
			System.out.println(c.phoneNumber);
			System.out.println("------------------------------------------");
		
			}
}

}