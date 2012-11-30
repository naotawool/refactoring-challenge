package challenge.refactoring.lastandfirst.after.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

/**
 * ファイルリーダー。
 *
 * @author naotake
 */
public class FileReader {

    private static final String DEFAULT_ENCODING = "utf-8";

    private final InputStream in;

    /**
     * コンストラクタによるインスタンス化を抑制。
     */
    private FileReader(InputStream in) {
        this.in = in;
    }

    /**
     * テキストファイルとして読み込むためのリーダーを生成する。
     *
     * @param clazz 読み込み対象クラス
     * @return ファイルリーダー
     */
    public static FileReader asText(Class<?> clazz) {
        return new FileReader(getResourceAsStream(clazz, FileExtension.TEXT));
    }

    /**
     * 指定されたクラスから{@link InputStream}を取得する。
     *
     * @param clazz 読み込み対象クラス
     * @param extension ファイル拡張子種別
     * @return {@link InputStream}
     */
    private static InputStream getResourceAsStream(Class<?> clazz,
            FileExtension extension) {
        return clazz.getResourceAsStream(String.format("%s.%s",
                clazz.getSimpleName(), extension));
    }

    /**
     * ファイルの各行を文字列として読み込む。
     * <p>
     * ファイル読み込み中に{@link IOException}が発生した場合、空の{@link List}を返す。
     * </p>
     *
     * @return ファイルの各行一覧
     */
    public List<String> readLines() {
        try {
            return IOUtils.readLines(in, DEFAULT_ENCODING);
        } catch (IOException e) {
            return Lists.newArrayListWithCapacity(0);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

    /**
     * ファイルの各行から空白を取り除いた文字列として読み込む。
     *
     * @see #readLines()
     * @return ファイルの各行一覧
     */
    public List<String> readLinesDeletedWhitespace() {
        List<String> lines = readLines();

        List<String> deletedWhitespaceLines = Lists
                .newArrayListWithCapacity(lines.size());
        for (String line : lines) {
            deletedWhitespaceLines.add(StringUtils.deleteWhitespace(line));
        }
        return deletedWhitespaceLines;
    }

    /**
     * ファイル拡張子を表す列挙型。
     *
     * @author naotake
     */
    private static enum FileExtension {
        /** テキストファイル */
        TEXT("txt");

        private final String extension;

        private FileExtension(String extension) {
            this.extension = extension;
        }

        @Override
        public String toString() {
            return extension;
        }
    }
}
