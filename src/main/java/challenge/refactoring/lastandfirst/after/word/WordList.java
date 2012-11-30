package challenge.refactoring.lastandfirst.after.word;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

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
