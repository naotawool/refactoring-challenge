package challenge.refactoring.lastandfirst.after.word;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * {@link InitialWord}に対するテストクラス。
 *
 * @author naotake
 */
public class InitialWordTest {

    private InitialWord testee;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void 単語のごりらを指定してインスタンスを生成できること() {
        testee = InitialWord.wordOf("ごりら");
        assertThat(testee.toString(), is("ご"));
    }

    @Test
    public void 頭文字の_ご_を指定してインスタンスを生成できること() {
        testee = InitialWord.of("ご");
        assertThat(testee.toString(), is("ご"));
    }

    @Test
    public void 単語を指定なかった場合はNullPointerExceptionが送出されること() {
        exception.expect(NullPointerException.class);
        exception.expectMessage(is("頭文字は必須です。"));

        InitialWord.wordOf(null);
    }

    @Test
    public void 頭文字を指定なかった場合はNullPointerExceptionが送出されること() {
        exception.expect(NullPointerException.class);
        exception.expectMessage(is("頭文字は必須です。"));

        InitialWord.of("");
    }
}
