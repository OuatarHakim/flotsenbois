import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceDGS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Autoroute {

    private static Node source;
    private  static Node destination;

    public static  void main(String[] args){
        System.setProperty("org.graphStream.ui" , "swing");
        Graph g = readDGSfile("./Data/autoroute.dgs","Autoroute");

        source = g.getNode("A");
        destination = g.getNode("I");

        ArrayList<Node> nodesUpdate = new ArrayList<Node>();
        nodesUpdate.add(g.getNode("A"));
        nodesUpdate.add(g.getNode("C"));
        nodesUpdate.add(g.getNode("D"));
        nodesUpdate.add(g.getNode("H"));
        nodesUpdate.add(g.getNode("I"));

        Stream<Edge> edgesUpdate = g.edges().filter(e -> nodesUpdate.contains(e.getNode1()));





    }

    private static Graph readDGSfile(String pathFile ,String name){
        Graph g = new DefaultGraph(name);
        FileSource fs = new FileSourceDGS();
        fs.addSink(g);
        try{
            fs.readAll(pathFile);
        } catch (IOException e) {
            System.out.println("Error ! ");
            e.printStackTrace();
            System.exit(1);
        } finally {
            fs.removeSink(g);
        }

        return g;

    }

}
