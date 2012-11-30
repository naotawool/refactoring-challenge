package challenge.refactoring.lastandfirst.after.user;

import static challenge.refactoring.lastandfirst.after.IsWord.isWord;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link OnlyWordFileUser}に対するテストクラス。<br />
 * テスト用に用意したファイル内容は以下の通り。
 *
 * <pre>
 * ------------------------------------
 * てすと, せんせい, はげ
 *
 * げーむ, ほう き,  く  うき
 *
 * げーと , げのむ , げげげのきたろう,
 *
 *
 * ------------------------------------
 * </pre>
 *
 * @author naotake
 */
public class OnlyWordFileUserTest {

    private OnlyWordFileUser testee;

    /**
     * 事前準備。
     */
    @Before
    public void before() {
        testee = new OnlyWordFileUser();
    }

    @Test
    public void _げ_を指定するとファイルから読み込んだ内容を順に返すこと() {
        assertThat(testee.nextWord("げ"), isWord("げげげのきたろう"));
        assertThat(testee.nextWord("げ"), isWord("げのむ"));
        assertThat(testee.nextWord("げ"), isWord("げーと"));
        assertThat(testee.nextWord("げ"), isWord("げーむ"));
        assertThat(testee.nextWord("げ"), nullValue());
    }
}