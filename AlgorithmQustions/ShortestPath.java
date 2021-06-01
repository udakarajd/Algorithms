import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class QNode{

        Point point;
        int distance;

        public QNode(Point point, int distance){
            this.point = point;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};

        Point origin = new Point(2, 1);
        Point destination = new Point(7, 9);

        int distance = getShortestDistance(mat, origin, destination);

        System.out.println("Shortest distance : " + (distance >= 0 ? distance : "Unreachable"));
    }


    public static int getShortestDistance(int mat[][], Point origin, Point dest) {

        if (validCell(mat,origin)==null || validCell(mat, dest) == null)
            return -1;

        boolean visited[][] = new boolean[mat.length][mat[0].length];


        Queue<QNode> q = new LinkedList<>();

        q.add(new QNode(origin, 0));

        while (!q.isEmpty()){

            QNode curr = q.peek();

            if(curr.point.x == dest.x && curr.point.y == dest.y){
                return  curr.distance;
            }

            addToQueue(q, visited,curr, canMoveUp(mat, curr.point));
            addToQueue(q,  visited,curr, canMoveDown(mat, curr.point));
            addToQueue(q, visited, curr, canMoveLeft(mat, curr.point));
            addToQueue(q,  visited,curr, canMoveRight(mat, curr.point));

            q.remove();
            visited[curr.point.x][curr.point.y]=true;


        }


        return -1;
    }

    private static void addToQueue(Queue<QNode> q, boolean[][] visited, QNode curr, Point point) {
        if(point !=null && !visited[curr.point.x][curr.point.y]){
            q.add(new QNode(point,curr.distance+1));
        }
    }


    static Point canMoveUp(int mat[][], Point point) {
        return validCell(mat, new Point(point.x, point.y + 1));
    }

    static Point canMoveDown(int mat[][], Point point) {
        return validCell(mat, new Point(point.x, point.y - 1));
    }

    static Point canMoveLeft(int mat[][], Point point) {
        return validCell(mat, new Point(point.x + 1, point.y));
    }

    static Point canMoveRight(int mat[][], Point point) {
        return validCell(mat, new Point(point.x - 1, point.y));
    }


    static Point validCell(int mat[][], Point point) {

        if (!isWithInBoundary(mat, point )|| ! isValid(mat, point))
            return null;
        return point;
    }

    private static boolean isValid(int[][] mat, Point point) {
       return mat[point.x][point.y] == 1;
    }

    private static boolean isWithInBoundary(int[][] mat, Point point) {

        if (point.y < 0 || point.x < 0 || point.x >= mat.length || point.y >= mat[0].length) {
            return false;
        }
        return true;
    }

}