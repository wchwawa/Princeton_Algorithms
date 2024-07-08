/**
 * Union-find with specific canonical element.
 * Add a method find() to the union-find data type so that find(i)
 * returns the largest element in the connected component containing i.
 * The operations, union(), connected(), and find() should all take
 * logarithmic time or better.
 *
 * For example, if one of the connected components is {1, 2, 6, 9},
 * then the find() method should return 9 for each of the four elements
 * in the connected components.
 */

public class findCanonicalElement {
    int[] parent;
    int[] size;

    public findCanonicalElement(int n){
        parent = new int[n];
        for (int i = 0; i < n; i ++){
            parent[i] = i;
        }
        size = new int[n];
        for (int i = 0; i < n; i++){
            size[i] = 1;
        }
    }

    private int root(int n){
        while (n != parent[n]){
            n = parent[n];
        }
        return n;
    }

    public int find(int n){
        int maxElement = n;
        for (int i = 0; i < parent.length; i ++){
            if (root(i) == root(n)){
                if(i > maxElement){
                    maxElement = i;
                }
            }
        }
        return maxElement;
    }

    public void union(int p, int q){
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot != qRoot){
            if (size[pRoot] > size[qRoot]){
                parent[qRoot] = pRoot;
            } else if (size[pRoot] < size[qRoot]) {
                parent[pRoot] = qRoot;
            } else {
                parent[qRoot] = pRoot;
            }
        }
    }

    public boolean connect(int p, int q){
        if (root(p) == root(q)){
            return true;
        }
        return false;
    }
}
