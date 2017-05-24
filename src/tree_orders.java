import java.util.*;
import java.io.*;

public class tree_orders {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result = InOrderTraveral(0, this, result);
			return result;
		}

		public ArrayList<Integer> InOrderTraveral (int node, TreeOrders tree, ArrayList<Integer> result){
			if (node == -1) return result;
			else {
				InOrderTraveral(left[node], tree, result);
				result.add(key[node]);
				InOrderTraveral(right[node], tree, result);
			}
			return result;
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result = PreOrderTraveral(0, this, result);
			return result;
		}

		public ArrayList<Integer> PreOrderTraveral (int node, TreeOrders tree, ArrayList<Integer> result){
			if (node == -1) return result;
			else {
				result.add(key[node]);
				PreOrderTraveral(left[node], tree, result);
				PreOrderTraveral(right[node], tree, result);
			}
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			result = PostOrderTraveral(0, this, result);
			return result;
		}

		public ArrayList<Integer> PostOrderTraveral (int node, TreeOrders tree, ArrayList<Integer> result){
			if (node == -1) return result;
			else {
				PostOrderTraveral(left[node], tree, result);
				PostOrderTraveral(right[node], tree, result);
				result.add(key[node]);
			}
			return result;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
