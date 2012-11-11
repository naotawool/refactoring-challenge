package challenge.refactoring.lastandfirst.before;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;

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

    private static final List<String> SAID_WORDS = new ArrayList<String>();

    /**
     * しりとりの最初の文字を取得する。
     *
     * @return 最初の言葉
     */
    public String getStartWord() {
        return ALL_HIRAGANA[RandomUtils.nextInt(ALL_HIRAGANA.length)];
    }

    /**
     * 指定された言葉が正しいかどうかをチェックする。
     *
     * @param word 言葉
     * @return 正しい場合は{@code true}
     */
    public boolean okWord(String word) {
        if (StringUtils.isEmpty(word) // 指定された言葉が空かどうか
                || StringUtils.endsWith(word, "ん") // 指定された言葉が「ん」で終わっているかどうか
                || SAID_WORDS.contains(word) // 既に出た言葉かどうか
        ) {
            return false;
        }

        SAID_WORDS.add(word);
        return true;
    }

    /**
     * 指定された言葉を基に、次の文字を返す。
     *
     * @param word 言葉
     * @return 次の文字
     */
    public String nextWord(String word) {

        String nextWord = StringUtils.left(StringUtils.reverse(word), 1);

        if (StringUtils.equals(nextWord, "ー")
                || StringUtils.equals(nextWord, "－")) {
            nextWord = StringUtils.mid(StringUtils.reverse(word), 1, 1);
        }

        return StringUtils.replaceEach(nextWord, LOWER_CASE_WORD,
                UPPER_CASE_WORD);
    }
}
