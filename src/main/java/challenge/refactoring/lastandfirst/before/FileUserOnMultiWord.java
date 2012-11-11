package challenge.refactoring.lastandfirst.before;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

/**
 * しりとりを行うユーザ。<br />
 * ファイルから読み込んだ内容を覚えたユーザ。<br />
 * 開始文字が同じ言葉を許容する。
 *
 * @author naotake
 */
public class FileUserOnMultiWord extends FileUser {

    private Map<String, List<Word>> multiWords;

    public FileUserOnMultiWord() {

        InputStream in = null;
        List<String> lines = null;
        try {
            // ファイル読み込み
            in = FileUser.class.getResourceAsStream(FileUserOnMultiWord.class
                    .getSimpleName() + ".txt");

            // 行単位でファイルの内容を読み込み List に文字列として格納する
            lines = IOUtils.readLines(in, "utf-8");
        } catch (IOException e) {
            lines = new ArrayList<String>();
        } finally {
            IOUtils.closeQuietly(in);
        }

        multiWords = new HashMap<String, List<Word>>();

        // ファイルの各行単位に処理を行う
        for (String line : lines) {
            String[] words = StringUtils.split(
                    StringUtils.deleteWhitespace(line), ",");
            for (String word : words) {
                // 単語の先頭の文字をキーとする
                String key = StringUtils.left(word, 1);

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
