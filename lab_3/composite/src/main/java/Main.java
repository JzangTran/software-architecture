import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main editor = new Main();
        editor.load();

        CompoundGraphic selection = new CompoundGraphic();
        Dot d = new Dot(10, 20);
        Circle c = new Circle(15, 15, 5);

        selection.add(d);
        selection.add(c);

        editor.groupSelected(List.of(d, c));
    }

    private CompoundGraphic graphic;

    public void load() {
        graphic = new CompoundGraphic();

        graphic.add(new Dot(1, 2));
        graphic.add(new Circle(5, 3, 10));
    }

    public void groupSelected(List<Graphic> components) {
        CompoundGraphic group = new CompoundGraphic();
        for(Graphic component: components) {
            group.add(component);
            graphic.remove(component);
        }

        graphic.add(group);
        graphic.draw();
    }
}
