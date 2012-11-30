package challenge.refactoring.lastandfirst.after.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

public class FileReader {

    private static final String DEFAULT_ENCODING = "utf-8";

    private final InputStream in;

    private FileReader(InputStream in) {
        this.in = in;
    }

    public static FileReader asText(Class<?> clazz) {
        return new FileReader(getResourceAsStream(clazz, FileExtension.TEXT));
    }

    private static InputStream getResourceAsStream(Class<?> clazz,
            FileExtension extension) {
        return clazz.getResourceAsStream(String.format("%s.%s",
                clazz.getSimpleName(), extension));
    }

    public List<String> readLines() {
        try {
            return IOUtils.readLines(in, DEFAULT_ENCODING);
        } catch (IOException e) {
            return Lists.newArrayListWithCapacity(0);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

    public List<String> readLinesDeletedWhitespace() {
        List<String> lines = readLines();

        List<String> deletedWhitespaceLines = Lists
                .newArrayListWithCapacity(lines.size());
        for (String line : lines) {
            deletedWhitespaceLines.add(StringUtils.deleteWhitespace(line));
        }
        return deletedWhitespaceLines;
    }

    private static enum FileExtension {
        TEXT("txt");

        private final String extension;

        private FileExtension(String extension) {
            this.extension = extension;
        }

        @Override
        public String toString() {
            return extension;
        }
    }
}
