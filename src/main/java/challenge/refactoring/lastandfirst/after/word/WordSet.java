package challenge.refactoring.lastandfirst.after.word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * {@link Words}の{@link Set}実装。
 *
 * @author naotake
 */
public class WordSet implements Words {

    private Set<Word> words;

    public WordSet(int expectedSize) {
        this.words = Sets.newHashSetWithExpectedSize(expectedSize);
    }

    public WordSet() {
        this.words = Sets.newHashSet();
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
        List<Word> wordList = new ArrayList<Word>(words);
        Collections.sort(wordList);
        for (Word word : wordList) {
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
