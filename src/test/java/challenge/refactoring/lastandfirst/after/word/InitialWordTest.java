package challenge.refactoring.lastandfirst.after.word;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * {@link InitialWord}に対するテストクラス。
 *
 * @author naotake
 */
public class InitialWordTest {

    private InitialWord testee;

    @Test
    public void 単語のごりらを指定してインスタンスを生成できること() {
        testee = InitialWord.wordOf("ごりら");
        assertThat(testee.toString(), is("ご"));
    }

    @Test(expected = NullPointerException.class)
    public void 単語を指定なかった場合はNullPointerExceptionが送出されること() {
        InitialWord.wordOf(null);
    }

    @Test(expected = NullPointerException.class)
    public void 頭文字を指定なかった場合はNullPointerExceptionが送出されること() {
        InitialWord.of("");
    }
}
