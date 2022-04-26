package sise.fifteen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    private int width;
    private int height;
    int depth=20;
    Board board = new Board();
//    public DFS(List<Integer> params) {
//        System.out.println(Arrays.deepToString(new List[]{params}));
//    }
    public DFS(int[][] params, int height, int width) {
        //System.out.println(Arrays.deepToString(new List[]{Collections.singletonList(params)}));
        check(params,width,height);
    }

    public boolean check(int[][] startboard,int width,int height)
    {
        int v;
        if(board.isOrdered(startboard,width,height))
        {System.out.println("git");
            return true;
        }
//        System.out.println("zle");
//        return false;
        Stack<Integer> S = new Stack<>();
        Set<Integer> T= new HashSet<>();
        for(int i=0;i<width;i++) {
            for (int j = 0; j < height; j++)
            {
                S.push(startboard[i][j]);
            }
        }

        while (!S.isEmpty())
        {
            v=S.pop();
        if(!T.contains(v))
        {
            T.add(v);
        }



//            System.out.println(T);
//            System.out.println(v);
//        System.out.println("magia");
//        System.out.println(Arrays.deepToString(startboard));
//            System.out.println("a");
//            board.move(Movement.D,startboard,width,height);
//        System.out.println(Arrays.deepToString(startboard));
//        System.out.println("magia2");
//            if(board.isOrdered(startboard,width,height))
//            {System.out.println("git");
//
//                return true;
//
//          }
        }

        System.out.println("Aa");
        System.out.println(S);
        System.out.println("av");
        return true;


    }


}
