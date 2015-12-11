import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ratingTF;

    @FXML
    private TextField m3release;

    @FXML
    private TextField staringTF;

    @FXML
    private Button submit;

    @FXML
    private TextField m1rating;

    @FXML
    private TextField m1title;

    @FXML
    private TextField releaseTF;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField m2rating;

    @FXML
    private TextField m3rating;

    @FXML
    private TextField m3title;

    @FXML
    private TextField directorTF;

    @FXML
    private TextField m1release;

    @FXML
    private TextField m2release;

    @FXML
    private TextField titleTF;

    @FXML
    private TextField m2title;

    public ArrayList<Movie> movieList = new ArrayList<>();
    @FXML
    void initialize() {


        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    Movie m = new Movie();
                    if(titleTF.getText().equals("")){
                        throw new Exception("Test");
                    }
                    if(directorTF.getText().equals("")){
                        throw new Exception("Test");
                    }
                    if(staringTF.getText().equals("")){
                        throw new Exception("Test");
                    }
                    m.setTitle(titleTF.getText());
                    int rating = Integer.parseInt(ratingTF.getText());
                    m.setRating(rating);

                    //System.out.println(releaseTF.getText().substring(6,10));
                    int month = Integer.parseInt(releaseTF.getText().substring(0,2));
                    int day = Integer.parseInt(releaseTF.getText().substring(3,5));
                    int year = Integer.parseInt(releaseTF.getText().substring(6,10));

                    Date release = dateFromInts(year,month,day);
                    m.setReleaseDate(release);
                    m.setDirector(directorTF.getText());
                    m.setStarring(staringTF.getText());

                    statusLabel.setTextFill(Color.web("#00FF00"));
                    statusLabel.setText("Movie Added");

                    movieList.add(m);
                    updateTable();

                }catch (Exception e){
                    statusLabel.setTextFill(Color.web("#FF0000"));
                    statusLabel.setText("Error");
                }
            }
        });

        titleTF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                titleTF.setText(event.toString());
            }
        });

        directorTF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                directorTF.setText(event.toString());
            }
        });
        staringTF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                staringTF.setText(event.toString());
            }
        });
        releaseTF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                releaseTF.setText(event.toString());
            }
        });
        ratingTF.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ratingTF.setText(event.toString());
            }
        });

/*
        assert ratingTF != null : "fx:id=\"ratingTF\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert m3release != null : "fx:id=\"m3release\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert staringTF != null : "fx:id=\"staringTF\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert submit != null : "fx:id=\"submit\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert m1rating != null : "fx:id=\"m1rating\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert m1title != null : "fx:id=\"m1title\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert releaseTF != null : "fx:id=\"releaseTF\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert statusLabel != null : "fx:id=\"statusLabel\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert m2rating != null : "fx:id=\"m2rating\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert m3rating != null : "fx:id=\"m3rating\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert m3title != null : "fx:id=\"m3title\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert directorTF != null : "fx:id=\"directorTF\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert m1release != null : "fx:id=\"m1release\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert m2release != null : "fx:id=\"m2release\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert titleTF != null : "fx:id=\"titleTF\" was not injected: check your FXML file 'Lab12.fxml'.";
        assert m2title != null : "fx:id=\"m2title\" was not injected: check your FXML file 'Lab12.fxml'.";
*/
    }
    public static Date dateFromInts(int year, int month, int day)

    {
        return new Date(year-1900,month-1,day);
    }


    void updateTable(){
        for(int i =0; i<movieList.size(); i++){
            switch (i){
                case 0:
                    m1title.setText(movieList.get(i).title);
                    m1rating.setText(Integer.toString(movieList.get(i).getRating()));
                    Date d = movieList.get(i).getReleaseDate();
                    m1release.setText((d.getYear()+1900) + "-" + d.getMonth() +"-" + d.getDate());
                    break;
                case 1:
                    m2title.setText(movieList.get(i).title);
                    m2rating.setText(Integer.toString(movieList.get(i).getRating()));
                    d = movieList.get(i).getReleaseDate();
                    m2release.setText((d.getYear()+1900) + "-" + d.getMonth() +"-" + d.getDate());
                    break;
                case 2:
                    m3title.setText(movieList.get(i).title);
                    m3rating.setText(Integer.toString(movieList.get(i).getRating()));
                    d = movieList.get(i).getReleaseDate();
                    m3release.setText((d.getYear()+1900) + "-" + d.getMonth() +"-" + d.getDate());
                    break;
            }
        }
    }
}
