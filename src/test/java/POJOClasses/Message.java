package POJOClasses;

public class Message {
	//POJO
	
	/*
	 * Plain old java object
	 * 
	 * Serialization:- Convert Java Object to Request payload
	 * 
	 * Create variables and methods 
	 * create object for that class and pass that object to restassured
	 * body method
	 * 
	 * 
	 */
	
	/*
	 * In POJO Classes ,we have variables as private, methods as public
	 * 
	 * We have setters and getters method, setters method are used in serialization to create payloads 
	 * getters methods are used in deserialization to transform paylods to java objects
	 */
	
	/*
	 * For POJO Classes,for converting to json,we need jackson and gsen libraries
	 * for converting to xml,we need to jaxb libraries
	 * 
	 */

	private String message;
	private String greet;
	public String getMessage()
	{
		return message;
	}
	
	public String getGreet()
	{
		return greet;
	}
	
	public void setMessage(String message)
	{
		this.message=message;
	}
	public void setGreet(String greet)
	{
		this.greet=greet;
	}
}
 class Serialization
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Message m=new Message();
		m.setMessage("I am in restassured");
		m.setGreet("hello");
		
		/*
		 * Now pass this object m in body method in restassured, it will automatically create json
		 */

	}

}
