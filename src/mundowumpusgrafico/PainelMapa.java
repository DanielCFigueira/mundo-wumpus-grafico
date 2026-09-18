/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundowumpusgrafico;

import java.awt.*;
import javax.swing.*;

/**
 * PainelMapa — camada de VISÃO do jogo.
 *
 * Contrato de leitura com o Model (Mundo + AgenteInteligente).
 * Esta classe NUNCA chama métodos que alterem o estado do jogo
 * (marcarVisitada, alterarPontuacao, morrer, etc.) — apenas os
 * getters de leitura abaixo:
 *
 * Mundo:
 *   estaDentroDoMapa(linha, coluna) -> boolean
 *   getElemento(linha, coluna)      -> char   (só se estaVisitada ou revelarTudo)
 *   estaVisitada(linha, coluna)     -> boolean
 *   temBrisa(linha, coluna)         -> boolean
 *   temFedor(linha, coluna)         -> boolean
 *   TAMANHO, VAZIO, POCO, WUMPUS, OURO -> constantes públicas
 *
 * AgenteInteligente:
 *   getLinha() / getColuna()            -> int
 *   getQuantidadeDeMovimentos()         -> int
 *   getPontuacao()                      -> int
 *   estaVivo()                          -> boolean
 *   possuiOuro() / possuiFlecha()       -> boolean
 */

/**
 *
 * @author Lased
 */
public class PainelMapa extends JPanel {
    
    private static final int TAMANHO_CELULA = 72;
    private static final int MARGEM_ESQ = 40; // espaço p/ números de linha
    private static final int MARGEM_SUP = 40; // espaço p/ números de coluna
    
    private final Mundo mundo;
    private final AgenteInteligente agente;
    private boolean revelarTudo = false; // só vira true na Fase 4
    
    public PainelMapa(Mundo mundo, AgenteInteligente agente) {
        this.mundo = mundo;
        this.agente = agente;
        int lado = Mundo.TAMANHO * TAMANHO_CELULA;
        setPreferredSize(new Dimension(lado + MARGEM_ESQ, lado + MARGEM_SUP));
        setBackground(Color.WHITE);
    }
    
    public void setRevelarTudo(boolean revelarTudo){
        this.revelarTudo = revelarTudo;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        desenharCabecalhos(g2);
        desenharGrade(g2);
        // desenharElementos(g2); // entra na Fase 2 (Etapa 2)
    }
    
    private void  desenharCabecalhos(Graphics2D g2){
        g2.setColor(Color.BLACK);
        for (int coluna = 0; coluna < Mundo.TAMANHO; coluna++){
            int x = MARGEM_ESQ + coluna * TAMANHO_CELULA + TAMANHO_CELULA / 2 -4;
            g2.drawString(String.valueOf(coluna), x, MARGEM_SUP - 10);
        }
        for (int linha = 0; linha < Mundo.TAMANHO; linha++){
            int y = MARGEM_SUP + linha * TAMANHO_CELULA + TAMANHO_CELULA / 2 - 4;
            g2.drawString(String.valueOf(linha), MARGEM_ESQ - 20, y);
        }
    }
    
    private void desenharGrade(Graphics2D g2){
        g2.setColor(Color.LIGHT_GRAY);
        int lado = Mundo.TAMANHO * TAMANHO_CELULA;
        
        for (int i = 0; i <= Mundo.TAMANHO; i++){
            g2.drawLine(MARGEM_ESQ + i * TAMANHO_CELULA, MARGEM_SUP,
                    MARGEM_ESQ + i * TAMANHO_CELULA, MARGEM_SUP + lado);
            g2.drawLine(MARGEM_ESQ, MARGEM_SUP + i * TAMANHO_CELULA,
                    MARGEM_ESQ + lado, MARGEM_SUP + i * TAMANHO_CELULA);
        }
    }
}
