package challenge.refactoring.lastandfirst.before;

import java.util.HashMap;
import java.util.Map;

/**
 * 指定された言葉を覚えるユーザ。
 *
 * @author naotake
 */
public class SingleWordPickUpUser {

    private Map<String, String> wordList;

    public SingleWordPickUpUser() {
        wordList = new HashMap<String, String>();
    }

    public void addWord(String key, String word) {
        wordList.put(key, word);
    }

    public String nextWord(String word) {
        if (!wordList.containsKey(word)) {
            return null;
        }
        return wordList.get(word);
    }
}
