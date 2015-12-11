import java.io.Serializable;
import java.util.*;

public class Movie implements Serializable
{
    String title;
    String director;
    String starring;
    int rating;
    Date releaseDate;

    public Movie(){}

    public Movie(String theTitle, String theDirector, String theStarring, int theRating, Date theRelease)throws PreFilmDate
    {
        checkYear(theRelease.getYear() + 1900);
        title = theTitle;
        director = theDirector;
        starring = theStarring;
        rating = theRating;
        releaseDate = theRelease;
    }

    public void setTitle(String t)
    {
        title = t;
    }

    public void setDirector(String d)
    {
        director = d;
    }

    public void setStarring(String s)
    {
        starring = s;
    }

    public void setRating(int r)
    {
        rating = r;
    }

    public void setReleaseDate(Date da) throws PreFilmDate
    {
        checkYear(da.getYear() + 1900);
        releaseDate = da;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDirector()
    {
        return director;
    }

    public String getStarring()
    {
        return starring;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public int getRating()
    {
        return rating;
    }
    public void checkYear(int year) throws PreFilmDate{
        if(year < 1891)
        {
            throw new PreFilmDate("Cannot have Film before the camera");
        }
    }

}
