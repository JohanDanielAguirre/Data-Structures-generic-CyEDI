package model;

public interface Graph<V> {
    public void bfs(Vertex<V> v);
    public void dfs();

    public void agregarArista(Vertex<V> v, Vertex<V> y);

    public void agregarVertice(Vertex<V> vertice);


}
