public class weightedUnionFind {
    int[] parent;
    int[] rank;

    public weightedUnionFind(int n){
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i ++){
            parent[i] = i;
            rank[i] = i;
        }
    }

    private int root(int p){
        while(parent[p] != p){
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q){
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot != qRoot){
            if (rank[pRoot] > rank[qRoot]){
                parent[q] = pRoot;
            } else if (rank[pRoot] < rank[qRoot]) {
                parent[p] = qRoot;
            } else {
                parent[p] = qRoot;
                rank[qRoot] ++;
            }
        }
    }

    public boolean connected(int p, int q){
        if (root(p) == root(q)){
            return true;
        } else {
            return false;
        }
    }


}
