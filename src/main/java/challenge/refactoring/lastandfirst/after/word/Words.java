package challenge.refactoring.lastandfirst.after.word;

public interface Words {

    public boolean add(Word word);

    public boolean remove(Word word);

    public boolean contains(Word word);

    public boolean containsInitialWord(String initialWord);

    public Word getByInitial(String initialWord);

    public boolean isEmpty();
}
