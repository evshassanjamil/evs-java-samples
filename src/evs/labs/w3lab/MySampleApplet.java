package evs.labs.w3lab;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySampleApplet extends Applet implements ActionListener {
    int x = 20;
    int width = 65, height = 20;
    int y = 20, y1 = 25, y2 = 50;
    private Button button1, button2;

    private void initButtons() {

        // Resetting default applet layout manager to null
        setLayout(null);

        //Initialize the buttons and give them names
        button1 = new Button("Button1");
        button2 = new Button("Button2");

        //add the buttons to the applet
        add(button1);
        add(button2);

        //Position Buttons(X, Y, Width, Height);
        button1.setBounds(x, y1, width, height);
        button2.setBounds(x, y2, width, height);

        //Make a new method that "listens" for the button press
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    /**
     * JavaDocs available in hyperlink {@link Applet#paint(Graphics)}
     */
    @Override
    public void paint(Graphics g) {
        // Drawing String in applet
        g.drawString("Hello World", x, y);
    }

    /*
     * BUTTON LISTENER CALLBACK METHOD
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1)
            System.out.println("Button1 pressed");
        else
            System.out.println("Button2 pressed");
    }

    /*
     * APPLET LIFECYCLE METHODS
     */
    @Override
    public void init() {
        super.init();
        System.out.println("Applet initiated");
        initButtons();
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Applet started");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("Applet stopped");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.print("Applet destroyed");
    }
}
