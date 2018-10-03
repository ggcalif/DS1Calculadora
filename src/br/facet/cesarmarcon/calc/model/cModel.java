package br.facet.cesarmarcon.calc.model;

import br.facet.cesarmarcon.calc.view.MainWindow;

/** Autor: Cesar Marcon Metodos padrões de uma simples calculadora, contendo os
 * metodos: soma, subtração, multiplicação e divisão. */
public class cModel
{
    /** metodo para somar
     * @param num1 primeiro valor de entrada
     * @param num2 segundo valor de entrada
     * @return retorna a soma dos valores */
    public static double soma(double num1, double num2)
    {
        double resultado = num1 + num2;
        return resultado;
    }
    
    /** metodo para subtrair
     * @param num1 primeiro valor de entrada
     * @param num2 segundo valor de entrada
     * @return retorna a subtracao dos valores */
    public static double subtracao(double num1, double num2)
    {
        double resultado = num1 - num2;
        return resultado;
    }
    
    /** metodo para multiplicar
     * @param num1 primeiro valor de entrada
     * @param num2 segundo valor de entrada
     * @return retorna a multiplicacao dos valores */
    public static double multiplicacao(double num1, double num2)
    {
        double resultado = num1 * num2;
        return resultado;
    }
    
    /** metodo para dividir
     * @param num1 primeiro valor de entrada
     * @param num2 segundo valor de entrada
     * @return retorna a divisao dos valores */
    public static double divisao(double num1, double num2)
    {
        if (num2 == 0)
        {
            System.out.println("ERROR!");
        }
        double resultado = num1 / num2;
        return resultado;
    }
}
