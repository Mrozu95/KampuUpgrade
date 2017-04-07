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
    private SimpleDirectedWeightedGraph<Screen,DefaultWeightedEdge> graph;
    //private DijkstraShortestPath<Screen, Screen> dijkstraShortestPath;

    //list of screen which will be path of user

    //starting screen and last screen
    private final Screen startPoint;
    private final Screen endPoint;
    private ArrayList<Screen> screens;
    private List<Screen> path;

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
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph, startPoint ,endPoint);
        path = dijkstraShortestPath.getPathEdgeList();
    }


    //Create graph
    private void MakeGraph()
    {

        for (Screen screen: screens)
        {
            for (Screen neighbour: screen.getNeighbours())
            {
                graph.addEdge(screen, neighbour);
                DefaultWeightedEdge edge = graph.addEdge(screen, neighbour);
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

    public SimpleDirectedWeightedGraph<Screen, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    public List<Screen> getPath() {
        return path;
    }
}
