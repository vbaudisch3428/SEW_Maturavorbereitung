public class ImageFile implements File {
    public String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void show(){
        System.out.println("ImageFile: "+name);
    }

    @Override
    public void add(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
