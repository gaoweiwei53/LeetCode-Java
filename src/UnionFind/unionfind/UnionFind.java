package unionfind;

import java.util.Arrays;

// 开启了路径压缩和按秩合并的并查集
public class UnionFind {
    int[] parent;

    //  i的根节点的子集的大小 亦称为秩
    int[] size;
    // 子集的个数 亦称连通分量
    int branchCount;

    public UnionFind(int n) {
        this.branchCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    // 查找根节点
    public int find(int x) {
        // 路径压缩
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public boolean union (int x, int y) {
         int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }
        // 按秩合并, 选取较大的子集的根节点作为合并的根节点
        if (size[rootX] <= size[rootY]){
            parent[rootX] = parent[rootY];
            size[rootY] +=  size[rootX];
        }
        else{
            parent[rootY] = parent[rootX];
            size[rootX] +=  size[rootY];
        }
        // 减少了一棵树，则连通分量 -1
        --branchCount;
        return true;
    }
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int branchCount() {
        return branchCount;
    }
}
class Test{
    // hahaha
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(7);
        int[][] edges = {{0, 1}, {1,2},{1,3},{2,4},{3,4},{6,5}};
        for (int i = 0; i < 6; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            unionFind.union(x, y);
        }
        for (int i = 0; i < 7; i++) {
            System.out.print(unionFind.parent[i]+ " ");
        }
        System.out.println();
        for (int i = 0; i < 7; i++) {
            System.out.print(unionFind.size[i]+ " ");
        }
        System.out.println();
        System.out.println(unionFind.branchCount);
    }
}