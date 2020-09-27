package com.study.september.week4;

import java.util.*;

/**
 * Evaluate Division
 *
 * You are given equations in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating-point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 *
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 *
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= equations[i][0], equations[i][1] <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= queries[i][0], queries[i][1] <= 5
 * equations[i][0], equations[i][1], queries[i][0], queries[i][1] consist of lower case English letters and digits.
 *
 */
public class Solution27 {
    public double[] calcEquation_1ms(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        buildGraph(graph, equations, values);

        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i ++){
            result[i] = getQueryResult(queries.get(i), graph);
        }
        return result;
    }

    private double getQueryResult(List<String> query, Map<String, Map<String, Double>> graph) {
        String node1 = query.get(0);
        String node2 = query.get(1);

        if(!graph.containsKey(node1) || !graph.containsKey(node2)) return -1;

        return dfsToGetResult(node1, node2, graph, new HashSet<>());
    }

    private double dfsToGetResult(String node1, String node2, Map<String, Map<String, Double>> graph, HashSet<String> visited) {
        if(!graph.containsKey(node1)) return -1;
        if(graph.get(node1).containsKey(node2)) return graph.get(node1).get(node2);

        visited.add(node1);

        for (Map.Entry<String, Double> neighbour : graph.get(node1).entrySet()) {
            if(visited.contains(neighbour.getKey())) continue;
            double temp = dfsToGetResult(neighbour.getKey(), node2, graph, visited);

            if(temp != -1)
                return neighbour.getValue() * temp;

        }

        return -1;
    }

    private void buildGraph(Map<String, Map<String, Double>> graph, List<List<String>> equations, double[] values) {
        for(int i = 0; i < values.length; i ++){
            List<String> nodes = equations.get(i);
            String node1 = nodes.get(0);
            String node2 = nodes.get(1);

            graph.putIfAbsent(node1, new HashMap<>());
            graph.get(node1).put(node2, values[i]);

            graph.putIfAbsent(node2, new HashMap<>());
            graph.get(node2).put(node1, 1.0/values[i]);
        }
    }

    public double[] calcEquation_2ms(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Matrix matrix = new Matrix(equations, values);
        return matrix.evaluate(queries);
    }

    private static class Matrix {
        private Map<String, Map<String, Double>> matrix;

        public Matrix(List<List<String>> equations, double[] values) {
            matrix = new HashMap<>();

            for (int i = 0; i < values.length; i++) {
                add(equations.get(i).get(0), equations.get(i).get(1), values[i]);
            }

            floydWarshall();
        }

        private void add(String a, String b, double value) {
            matrix.computeIfAbsent(a, z -> new HashMap<>()).put(b, value);
            matrix.computeIfAbsent(b, z -> new HashMap<>()).put(a, 1.0 / value);
        }

        private void floydWarshall() {
            Set<String> keys = matrix.keySet();

            for (String intermediate : keys) {
                for (String from : keys) {
                    if (!matrix.get(from).containsKey(intermediate)) {
                        continue;
                    }

                    for (String to : keys) {
                        if (!matrix.get(from).containsKey(to) && matrix.get(intermediate).containsKey(to)) {
                            double value = matrix.get(from).get(intermediate) * matrix.get(intermediate).get(to);
                            matrix.get(from).put(to, value);
                        }
                    }
                }
            }
        }

        public double[] evaluate(List<List<String>> queries) {
            int n = queries.size();
            double[] answer = new double[n];

            for (int i = 0; i < n; i++) {
                String from = queries.get(i).get(0);
                String to = queries.get(i).get(1);
                answer[i] = matrix.getOrDefault(from, new HashMap<>()).getOrDefault(to, -1.0);
            }

            return answer;
        }
    }
}
