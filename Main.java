import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {

    static int NumberNode = 0;
    static int MAXN = 10000005;
    static int start;
    static int end;
    // private static Object point;
    static Point point[] = new Point[MAXN];
    static int trace[] = new int[MAXN];
    static int NumberPath = 0;
    static int CurrentNode = 1;
    /*static ArrayList<ArrayList<Integer>> Path = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> Save = new ArrayList<Integer>();
    static ArrayList<Integer> paths = new ArrayList<Integer>();
    static ArrayList<Integer> Suggest = new ArrayList<Integer>();*/


    public static void main(String[] args) {

        //  Khởi tạo
        for (int index = 1; index < MAXN; index++)
            point[index] = new Point();

        //  Đọc input
        ReadInput readInput= new ReadInput();
        readInput.Read();

        Scanner scanner= new Scanner(System.in);
        
        // Nhập điểm đầu và điểm cuối
        System.out.print("Start: ");
        start= scanner.nextInt();
        System.out.print("End: ");
        end= scanner.nextInt();


        // Trường hợp có gợi ý
        // Tìm đường đi với DFS
        Simulate simulate= new Simulate();

        simulate.FindAllPaths();
        // Gợi ý đường đi
        System.out.println("You now are in node " + start);
        while (true) {
            Simulate.OnTheWay();
            if (CurrentNode == NumberNode)
                break;
        }


        /// Trường hợp ko có gợi ý
        ReSimulate reSimulate= new ReSimulate();

        reSimulate.FindAllPaths();
        reSimulate.FindShortestPath();
    }
}