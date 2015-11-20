import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Lab11 extends Applet {
    int position;
    Timer t;
    int speed =30;
    Button b;
    TextField tf;
    boolean movingRight = true;
    public void init(){

        //Create your timer, button and text field
        //associate the appropriate object to the appropriate action listener
        //Add the text field and button to the screen
    }
    public void paint(Graphics g) {

        //Create your circle using g.fillOval(xpos,ypos,width,height)
    }

    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //If you reach one end of the panel, switch directions and start moving to the other end
            //End by repainting


        }
    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //Take the value from your textfield (tf.getText()) convert it to an int, stop your old
            // timer create a new timer with the new int value start your new timer

        }
    }
    private class TFListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //Set the value of your Text fields text (tf.setText()) to e.getActionCommand()

        }
    }
}
