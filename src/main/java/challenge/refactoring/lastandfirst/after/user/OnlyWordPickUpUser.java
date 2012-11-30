package challenge.refactoring.lastandfirst.after.user;

import challenge.refactoring.lastandfirst.after.word.Word;
import challenge.refactoring.lastandfirst.after.word.WordSet;
import challenge.refactoring.lastandfirst.after.word.Words;

/**
 * 指定された単語を重複無く覚えるユーザ。
 * <p>
 * 覚える際、重複等を意識している。そのため、既に覚えた単語が指定された場合は、取り込み対象外としている。
 * </p>
 *
 * @author naotake
 */
public class OnlyWordPickUpUser extends AbstractPickUpUser {

    private Words words;

    public OnlyWordPickUpUser() {
        words = new WordSet();
    }

    @Override
    public boolean pickUpWord(String wordStr) {
        return words.add(Word.of(wordStr));
    }

    /**
     * {@inheritDoc}<br />
     * 同じ単語を 2 回以上返さぬよう、自身が保持する単語一覧からは除外する。
     */
    @Override
    public Word nextWord(String initialWord) {
        Word word = words.getByInitial(initialWord);
        if (word != null) {
            words.remove(word);
        }
        return word;
    }

    @Override
    public String toString() {
        return OnlyWordPickUpUser.class.getSimpleName();
    }
}
