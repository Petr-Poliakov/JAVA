import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Ex9 {
    public static void main(String[] args) {
        Point2D cat = new Point2D(3, 3);
        Point2D exit = new Point2D(10, 4);
        var mg = new MapGenerator();
        var mg1 = new MapGenerator();
        mg.setCat(cat);
        mg.setExit(exit);

        System.out.println(new MapPrinter().mapColor(
                mg.getMap()));

        var lee = new WaveAlgorithm(mg.getMap());
        lee.Colorize(cat);
        System.out.println(
                new MapPrinter().rawData(
                        mg.getMap()));

        mg1.setRoad(lee.getRoad(exit));
        mg1.setCat(cat);
        mg1.setExit(exit);
        System.out.println(new MapPrinter().mapColor(
                mg1.getMap()));
    }
}

class Point2D {
    int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("x: %d y:%d", x, y);
    }
}

class WaveAlgorithm {
    int[][] map;

    public WaveAlgorithm(int[][] map) {
        this.map = map;
    }

    public void Colorize(Point2D startPoint) {
        Queue<Point2D> queue = new LinkedList<Point2D>();
        queue.add(startPoint);
        map[startPoint.x][startPoint.y] = 1;

        while (queue.size() != 0) {
            Point2D p = queue.remove();

            if (map[p.x - 1][p.y] == 0 || map[p.x - 1][p.y] == -3) {
                queue.add(new Point2D(p.x - 1, p.y));
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y - 1] == 0 || map[p.x][p.y -1 ] == -3) {
                queue.add(new Point2D(p.x, p.y - 1));
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
            }
            if (map[p.x + 1][p.y] == 0 || map[p.x + 1][p.y] == -3) {
                queue.add(new Point2D(p.x + 1, p.y));
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y + 1] == 0 || map[p.x + 1][p.y] == -3) {
                queue.add(new Point2D(p.x, p.y + 1));
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
            }
        }

    }

    public Deque<Point2D> getRoad(Point2D exit) {
        Deque<Point2D> road = new ArrayDeque<>();
        Point2D p = new Point2D(exit.x, exit.y);
        road.addFirst(exit);
        while (map[p.x][p.y] > 1) {
            if (map[p.x][p.y - 1] < map[p.x][p.y] && map[p.x][p.y - 1] != -1) {
                if (map[p.x][p.y - 1] != map[road.getFirst().x][road.getFirst().y]) {
                    road.addFirst(new Point2D(p.x, p.y - 1));
                    p.y = p.y - 1;
                }
            }
            if (map[p.x - 1][p.y] < map[p.x][p.y] && map[p.x - 1][p.y] != -1) {
                if (map[p.x - 1][p.y] != map[road.getFirst().x][road.getFirst().y]) {
                    road.addFirst(new Point2D(p.x - 1, p.y));
                    p.x = p.x - 1;
                }
            }
            if (map[p.x][p.y + 1] < map[p.x][p.y] && map[p.x][p.y + 1] != -1) {
                if (map[p.x][p.y + 1] != map[road.getFirst().x][road.getFirst().y]) {
                    road.addFirst(new Point2D(p.x, p.y + 1));
                    p.y = p.y + 1;
                }
            }
            if (map[p.x + 1][p.y] < map[p.x][p.y] && map[p.x + 1][p.y] != -1) {
                if (map[p.x + 1][p.y] != map[road.getFirst().x][road.getFirst().y]) {
                    road.addFirst(new Point2D(p.x + 1, p.y));
                    p.x = p.x + 1;
                }
            }
        }
        return road;
    }
}

class MapGenerator {
    int[][] map;

    public MapGenerator() {
        int[][] map = {
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, 0, 0, 0, 0, -1 },
                { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };

        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }

    public void setCat(Point2D pos) {
        map[pos.x][pos.y] = -2;
    }

    public void setExit(Point2D pos) {
        map[pos.x][pos.y] = -3;
    }

    public void setRoad(Deque road) {
        while (road.size() != 0) {
            Point2D coordinate = (Point2D) road.pop();
            map[coordinate.x][coordinate.y] = -5;
        }
    }
}

class MapPrinter {

    public MapPrinter() {

    }

    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%5d", map[row][col]));
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }

        return sb.toString();
    }

    public String mapColor(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case 0:
                        sb.append("▒");
                        break;
                    case -1:
                        sb.append("█");
                        break;
                    case -2:
                        sb.append("K");
                        break;
                    case -3:
                        sb.append("E");
                        break;
                    case -5:
                        sb.append("░");
                        break;
                    default:
                        break;

                }
            }
            sb.append("\n");
        }
        
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }

    
}