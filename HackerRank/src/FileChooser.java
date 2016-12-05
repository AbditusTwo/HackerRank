import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileChooser {
    public static void main (String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);

        int returnValue = chooser.showOpenDialog(chooser);

        try (BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath()));
             BufferedWriter bw = new BufferedWriter(new FileWriter(chooser.getCurrentDirectory() + "\\myfile.txt"))
        ) {

            String sCurrentString;

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());

                while ((sCurrentString = br.readLine()) != null) {
                    if (sCurrentString.contains("Something")) {
                        String sConverted = sCurrentString.replace("What_to_replace", "on_what_to_replace" );
                        bw.write(sConverted + "\n");
                        //Debug:
                        System.out.println(sConverted);
                    }
                    //Do something
                }
            }
        }
    }
}