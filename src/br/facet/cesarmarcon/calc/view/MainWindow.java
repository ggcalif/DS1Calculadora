package br.facet.cesarmarcon.calc.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import java.awt.SystemColor;
import javax.swing.UIManager;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.io.FileHandler;
import br.facet.cesarmarcon.calc.controller.cController;
import br.facet.cesarmarcon.calc.model.cModel;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JList;
import java.awt.GridLayout;

/** @author ggCalif MainWindow responsável pela tela grafica e salvamento dos
 *         resultados anteriores **/
public class MainWindow extends JFrame
{
    ///##### VARIAVEIS WINDOWS BUILDER ##################
    private static JTextField caixaDeSaida;
    private static JTextField caixaDeEntrada;
    //////////////////////////////////////////////////////
    ///############ VARIAVEIS PARA CALCULOS ##############
    static String entrada = "";
    static String entradaNum = "";
    static String ultimoOperado = "";
    static double resultado;
    static double operador;
    static double operando;
    static boolean operadorB = false;
    static boolean igualChamou = false;
    static boolean limparSeApaertaNumeros = false;
    static boolean calcular = false;
    static boolean operações = true;
    private static NumberFormat formatarDoubleCalcauladora = new DecimalFormat("###.###");
    private static DefaultListModel<String> modelListadeNumeros = new DefaultListModel<String>();
    JPanel panelCalc = new JPanel();
    JPanel panelFormatCalc = new JPanel();
    public cController Ccalc = new cController();
    public cModel Mcalc = new cModel();
    ////////////////////////////////////////////////////////////
    
    /** Base principal da class, pois seta todos os paramentros da class. Ex:
     * Botões numericos, botões operadores, salvar arquivos, */
    public MainWindow()
    {
        setTitle("CALCULADORA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        JMenuItem menuCarregar = new JMenuItem("Carregar");
        mnFile.add(menuCarregar);
        JMenuItem menuSalvar = new JMenuItem("Salvar");
        mnFile.add(menuSalvar);
        JMenuItem menuExit = new JMenuItem("Exit");
        mnFile.add(menuExit);
        menuSalvar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Salvar();
            }
        });
        menuExit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sair();
            }
        });
        menuCarregar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Carregar();
            }
        });
        // ------------------------------------------------------ painel principal ( ABAS)
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        // ------------------------------------------------------ configuração painel calculadora cientifica
        tabbedPane.addTab("Calculadora", null, panelCalc, null);
        panelCalc.setLayout(new BorderLayout(0, 0));
        panelCalc.add(panelFormatCalc, BorderLayout.CENTER);
        panelFormatCalc.setBackground(Color.WHITE);
        panelFormatCalc.setLayout(new MigLayout("", "[71px][71px][71px][71px][71px][71px]", "[35px][35px][35px][35px][35px][35px]"));
        // ------------------------------------------------------ textfield calc
        caixaDeSaida = new JTextField();
        caixaDeSaida.setFont(new Font("Tahoma", Font.BOLD, 14));
        caixaDeSaida.setBackground(Color.WHITE);
        caixaDeSaida.setEditable(false);
        caixaDeSaida.setHorizontalAlignment(SwingConstants.RIGHT);
        panelFormatCalc.add(caixaDeSaida, "cell 0 0 4 1,grow");
        caixaDeSaida.setColumns(10);
        JButton btn7 = new JButton("7");
        btn7.setFont(new Font("Consolas", Font.BOLD, 13));
        btn7.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (limparSeApaertaNumeros)
                {
                    resultado = 0;
                    operador = 0;
                    caixaDeSaida.setText("");
                    caixaDeEntrada.setText("");
                    entradaNum = "";
                    entrada = "";
                    operadorB = false;
                    limparSeApaertaNumeros = false;
                }
                caixaDeEntrada.setText(entradaNum += "7");
            }
        });
        caixaDeEntrada = new JTextField();
        caixaDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 16));
        caixaDeEntrada.setForeground(Color.BLACK);
        caixaDeEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
        caixaDeEntrada.setColumns(10);
        panelFormatCalc.add(caixaDeEntrada, "cell 0 1 4 1,grow");
        panelFormatCalc.add(btn7, "cell 0 2,grow");
        JButton btn8 = new JButton("8");
        btn8.setFont(new Font("Consolas", Font.BOLD, 13));
        btn8.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (limparSeApaertaNumeros)
                {
                    resultado = 0;
                    operador = 0;
                    caixaDeSaida.setText("");
                    caixaDeEntrada.setText("");
                    entradaNum = "";
                    entrada = "";
                    operadorB = false;
                    limparSeApaertaNumeros = false;
                }
                //caixaDeSaida.setText(entrada+="8");
                caixaDeEntrada.setText(entradaNum += "8");
            }
        });
        panelFormatCalc.add(btn8, "cell 1 2,grow");
        JButton btn9 = new JButton("9");
        btn9.setFont(new Font("Consolas", Font.BOLD, 13));
        btn9.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (limparSeApaertaNumeros)
                {
                    resultado = 0;
                    operador = 0;
                    caixaDeSaida.setText("");
                    caixaDeEntrada.setText("");
                    entradaNum = "";
                    entrada = "";
                    operadorB = false;
                    limparSeApaertaNumeros = false;
                }
                caixaDeEntrada.setText(entradaNum += "9");
            }
        });
        panelFormatCalc.add(btn9, "cell 2 2,grow");
        JButton btn4 = new JButton("4");
        btn4.setFont(new Font("Consolas", Font.BOLD, 13));
        btn4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (limparSeApaertaNumeros)
                {
                    resultado = 0;
                    operador = 0;
                    caixaDeSaida.setText("");
                    caixaDeEntrada.setText("");
                    entradaNum = "";
                    entrada = "";
                    operadorB = false;
                    limparSeApaertaNumeros = false;
                }
                caixaDeEntrada.setText(entradaNum += "4");
            }
        });
        JButton btnDividir_1 = new JButton("/");
        btnDividir_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnDividir_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                botaoDividir();
            }
        });
        panelFormatCalc.add(btnDividir_1, "cell 3 2,grow");
        panelFormatCalc.add(btn4, "cell 0 3,grow");
        JButton btn5 = new JButton("5");
        btn5.setFont(new Font("Consolas", Font.BOLD, 13));
        btn5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (limparSeApaertaNumeros)
                {
                    resultado = 0;
                    operador = 0;
                    caixaDeSaida.setText("");
                    caixaDeEntrada.setText("");
                    entradaNum = "";
                    entrada = "";
                    operadorB = false;
                    limparSeApaertaNumeros = false;
                }
                caixaDeEntrada.setText(entradaNum += "5");
            }
        });
        panelFormatCalc.add(btn5, "cell 1 3,grow");
        JButton btn6 = new JButton("6");
        btn6.setFont(new Font("Consolas", Font.BOLD, 13));
        btn6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (limparSeApaertaNumeros)
                {
                    resultado = 0;
                    operador = 0;
                    caixaDeSaida.setText("");
                    caixaDeEntrada.setText("");
                    entradaNum = "";
                    entrada = "";
                    operadorB = false;
                    limparSeApaertaNumeros = false;
                }
                caixaDeEntrada.setText(entradaNum += "6");
            }
        });
        panelFormatCalc.add(btn6, "cell 2 3,grow");
        JButton btn1 = new JButton("1");
        btn1.setFont(new Font("Consolas", Font.BOLD, 13));
        btn1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (limparSeApaertaNumeros)
                {
                    resultado = 0;
                    operador = 0;
                    caixaDeSaida.setText("");
                    caixaDeEntrada.setText("");
                    entradaNum = "";
                    entrada = "";
                    operadorB = false;
                    limparSeApaertaNumeros = false;
                }
                caixaDeEntrada.setText(entradaNum += "1");
            }
        });
        JButton btnMulti_1 = new JButton("x");
        btnMulti_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnMulti_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                botaoVezes();
            }
        });
        panelFormatCalc.add(btnMulti_1, "cell 3 3,grow");
        panelFormatCalc.add(btn1, "cell 0 4,grow");
        JButton btn2 = new JButton("2");
        btn2.setFont(new Font("Consolas", Font.BOLD, 13));
        btn2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (limparSeApaertaNumeros)
                {
                    resultado = 0;
                    operador = 0;
                    caixaDeSaida.setText("");
                    caixaDeEntrada.setText("");
                    entradaNum = "";
                    entrada = "";
                    operadorB = false;
                    limparSeApaertaNumeros = false;
                }
                caixaDeEntrada.setText(entradaNum += "2");
            }
        });
        panelFormatCalc.add(btn2, "cell 1 4,grow");
        JButton btn3 = new JButton("3");
        btn3.setFont(new Font("Consolas", Font.BOLD, 13));
        btn3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (limparSeApaertaNumeros)
                {
                    resultado = 0;
                    operador = 0;
                    caixaDeSaida.setText("");
                    caixaDeEntrada.setText("");
                    entradaNum = "";
                    entrada = "";
                    operadorB = false;
                    limparSeApaertaNumeros = false;
                }
                caixaDeEntrada.setText(entradaNum += "3");
            }
        });
        panelFormatCalc.add(btn3, "cell 2 4,grow");
        JButton btn0 = new JButton("0");
        btn0.setFont(new Font("Consolas", Font.BOLD, 13));
        btn0.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (limparSeApaertaNumeros)
                {
                    resultado = 0;
                    operador = 0;
                    caixaDeSaida.setText("");
                    caixaDeEntrada.setText("");
                    entradaNum = "";
                    entrada = "";
                    operadorB = false;
                    limparSeApaertaNumeros = false;
                }
                caixaDeEntrada.setText(entradaNum += "0");
            }
        });
        JButton btnSubt_1 = new JButton("-");
        btnSubt_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSubt_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                botaoMenos();
            }
        });
        panelFormatCalc.add(btnSubt_1, "cell 3 4,grow");
        JButton btnCE_1 = new JButton("CE");
        btnCE_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCE_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                caixaDeEntrada.setText(entradaNum = "");
            }
        });
        panelFormatCalc.add(btnCE_1, "cell 0 5,grow");
        panelFormatCalc.add(btn0, "cell 1 5,grow");
        JButton btnIgual = new JButton("=");
        btnIgual.setBackground(UIManager.getColor("Button.darkShadow"));
        btnIgual.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnIgual.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                botaoIgual();
            }
        });
        panelFormatCalc.add(btnIgual, "cell 2 5,grow");
        JButton btnSom_1 = new JButton("+");
        btnSom_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSom_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                botaoMais();
            }
        });
        panelFormatCalc.add(btnSom_1, "cell 3 5,grow");
    }
    
    /** logica dos Botões de operação soma, subtracao, divisao, multiplicação e
     * botao de igual. **/
    ////########### Logica Botão Mais #############.
    private static void botaoMais()
    {
        if (limparSeApaertaNumeros)
        {
            entradaNum = "";
            limparSeApaertaNumeros = false;
        }
        if (!operadorB)
        {
            ultimoOperado = "+";
            float num1 = Float.parseFloat(entradaNum);
            System.out.println(num1);
            operador = num1;
            caixaDeSaida.setText(entrada += entradaNum + "+");
            caixaDeEntrada.setText("");
            entradaNum = "";
            operadorB = true;
            calcular = true;
        }
        else if (calcular)
        {
            ultimoOperado = "+";
            double num1 = Float.parseFloat(entradaNum);
            System.out.println(num1);
            resultado = cModel.soma(operador, num1);
            operador = resultado;
            caixaDeSaida.setText(entrada += entradaNum + "+");
            caixaDeEntrada.setText("");
            entradaNum = "";
        }
        else if (operadorB && !igualChamou)
        {
            ultimoOperado = "+";
            caixaDeSaida.setText(entrada += entradaNum + "+");
            caixaDeEntrada.setText("");
            entradaNum = "";
            calcular = true;
        }
        else
        {
            ultimoOperado = "+";
            double num1 = Float.parseFloat(entradaNum);
            System.out.println(num1);
            System.out.println(operador);
            resultado = cModel.soma(operador, num1);
            caixaDeSaida.setText(entrada += entradaNum + "+");
            caixaDeEntrada.setText("");
            entradaNum = "";
        }
    }
    
    private static void botaoMenos()
    {
        if (limparSeApaertaNumeros)
        {
            entradaNum = "";
            limparSeApaertaNumeros = false;
        }
        if (!operadorB)
        {
            ultimoOperado = "-";
            double num1 = Float.parseFloat(entradaNum);
            System.out.println(num1);
            operador = num1;
            caixaDeSaida.setText(entrada += entradaNum + "-");
            caixaDeEntrada.setText("");
            entradaNum = "";
            operadorB = true;
        }
        else if (calcular)
        {
            ultimoOperado = "-";
            double num1 = Float.parseFloat(entradaNum);
            System.out.println(num1);
            resultado = cModel.subtracao(operador, num1);
            operador = resultado;
            caixaDeSaida.setText(entrada += entradaNum + "-");
            caixaDeEntrada.setText("");
            entradaNum = "";
        }
        else if (operadorB && !igualChamou)
        {
            ultimoOperado = "-";
            caixaDeSaida.setText(entrada += entradaNum + "-");
            caixaDeEntrada.setText("");
            entradaNum = "";
            calcular = true;
        }
        else
        {
            ultimoOperado = "-";
            double num1 = Float.parseFloat(entradaNum);
            System.out.println(num1);
            resultado = cModel.subtracao(operador, num1);
            caixaDeSaida.setText(entrada += entradaNum + "-");
            caixaDeEntrada.setText("");
            entradaNum = "";
        }
    }
    
    private static void botaoVezes()
    {
        if (limparSeApaertaNumeros)
        {
            entradaNum = "";
            limparSeApaertaNumeros = false;
        }
        if (!operadorB)
        {
            ultimoOperado = "*";
            double num1 = Float.parseFloat(entradaNum);
            System.out.println(num1 + "oi");
            operador = num1;
            caixaDeSaida.setText(entrada += entradaNum + "*");
            caixaDeEntrada.setText("");
            entradaNum = "";
            operadorB = true;
        }
        else if (operadorB && !igualChamou)
        {
            ultimoOperado = "*";
            caixaDeSaida.setText(entrada += entradaNum + "*");
            caixaDeEntrada.setText("");
            entradaNum = "";
        }
        else
        {
            ultimoOperado = "*";
            double num1 = Float.parseFloat(entradaNum);
            System.out.println(num1 + "oisss");
            resultado = cModel.multiplicacao(operador, num1);
            caixaDeSaida.setText(entrada += entradaNum + "*");
            caixaDeEntrada.setText("");
            entradaNum = "";
        }
    }
    
    private static void botaoDividir()
    {
        if (limparSeApaertaNumeros)
        {
            entradaNum = "";
            limparSeApaertaNumeros = false;
        }
        if (!operadorB)
        {
            ultimoOperado = "/";
            double num1 = Float.parseFloat(entradaNum);
            System.out.println(num1);
            operador = num1;
            caixaDeSaida.setText(entrada += entradaNum + "/");
            caixaDeEntrada.setText("");
            entradaNum = "";
            operadorB = true;
        }
        else if (operadorB && !igualChamou)
        {
            ultimoOperado = "/";
            caixaDeSaida.setText(entrada += entradaNum + "/");
            caixaDeEntrada.setText("");
            entradaNum = "";
        }
        else
        {
            ultimoOperado = "/";
            double num1 = Float.parseFloat(entradaNum);
            System.out.println(num1);
            resultado = cModel.divisao(operador, num1);
            caixaDeSaida.setText(entrada += entradaNum + "/");
            caixaDeEntrada.setText("");
            entradaNum = "";
        }
    }
    
    private void botaoIgual()
    {
        if (ultimoOperado.equals("+"))
        {
            igualChamou = true;
            calcular = false;
            botaoMais();
            igualChamou = false;
        }
        else if (ultimoOperado.equals("-"))
        {
            igualChamou = true;
            calcular = false;
            botaoMenos();
            igualChamou = false;
        }
        else if (ultimoOperado.equals("*"))
        {
            igualChamou = true;
            calcular = false;
            botaoVezes();
            igualChamou = false;
        }
        else if (ultimoOperado.equals("/"))
        {
            igualChamou = true;
            calcular = false;
            botaoDividir();
            igualChamou = false;
        }
        ultimoOperado = "igual";
        entrada = ("" + resultado);
        entradaNum = ("" + resultado);
        caixaDeSaida.setText("");
        caixaDeEntrada.setText(entrada);
        operador = resultado;
        resultado = 0;
        operadorB = true;
        limparSeApaertaNumeros = true;
    }
    
    /* * metodos para salvar, carregar e sair. */
    private static void Salvar()
    {
        try
        {
            File file = new File("Calculator.saveFile.xml");
            file.createNewFile();
            //
            XMLConfiguration config = new XMLConfiguration();
            config.addProperty("calculadora.entrada", caixaDeEntrada.getText());
            config.addProperty("calculadora.operador", operador);
            config.addProperty("calculadora.oepradorB", operadorB);
            FileHandler handler = new FileHandler(config);
            handler.save(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void Carregar()
    {
        try
        {
            File file = new File("Calculator.saveFile.xml");
            //
            Configurations configs = new Configurations();
            XMLConfiguration config = configs.xml(file);
            entrada = config.getString("calculadora.entrada");
            if (!entrada.equals(""))
            {
                System.out.println("oi");
                operador = config.getDouble("calculadora.operador");
                entradaNum = ("");
                caixaDeSaida.setText("");
                caixaDeEntrada.setText(entrada);
                resultado = 0;
                operadorB = true;
                limparSeApaertaNumeros = true;
            }
            List<String> listaDeNumeros = config.getList(String.class, "fibo.numerosArray");
            if (listaDeNumeros != null)
            {
                for (String numero : listaDeNumeros)
                {
                    modelListadeNumeros.addElement(numero);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void dispose()
    {
        Salvar();
        super.dispose();
    }
    
    private void sair()
    {
        dispose();
    }
    
    public static NumberFormat getFormatarDoubleCalcauladora()
    {
        return formatarDoubleCalcauladora;
    }
    
    public static void setFormatarDoubleCalcauladora(NumberFormat formatarDoubleCalcauladora)
    {
        MainWindow.formatarDoubleCalcauladora = formatarDoubleCalcauladora;
    }
}
