import java.util.*;
import java.io.*;

public class tree_height {
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

	class Node{
		int node_key;
		ArrayList<Node> Childrens = new ArrayList();
	}

	public class TreeHeight {
		int n;
		int parent[];
		int root;
		Node nodes[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}

			nodes = new Node[n];
			for (int i = 0; i < n; i++) nodes[i] = new Node();

			for (int i = 0; i < n; i++){
				nodes[i].node_key = i;
				if(parent[i] == -1) root = i;
				else nodes[parent[i]].Childrens.add(nodes[i]);
			}

		}

		int computeHeight() {
                        // Replace this code with a faster implementation
/*
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
*/

			return node_heigth(nodes[root]);
		}
	}

	static int node_heigth(Node node){
    	int cur_node_hight = 0;
    	if(node.Childrens.isEmpty()) return 1;
    	else{
    		for (int i = 0; i < node.Childrens.size(); i++) cur_node_hight = Math.max(cur_node_hight, node_heigth(node.Childrens.get(i)));
		}

		return cur_node_hight+1;
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
