package challenge.refactoring.lastandfirst.after.user;

import challenge.refactoring.lastandfirst.after.word.Word;
import challenge.refactoring.lastandfirst.after.word.WordList;
import challenge.refactoring.lastandfirst.after.word.Words;

/**
 * ファイルから取得した単語の情報を取り込んだユーザ。
 * <p>
 * 取り込む際、重複等は意識していない。そのため、取り込むファイルに同一単語が含まれていた場合でも、そのまま取り込んでいることに注意すること。
 * </p>
 *
 * @author naotake
 */
public class AnyWordFileUser extends AbstractFileUser {

    private Words words;

    /**
     * {@inheritDoc}<br />
     * 同じ単語を 2 回以上返さぬよう、自身が保持する単語一覧からは除外する。
     */
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
    protected void importWord(String wordStr) {
        Word word = Word.of(wordStr);
        words.add(word);
    }
}
