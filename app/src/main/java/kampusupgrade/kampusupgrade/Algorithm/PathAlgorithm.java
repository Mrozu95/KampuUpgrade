package kampusupgrade.kampusupgrade.Algorithm;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.*;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.VertexCovers;
import org.jgrapht.graph.AsUnweightedDirectedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.simpleframework.xml.util.Match;

import kampusupgrade.kampusupgrade.Data.*;
import kampusupgrade.kampusupgrade.RestClient.RESTController;


/**
 * Created by Michal on 2017-03-13.
 */

public class PathAlgorithm {

    //graph of building. Screens are vertexes. Edge is from Screen to Screen and has it own weight calculated on distance between screens
    private SimpleDirectedWeightedGraph<Integer, DefaultWeightedEdge> graph;
    //private DijkstraShortestPath<Screen, Screen> dijkstraShortestPath;

    //list of screen which will be path of user

    //starting screen and last screen
    private final Screen startPoint;
    private final Screen endPoint;
    private ArrayList<Screen> screens;

    //List of all screens' ID
    private List<DefaultWeightedEdge> path;

    public PathAlgorithm(Screen startPoint, Screen endPoint, ArrayList<Screen> screens)
    {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.screens = screens;

        graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        run();
    }

    private void run()
    {
        MakeGraph();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph, startPoint.getId() ,endPoint.getId());
        path = dijkstraShortestPath.getPathEdgeList();
    }


    //Create graph
    private void MakeGraph()
    {

        //adding vertexes
        for(Screen s: screens)
        {
            graph.addVertex(s.getId());
        }

        for (Screen screen: screens)
        {
            for (Screen neighbour: screen.getNeighbours())
            {
                DefaultWeightedEdge edge = graph.addEdge(screen.getId(), neighbour.getId());
                graph.setEdgeWeight(edge, CalculateDistanceBetweenScreens(screen, neighbour));
            }
        }
    }

    //distance between Vertexes
    private float CalculateDistanceBetweenScreens(Screen s1, Screen s2)
    {
        float xDiff = s1.getCoordinate().getX() - s2.getCoordinate().getX();
        float yDiff = s1.getCoordinate().getY() - s2.getCoordinate().getY();

        double sum = (Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
        double dist = Math.sqrt(sum);

        return (float)dist;
    }

    public ArrayList<Integer> getPath()
    {
        ArrayList<Integer> intPath = new ArrayList<>();
        if(path.size() > 2)
        {
            for(int i = 0; i < path.size(); i++)
            {
                if(i < path.size() - 1)
                {
                    intPath.add(graph.getEdgeSource(path.get(i)));
                }
                else //last screen id
                {
                    intPath.add(graph.getEdgeSource(path.get(i)));
                    intPath.add(graph.getEdgeTarget(path.get(i)));
                }
            }
        }
        else //one edge
        {
            intPath.add(graph.getEdgeSource(path.get(0)));
            intPath.add(graph.getEdgeTarget(path.get(0)));
        }

        return intPath;
    }
}
