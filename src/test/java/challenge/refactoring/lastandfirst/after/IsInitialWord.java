package challenge.refactoring.lastandfirst.after;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import challenge.refactoring.lastandfirst.after.word.InitialWord;

public class IsInitialWord extends TypeSafeMatcher<InitialWord> {

    private InitialWord expect;

    private IsInitialWord(InitialWord expect) {
        this.expect = expect;
    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(expect);
    }

    @Override
    protected boolean matchesSafely(InitialWord actual) {
        return actual.equals(expect);
    }

    public static IsInitialWord isInitialWord(String expect) {
        return new IsInitialWord(InitialWord.of(expect));
    }

    public static IsInitialWord isInitialWord(InitialWord expect) {
        return new IsInitialWord(expect);
    }
}
