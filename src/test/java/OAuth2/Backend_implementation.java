package OAuth2;

public class Backend_implementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * Why Application rely on third party services like google or facebook for authentication?
		 * 
		 * No data breach headaches
		 * No need to maintain user profile data
		 */
		
		
		//---------------------------------------------------------------------
		
		
		/*
		 * Client is BookmyShow
		 * now client needs to register itself with google to host google authentication in their services
		 * then after google approves it,google will provide client id and client secret id 
		 * 
		 * When i click sign in with google ,I am giving permission to google to share my user profile(not password)
		 * with the client(Eg BookMyShow)
		 * 
		 */
		
		//----------------------------------------------------------------------------
		
		/*
		 * User will sign in to google authorization server and then google will check if u are actually authenticated user or not
		 * If you are successfully signed in ,then google will sent the code back to bookmyshow
		 * 
		 * We have two servers----1)Authorization server---this will authorize the user after user signs in to make sure he is existing user or not(if his account exxists in google/facebook or not)
		 * 2)Resource Server------Now client(bookmyshow) needs user profile data which is in Google Resources server
		 * now, bookmyshow received code from authorization server ,now client(bookmyshow) will
		 * hit the google resource server with code and client secret id and client id,it will receive that code and 
		 * it will validate that code that if it is generated from google only
		 * after that it will see with with user profile data that code is attached
		 * then google will return accesstoken, and other details that client had asked for(suppose first name last name etc)
		 * 
		 * This Accesstoken is set back to client(bookmyshow) and it is stored in browser cookie
		 * now what all operations u make on this client(bookmyshow) this access token will be attatched
		 * 
		 * 
		 * If accesstoken expires,then u have to sign in again
		 * 
		 */
	}

}
