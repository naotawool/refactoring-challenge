package challenge.refactoring.lastandfirst.after.user;

import challenge.refactoring.lastandfirst.after.word.Word;
import challenge.refactoring.lastandfirst.after.word.WordList;
import challenge.refactoring.lastandfirst.after.word.Words;

/**
 * 指定した単語を覚えるユーザ。
 * <p>
 * 覚える際、重複等は意識していない。そのため、既に覚えた単語が指定された場合でも取り込まれてしまうことに注意すること。
 * </p>
 *
 * @author naotake
 */
public class AnyWordPickUpUser extends AbstractPickUpUser {

    private Words words;

    public AnyWordPickUpUser() {
        this.words = new WordList();
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
        words.remove(word);
        return word;
    }

    @Override
    public String toString() {
        return AnyWordPickUpUser.class.getSimpleName();
    }
}
