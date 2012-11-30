package challenge.refactoring.lastandfirst.after.user;

import challenge.refactoring.lastandfirst.after.word.Word;
import challenge.refactoring.lastandfirst.after.word.WordList;
import challenge.refactoring.lastandfirst.after.word.Words;

/**
 * 指定された言葉を覚えるユーザ。
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
