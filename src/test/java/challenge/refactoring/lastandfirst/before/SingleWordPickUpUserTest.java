package challenge.refactoring.lastandfirst.before;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link SingleWordPickUpUser}に対するテストクラス。
 *
 * @author naotake
 */
public class SingleWordPickUpUserTest {

    private SingleWordPickUpUser testee;

    /**
     * 事前準備。
     */
    @Before
    public void before() {
        testee = new SingleWordPickUpUser();
        testee.addWord("し", "しまうま");
        testee.addWord("ま", "まりも");
        testee.addWord("も", "もぐら");
        testee.addWord("ら", "らっきょ");
        testee.addWord("よ", "ようかん");
    }

    @Test
    public void _し_を指定すると_しまうま_が返されること() {
        assertThat(testee.nextWord("し"), is("しまうま"));
    }

    @Test
    public void _ま_を指定すると_まりも_が返されること() {
        assertThat(testee.nextWord("ま"), is("まりも"));
    }

    @Test
    public void _め_を指定するとnullが返されること() {
        assertThat(testee.nextWord("め"), nullValue());
    }
}
