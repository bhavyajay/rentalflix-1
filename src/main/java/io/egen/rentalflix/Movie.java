package main.java.io.egen.rentalflix;

/**
 * Entity representing a movie.
 * Fields: id, title, year, language
 */
public class Movie {
	//POJO IMPLEMENTATION GOES HERE
	
	static int id;
	static String title;
	static int year;
	static String language;
	static boolean rented = false;
	static String user;
	
	public void setId(int newid){id = newid;}
	public int getId(){return id;}
  
	public void setTitle(String newTitle){title = newTitle;}
	public String getTitle(){return title;}
  
	public void setYear(int newYear){year = newYear;}
	public int getYear(){return year;}

	public void setLanguage(String newLanguage){language = newLanguage;}
	public String getLanguage(){return language;}
	
	public void setRented(){rented = true;}
	public boolean getStatus(){return rented;}
	
	public void setUser(String userName){user = userName;}
	public String getuser(){return user;}
	  
	
}
