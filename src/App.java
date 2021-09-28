
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class App {
 
     static Map<String,Vertex> vertexMap =new HashMap<String,Vertex>();
    public static void main(String[] args) {
 
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");
 
        vertexA.addNeighbour(new Edge(2,vertexA,vertexB));
        vertexA.addNeighbour(new Edge(2,vertexA,vertexD));
        vertexA.addNeighbour(new Edge(5,vertexA,vertexC));

        vertexB.addNeighbour(new Edge(2,vertexB,vertexA));
        vertexB.addNeighbour(new Edge(3,vertexB,vertexC));
        vertexB.addNeighbour(new Edge(2,vertexB,vertexD));

        vertexC.addNeighbour(new Edge(5,vertexC,vertexA));
        vertexC.addNeighbour(new Edge(3,vertexC,vertexB));
        vertexC.addNeighbour(new Edge(3,vertexC,vertexD));
        vertexC.addNeighbour(new Edge(1,vertexC,vertexE));
        vertexC.addNeighbour(new Edge(5,vertexC,vertexF));
        
        vertexD.addNeighbour(new Edge(1,vertexD,vertexA));
        vertexD.addNeighbour(new Edge(2,vertexD,vertexB));
        vertexD.addNeighbour(new Edge(3,vertexD,vertexC));
        vertexD.addNeighbour(new Edge(1,vertexD,vertexE));

        vertexE.addNeighbour(new Edge(1,vertexE,vertexD));
        vertexE.addNeighbour(new Edge(1,vertexE,vertexC));
        vertexE.addNeighbour(new Edge(2,vertexE,vertexF));

        vertexF.addNeighbour(new Edge(5,vertexE,vertexC));
        vertexF.addNeighbour(new Edge(3,vertexE,vertexE));

        vertexMap.put("A",vertexA);
        vertexMap.put("B",vertexB);
        vertexMap.put("C",vertexC);
        vertexMap.put("D",vertexD);
        vertexMap.put("E",vertexE);
        vertexMap.put("F",vertexF);

 
        DijkstraShortestPath shortestPath = new DijkstraShortestPath();


        System.out.println("Set the Source Vertex");
        Scanner scn= new Scanner(System.in);
        String sourceVrtx = scn.nextLine();

        System.out.println("Enter Source and Destination : Source,Destination");
        System.out.println("type \'exit\' to exit App");
        String input ;
         
         while(true)
         {
             input=scn.nextLine();
             if(input.equals("exit"))
                break;
             String [] node = input.split("[,]");

             if(!node[0].equals(sourceVrtx))
             {
                 System.out.println("Restart App and Set Source as -> "+node[0]);
                 break;
             }

             shortestPath.computeShortestPaths(vertexMap.get(node[0]));

             System.out.println("Shortest Path from" + node[0] +"to : "+ node[1]+"  "+shortestPath.getShortestPathTo(vertexMap.get(node[1])));
         }

         scn.close();
 
    }

}