package challenge.refactoring.lastandfirst.after.word;

import org.apache.commons.lang.StringUtils;

/**
 * 単語を表すクラス。
 *
 * @author naotake
 */
public class Word implements Comparable<Word> {

    private InitialWord initialWord;
    private String word;

    /**
     * コンストラクタによるインスタンス化を抑制。
     */
    private Word(InitialWord initialWord, String word) {
        this.initialWord = initialWord;
        this.word = word;
    }

    /**
     * 単語の文字列を基にインスタンスを生成する。
     *
     * @param word 単語の文字列
     * @return {@link Word}
     */
    public static Word of(String word) {
        isValid(word);
        return new Word(InitialWord.wordOf(word), word);
    }

    private static void isValid(String word) {
        if (StringUtils.isEmpty(word)) {
            throw new NullPointerException("単語は必須です。");
        }
    }

    /**
     * 単語の頭文字が等しいかどうかを比較する。
     *
     * @param initialWord 比較する頭文字
     * @return 頭文字が等しい場合は{@code true}
     */
    public boolean equalsInitialWord(String initialWord) {
        return InitialWord.of(initialWord).equals(this.initialWord);
    }

    /**
     * 頭文字を取得する。
     *
     * @return {@link InitialWord}
     */
    public InitialWord getInitialWord() {
        return initialWord;
    }

    /**
     * 単語の最後が "ん" で終わっているかどうかを取得する。
     *
     * @return 単語の最後が "ん" で終わっている場合は{@code true}
     */
    public boolean endsWithNn() {
        return StringUtils.endsWith(word, "ん");
    }

    /**
     * 単語の最後が "ー" or "－" で終わっているかどうかを取得する。
     *
     * @return 単語の最後が "ー" or "－" で終わっている場合は{@code true}
     */
    public boolean endsWithHyphen() {
        String lastWord = substringLastWord();
        return StringUtils.equals(lastWord, "ー")
                || StringUtils.equals(lastWord, "－");
    }

    /**
     * 単語の最後の文字を返す。
     *
     * <pre>
     * ごりら  -->  ら
     * らっぱ  -->  ぱ
     * みるく  -->  く
     * </pre>
     *
     * @return 単語の最後の文字
     */
    public String substringLastWord() {
        return StringUtils.left(StringUtils.reverse(word), 1);
    }

    /**
     * 単語の最後の手前の文字を返す。
     *
     * <pre>
     * ごりら  -->  り
     * らっぱ  -->  っ
     * みるく  -->  る
     * さる    -->  {@code null}
     * </pre>
     *
     * @return 単語の最後の手前の文字
     */
    public String substringBeforeLastWord() {
        if (word.length() < 2) {
            return null;
        }
        return StringUtils.mid(StringUtils.reverse(word), 1, 1);
    }

    /**
     * 単語の文字列が等しいかどうかを比較する。
     *
     * @param other 比較対象
     * @return 単語の文字列が等しい場合は{@code true}
     */
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

    /**
     * 単語の文字列による順序の比較を行う。
     *
     * @see String#compareTo(String)
     */
    @Override
    public int compareTo(Word other) {
        return word.compareTo(other.word);
    }
}
