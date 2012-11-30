package challenge.refactoring.lastandfirst.after;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import challenge.refactoring.lastandfirst.after.word.Word;

public class IsWord extends TypeSafeMatcher<Word> {

    private Word expect;

    private IsWord(Word expect) {
        this.expect = expect;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(expect);
    }

    @Override
    protected boolean matchesSafely(Word actual) {
        return actual.equals(expect);
    }

    public static IsWord isWord(String expect) {
        return new IsWord(Word.of(expect));
    }

    public static IsWord isWord(Word expect) {
        return new IsWord(expect);
    }
}
