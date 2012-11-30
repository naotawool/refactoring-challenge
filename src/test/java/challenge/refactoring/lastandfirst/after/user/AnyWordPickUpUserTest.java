package challenge.refactoring.lastandfirst.after.user;

import static challenge.refactoring.lastandfirst.after.IsWord.isWord;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link AnyWordPickUpUser}に対するテストクラス。
 *
 * @author naotake
 */
public class AnyWordPickUpUserTest {

    private AnyWordPickUpUser testee;

    /**
     * 事前準備。
     */
    @Before
    public void before() {
        testee = new AnyWordPickUpUser();
        testee.pickUpWord("しまうま");
        testee.pickUpWord("まりも");
        testee.pickUpWord("もぐら");
        testee.pickUpWord("らっきょ");
        testee.pickUpWord("ようかん");
    }

    @Test
    public void _し_を指定すると_しまうま_が返されること() {
        assertThat(testee.nextWord("し"), isWord("しまうま"));
    }

    @Test
    public void _ま_を指定すると_まりも_が返されること() {
        assertThat(testee.nextWord("ま"), isWord("まりも"));
    }

    @Test
    public void _め_を指定するとnullが返されること() {
        assertThat(testee.nextWord("め"), nullValue());
    }
}