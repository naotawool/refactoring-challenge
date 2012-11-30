package challenge.refactoring.lastandfirst.after.user;

import java.util.Map;

import challenge.refactoring.lastandfirst.after.word.Word;

import com.google.common.collect.Maps;

/**
 * しりとりを行うデフォルトユーザ。
 * <p>
 * インスタンス時に指定された単語のみを保持する。
 * </p>
 *
 * @author naotake
 */
public class DefaultUser implements User {

    private static final Map<String, String> WORDS = Maps.newHashMap();

    public DefaultUser() {
        WORDS.put("り", "りんご");
        WORDS.put("ご", "ごりら");
        WORDS.put("ら", "らっぱ");
        WORDS.put("ぱ", "ぱんだ");
        WORDS.put("だ", "だんご");
        WORDS.put("ご", "ごーる");
        WORDS.put("る", "るびー");
        WORDS.put("び", "びーる");
        WORDS.put("る", "るーる");
        WORDS.put("る", "るーと");
        WORDS.put("と", "といれ");
        WORDS.put("や", "やくると");
    }

    @Override
    public Word nextWord(String initialWord) {
        if (!WORDS.containsKey(initialWord)) {
            return null;
        }
        return Word.of(WORDS.get(initialWord));
    }

    public String toString() {
        return DefaultUser.class.getSimpleName();
    }
}
