import java.util.*;

class ST {
    private int[] seg;
    private int[] lazy;

    public ST(int n) {
        seg = new int[4 * n];
        lazy = new int[4 * n];
    }

    public void build(int ind, int low, int high, int[] arr) {
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high) >> 1;
        build(2 * ind + 1, low, mid, arr);
        build(2 * ind + 2, mid + 1, high, arr);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    public void update(int ind, int low, int high, int l, int r, int val) {
        if (lazy[ind] != 0) {
            seg[ind] += (high - low + 1) * lazy[ind];
            if (low != high) {
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }
            lazy[ind] = 0;
        }

        if (high < l || r < low) {
            return;
        }

        if (low >= l && high <= r) {
            seg[ind] += (high - low + 1) * val;
            if (low != high) {
                lazy[2 * ind + 1] += val;
                lazy[2 * ind + 2] += val;
            }
            return;
        }

        int mid = (low + high) >> 1;
        update(2 * ind + 1, low, mid, l, r, val);
        update(2 * ind + 2, mid + 1, high, l, r, val);
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    public int query(int ind, int low, int high, int l, int r) {
        if (lazy[ind] != 0) {
            seg[ind] += (high - low + 1) * lazy[ind];
            if (low != high) {
                lazy[2 * ind + 1] += lazy[ind];
                lazy[2 * ind + 2] += lazy[ind];
            }
            lazy[ind] = 0;
        }

        if (high < l || r < low) {
            return 0;
        }

        if (low >= l && high <= r) {
            return seg[ind];
        }

        int mid = (low + high) >> 1;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);
        return left + right;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ST st = new ST(n + 1);
        st.build(0, 0, n - 1, arr);

        int q = scanner.nextInt();
        while (q-- > 0) {
            int type = scanner.nextInt();
            if (type == 1) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int val = scanner.nextInt();
                st.update(0, 0, n - 1, l - 1, r - 1, val);
            } else if (type == 2) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int sum = st.query(0, 0, n - 1, l - 1, r - 1);
                System.out.println(sum);
            }
        }

        scanner.close();
    }
}
