package challenge.refactoring.lastandfirst.after;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;

import challenge.refactoring.lastandfirst.after.word.Word;
import challenge.refactoring.lastandfirst.after.word.WordSet;

/**
 * 審判員クラス。
 *
 * @author naotake
 */
public class Judge {

    private static final String[] LOWER_CASE_WORD = //
    { "ぁ", "ぃ", "ぅ", "ぇ", "ぉ", "ゃ", "ゅ", "ょ" };

    private static final String[] UPPER_CASE_WORD = //
    { "あ", "い", "う", "え", "お", "や", "ゆ", "よ" };

    private static final String[] ALL_HIRAGANA = { "あ", "い", "う", "え", "お", //
            "か", "き", "く", "け", "こ", "さ", "し", "す", "せ", "そ", //
            "た", "ち", "つ", "て", "と", "な", "に", "ぬ", "ね", "の", //
            "は", "ひ", "ふ", "へ", "ほ", "ま", "み", "む", "め", "も", //
            "や", "ゆ", "よ", "ら", "り", "る", "れ", "ろ", "わ", "を" };

    private static final WordSet SAID_WORDS = new WordSet();

    /**
     * しりとりの最初の文字を取得する。
     *
     * @return 最初の言葉
     */
    public String startWord() {
        return ALL_HIRAGANA[RandomUtils.nextInt(ALL_HIRAGANA.length)];
    }

    /**
     * 指定された言葉が正しいかどうかをチェックする。 <br />
     * 以下の条件に 1 つも該当しなければ{@code true}を返す。
     * <ul>
     * <li>指定された言葉が空かどうか</li>
     * <li>指定された言葉が「ん」で終わっているかどうか</li>
     * <li>既に出た言葉かどうか</li>
     * </ul>
     *
     * @param word 言葉
     * @return 正しい場合は{@code true}
     */
    public boolean isValidWord(Word word) {
        if (word == null || word.endsWithNn()) {
            return false;
        }
        return SAID_WORDS.add(word);
    }

    /**
     * 指定された言葉を基に、次の文字を返す。
     *
     * @param word 言葉
     * @return 次の文字
     */
    public String nextWord(Word word) {

        String lastWord = word.substringLastWord();
        if (word.endsWithHyphen()) {
            lastWord = word.substringBeforeLastWord();
        }
        return replaceLowerToUpper(lastWord);
    }

    private String replaceLowerToUpper(String word) {
        return StringUtils.replaceEach(word, LOWER_CASE_WORD, UPPER_CASE_WORD);
    }
}
