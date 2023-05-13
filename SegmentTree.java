class SegmentTree {
    int[] tree;
    int size;
 
    SegmentTree(int[] array) {
        size = array.length;
        tree = new int[4 * size];
        buildTree(array, 0, 0, size - 1);
    }
 
    private void buildTree(int[] array, int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = array[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildTree(array, 2 * treeIndex + 1, left, mid);
        buildTree(array, 2 * treeIndex + 2, mid + 1, right);
        tree[treeIndex] = Math.min(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }
 
    private int query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft <= left && right <= queryRight)
            return tree[treeIndex];
        int mid = left + (right - left) / 2;
        int minValue = Integer.MAX_VALUE;
        if (queryLeft <= mid)
            minValue = Math.min(minValue, query(2 * treeIndex + 1, left, mid, queryLeft, queryRight));
        if (queryRight > mid)
            minValue = Math.min(minValue, query(2 * treeIndex + 2, mid + 1, right, queryLeft, queryRight));
        return minValue;
    }
 
    int query(int left, int right) {
        return query(0, 0, size - 1, left, right);
    }
}
 
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 5, 4, 6};
        SegmentTree st = new SegmentTree(array);
        System.out.println(st.query(1, 5)); // 2
    }
}
