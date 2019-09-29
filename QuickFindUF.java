public class QuickFindUF {
	private int count;
	private int[] id;
//n access
	public QuickFindUF(INT N){
		count = n;
		id= new int[N];
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
	}

	public int count(){
		return count;
	}

	public int find(int p){
		validate(p);
		return id[p];
	}


	private void validate(int p){
		int n = id.length;
		if(p<0 || p >= n){
			throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
		}
	}

//2 access
	public boolean connected(int p, int q){
		return id[p] == id[q];
	}


//set all element value with pid to qid, which is
//the value of component which is q in it. 
//cost model: 2N+2 access
	public void union(int p, int q){
		validate(p);
		validate(q);
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i < id.length; i++){
			if(id[i] == pid) id[i] = qid;
		}
		count--;
	}
	
	public static void main(String[] args) {
		int n = StdIn.readInt();
		QuickFindUF uf = new QuickFindUF(n);
		while (!StdIn.isEmpty()) {
			int p = StdInt();
			int q = StdInt();
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
			System.out.println(p + " " + q);
		}
		System.out.println(uf.count() + " components");
	}


}








