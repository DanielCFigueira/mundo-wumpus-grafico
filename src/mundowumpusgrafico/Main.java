package mundowumpusgrafico;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args){
        Mundo mundo = new Mundo();
        AgenteInteligente agente = new  AgenteInteligente();
        
        SwingUtilities.invokeLater(() -> {
            JanelaJogo janela = new JanelaJogo(mundo, agente);
            janela.setVisible(true);
        });
    }
}