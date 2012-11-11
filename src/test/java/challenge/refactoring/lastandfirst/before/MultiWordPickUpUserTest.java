package challenge.refactoring.lastandfirst.before;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link MultiWordPickUpUser}に対するテストクラス。
 *
 * FIXME @Enclosed を使ったテストを書ける
 *
 * @author naotake
 */
public class MultiWordPickUpUserTest {

    private MultiWordPickUpUser testee;

    @Before
    public void before() {
        testee = new MultiWordPickUpUser();
    }

    @Test
    public void _しまうま_を覚えさせたら_し_の言葉として_しまうま_を返すこと() {
        testee.addWord("し", "しまうま");
        assertThat(testee.nextWord("し"), is("しまうま"));
    }

    @Test
    public void _しまうま_を覚えさせてが_ま_の言葉としてはnullを返すこと() {
        testee.addWord("し", "しまうま");
        assertThat(testee.nextWord("ま"), nullValue());
    }

    /**
     * 同じ言葉を返さないこと。
     */
    @Test
    public void _しまうま_と_しまんと_を覚えさせたら_し_の言葉として２つ返すこと() {
        testee.addWord("し", "しまうま");
        testee.addWord("し", "しまんと");

        assertThat(testee.nextWord("し"), is("しまうま"));
        assertThat(testee.nextWord("し"), is("しまんと"));
        assertThat(testee.nextWord("し"), nullValue());
    }
}
