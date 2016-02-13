package main.java.io.egen.rentalflix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
	
	List<Movie> movie_list = Collections.synchronizedList(new ArrayList<Movie>());
	
	/**
	 * Finds all available movies in the movie store
	 * @return list of movies or empty list
	 */
	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return movie_list;
	}

	/**
	 * Finds all movies in the movie store which contains <strong>name</strong> in the title
	 * @param name String
	 * @return list of movies or empty list
	 */
	@Override
	public List<Movie> findByName(String name) {
		// TODO Auto-generated method stub
		List<Movie> list = Collections.synchronizedList(new ArrayList<Movie>());
		synchronized(movie_list) 
		{
			
		       Iterator<Movie> iterator = movie_list.iterator(); 
		       
		       while (iterator.hasNext())
		       {
		    	   Movie current = iterator.next();
		    	   if(current.getTitle().contains(name))
		    	   {
		    		   list.add(current);
		    	   }
		       }
		}
		
		
		return list;
	}
	/**
	 * Create a new movie in the movie store
	 * @param movie
	 * @return Movie
	 */
	@Override
	public Movie create(Movie movie) {
		// TODO Auto-generated method stub
		movie_list.add(movie);
		
		return movie;
	}

	/**
	 * Update an existing movie
	 * @param movie
	 * @return updated movie or throws <strong>IllegalArgumentException</strong> if movie with this id is not found
	 */
	@Override
	public Movie update(Movie movie) {
		// TODO Auto-generated method stub
		int id = movie.getId();
		synchronized(movie_list) 
		{
		       Iterator<Movie> iterator = movie_list.iterator(); 
		       
		       while (iterator.hasNext())
		       {
		    	   Movie current = iterator.next();
		    	   System.out.println(current.getId());
		    	   if(current.getId() == id)
		    	   {
		    		   System.out.println(current.getId()+" "+id);
		    		   current.setTitle(movie.getTitle());
		    		   current.setLanguage(movie.getLanguage());
		    		   current.setYear(movie.getYear());
		    		   return current;
		    	   }
		       }
		       
		}
		throw new IllegalArgumentException("invalid id");
		
		
	}
	/**
	 * Delete an existing movie 
	 * @param id
	 * @return deleted movie or throws <strong>IllegalArgumentException</strong> if movie with this id is not found
	 */
	@Override
	public Movie delete(int id) {
		// TODO Auto-generated method stub
		synchronized(movie_list) 
		{
		       Iterator<Movie> iterator = movie_list.iterator(); 
		       
		       while (iterator.hasNext())
		       {
		    	   Movie current = iterator.next();
		    	   if(current.getId() == id)
		    	   {
		    		  movie_list.remove(current);
		    		   return current;
		    	   }
		       }
		}
		throw new IllegalArgumentException("invalid id");
	
	}

	/**
	 * Rent the movie with movieId to the <strong>user</strong>.
	 * Make sure this movie is not rented already. 
	 * If it is already rented, throw <strong>IllegalArgumentException</strong>
	 * @param movieId
	 * @param user
	 * @return true: if movie can be rented, false otherwise
	 */
	@Override
	public boolean rentMovie(int movieId, String user) {
		// TODO Auto-generated method stub
		synchronized(movie_list) 
		{
		       Iterator<Movie> iterator = movie_list.iterator(); 
		       
		       while (iterator.hasNext())
		       {
		    	   Movie current = iterator.next();
		    	   if(current.getId() == movieId)
		    	   {
		    		
		    		  boolean isRented = current.getStatus();
		    		   if(isRented == true)
		    		   {
		    			   System.out.println("here");
		    			   throw new IllegalArgumentException("movie already rented");
		    			   
		    		   }
		    		   else
		    		   {
		    			   System.out.println("going here");
		    			   current.setRented();
		    			   current.setUser(user);
		    			   return true;
		    		   }
		    	   }
		       }
		       return false;
		}
		
	
	}

}
