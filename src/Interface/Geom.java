package Interface;

abstract public class Geom {
    protected String borderColor;
    protected String backgroundColor;

    public Geom(String borderColor, String backgroundColor) {
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
    }
}
