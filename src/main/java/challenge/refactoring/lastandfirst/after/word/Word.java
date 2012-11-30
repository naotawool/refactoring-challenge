package challenge.refactoring.lastandfirst.after.word;

import org.apache.commons.lang.StringUtils;

public class Word implements Comparable<Word> {

    private InitialWord initialWord;
    private String word;

    private Word(InitialWord initialWord, String word) {
        this.initialWord = initialWord;
        this.word = word;
    }

    public static Word of(String word) {
        isValid(word);
        return new Word(InitialWord.wordOf(word), word);
    }

    private static void isValid(String word) {
        if (StringUtils.isEmpty(word)) {
            throw new NullPointerException("単語は必須です。");
        }
    }

    public boolean equalsInitialWord(String initialWord) {
        return InitialWord.of(initialWord).equals(this.initialWord);
    }

    public InitialWord getInitialWord() {
        return initialWord;
    }

    public boolean endsWithNn() {
        return StringUtils.endsWith(word, "ん");
    }

    public String substringLastWord() {
        return StringUtils.left(StringUtils.reverse(word), 1);
    }

    public String substringBeforeLastWord() {
        if (word.length() < 2) {
            return null;
        }
        return StringUtils.mid(StringUtils.reverse(word), 1, 1);
    }

    public boolean endsWithHyphen() {
        String lastWord = substringLastWord();
        return StringUtils.equals(lastWord, "ー")
                || StringUtils.equals(lastWord, "－");
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Word)) {
            return false;
        }

        return StringUtils.equals(word, Word.class.cast(other).toString());
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public int compareTo(Word other) {
        return word.compareTo(other.word);
    }
}
