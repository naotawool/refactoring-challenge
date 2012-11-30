package challenge.refactoring.lastandfirst.after.word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

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
