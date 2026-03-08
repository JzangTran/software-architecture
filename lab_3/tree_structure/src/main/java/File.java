public class File implements FileSystemComponent {
    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void show(String indent) {
        System.out.println("File \t > " + indent + fileName);
    }
}
