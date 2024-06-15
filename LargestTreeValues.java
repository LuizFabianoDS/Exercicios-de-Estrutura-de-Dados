package exercises;

import dataStructure.Tree;
import java.util.ArrayList;
import java.util.List;

public class LargestTreeValues
{
    // Método para retornar uma lista de inteiros dos maiores valores
    // Recebe uma árvore como parâmetro
    public static List<Integer> largrestValues (Tree tree)
    {
        // Lista de inteiros
        var list = new ArrayList<Integer>();

        // Método de resolução recursivo
        // Parâmetros: raiz , nível , lista
        solveTree(tree.root,0,list);
        return list;
    }


    private static void solveTree(Tree.Node node, int level, ArrayList<Integer> list)
    {
        if(node == null) return;

        // Se o nível for igual ao tamanho da lista
        // (level = 0, então, lista está vazia)
        // Então, podemos adicionar diretamente na lista
        if(level == list.size()) list.add(node.value);
        else
        {
            // Adiciona na lista o máximo valor
            //set passa como parâmetro um index, no caso o level e um valor
            // Usamos o max, passando um método de busca no level e pedimos
            // o valor máximo desse level
            list.set(level,Math.max(list.get(level),node.value));
        }

        // Método de resolução recursivo
        // Passar a direção como parâmetro,adicionando +1 no level
        // para ir descendo pela árvore e passamos a lista para armazenar
        solveTree(node.left,level+1,list);
        solveTree(node.right,level+1,list);

    }

    public static void main(String[] args)
    {
        Tree tree = new Tree();

        tree.insert(100);

        tree.insert(10);
        tree.insert(5);


        tree.insert(6);
        tree.insert(1);
        tree.insert(7);
        tree.insert(5);

        System.out.println(largrestValues(tree));
    }
}
