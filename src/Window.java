import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.File;

public class Window extends JFrame implements KeyListener {

    private static BufferStrategy BufferStrat;
    private int Xcord = 400;
    private int Ycord = 300;
    private static Window frame;

    public Window(){
        setTitle("Example Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true);
        addKeyListener(this);
        requestFocusInWindow();
        setVisible(true);


    }


    public static void main(Window Window){
//        frame = Window;
//        frame.setVisible(true);
//        frame.createBufferStrategy(2);
//        BufferStrat = Window.getBufferStrategy();


    }



    @Override
    public void keyTyped(KeyEvent e) {

        // Your keyTyped method implementation
    }

    @Override
    public void keyPressed(KeyEvent e) {

        moveDot(e);
        // Your keyPressed method implementation
    }

    @Override
    public void keyReleased(KeyEvent e) {

        // Your keyReleased method implementation
    }

    private void moveDot(KeyEvent e) {

        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                Ycord = Ycord - 10;
                break;
            case KeyEvent.VK_DOWN:
                Ycord = Ycord + 10;
                break;
            case KeyEvent.VK_LEFT:
                Xcord = Xcord - 10;
                break;
            case KeyEvent.VK_RIGHT:
                Xcord = Xcord + 10;
                break;
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        createBufferStrategy(2);
        BufferStrat = getBufferStrategy();
        Graphics secondFrame;

        do {
            //this defines another un-viewable frame, Items are then drawn into this frame.
            secondFrame = (Graphics2D) BufferStrat.getDrawGraphics();
            try {
                // Put all the draw functions here to draw into the secondframe
                setBackground(Color.WHITE);
                secondFrame.fillRect(Xcord, Ycord, 20, 20);
            } finally {
                //shows what was drawn in the buffer frame and then disposes of that frame.
                BufferStrat.show();
                secondFrame.dispose();
            }

            //BufferFrames sometimes get lost, this Protects that
        } while (BufferStrat.contentsLost()) ;


    }






}

