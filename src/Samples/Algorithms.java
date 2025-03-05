package Samples;

import java.util.*;

public class Algorithms {

    public static void trackPerformance(Runnable function) {
        // Получаем текущий экземпляр Runtime
        Runtime runtime = Runtime.getRuntime();

        // Запрашиваем сборку мусора перед началом измерений
        runtime.gc();

        // Замер начальной памяти
        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        // Замер времени старта
        long startTime = System.nanoTime();

        // Выполнение функции
        function.run();

        // Замер конечного времени
        long endTime = System.nanoTime();
        // Замер конечной памяти
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        // Расчет времени выполнения
        long duration = endTime - startTime;
        // Расчет использования памяти
        long memoryUsed = endMemory - startMemory;

        // Вывод результатов
        System.out.println("Время выполнения (ms): " + duration / 1_000_000);
        System.out.println("Использованная память (MB): " + memoryUsed / (1024 * 1024));
    }

    // Binary search
    public static int binSearch(int[] arr, int l, int r, int x) {
        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private static int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;


                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    public static void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    //Quick sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }




    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;


                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Heap sort
    private static int LEFT(int i) {
        return (2 * i + 1);
    }

    private static int RIGHT(int i) {
        return (2 * i + 2);
    }

    private static void swap(int[] sortArr, int i, int j) {
        int swap = sortArr[i];
        sortArr[i] = sortArr[j];
        sortArr[j] = swap;
    }

    private static void heapify(int[] sortArr, int i, int size) {
        int left = LEFT(i);
        int right = RIGHT(i);
        int largest = i;

        if (left < size && sortArr[left] > sortArr[i]) largest = left;
        if (right < size && sortArr[right] > sortArr[largest]) largest = right;

        if (largest != i) {
            swap(sortArr, i, largest);
            heapify(sortArr, largest, size);
        }
    }

    public static int pop(int[] sortArr, int size) {
        if (size <= 0) {
            return -1;
        }
        int top = sortArr[0];

        sortArr[0] = sortArr[size-1];
        heapify(sortArr, 0, size - 1);
        return top;
    }

    public static void heapSort(int[] sortArr) {
        int n = sortArr.length;

        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(sortArr, i--, n);
        }

        while (n > 0) {
            sortArr[n - 1] = pop(sortArr, n);
            n--;
        }
    }

    // Combinations
    public static void genPermutations(List<Character> abc, String current, List<String> permutations) {
        if (current.length() == abc.size()) {
            permutations.add(current);
            return;
        }

        for (char s : abc) {
            if (current.indexOf(s) == -1) {
                genPermutations(abc, current + s, permutations);
            }
        }
    }

    // Dijkstra
    static class UnweightedGraph {
        private final int vertices;
        private final List<List<Integer>> adjList;

        public UnweightedGraph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination) {
            adjList.get(source).add(destination);
            adjList.get(destination).add(source); // Для неориентированного графа
        }

        public void bfs(int start) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();
            int[] distance = new int[vertices];

            visited[start] = true;
            queue.add(start);
            distance[start] = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int neighbor : adjList.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                        distance[neighbor] = distance[current] + 1;
                    }
                }
            }

            printDistance(distance);
        }

        private void printDistance(int[] distance) {
            System.out.println("Расстояния от начальной вершины:");
            for (int i = 0; i < distance.length; i++) {
                System.out.println("Вершина " + i + " расстояние: " + distance[i]);
            }
        }
    }

    // Dijkstra (with weights)
    public static class Graph {

        private Set<Node> nodes = new HashSet<>();

        public void addNode(Node nodeA) {
            nodes.add(nodeA);
        }

        public Set<Node> getNodes() {
            return nodes;
        }

        public void setNodes(Set<Node> nodes) {
            this.nodes = nodes;
        }
    }

    public class Node {

        private String name;
        private LinkedList<Node> shortestPath = new LinkedList<>();
        private Integer distance = Integer.MAX_VALUE;
        private Map<Node, Integer> adjacentNodes = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }

        public void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<Node, Integer> getAdjacentNodes() {
            return adjacentNodes;
        }

        public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public List<Node> getShortestPath() {
            return shortestPath;
        }

        public void setShortestPath(LinkedList<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }
    }

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry < Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
