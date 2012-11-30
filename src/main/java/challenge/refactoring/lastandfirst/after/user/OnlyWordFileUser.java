package challenge.refactoring.lastandfirst.after.user;

import challenge.refactoring.lastandfirst.after.word.Word;
import challenge.refactoring.lastandfirst.after.word.WordSet;
import challenge.refactoring.lastandfirst.after.word.Words;

/**
 * しりとりを行うユーザ。<br />
 * ファイルから読み込んだ内容を覚えたユーザ。<br />
 * 開始文字が同じ言葉を許容する。
 *
 * @author naotake
 */
public class OnlyWordFileUser extends AbstractFileUser {

    private Words multiWords;

    @Override
    public Word nextWord(String initialWord) {
        Word word = multiWords.getByInitial(initialWord);
        multiWords.remove(word);
        return word;
    }

    @Override
    protected Class<?> userType() {
        return OnlyWordFileUser.class;
    }

    @Override
    protected void initializeWords() {
        multiWords = new WordSet();
    }

    @Override
    protected void initializeWord(String wordStr) {
        Word word = Word.of(wordStr);
        multiWords.add(word);
    }
}
