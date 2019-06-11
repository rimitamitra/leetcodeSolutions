/**
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
**/

class Solution973 {
    public int[][] kClosest(int[][] points, int K) {
        int[] distance = new int[points.length];
        int maxDist = 0;
        int[][] res = new int[K][2]; 
        int count=0;
        
        for(int i=0; i<points.length;i++){
            distance[i] = dist(points[i]);
        }
        
        Arrays.sort(distance);
        //get the max distance for K
        maxDist = distance[K-1];
        
        for(int i=0; i<points.length; i++){
            if(dist(points[i]) <= maxDist)
                res[count++] = points[i];
        }
        
        return res;
    }
    
    private int dist(int[] pt){
        return pt[0]*pt[0] + pt[1]*pt[1];
    }
}