package de.mss.littleprofessor.app;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;


public class LibFileFilter implements FileFilter {

   @Override
   public boolean accept(File f) {
      PathMatcher m = FileSystems.getDefault().getPathMatcher("glob:*globlib*.jar");
      if (m.matches(Paths.get(f.getName())))
         return false;
      m = FileSystems.getDefault().getPathMatcher("glob:*lib*.jar");
      return m.matches(Paths.get(f.getName()));
   }

}
