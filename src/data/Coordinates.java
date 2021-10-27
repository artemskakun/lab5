package data;

/**
 * X-Y coordinates.
 */
public class Coordinates {
    private Long x;
    private Long y;

    public Coordinates(Long x, Long y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return X-coordinate.
     */
    public Long getX() {
        return x;
    }

    /**
     * @return Y-coordinate.
     */
    public Long getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X:" + x + " Y:" + y;
    }

    @Override
    public int hashCode() {
        return y.hashCode() + x.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Coordinates) {
            Coordinates coordinates = (Coordinates) obj;
            return (x == coordinates.getX()) && y.equals(coordinates.getY());
        }
        return false;
    }
}