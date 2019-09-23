package save_load;

import gui.FieldFrameBuilder;

import java.io.*;

public class SaveLoad implements Serializable {

    public void save(Object e) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("E:\\eclipse-workspace\\RabbitsGUI3\\save.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(e);
        out.close();
        fileOut.close();
    }

    public FieldFrameBuilder load() throws IOException, ClassNotFoundException {
        FieldFrameBuilder e;
        FileInputStream fileIn = new FileInputStream("E:\\eclipse-workspace\\RabbitsGUI3\\save.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        e = (FieldFrameBuilder) in.readObject();
        in.close();
        fileIn.close();
        return e;
    }

}
