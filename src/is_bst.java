import java.util.*;
import java.io.*;

public class is_bst {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            if (nodes == 0) return true;

            ArrayList<Integer> result = new ArrayList<Integer>();
            result = InOrderTraveral(0, tree, result);
            int prevKey=result.get(0);
            for (int i = 1;  i < result.size(); i++)
            {
                if(prevKey >= result.get(i)) return false;
                prevKey = result.get(i);
            }
          return true;
        }

        private ArrayList<Integer> InOrderTraveral (int nodeIdx, Node[] tree, ArrayList<Integer> result){
            if (nodeIdx == -1) return result;
            else {
                InOrderTraveral(tree[nodeIdx].left, tree, result);
                result.add(tree[nodeIdx].key);
                InOrderTraveral(tree[nodeIdx].right, tree, result);
            }
            return result;
        }

    }


    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
