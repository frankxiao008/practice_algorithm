


public class QuickUnionUF {
	private int[] id;
	private int count;

	public QuickUnionUF(int N){
		id = new int[N];
		count = N;
		for(int i = 0; i < N; i++)
			id[i] = i;
	
	}

	public int count(){
		return count;
	}

	public int root(int i){
		validate(i);
		while(i != id[i])  i = id[i];
		return i;
	}

	private void validate(int p){
		int n = id.length;
		if(p < 0 || p > n)
			throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n-1));
	}

	public boolean connected(int p, int q){
		return root(p) == root(q);
	}

	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		if(i == j) return;
		id[i] = j;
		count--;
	}


}
	
