import java.util.Stack;

public class Maze {

    /**
     * 找任意一条路径
    //核心算法
     图的深度优先遍历
    //输入：迷宫字符数组，起始点坐标
    //输出：起点到终点路径
     */
    public void mazeExit(char[][] maze,int sx,int sy,int ex,int ey){
        Cell[][] cells=createMaze(maze);
        Cell startCell=cells[sx][sy];
        Cell endCell=cells[ex][ey];
        Stack<Cell> stack=new Stack<Cell>();
        stack.push(startCell);
        printMatch(cells);
        while (!stack.isEmpty()){
            Cell current=stack.peek();
            if (current==endCell){ //找到终点
                current.c='*';
                stack.pop();
                while(!stack.isEmpty()){
                    if (isAdjoinCell(current,stack.peek())){
                        current=stack.peek();
                        stack.pop().c='*';
                    }else{
                        stack.pop();
                    }
                }
                System.out.println("找到出路");
                printMatch(cells);
                return;

            }else{ //继续搜索
                int count=0;
                if (isValidWayCell(cells[current.x][current.y+1])) {
                    stack.push(cells[current.x][current.y+1]);
                    cells[current.x][current.y+1].visited=true;
                    count++;
                }
                if (isValidWayCell(cells[current.x][current.y-1])) {
                    stack.push(cells[current.x][current.y-1]);
                    cells[current.x][current.y-1].visited=true;
                    count++;
                }
                if (isValidWayCell(cells[current.x-1][current.y])) {
                    stack.push(cells[current.x-1][current.y]);
                    cells[current.x-1][current.y].visited=true;
                    count++;
                }
                if (isValidWayCell(cells[current.x+1][current.y])) {
                    stack.push(cells[current.x+1][current.y]);
                    cells[current.x+1][current.y].visited=true;
                    count++;
                }
                //回溯
                if (count==0){
                    stack.pop();//死点直接剔除
                }
            }
        }
        System.out.println("未找到出路");
        return;
    }

    //创建迷宫对象
    public Cell[][] createMaze(char[][] maze){
        Cell[][] cells=new Cell[maze.length][];
        for (int i =0;i<maze.length;i++){
            cells[i]=new Cell[maze[i].length];
            for (int j=0;j<maze[i].length;j++){
                cells[i][j]=new Cell(i,j,false,maze[i][j]);
            }
        }
        return cells;
    }

    //判断一个位置是否入栈
    public  boolean isValidWayCell(Cell cell){
        return cell.c=='0' && !cell.visited;
    }

    //判断两个位置是否毗邻
    public boolean isAdjoinCell(Cell cell1,Cell cell2){
        if (cell1.x==cell2.x && Math.abs(cell1.y-cell2.y)==1) return true;
        if (cell1.y==cell2.y && Math.abs(cell1.x-cell2.x)==1) return true;
        return false;
    }

    //打印迷宫
    public  void printMatch(Cell[][] cells){
        for (int i=0;i<cells.length;i++){
            for (int j=0;j<cells[i].length;j++){
                System.out.print(cells[i][j].c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Maze mazeObjec=new Maze();
        //抽象为图的边
        char[][] maze={
                {'1','1','1','1','1','1','1','1','1','1'},
                {'1','0','0','1','1','1','0','0','1','1'},
                {'1','0','0','1','1','0','0','1','0','1'},
                {'1','0','0','0','0','0','1','1','0','1'},
                {'1','0','0','0','0','0','1','0','0','1'},
                {'1','0','0','1','0','0','0','0','0','1'},
                {'1','0','0','0','0','1','0','1','0','1'},
                {'1','0','1','0','0','0','0','1','0','1'},
                {'1','1','0','1','0','1','1','0','0','1'},
                {'1','1','1','1','1','1','1','1','1','1'}
        };
        mazeObjec.mazeExit(maze,8,8,1,7);
    }
}

/**
 * 抽象为图的顶点
 */
class Cell{
    int x=0; //行
    int y =0; //列
    boolean visited=false; //是否被访问过
    char c=' '; //1:强  0：可通路  *：到终点的路径
    public Cell(int x,int y,boolean visited,char c){
        this.x=x;
        this.y=y;
        this.visited=visited;
        this.c=c;
    }
}
