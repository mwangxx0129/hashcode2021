package com.hashcode2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Deliver {

    public static void deliver3(List<List<String>> pizzaIngList, Map<Integer, Integer> teamTypeWithNum) {
        int availablePizza = pizzaIngList.size();
        int[] res = helper(pizzaIngList, teamTypeWithNum);
        int twoTotal = getSub(pizzaIngList, 0, res[0], 2);
        int threeTotal = getSub(pizzaIngList, res[0] * 2, res[1], 3);
        int fourTotal = getSub(pizzaIngList, res[0] * 2 + res[1] * 3, res[1], 4);
        System.out.println("total = " + twoTotal + threeTotal + fourTotal);
    }

    private static int[] helper(List<List<String>> pizzaIngList, Map<Integer, Integer> teamTypeWithNum) {
        int availablePizza = pizzaIngList.size();

        for (int i = 0; i < teamTypeWithNum.get(4); ++ i) {
            for (int j =  0; j < teamTypeWithNum.get(3); ++ j) {
                for (int k = 0; k < teamTypeWithNum.get(2); ++ k) {
                    if (i * 4 + j * 3 + k * 2 == availablePizza) {
                        System.out.println("2=" + k);
                        System.out.println("3=" + j);
                        System.out.println("4=" + i);

                        return new int[] {k, j, i};
                    }
                }
            }
        }
        return null;
    }
    // make the deliver work --- deliver all pizza
    public static void deliver2(List<List<String>> pizzaIngList, Map<Integer, Integer> teamTypeWithNum) {
        int availablePizza = pizzaIngList.size();
        int type4 = teamTypeWithNum.get(4) / 4;
        availablePizza -= type4 * 4;

        System.out.println("availablePizza=" + availablePizza);

        int total = 0;
        if (availablePizza == 0) {
            total += getSub(pizzaIngList, 0, type4, 4);
            System.out.println("4:" + total);
            return;
        } else if (availablePizza == 1) {
            type4 -= 1;
            availablePizza += 4;
            total += getSub(pizzaIngList, 0, type4, 4);
        }

        if (availablePizza % 2 != 0) {
            int type3 = teamTypeWithNum.get(3) / 3 * 3;
            availablePizza -= type3;
            int temp = getSub(pizzaIngList, 0, type3, 3);
            System.out.println("3:" + temp);
            total += temp;
        }
        if (availablePizza > 0) {
            int type2 = availablePizza / 2;
            total += getSub(pizzaIngList, 0, type2, 2);
            System.out.println("2:" + total);
        }
    }

    public static int getSub(List<List<String>> pizzaIngList, int start, int num, int type) {
        int total = 0;
        for (int i = start; i < start + num * type && i < pizzaIngList.size();  i += type) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < type; ++ j) {
                for (String e : pizzaIngList.get(i + j)) {
                    set.add(e);
                }
            }
            total += set.size() * set.size();
        }
        System.out.println(total);
        return total;
    }

    public static void deliver(List<List<String>> pizzaIngList, Map<Integer, Integer> teamTypeWithNum) {
        int availablePizza = pizzaIngList.size();
        System.out.println(teamTypeWithNum);
        System.out.println(pizzaIngList.size());

        List<Integer> teams = new ArrayList<>();
        for (int i = 0; i < teamTypeWithNum.get(2); ++i) {
            teams.add(2);
        }
        for (int i = 0; i < teamTypeWithNum.get(3); ++i) {
            teams.add(3);
        }
        for (int i = 0; i < teamTypeWithNum.get(4); ++i) {
            teams.add(4);
        }

        System.out.println(teams);
        System.out.println(availablePizza);
//        Collections.reverse(teams);
        dfs(pizzaIngList, teams, 0, availablePizza, res);
        System.out.println(res);
        System.out.println("get credit");
        int creditPoint = credit(pizzaIngList, res);
        System.out.println(creditPoint);
    }

    static boolean found = false;
    static List<Integer> res = new ArrayList<>();

    // small data size limitation
    private static void dfs(List<List<String>> pizzaIngList, List<Integer> teams, int start, int availablePizza, List<Integer> path) {
        if (found) return;
        if (availablePizza == 0) {
            found = true;
            res = new ArrayList<>(path);
            return;
        }
        if (availablePizza < 0) return;

        for (int i = start; i < teams.size(); ++i) {
            path.add(teams.get(i));
            dfs(pizzaIngList, teams, i + 1, availablePizza - teams.get(i), path);
            path.remove(path.size() - 1);
        }
//        System.out.println("dfs");
    }

    public static int credit(List<List<String>> pizzaIngList, List<Integer> path) {
        pizzaIngList.sort((a, b) -> b.size() - a.size());
        System.out.println(pizzaIngList);
        int sum = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer e : path) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        int[] types = {2, 3, 4};
        for (int i = 0; i < types.length; ++i) {
            int type = types[i];
            int num = map.getOrDefault(type, 0);
            Set<String> set = new HashSet<>();
            for (int k = 0; k < type * num; ++k) {
                for (String s : pizzaIngList.get(j++)) {
                    set.add(s);
                }
            }
            System.out.println(type + ":" + set.toString());
            sum += set.size() * set.size();
        }
        return sum;
    }
}
