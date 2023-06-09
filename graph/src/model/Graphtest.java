package model;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class Graphtest extends TestCase {
    private GraphListaadyacencia g= new GraphListaadyacencia();
    public void stage1(){
        g.agregarVertice(new Vertex("bonafon"));
        g.agregarVertice(new Vertex<>("obras termo"));
        g.agregarVertice(new Vertex("albañiles unidos"));
        g.agregarVertice(new Vertex<>("buses incorporados"));
        g.agregarVertice(new Vertex("Kantiano"));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(1));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(2));
        g.agregarArista((Vertex) g.getVertices().get(1), (Vertex) g.getVertices().get(3));
        g.agregarArista((Vertex) g.getVertices().get(1), (Vertex) g.getVertices().get(2));
        g.agregarArista((Vertex) g.getVertices().get(2), (Vertex) g.getVertices().get(4));
    }
    public void stage2(){
        g.agregarVertice(new Vertex("bonafon"));
        g.agregarVertice(new Vertex("obras termo"));
        g.agregarVertice(new Vertex("albañiles unidos"));
        g.agregarVertice(new Vertex("buses incorporados"));
        g.agregarVertice(new Vertex("Kantiano"));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(1));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(2));
        g.agregarArista((Vertex) g.getVertices().get(3), (Vertex) g.getVertices().get(4));
    }
    public void stage3(){
        g.agregarVertice(new Vertex("bonafon"));
        g.agregarVertice(new Vertex("obras termo"));
        g.agregarVertice(new Vertex("albañiles unidos"));
        g.agregarVertice(new Vertex("buses incorporados"));
        g.agregarVertice(new Vertex("Kantiano"));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(1));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(2));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(3));
        g.agregarArista((Vertex) g.getVertices().get(0), (Vertex) g.getVertices().get(4));
        g.agregarArista((Vertex) g.getVertices().get(1), (Vertex) g.getVertices().get(2));
        g.agregarArista((Vertex) g.getVertices().get(1), (Vertex) g.getVertices().get(3));
        g.agregarArista((Vertex) g.getVertices().get(1), (Vertex) g.getVertices().get(4));
        g.agregarArista((Vertex) g.getVertices().get(2), (Vertex) g.getVertices().get(3));
        g.agregarArista((Vertex) g.getVertices().get(2), (Vertex) g.getVertices().get(4));
        g.agregarArista((Vertex) g.getVertices().get(3), (Vertex) g.getVertices().get(4));
    }
    public void stage4(){
        g.agregarVertice(new Vertex("bonafon"));
        g.agregarVertice(new Vertex("obras termo"));
        g.agregarVertice(new Vertex("albañiles unidos"));
        g.agregarVertice(new Vertex("buses incorporados"));
        g.agregarVertice(new Vertex("Kantiano"));
    }
    @Test
    public void testbfsalldisconnect(){
      stage4();
      g.bfs((Vertex) g.getVertices().get(0));
      Vertex v=(Vertex) g.getVertices().get(1);
      assertEquals(Colors.WHITE,v.getC());
         v=(Vertex) g.getVertices().get(2);
        assertEquals(Colors.WHITE,v.getC());
         v=(Vertex) g.getVertices().get(3);
        assertEquals(Colors.WHITE,v.getC());
         v=(Vertex) g.getVertices().get(4);
        assertEquals(Colors.WHITE,v.getC());
    }
    @Test
    public void testbfsdisconnect(){
        stage2();
        g.bfs((Vertex) g.getVertices().get(0));
        Vertex v=(Vertex) g.getVertices().get(1);
        assertEquals(1,v.getDistance());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(1,v.getDistance());
        v=(Vertex) g.getVertices().get(0);
        assertEquals(0,v.getDistance());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(0,v.getDistance());
    }
    @Test
    public void testbfsnormal(){
        stage1();
        g.bfs((Vertex) g.getVertices().get(3));
        Vertex v=(Vertex) g.getVertices().get(3);
        assertEquals(0,v.getDistance());
         v=(Vertex) g.getVertices().get(0);
        assertEquals(2,v.getDistance());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(3,v.getDistance());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(2,v.getDistance());
    }
    @Test
    public void testbfsallconected(){
        stage3();
        g.bfs((Vertex) g.getVertices().get(3));
        Vertex v=(Vertex) g.getVertices().get(3);
        assertEquals(0,v.getDistance());
        v=(Vertex) g.getVertices().get(0);
        assertEquals(1,v.getDistance());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(1,v.getDistance());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(1,v.getDistance());
    }
    @Test
    public void testdfsalldisconnected(){
        stage4();
        g.dfs();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(2,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(1);
        assertEquals(4,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(6,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(3);
        assertEquals(8,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(10,v.getDistancefinal());
    }
    @Test
    public void testdfsdisconnect(){
        stage2();
        g.dfs();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(6,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(1);
        assertEquals(3,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(5,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(3);
        assertEquals(10,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(9,v.getDistancefinal());
    }
    @Test
    public void testdfsnormal(){
        stage1();
        g.dfs();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(10,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(1);
        assertEquals(9,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(8,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(3);
        assertEquals(4,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(7,v.getDistancefinal());
    }
    @Test
    public void testdfsallconected(){
        stage3();
        g.dfs();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(10,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(1);
        assertEquals(9,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(2);
        assertEquals(8,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(3);
        assertEquals(7,v.getDistancefinal());
        v=(Vertex) g.getVertices().get(4);
        assertEquals(6,v.getDistancefinal());
    }
    @Test
    public void testdeleteedgewithotherconnections(){
        stage3();
        assertEquals(true,g.borrarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1)));
    }
    @Test
    public void testdeleteedgewithoutotherconnections(){
        stage4();
        assertEquals(false,g.borrarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1)));
    }
    @Test
    public void testdeleteedgenull(){
        stage4();
        assertEquals(false,g.borrarArista((Vertex) g.getVertices().get(0),null));
    }
    @Test
    public void testdeletebothedgenull(){
        stage4();
        assertEquals(false,g.borrarArista(null,null));
    }

    @Test
    public void testdeletevertexnull(){
        stage4();
        assertEquals(false,g.borrarVertice(null));
    }
    @Test
    public void testdeletevertexinexistent(){
        stage4();
        Vertex v= new Vertex<>("la tia conchita");
        assertEquals(false,g.borrarVertice(v));
    }
    @Test
    public void testdeletevertex(){
        stage2();
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(5,g.getVertices().size());
        assertEquals(true,g.borrarVertice(v));
        assertEquals(4,g.getVertices().size());
    }
    @Test
    public void testAdd2Vertexequals() {
        Vertex v=new Vertex("1");
        g.agregarVertice(v);
        g.agregarVertice(v);
        assertEquals(1,g.getVertices().size());
    }
    @Test
    public void testAddVertexnormal() {
        Vertex v=new Vertex("1");
        g.agregarVertice(v);
        v=new Vertex("perro");
        g.agregarVertice(v);
        v=new Vertex("1.1102.992.004");
        g.agregarVertice(v);
        assertEquals(3,g.getVertices().size());
    }
    @Test
    public void testAddVertexnull() {
        g.agregarVertice(null);
        assertEquals(0,g.getVertices().size());
    }

    @Test
    public void testAddedgenull() {
        g.agregarVertice(new  Vertex("si"));
        g.agregarArista((Vertex) g.getVertices().get(0),null);
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(0,v.getAdyacentes().size());
    }
    @Test
    public void testAddsameedge() {
        g.agregarVertice(new  Vertex("si"));
        g.agregarVertice(new  Vertex("no"));
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1));
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1));
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(1,v.getAdyacentes().size());
    }
    @Test
    public void testAddedgesnormal() {
        g.agregarVertice(new  Vertex("si"));
        g.agregarVertice(new  Vertex("no"));
        g.agregarVertice(new  Vertex("talvez"));
        g.agregarVertice(new  Vertex("depende"));
        g.agregarVertice(new  Vertex("devezencuando"));
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(1));
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(2));
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(3));
        g.agregarArista((Vertex) g.getVertices().get(0),(Vertex) g.getVertices().get(4));
        Vertex v=(Vertex) g.getVertices().get(0);
        assertEquals(4,v.getAdyacentes().size());
    }
}
