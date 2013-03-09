package challenge.refactoring.lastandfirst.before;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link Judge}に対するテストクラス。
 *
 * @author naotake
 */
public class JudgeTest {

    private Judge testee;

    /**
     * 事前準備。
     */
    @Before
    public void before() {
        testee = new Judge();
    }

    @Test
    public void _まりも_の判定結果としてfalseが返されること() {
        assertThat(testee.okWord("まりも"), is(true));
    }

    @Test
    public void _ようかん_の判定結果としてfalseが返されること() {
        assertThat(testee.okWord("ようかん"), is(false));
    }

    @Test
    public void _ごりら_の２回目の判定結果としてfalseが返されること() {
        assertThat(testee.okWord("ごりら"), is(true));
        assertThat(testee.okWord("ごりら"), is(false));
    }

    @Test
    public void _null_の判定結果としてfalseが返されること() {
        assertThat(testee.okWord(null), is(false));
    }

    @Test
    public void _まりも_の次のしりとり文字として_も_が返されること() {
        assertThat(testee.nextWord("まりも"), is("も"));
    }

    @Test
    public void _きんぎょ_の次のしりとり文字として_よ_が返されること() {
        assertThat(testee.nextWord("きんぎょ"), is("よ"));
    }

    @Test
    public void _つりー_の次のしりとり文字として_り_が返されること() {
        assertThat(testee.nextWord("つり－"), is("り"));
    }

    @Test
    public void 開始の文字がランダムに何かしら返されること() {
        String result = testee.getStartWord();
        assertThat(result, notNullValue());
        assertThat(result.length(), is(1));
    }
}
