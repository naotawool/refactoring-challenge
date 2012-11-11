package challenge.refactoring.lastandfirst.before;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * しりとりを行うデフォルトユーザ。
 *
 * @author naotake
 */
public class DefaultUser {

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

    public String nextWord(String word) {
        if (!WORDS.containsKey(word)) {
            return null;
        }
        return WORDS.get(word);
    }
}
