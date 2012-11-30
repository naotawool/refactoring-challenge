package challenge.refactoring.lastandfirst.after.user;

import challenge.refactoring.lastandfirst.after.word.Word;
import challenge.refactoring.lastandfirst.after.word.WordList;
import challenge.refactoring.lastandfirst.after.word.Words;

/**
 * しりとりを行うユーザ。<br />
 * ファイルから読み込んだ内容を覚えたユーザ。
 *
 * @author naotake
 */
public class AnyWordFileUser extends AbstractFileUser {

    private Words words;

    @Override
    public Word nextWord(String initialWord) {
        Word word = words.getByInitial(initialWord);
        words.remove(word);
        return word;
    }

    @Override
    protected Class<?> userType() {
        return AnyWordFileUser.class;
    }

    @Override
    protected void initializeWords() {
        this.words = new WordList();
    }

    @Override
    protected void initializeWord(String wordStr) {
        Word word = Word.of(wordStr);
        words.add(word);
    }
}
