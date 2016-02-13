package test.java.io.egen.rentalflix;

import static org.junit.Assert.*;

import java.util.List;

import main.java.io.egen.rentalflix.Movie;
import main.java.io.egen.rentalflix.MovieService;

import org.junit.*;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {
	
	private MovieService movieService = new MovieService();
			Movie movie; Movie newMovie; Movie movie1;
	@Before
	 public void set()
	{
		 movie = new Movie();
		 movie.setId(1);
		 movie.setTitle("Harry Potter");
		 movie.setLanguage("English");
		 movie.setYear(2008);
		 movieService.create(movie);
		 
	}
	
	 @Test
	 public void EmptyCollection() 
	 {
		 List<Movie> list = movieService.findAll();
		 assertFalse(list.isEmpty());
	     System.out.println("@Test: EmptyArrayList");
	 }
	 
	 @Test
	 public void testCreateMovie() 
	 {
		
		 List<Movie> list = movieService.findByName("Harry Potter");
		 /* Check that the list is not empty */
		 assertFalse(list.isEmpty());
		
	 }

	 @Test
	 public void testUpdateMovie() 
	 {
		 newMovie = new Movie();
		 newMovie.setId(1);
		 newMovie.setTitle("Kung Fu Panda");
		 newMovie.setLanguage("English");
		 newMovie.setYear(2010);
		 Movie updated = movieService.update(newMovie);
		 assertEquals(updated.getTitle(),"Kung Fu Panda");
		 assertEquals(updated.getYear(),2010);
		
	 }
	 
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testDeleteMovie() 
	 {
		  movieService.delete(5);
		
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void testRentMovie() 
	 {
		  movieService.rentMovie(1, "Bhavya Chauhan");
		  movieService.rentMovie(1, "Rashi");
		
	 }
	 

}
