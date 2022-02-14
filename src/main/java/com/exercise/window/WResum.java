package com.exercise.window;

import javax.swing.*;

import com.exercise.analizador.Analizador;

import java.awt.*;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;


/**
 * Clase encargada de generar la ventana principal
 */
public class WResum extends JFrame{
    JPanel panel;
    JTextArea textArea;
    String textIn;
    JButton btn;

    /** 
     * Constructor de la ventana principal
     */
    Reader reader;
    public WResum(String textIn){
        this.setTitle("Resumen");
        this.textIn = textIn;
        init();
    }

    /** 
     * Metodo que inicializa los elementos de la ventana principal
     */
    private void init() {
        reader = new StringReader(textIn);
        Analizador analizador = new Analizador(reader);
		try {
			int salida = analizador.yylex();
            while(salida != Analizador.YYEOF){
                analizador.yylex();
    
            }
            System.out.println( "contador: "+ Analizador.getContador()  ); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
            System.out.println("Atrape el error");
		}
        
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //text area
        textArea = new JTextArea("");
        //pos x,y celd Oc x,y estira x,y
        panel.add(textArea, constraints(0,0,2,2,1.0,1.0,GridBagConstraints.BOTH  ,c));

        /*
        //evaluate button 
        btn = new JButton("Evaluar");
        panel.add(btn, constraints(1,2,1,1,0.0,0.0,GridBagConstraints.NONE,c));
        //panel.add(btn, c);
        */


        this.setVisible(true);
        this.add(panel);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
