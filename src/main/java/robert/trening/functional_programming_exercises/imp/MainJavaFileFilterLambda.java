package robert.trening.functional_programming_exercises.imp;

import java.io.File;
import java.io.FileFilter;

public class MainJavaFileFilterLambda {
    public static void main(String[] args) {
//        FileFilter fileFilter1 = new FileFilter() {
//
//            @Override
//            public boolean accept(File file) {
//                return file.getName().endsWith(".java");
//            }
//        };
        FileFilter filter = (File file) -> file.getName().endsWith(".java");

        File dir = new File("d:\\java\\noweRozdanie\\microservices-demo\\microservices-demo\\src\\main\\java\\io\\pivotal\\microservices\\services\\web");
        File[] javaFiles;
        javaFiles = dir.listFiles(filter);

        for (File f : javaFiles) {
            System.out.println(f);
        }


    }

}
