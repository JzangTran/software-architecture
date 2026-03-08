import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {
    private List<FileSystemComponent> children;
    private String name;

    public Folder(String name) {
        children = new ArrayList<>();
        this.name = name;
    }

    public void add(FileSystemComponent child) {
        children.add(child);
    }

    public void remove(FileSystemComponent child) {
        children.remove(child);
    }

    @Override
    public void show(String indent) {
        System.out.println("Folder \t > " + name + indent);
        children.forEach(child -> {
            child.show(indent);
        });
    }
}
