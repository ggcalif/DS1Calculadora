package br.facet.cesarmarcon.calc.controller;

import java.awt.Dimension;
import br.facet.cesarmarcon.calc.model.cModel;
import br.facet.cesarmarcon.calc.view.MainWindow;

/** @author ggCalif Conexão entre controller e model **/
public class cController
{
    /** void main, seta as configuração de tela
     * @param args parametro padrao */
    public static void main(String[] args)
    {
        MainWindow window = new MainWindow();
        window.setVisible(true);
        window.setMinimumSize(new Dimension(600, 500));
        window.setMaximumSize(new Dimension(800, 600));
        window.setLocationRelativeTo(null);
        MainWindow.Carregar();
    }
}