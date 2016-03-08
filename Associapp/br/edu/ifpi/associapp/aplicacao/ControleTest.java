package br.edu.ifpi.associapp.aplicacao;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControleTest extends JFrame{

	JButton cancelar = new JButton("Cancelar");  
    JButton ok = new JButton("ok");  
    JTextField nome = new JTextField();  
    JTextField tipo = new JTextField(); 
    JTextField idade = new JTextField(); 

    public ControleTest (){  


        super("Janela de Teste de controle");  

        Container c = getContentPane();  

        c.setLayout(new GridLayout(4,2));  
        c.add(new JLabel ("Nome:"));  
        c.add(nome);  

        c.add(new JLabel ("Tipo: "));  
        c.add(tipo);  
        
        c.add(new JLabel ("idade: "));  
        c.add(idade);  

        c.add(ok);// add o botão ok no conteiner  
        c.add(cancelar);// add o botão cancelar no conteiner  




        setSize(300,150);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }



    public static void main(String[] args) {


        new ControleTest();
    }


	
}
