public class Main {
    public static void main(String[] args){
        File file1 = new TextFile("file1.txt");
        File file2 = new ImageFile("file2.jpg");
        File file3 = new ImageFile("file3.png");

        Folder folder = new Folder("MyFolder");
        folder.add(file1);
        folder.add(file2);
        folder.add(file3);

        folder.show();

        System.out.println();

        folder.remove(file1);
        folder.show();
    }
}
