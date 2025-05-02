public class TextFile implements File {
    public String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void show(){
        System.out.println("TextFile: "+name);
    }

    @Override
    public void add(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
