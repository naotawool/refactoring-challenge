package challenge.refactoring.lastandfirst.before;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link FileUser}に対するテストクラス。<br />
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
public class FileUserTest {

    private FileUser testee;

    /**
     * 事前準備。
     */
    @Before
    public void before() {
        testee = new FileUser();
    }

    @Test
    public void _く_を指定するとファイルから読み込んだ_くうき_が返されること() {
        assertThat(testee.nextWord("く"), is("くうき"));
    }
}
