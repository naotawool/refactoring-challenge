package challenge.refactoring.lastandfirst.before;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 指定された言葉を複数覚えるユーザ。
 *
 * @author naotake
 */
public class MultiWordPickUpUser extends SingleWordPickUpUser {

    private Map<String, List<Word>> multiWords;

    public MultiWordPickUpUser() {
        multiWords = Maps.newHashMap();
    }

    @Override
    public void addWord(String key, String word) {

        // すでにキーが含まれているか？
        if (multiWords.containsKey(key)) {
            List<Word> oldWordList = multiWords.get(key);

            boolean isExists = false;
            for (Word oldWord : oldWordList) {
                // 同じ単語が存在するか？
                if (oldWord.getWord().equals(word)) {
                    isExists = true;
                    break;
                }
            }

            // 同じ単語が無い場合は新たな単語として追加する
            if (!isExists) {
                Word newWord = new Word();
                newWord.setWord(word);
                newWord.setUsed(false);

                multiWords.get(key).add(newWord);
            }
        } else {
            // キーすら含まれていない場合はキーと単語を追加する
            Word newWord = new Word();
            newWord.setWord(word);
            newWord.setUsed(false);

            List<Word> wordList = new ArrayList<Word>();
            wordList.add(newWord);
            this.multiWords.put(key, wordList);
        }
    }

    @Override
    public String nextWord(String word) {
        if (!multiWords.containsKey(word)) {
            return null;
        }

        List<Word> words = multiWords.get(word);

        // 結果の単語
        Word result = null;

        // ファイルから読み込んだ単語の中でまだ使っていない単語を探し出す
        for (Word myWord : words) {
            if (!myWord.isUsed()) {
                result = myWord;
                myWord.setUsed(true);
                break;
            }
        }

        // まだ使っていない単語が無い場合は null を返す
        if (result == null) {
            return null;
        }
        return result.getWord();
    }

    private static class Word {
        private String word;
        private boolean used;

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }
    }
}
