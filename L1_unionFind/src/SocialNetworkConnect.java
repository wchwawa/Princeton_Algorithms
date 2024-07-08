/**
 * Social network connectivity.
 * Given a social network containing n members and a log file containing
 * m timestamps at which times pairs of members formed friendships, design
 * an algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an
 * equivalence relation.
 *
 * The running time of your algorithm should be m log n or better and use extra
 * space proportional to n.

 */


import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class SocialNetworkConnect {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    int[] parent;
    int[] size;
    String[] connectTime;

    public SocialNetworkConnect(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
        }
    }

    private int root(int n) {
        while (n != parent[n]) {
            n = parent[n];
        }
        return n;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        LocalDateTime dateTime = LocalDateTime.now();
        if (pRoot != qRoot) {
            if (size[pRoot] > size[qRoot]) {
                parent[qRoot] = pRoot;
                connectTime[q] = dateTime.format(formatter);
            } else if (size[pRoot] <= size[qRoot]) {
                parent[pRoot] = qRoot;
                connectTime[p] = dateTime.format(formatter);
            }
        }
    }

    public boolean connect ( int p, int q){
        if (root(p) == root(q)) {
            return true;
        }
        return false;
    }
}
