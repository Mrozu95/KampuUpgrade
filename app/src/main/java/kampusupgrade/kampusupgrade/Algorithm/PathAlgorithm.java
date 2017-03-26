package kampusupgrade.kampusupgrade.Algorithm;

import java.util.List;
import org.jgrapht.*;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.VertexCovers;
import org.jgrapht.graph.AsUnweightedDirectedGraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import kampusupgrade.kampusupgrade.Data.*;


/**
 * Created by Michal on 2017-03-13.
 */

public class PathAlgorithm {

    //graph of building. Screens are vertexes. Edge is from Screen to Screen and has it own weight calculated on distance between screens
    private Graph<Screen,Screen> graph;
    private DijkstraShortestPath<Screen, Screen> dijkstraShortestPath;

    //list of screen which will be path of user
    private List<Screen> path;

    //starting screen and last screen
    private final Screen startPoint;
    private final Screen endPoint;

    public PathAlgorithm( Screen startPoint, Screen endPoint)
    {
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        graph = new SimpleDirectedWeightedGraph<>(Screen.class);
        dijkstraShortestPath = new DijkstraShortestPath<>(graph, startPoint, endPoint);
    }


    public void setPath ()
    {
       path = dijkstraShortestPath.getPathEdgeList();
    }

    //TODO need connection with database
    public void createGraph()
    {
        setPath();
    }


    //Generate list of nodes to follow
  //  public List<Screen> CreatePath()
    //{

    //}

}
