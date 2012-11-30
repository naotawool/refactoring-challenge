package challenge.refactoring.lastandfirst.after.user;

import static challenge.refactoring.lastandfirst.after.IsWord.isWord;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link AnyWordFileUser}に対するテストクラス。<br />
 * テスト用に用意したファイル内容は以下の通り。
 *
 * <pre>
 * ------------------------------------
 * てすと, せんせい, はげ
 *
 * げーむ, ほう き,  く  うき
 *
 * ------------------------------------
 * </pre>
 *
 * @author naotake
 */
public class AnyWordFileUserTest {

    private AnyWordFileUser testee;

    /**
     * 事前準備。
     */
    @Before
    public void before() {
        testee = new AnyWordFileUser();
    }

    @Test
    public void _く_を指定するとファイルから読み込んだ_くうき_が返されること() {
        assertThat(testee.nextWord("く"), isWord("くうき"));
    }
}
