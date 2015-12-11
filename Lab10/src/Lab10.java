
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import java.util.*;


public class Lab10
{

    public static void main(String[] args)throws PreFilmDate, IOException,ClassNotFoundException,FileNotFoundException{
        ArrayList<Movie> movies = new ArrayList<>();
        Movie matrix, shawshank, starWarsVII;
        try {
            matrix = new Movie("Matrix", "Wachowski Brothers", "Keanu Reeves, Carrie-Anne Moss, Laurence Fishburne", 5, dateFromInts(1799, 3, 31));
        }catch (PreFilmDate e){
            System.out.println(e.getMessage());
        }
        matrix = new Movie("Matrix", "Wachowski Brothers", "Keanu Reeves, Carrie-Anne Moss, Laurence Fishburne", 5, dateFromInts(1999,3,31));
        shawshank = new Movie("The Shawshank Redemption", "Frank Darabont", "Tim Robbins, Morgan Freeman", 5, dateFromInts(1994,10,14));
        addMovie(movies, matrix);
        addMovie(movies, shawshank);
        starWarsVII = new Movie();
        starWarsVII.setTitle("Star Wars: The Force Awakens");
        starWarsVII.setDirector("J.J. Abrams");
        starWarsVII.setStarring("Harrison Ford, Carrie Fisher");
        starWarsVII.setRating(4);
        try {
            starWarsVII.setReleaseDate(dateFromInts(1015, 12, 18));
            addMovie(movies, starWarsVII);
        }catch (PreFilmDate e ){
            System.out.println(e.getMessage());
        }
        starWarsVII = new Movie();
        starWarsVII.setTitle("Star Wars: The Force Awakens");
        starWarsVII.setDirector("J.J. Abrams");
        starWarsVII.setStarring("Harrison Ford, Carrie Fisher");
        starWarsVII.setRating(4);
        starWarsVII.setReleaseDate(dateFromInts(2015,12,18));
        addMovie(movies, starWarsVII);


        //Add a few more movies to the movies ArrayList so you have at least 8


        System.out.println("------Original Movie Array sorted by Title--------");
        printMv(movies);

        writeMv(movies, "MovieTitle.dat");

        readMv("BadFile.dat", movies.size());

        readMv("MovieTitle.dat", movies.size());

    }
    public static void writeMv(ArrayList<Movie> m, String filename)throws IOException{
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(m);
        }catch (IOException e){
            System.out.println(e);
            return;
        }


    }

    public static void readMv(String filename, int size)throws  FileNotFoundException, IOException, ClassNotFoundException{
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            ArrayList<Movie> m = (ArrayList<Movie>) ois.readObject();
            printMv(m);
        }catch (FileNotFoundException e ){
            System.out.println(e);
        }
    }













    public static void addMovie(ArrayList<Movie> movies, Movie movieAdded)
    {
        for(int i =0; i < movies.size(); i++)
        {
            if(movieAdded.getTitle().compareTo(movies.get(i).getTitle())<0)
            {
                movies.add(i, movieAdded);
                return;
            }

        }
        movies.add(movieAdded);
    }

    public static void removeMovie(ArrayList<Movie> Movie, Movie m)
    {
        Movie.remove(m);
    }

    public static void printMv(ArrayList<Movie> movies)
    {
        for(int i = 0; i < movies.size(); i++)
        {
            printMovieInfo(movies.get(i));
        }
    }

    public static long daysSinceRelease(Movie m)
    {

        long rd = m.getReleaseDate().getTime();
        long current = System.currentTimeMillis();
        long difference = current - rd;
        long days = difference * 2880000;
        return days;
        //Use System.currentTimeMillis() to get the current time in milliseconds, m.getRelease().getTime() to get the movie release date in milliseconds.
        //Remember that a millisecond is 1/1000 of a second.
    }

    public static String movieDayOfTheWeek(Movie m)
    {
        int day = m.getReleaseDate().getDay();
        if (day == 0)
        {
            String theDay = "Sunday";
            return theDay;
        }
        if (day == 1)
        {
            String theDay = "Monday";
            return theDay;
        }
        if (day == 2)
        {
            String theDay = "Tuesday";
            return theDay;
        }
        if (day == 3)
        {
            String theDay = "Wednesday";
            return theDay;
        }
        if (day == 4)
        {
            String theDay = "Thursday";
            return theDay;
        }
        if (day == 5)
        {
            String theDay = "Friday";
            return theDay;
        }
        if (day == 6)
        {
            String theDay = "Saturday";
            return theDay;
        }
        return "";

    }

    public static Date dateFromInts(int year, int month, int day)
    {
        return new Date(year-1900,month-1,day);
    }

    public static void printMovieInfo(Movie m)
    {
        System.out.print(m.getTitle() + " stars " + m.getStarring() + " and is directed by " + m.getDirector() + " with a rating of " + m.getRating() + " stars released on " +  movieDayOfTheWeek(m) + " " + (m.getReleaseDate().getYear() + 1900) + "-" + (m.getReleaseDate().getMonth() + 1) + "-" + m.getReleaseDate().getDate() + " ");
        long daysSince = daysSinceRelease(m);
        if(daysSince < 0){
            daysSince*=-1;
            System.out.println(" "+ daysSince +" days from now." );
        }
        else{
            System.out.println(" "+ daysSince +" days ago." );
        }

    }
}
	
	
	
	
	
	
	
	
	