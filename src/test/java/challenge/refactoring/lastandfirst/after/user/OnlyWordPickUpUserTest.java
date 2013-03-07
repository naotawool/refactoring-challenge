package challenge.refactoring.lastandfirst.after.user;

import static challenge.refactoring.lastandfirst.after.IsWord.isWord;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link OnlyWordPickUpUser}に対するテストクラス。
 *
 * @author naotake
 */
public class OnlyWordPickUpUserTest {

    private OnlyWordPickUpUser testee;

    @Before
    public void before() {
        testee = new OnlyWordPickUpUser();
    }

    @Test
    public void _しまうま_を覚えさせたら_し_の言葉として_しまうま_を返すこと() {
        testee.pickUpWord("しまうま");
        assertThat(testee.nextWord("し"), isWord("しまうま"));
        assertThat(testee.nextWord("し"), nullValue());
    }

    @Test
    public void _しまうま_を覚えさせても_ま_の言葉としてはnullを返すこと() {
        testee.pickUpWord("しまうま");
        assertThat(testee.nextWord("ま"), nullValue());
    }

    /**
     * 同じ言葉を返さないこと。
     */
    @Test
    public void _しまうま_と_しまんと_を覚えさせたら_し_の言葉として２つ返すこと() {
        testee.pickUpWord("しまうま");
        testee.pickUpWord("しまんと");

        assertThat(testee.nextWord("し"), isWord("しまうま"));
        assertThat(testee.nextWord("し"), isWord("しまんと"));
        assertThat(testee.nextWord("し"), nullValue());
    }
}
