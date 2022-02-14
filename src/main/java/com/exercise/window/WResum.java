package com.exercise.window;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    DefaultTableModel model;
    JTable table;
    Analizador analizador;






    /** 
     * Constructor de la ventana principal
     */
    Reader reader;
    public WResum(JTextArea textArea){
        this.setTitle("Resumen");
        this.textArea = textArea;
        init();
    }





    /** 
     * Metodo que inicializa los elementos de la ventana principal, asi como el analizador 
     */
    private void init() {
        String [] nameRows = {"Col1", "Col2"};
        model = new DefaultTableModel(nameRows,0);
        setData("Tipo","Cantidad",model);
        reader = new StringReader(textArea.getText());
        System.out.println("reader"+ textArea.getText());
        table = new JTable(model);
        analizador = new Analizador(reader);
		try {
			int salida = analizador.yylex();
            while(salida != Analizador.YYEOF){
                analizador.yylex();
    
            }
            //Aqui se imprimen los datos en el text area
            setData("1 vocal","Cantidad"+ analizador.getOneVowel()+"" ,model);
            setData("2 vocales","Cantidad"+ analizador.getTwoVowel()+"" ,model);
            setData("3 vocales","Cantidad" +analizador.getThreeVowel()+"",model);
            setData("4 vocales","Cantidad"+analizador.getFourVowel()+"",model);
            setData("5 vocales","Cantidad"+analizador.getFiveVowel()+"",model);
            for(int i=0; i< analizador.getPosDigits().size(); i++){
                setData("numero en pos: ", analizador.getPosDigits().get(i), model);
            }
		} catch (IOException e1) {
			e1.printStackTrace();
            System.out.println("Atrape el error");
		}
        
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(table);


        this.setVisible(true);
        this.add(panel);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }






    private void setData(String tipo, String cantidad, DefaultTableModel model){
        model.addRow(new Object[]{tipo, cantidad});
    }
}
