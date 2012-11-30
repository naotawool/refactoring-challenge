package challenge.refactoring.lastandfirst.after.word;

import static challenge.refactoring.lastandfirst.after.IsWord.isWord;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link WordList}に対するテストクラス。
 *
 * @author naotake
 */
@RunWith(Enclosed.class)
public class WordListTest {

    public static class WordListが空の場合 {
        private WordList testee;

        @Before
        public void before() {
            testee = new WordList();
        }

        @Test
        public void contains_ごりら_でfalseが返されること() {
            assertThat(testee.contains(Word.of("ごりら")), is(false));
        }

        @Test
        public void remove_ごりら_でfalseが返されること() {
            assertThat(testee.remove(Word.of("ごりら")), is(false));
        }

        @Test
        public void containsInitialWord_ご_でfalseが返されること() {
            assertThat(testee.containsInitialWord("ご"), is(false));
        }

        @Test
        public void getByInitial_ご_でnullが返されること() {
            assertThat(testee.getByInitial("ご"), nullValue());
        }

        @Test
        public void isEmptyでtrueが返されること() {
            assertThat(testee.isEmpty(), is(true));
        }
    }

    public static class WordListに_ごりら_が設定されている場合 {

        private WordList testee;

        @Before
        public void before() {
            testee = new WordList();
            testee.add(Word.of("ごりら"));
        }

        @Test
        public void contains_ごりら_でtrueが返されること() {
            assertThat(testee.contains(Word.of("ごりら")), is(true));
        }

        @Test
        public void remove_ごりら_でtrueが返されること() {
            assertThat(testee.remove(Word.of("ごりら")), is(true));
        }

        @Test
        public void containsInitialWord_ご_でtrueが返されること() {
            assertThat(testee.containsInitialWord("ご"), is(true));
        }

        @Test
        public void getByInitial_ご_で_ごりら_が返されること() {
            assertThat(testee.getByInitial("ご"), isWord("ごりら"));
        }

        @Test
        public void isEmptyでfalseが返されること() {
            assertThat(testee.isEmpty(), is(false));
        }

        @Test
        public void addで同じ単語のごりらを追加できること() {
            assertThat(testee.add(Word.of("ごりら")), is(true));
        }
    }

    public static class WordListに_らっぱ_が設定されている場合 {

        private WordList testee;

        @Before
        public void before() {
            testee = new WordList();
            testee.add(Word.of("らっぱ"));
        }

        @Test
        public void contains_ごりら_でfalseが返されること() {
            assertThat(testee.contains(Word.of("ごりら")), is(false));
        }

        @Test
        public void remove_ごりら_でfalseが返されること() {
            assertThat(testee.remove(Word.of("ごりら")), is(false));
        }

        @Test
        public void containsInitialWord_ご_でfalseが返されること() {
            assertThat(testee.containsInitialWord("ご"), is(false));
        }

        @Test
        public void getByInitial_ご_でnullが返されること() {
            assertThat(testee.getByInitial("ご"), nullValue());
        }

        @Test
        public void isEmptyでtrueが返されること() {
            assertThat(testee.isEmpty(), is(false));
        }
    }
}
