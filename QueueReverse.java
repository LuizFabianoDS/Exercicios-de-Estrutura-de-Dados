package exercises;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReverse
{

    public static Queue<Integer> reverseFirst (Queue<Integer> queue, int k)
    {
        // Método recursivo
        // método recebe a fila e o valor de k
        solve(queue,k);
        // n recebe o tamanho da fila -1
        int n = queue.size() - k;

        // Enquanto houverem elementos na lista
        while(n-- > 0)
        {
            // element recebe o ultimo nó
            int element = queue.remove();

            // Adiciona novamente o nó na fila
            queue.add(element);
        }
        return queue;
    }

    private static void solve(Queue<Integer> queue, int k)
    {
        // Se o valor inserido for 0, return
        if(k == 0) return;

        // element recebe o nó removido (Desenfilerar o nó)
        int element = queue.remove();

        // invoca o método novamente com -1 no valor de k
        solve(queue,k -1);

        // Adiciona o nó armazenado dentro de element
        queue.add(element);
    }

    public static void main(String[] args)
    {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(reverseFirst(queue,3));


    }
}
