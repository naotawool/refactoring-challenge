package challenge.refactoring.lastandfirst.after.user;

import challenge.refactoring.lastandfirst.after.word.Word;
import challenge.refactoring.lastandfirst.after.word.WordSet;
import challenge.refactoring.lastandfirst.after.word.Words;

/**
 * 指定された言葉を複数覚えるユーザ。
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
