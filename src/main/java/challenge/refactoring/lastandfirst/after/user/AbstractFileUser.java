package challenge.refactoring.lastandfirst.after.user;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import challenge.refactoring.lastandfirst.after.utils.FileReader;

abstract class AbstractFileUser implements User {

    private static final String DEFAULT_SEPARATOR_CHARS = ",";

    protected AbstractFileUser() {
        initializeWords();

        FileReader fileReader = FileReader.asText(userType());

        List<String> lines = fileReader.readLinesDeletedWhitespace();
        for (String line : lines) {
            String[] words = StringUtils.split(line, DEFAULT_SEPARATOR_CHARS);
            for (String word : words) {
                initializeWord(word);
            }
        }
    }

    protected abstract Class<?> userType();

    protected abstract void initializeWords();

    protected abstract void initializeWord(String word);

    @Override
    public String toString() {
        return userType().getSimpleName();
    }
}
