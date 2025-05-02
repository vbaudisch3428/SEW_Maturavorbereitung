import java.util.ArrayList;
import java.util.List;

public class Folder implements File{
    private String name;
    private List<File> children = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    @Override
    public void show(){
        System.out.println("Folder: "+name);
        for (File f : children){
            f.show();
        }
    }

    @Override
    public void add(File file){
        children.add(file);
    }

    public void remove(File file){
        children.remove(file);
    }
}

