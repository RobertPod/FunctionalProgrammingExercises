package robert.trening.functional_programming_exercises.imp;

import java.io.File;
import java.io.FileFilter;

public class JavaFileFilter implements FileFilter {
    //    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".java");
    }
}
