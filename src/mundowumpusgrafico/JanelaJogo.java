/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundowumpusgrafico;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Lased
 */
public class JanelaJogo extends JFrame {
    
    private final PainelMapa painelMapa;
    
    public JanelaJogo(Mundo mundo, AgenteInteligente agente){
        setTitle("Mundo de Wumpus - Interface Gráfica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        painelMapa = new PainelMapa(mundo, agente);
        add(painelMapa, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
    }   
}