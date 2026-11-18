class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int totalNodes = edges.length; 
        int[] result = new int[2];

        DisjointSet dsu = new DisjointSet(totalNodes);

        for(int[] edge : edges){
            if(!dsu.disjointSetUnionBySize(edge[0]-1, edge[1] - 1)){ //starting index 1 not 0.
                result = edge; 
            }; 
        }
        return result; 
    }
}

public class DisjointSet{

    int parent[]; 
    int size[]; 

    DisjointSet(int nodes){ //constructor
        this.parent = new int[nodes]; 
        this.size = new int[nodes]; 
        
        //intilialize parent with self and size with 1. 
        Arrays.fill(this.size, 1);
        Arrays.setAll(this.parent, i -> i); 
    }

    public int findRootParent(int node){

        if(node == parent[node]){
            return node; 
        }
        parent[node] = findRootParent(parent[node]); //pathCompresssion
        return parent[node];  
    }

    public boolean disjointSetUnionBySize(int node1, int node2){

        int rootParentNode1 = findRootParent(node1); 
        int rootParentNode2 = findRootParent(node2);

        if(rootParentNode1 == rootParentNode2){
            return false; 
        }
        if(size[rootParentNode1] > size[rootParentNode2]){
            parent[rootParentNode2] = rootParentNode1; 
            size[rootParentNode1] += size[rootParentNode2]; 
        } else{
            size[rootParentNode2] += size[rootParentNode1];
            parent[rootParentNode1] = rootParentNode2;  
        }

        return true; 
    }
}
