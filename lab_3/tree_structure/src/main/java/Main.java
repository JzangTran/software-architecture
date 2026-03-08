public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("C://temp");

        File file1 = new File("/text_1.txt");
        File file2 = new File("/text_2.txt");

        Folder docs = new Folder("/docs");
        Folder images = new Folder("/images");

        docs.add(new File("/cv.pdf"));
        docs.add(new File("/report.docs"));

        images.add(new File("/img_1.png"));
        images.add(new File("/img_2.png"));

        root.add(file1);
        root.add(file2);
        root.add(docs);
        root.add(images);

        root.show("");
    }
}
