package challenge.refactoring.lastandfirst.after.user;

import challenge.refactoring.lastandfirst.after.word.Word;
import challenge.refactoring.lastandfirst.after.word.WordSet;
import challenge.refactoring.lastandfirst.after.word.Words;

/**
 * ファイルから取得した単語の情報を重複無く取り込んだユーザ。
 * <p>
 * 取り込む際、重複等を意識している。そのため、取り込むファイルに同一単語が含まれていた場合は、取り込み対象外としている。
 * </p>
 *
 * @author naotake
 */
public class OnlyWordFileUser extends AbstractFileUser {

    private Words multiWords;

    /**
     * {@inheritDoc}<br />
     * 同じ単語を 2 回以上返さぬよう、自身が保持する単語一覧からは除外する。
     */
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
    protected void importWord(String wordStr) {
        Word word = Word.of(wordStr);
        multiWords.add(word);
    }
}
