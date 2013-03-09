package challenge.refactoring.lastandfirst.after.word;

import org.apache.commons.lang.StringUtils;

/**
 * 単語の頭文字を表すクラス。
 *
 * @author naotake
 */
public class InitialWord {

    /** 頭文字 */
    private String initialWord;

    /**
     * コンストラクタによるインスタンス化を抑制。
     */
    private InitialWord(String initialWord) {
        this.initialWord = initialWord;
    }

    /**
     * 単語の文字列を基にインスタンスを生成する。
     *
     * @param word 単語の文字列
     * @return {@link InitialWord}
     */
    public static InitialWord wordOf(String word) {
        isValid(word);
        return new InitialWord(StringUtils.left(word, 1));
    }

    /**
     * 単語の頭文字を基にインスタンスを生成する。
     *
     * @param initialWord 単語の頭文字
     * @return {@link InitialWord}
     */
    public static InitialWord of(String initialWord) {
        isValid(initialWord);
        return new InitialWord(initialWord);
    }

    private static void isValid(String word) {
        if (StringUtils.isEmpty(word)) {
            throw new NullPointerException("頭文字は必須です。");
        }
    }

    /**
     * 頭文字が等しいかどうかを比較する。
     *
     * @param other 比較対象
     * @return 頭文字が等しい場合は{@code true}
     */
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

    /**
     * @return 頭文字
     */
    @Override
    public String toString() {
        return initialWord;
    }
}
