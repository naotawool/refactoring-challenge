package challenge.refactoring.lastandfirst.before;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Maps;

/**
 * しりとりを行うユーザ。<br />
 * ファイルから読み込んだ内容を覚えたユーザ。
 *
 * @author naotake
 */
public class FileUser {

    private Map<String, String> words;

    public FileUser() {
        InputStream in = null;
        List<String> lines = null;
        try {
            // 本クラスと同じパッケージ、同じ名前の .txt ファイルを読み取る
            in = FileUser.class.getResourceAsStream(FileUser.class
                    .getSimpleName() + ".txt");

            lines = IOUtils.readLines(in, "utf-8");
        } catch (IOException e) {
            lines = new ArrayList<String>();
        } finally {
            IOUtils.closeQuietly(in);
        }

        words = Maps.newHashMap();

        for (String line : lines) {
            String[] words = StringUtils.split(
                    StringUtils.deleteWhitespace(line), ",");
            for (String word : words) {
                String key = StringUtils.left(word, 1);
                this.words.put(key, word);
            }
        }
    }

    public String nextWord(String word) {
        if (!words.containsKey(word)) {
            return null;
        }
        return words.get(word);
    }
}
