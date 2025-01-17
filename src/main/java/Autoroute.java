import maxflow.MaxFlow;
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
        System.setProperty("org.graphstream.ui","swing");
        Graph g = readDGSfile("./Data/autoroute.dgs","Autoroute");
        g.setAttribute("ui.stylesheet" ,"url('./Data/style.css')");
        source = g.getNode("A");
        destination = g.getNode("I");
        g.display(false);

        MaxFlow mf = new MaxFlow();
        mf.setCapacityAttribute("cap");
        mf.init(g);
        mf.setSource(source);
        mf.setSink(destination);
        mf.compute();

        System.out.println(mf.getFlow());
        g.nodes().forEach((Node n )-> {
            n.setAttribute("ui.label" ,""+ n.getId());
        });
        g.edges().forEach((Edge e)-> {
            double flow = mf.getFlow(e);
            double cap = mf.getCapacity(e);
            if (flow > 0) e.setAttribute("ui.label", "" + flow + " / " + cap);
            if (cap == flow) e.setAttribute("ui.style", "fill-color: red;");
        });

        g.getEdge("BD").setAttribute("ui.style", "fill-color: #009999;");



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
