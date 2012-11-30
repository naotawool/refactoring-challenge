package challenge.refactoring.lastandfirst.after.word;

import static challenge.refactoring.lastandfirst.after.IsInitialWord.isInitialWord;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link Word}に対するテストクラス。
 *
 * @author naotake
 */
@RunWith(Enclosed.class)
public class WordTest {

    public static class 単語がごりらの場合 {

        private Word testee;

        @Before
        public void before() {
            testee = Word.of("ごりら");
        }

        @Test
        public void 最後の一つ前の文字として_り_が返されること() {
            assertThat(testee.substringBeforeLastWord(), is("り"));
        }

        @Test
        public void 最後の文字が_ん_ではないのでfalseが返されること() {
            assertThat(testee.endsWithNn(), is(false));
        }

        @Test
        public void 最後の文字が_ー_ではないのでfalseが返されること() {
            assertThat(testee.endsWithHyphen(), is(false));
        }
    }

    public static class 単語がきりんの場合 {

        private Word testee;

        @Before
        public void before() {
            testee = Word.of("きりん");
        }

        @Test
        public void 最後の一つ前の文字として_り_が返されること() {
            assertThat(testee.substringBeforeLastWord(), is("り"));
        }

        @Test
        public void 最後の文字が_ん_なのでtrueが返されること() {
            assertThat(testee.endsWithNn(), is(true));
        }

        @Test
        public void 最後の文字が_ー_ではないのでfalseが返されること() {
            assertThat(testee.endsWithHyphen(), is(false));
        }
    }

    public static class 単語がちーたーの場合 {

        private Word testee;

        @Before
        public void before() {
            testee = Word.of("ちーたー");
        }

        @Test
        public void 最後の一つ前の文字として_た_が返されること() {
            assertThat(testee.substringBeforeLastWord(), is("た"));
        }

        @Test
        public void 最後の文字が_ん_ではないのでfalseが返されること() {
            assertThat(testee.endsWithNn(), is(false));
        }

        @Test
        public void 最後の文字が_ー_なのでtrueが返されること() {
            assertThat(testee.endsWithHyphen(), is(true));
        }
    }

    public static class 単語がめの場合 {

        private Word testee;

        @Before
        public void before() {
            testee = Word.of("め");
        }

        @Test
        public void 単語が一文字なので最後の一つ前の文字としてnullが返されること() {
            assertThat(testee.substringBeforeLastWord(), nullValue());
        }
    }

    public static class 共通処理のテスト {

        private Word testee;

        @Before
        public void before() {
            testee = Word.of("たんご");
        }

        @Test(expected = NullPointerException.class)
        public void 単語を指定なかった場合はNullPointerExceptionが送出されること() {
            Word.of(null);
        }

        @Test
        public void 最初の文字が_た_と等しい場合trueが返されること() {
            assertThat(testee.equalsInitialWord("た"), is(true));
        }

        @Test
        public void 最初の文字が_ご_と異なる場合falseが返されること() {
            assertThat(testee.equalsInitialWord("ご"), is(false));
        }

        @Test
        public void 最初の文字として_ご_が返されること() {
            assertThat(testee.getInitialWord(), isInitialWord("た"));
        }

        @Test
        public void 最後の文字として_ら_が返されること() {
            assertThat(testee.substringLastWord(), is("ご"));
        }

        @Test
        public void equalsで同じ単語を指定した場合trueが返されること() {
            assertThat(testee.equals(Word.of("たんご")), is(true));
        }

        @Test
        public void equalsで異なる単語を指定した場合falseが返されること() {
            assertThat(testee.equals(Word.of("だんご")), is(false));
        }

        @Test
        public void equalsでWordの型以外を指定した場合falseが返されること() {
            assertThat(testee.equals("たんご"), is(false));
        }

        @Test
        public void toStringで_たんご_が返されること() {
            assertThat(testee.toString(), is("たんご"));
        }
    }
}
