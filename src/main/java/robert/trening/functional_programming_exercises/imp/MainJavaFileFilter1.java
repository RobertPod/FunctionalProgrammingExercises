package robert.trening.functional_programming_exercises.imp;

import java.io.File;
import java.io.FileFilter;

public class MainJavaFileFilter1 {
    public static void main(String[] args) {
        FileFilter fileFilter1 = new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };

        File dir = new File("d:\\java\\noweRozdanie\\microservices-demo\\microservices-demo\\src\\main\\java\\io\\pivotal\\microservices\\services\\web");
        File[] javaFiles;
        javaFiles = dir.listFiles(fileFilter1);


    }

}
