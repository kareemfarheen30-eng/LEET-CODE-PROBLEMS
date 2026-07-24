import java.util.*;

class UndergroundSystem {
    private Map<Integer, Pair> checkInMap;
    private Map<String, int[]> travelMap;

    class Pair {
        String station;
        int time;
        Pair(String s, int t) { station = s; time = t; }
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair p = checkInMap.get(id);
        String route = p.station + "-" + stationName;
        int duration = t - p.time;

        travelMap.putIfAbsent(route, new int[]{0, 0});
        travelMap.get(route)[0] += duration;
        travelMap.get(route)[1] += 1;
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        int[] data = travelMap.get(route);
        return (double)data[0] / data[1];
    }
}
