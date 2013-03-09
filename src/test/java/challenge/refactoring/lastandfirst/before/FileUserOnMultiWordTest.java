package challenge.refactoring.lastandfirst.before;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link FileUserOnMultiWord}に対するテストクラス。<br />
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
public class FileUserOnMultiWordTest {

    private FileUserOnMultiWord testee;

    /**
     * 事前準備。
     */
    @Before
    public void before() {
        testee = new FileUserOnMultiWord();
    }

    @Test
    public void _げ_を指定するとファイルから読み込んだ内容を順に返すこと() {
        assertThat(testee.nextWord("げ"), is("げーむ"));
        assertThat(testee.nextWord("げ"), is("げーと"));
        assertThat(testee.nextWord("げ"), is("げのむ"));
        assertThat(testee.nextWord("げ"), is("げげげのきたろう"));
        assertThat(testee.nextWord("げ"), nullValue());
    }

    @Test
    public void _せ_を指定するとファイルから読み込んだ内容を返すこと() {
        assertThat(testee.nextWord("せ"), is("せんせい"));
        assertThat(testee.nextWord("せ"), nullValue());
    }

    @Test
    public void _は_を指定するとファイルから読み込んだ内容を返すこと() {
        assertThat(testee.nextWord("は"), is("はげ"));
        assertThat(testee.nextWord("は"), nullValue());
    }
}
