package week9;
import java.util.ArrayList;
import java.util.List;
public class test {
    static void printchil(int root, List<List<Integer>>adj){
        System.out.println("Children of node "+root+": ");
        if(adj.get(root).isEmpty()){
            System.out.println("No children (leaf)");
        }else{
            for(int child : adj.get(root)){
                System.out.println(child+" ");
            }System.out.println();
        }
    }
    static void printleafs(int root,List<List<Integer>>adj){
        System.out.println("Leaf nodes: ");
        for(int i=0;i<adj.size();i++){
            if(adj.get(i).isEmpty()){
                System.out.print(i+" ");
            }

        }
        System.out.println();
    }
    static void printdeg(int root,List<List<Integer>> adj){
        System.out.println("Degrees of each node: ");
        for(int i=0;i<adj.size();i++){
            int degree = adj.get(i).size();
            for(List<Integer> list: adj){
                if(list.contains(i)){
                    degree++;
                }
            }
            System.out.print("Node "+i+" has degree "+ degree);
        }
    }
    public static void main(String[] args){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<5;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);
        int root =0;
        printchil(root, adj);
        printleafs(root, adj);
        printdeg(root, adj);
        

    }
}
