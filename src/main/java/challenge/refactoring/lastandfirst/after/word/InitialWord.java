package challenge.refactoring.lastandfirst.after.word;

import org.apache.commons.lang.StringUtils;

public class InitialWord {

    private String initialWord;

    private InitialWord(String initialWord) {
        this.initialWord = initialWord;
    }

    public static InitialWord wordOf(String word) {
        isValid(word);
        return new InitialWord(StringUtils.left(word, 1));
    }

    public static InitialWord of(String initialWord) {
        isValid(initialWord);
        return new InitialWord(initialWord);
    }

    private static void isValid(String word) {
        if (StringUtils.isEmpty(word)) {
            throw new NullPointerException("頭文字は必須です。");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof InitialWord)) {
            return false;
        }

        return StringUtils.equals(initialWord,
                InitialWord.class.cast(other).initialWord);
    }

    @Override
    public int hashCode() {
        return initialWord.hashCode();
    }

    @Override
    public String toString() {
        return initialWord;
    }
}
