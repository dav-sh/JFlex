package com.exercise.window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    JPanel panel;
    JTextArea textArea;
    JButton btn;
    public Window(){
        
        init();
    }

    private void init() {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //text area
        textArea = new JTextArea("Area de texto");
        //pos x,y celd Oc x,y estira x,y
        panel.add(textArea, constraints(0,0,2,2,1.0,1.0,GridBagConstraints.BOTH  ,c));

        //evaluate button 
        btn = new JButton("Evaluar");
        panel.add(btn, constraints(1,2,1,1,0.0,0.0,GridBagConstraints.NONE,c));
        //panel.add(btn, c);



        this.setVisible(true);
        this.add(panel);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private GridBagConstraints constraints(int x,int y, int width,int height, double weightx , double weighty, int est ,GridBagConstraints c){
        c.gridx = x; c.gridy = y; c.gridwidth = width; c.gridheight = height; c.weightx = weightx; c.weighty = weighty; c.fill = est;
        return c;
    }
}
