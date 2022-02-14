package com.exercise.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Clase encargada de generar la ventana principal
 */
public class Window extends JFrame{
    JPanel panel;
    JTextArea textArea;
    JButton btn;
    JScrollPane scroll;

    /** 
     * Constructor de la ventana principal
     */
    public Window(){
        this.setTitle("Principal");
        init();
    }

    /** 
     * Metodo que inicializa los elementos de la ventana principal
     */
    private void init() {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //text area
        textArea = new JTextArea("Area de texto");
        scroll = new JScrollPane(textArea);
        //pos x,y celd Oc x,y estira x,y
        panel.add(scroll, constraints(0,0,2,2,1.0,1.0,GridBagConstraints.BOTH  ,c));

        //evaluate button 
        btn = new JButton("Evaluar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WResum(textArea.getText());
            }

        });

        panel.add(btn, constraints(1,2,1,1,0.0,0.0,GridBagConstraints.NONE,c));




        this.setVisible(true);
        this.add(panel);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Metodo que sirve para definir la posicion y ancho de los elementos de la ventana
     * @param x posicion en x
     * @param y posicion en y
     * @param width numero de celdas que se estira en x
     * @param height numero de celdas que se estira en y
     * @param weightx indica si se estira en x
     * @param weighty indica si se estira en y
     * @param est definimos la direccion en la cual se estira
     * @param c constante g del layout
     * @return el valor de las caracteristicas del elemento
     */
    private GridBagConstraints constraints(int x,int y, int width,int height, double weightx , double weighty, int est ,GridBagConstraints c){
        c.gridx = x; c.gridy = y; c.gridwidth = width; c.gridheight = height; c.weightx = weightx; c.weighty = weighty; c.fill = est;
        return c;
    }

    
}
