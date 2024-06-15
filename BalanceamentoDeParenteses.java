package exercises;

import jdk.dynalink.support.ChainedCallSite;

import java.util.Collections;
import java.util.Set;
import java.util.Stack;

public class BalanceamentoDeParenteses
{
    public static boolean solve(String expression)
    {
        // Caracteres de abertura
        Set<Character> oppenSymbols = Set.of('(','[','{');

        // Caracteres de fechamento
        Set<Character> closeSymbols = Set.of(')',']','}');

        // Criando uma pilha de caracetres
        Stack<Character> stack = new Stack<>();

        // Criando uma array com os caracteres da expressão inserida
        for (char c: expression.toCharArray())
        {
            // Se o símbolo de abertura conter o caractere
            //recebido em c , adiciona c na pilha
            if (oppenSymbols.contains(c)) stack.push(c);

            // Se o fechamento de caracteres possuirem o c
            if(closeSymbols.contains(c))
            {
                // Se a pilha está vazia, return false;
                if(stack.isEmpty()) return false;

                // open recebe o ultimo elemento inserido na pilha
                var open = stack.pop();

                // Verifica se open é igual a abertura
                // e c diferente de fechamento, se for, return false
                if(open == '(' && c != ')') return false;
                if(open == '[' && c != ']') return false;
                if(open == '{' && c != '}') return false;
            }
        }

        // Retornar true ou false
        // Se a lista estiver vazia, expressão valida: true;
        // Se houver algum caractere, expressão inválida: false;
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {

        System.out.println(solve("2*(32+4*[1+1])"));
        System.out.println(solve("2*(32+4*[1+1]})"));

    }
}
