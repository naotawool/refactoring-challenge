package challenge.refactoring.lastandfirst.after.word;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * {@link Words}の{@link List}実装。
 *
 * @author naotake
 */
public class WordList implements Words {

    private List<Word> words;

    public WordList(int initialArraySize) {
        this.words = Lists.newArrayListWithCapacity(initialArraySize);
    }

    public WordList() {
        this.words = Lists.newArrayList();
    }

    @Override
    public boolean add(Word word) {
        return words.add(word);
    }

    @Override
    public boolean remove(Word word) {
        return words.remove(word);
    }

    @Override
    public boolean contains(Word word) {
        return words.contains(word);
    }

    @Override
    public boolean containsInitialWord(String initialWord) {
        return (getByInitial(initialWord) != null);
    }

    /**
     * {@inheritDoc}<br />
     * 該当する単語が複数存在した場合は、単語の文字列の自然順序でソートされたものから最初にヒットしたものを返す。
     */
    @Override
    public Word getByInitial(String initialWord) {
        Collections.sort(words);
        for (Word word : words) {
            if (word.equalsInitialWord(initialWord)) {
                return word;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return words.isEmpty();
    }
}
