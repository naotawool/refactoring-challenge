package challenge.refactoring.lastandfirst.after;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import challenge.refactoring.lastandfirst.after.word.Word;

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
        assertThat(testee.isValidWord(Word.of("まりも")), is(true));
    }

    @Test
    public void _ぱんだ_の判定結果としてfalseが返されること() {
        assertThat(testee.isValidWord(Word.of("ぱんだ")), is(true));
    }

    @Test
    public void _ようかん_の判定結果としてfalseが返されること() {
        assertThat(testee.isValidWord(Word.of("ようかん")), is(false));
    }

    @Test
    public void _ごりら_の２回目の判定結果としてfalseが返されること() {
        assertThat(testee.isValidWord(Word.of("ごりら")), is(true));
        assertThat(testee.isValidWord(Word.of("ごりら")), is(false));
    }

    @Test
    public void _null_の判定結果としてfalseが返されること() {
        assertThat(testee.isValidWord(null), is(false));
    }

    @Test
    public void _まりも_の次のしりとり文字として_も_が返されること() {
        assertThat(testee.nextWord(Word.of("まりも")), is("も"));
    }

    @Test
    public void _きんぎょ_の次のしりとり文字として_よ_が返されること() {
        assertThat(testee.nextWord(Word.of("きんぎょ")), is("よ"));
    }

    @Test
    public void _つりー_の次のしりとり文字として_り_が返されること() {
        assertThat(testee.nextWord(Word.of("つり－")), is("り"));
    }

    @Test
    public void 開始の文字がランダムに何かしら返されること() {
        assertThat(testee.startWord(), notNullValue());
    }
}
