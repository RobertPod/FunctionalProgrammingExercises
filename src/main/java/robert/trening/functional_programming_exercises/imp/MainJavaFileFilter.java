package robert.trening.functional_programming_exercises.imp;

import java.io.File;

public class MainJavaFileFilter {
    public static void main(String[] args) {
        JavaFileFilter fileFilter = new JavaFileFilter();

        File dir = new File("d:\\java\\noweRozdanie\\microservices-demo\\microservices-demo\\src\\main\\java\\io\\pivotal\\microservices\\services\\web");
        File[] javaFiles;
        javaFiles = dir. listFiles(fileFilter);


    }

}
