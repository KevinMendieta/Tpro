/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author kevin
 */
public class Tpro extends JFrame{
    
    //Screen size
    private static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    
    //gui components
    private final Logic controller;
    private JPanel inputPanel, resultPanel, sendPanel;
    
    //resultPanelElements
    private JLabel textLabel, resultLabel;
    
    //inputPanelElements
    private JTextField inputField;
    private JLabel infoLabel;
    
    //sendPanelElements
    private JButton sendButton;
    
    
    public Tpro(){
        controller = new Logic();
        prepareElements();
    }
    
    private void prepareElements(){
        setTitle("Tpro");
        setSize(SCREEN.width/4,SCREEN.height/4);
        center();
        prepareInputElements();
        prepareResultElements();
        prepareSendElements();
        prepareActions();
    }
    
    private void prepareInputElements() {
        inputPanel = new JPanel();
        inputPanel.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10),new TitledBorder("")));
        infoLabel = new JLabel("Valor de n con el que desea calcular: ");
        inputField = new JTextField("3");
        inputPanel.add(infoLabel);inputPanel.add(inputField);
        add(inputPanel,BorderLayout.NORTH);
    }
    
    private void prepareResultElements() {
        resultPanel = new JPanel();
        resultPanel.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10),new TitledBorder("")));
        textLabel = new JLabel("El resultado es: ");
        resultLabel = new JLabel("No se ha asignado n.");
        resultPanel.add(textLabel);resultPanel.add(resultLabel);
        add(resultPanel,BorderLayout.SOUTH);
    }
    
    private void prepareSendElements(){
        sendPanel = new JPanel();
        sendPanel.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10),new TitledBorder("")));
        sendButton = new JButton("calcular");
        sendPanel.add(sendButton);
        add(sendPanel,BorderLayout.CENTER);
    }
    
    private void center(){		
        int xEsquina = (SCREEN.width-getSize().width)/2;
        int yEsquina = (SCREEN.height-getSize().height)/2;		
        setLocation(xEsquina,yEsquina);
    }
    
    private void calculate(){
        try{
            int n = Integer.parseInt(inputField.getText());
            resultLabel.setText(controller.calculate(n)+"");
        }catch(Exception e){
            resultLabel.setText("valor de n no valido");
        }
    }
    
    private void prepareActions(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Para boton Ok de ventana ganar
        sendButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                calculate();
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tpro gui = new Tpro();
        System.out.println("ssd");
        gui.setVisible(true);
    }
}