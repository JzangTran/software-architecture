public class Editor {
    public EventManager events;

    public Editor() {
        events = new EventManager("open", "save");
    }

    public void openFile() {
        System.out.println("open file: abc.txt");
        events.notify("open", "abc.txt");
    }

    public void saveFile() {
        System.out.println("save file: abc.txt");
        events.notify("save", "abc.txt");
    }
}
