public class successorWithDelete {
    boolean[] removed;
    int[] successor;
    public successorWithDelete(int n){
        removed = new boolean[n];
        for (int i = 0; i < n; i++){
            removed[i] = false;
        }
        successor = new int[n];
        for (int i = 0; i < n; i++){
            if(i < n - 1){
                successor[i] = i + 1;
            }
        }
    }

    public void remove(int n){
        removed[n] = true;
    }

    public int findSuccessor(int n){
        if (n + 1 < successor.length && n >= 0){
            Integer X = successor[n];
            Integer Y = n;
            while (!removed[X]){
                if (n == removed.length - 1){
                    break;
                }
                Y = Y + 1;
                X = successor[Y];
            }
            return successor[Y];
        }
        return -1; //invalid integer
    }
}
