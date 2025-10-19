class Solution {
    void bfs(int[][] image,int sr,int sc,int color,int original,int[][] vis,int n,int m){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            image[row][col]=color;
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && image[nr][nc]==original){
                    vis[nr][nc]=1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        int n=image.length;
        int m=image[0].length;
        int[][] vis=new int[n][m];
        bfs(image,sr,sc,color,original,vis,n,m);
        return image;
    }
}
