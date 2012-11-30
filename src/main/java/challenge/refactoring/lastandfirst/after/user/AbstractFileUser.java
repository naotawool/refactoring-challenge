package challenge.refactoring.lastandfirst.after.user;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import challenge.refactoring.lastandfirst.after.file.FileReader;

/**
 * しりとりで使用する単語をファイルから取得するユーザの抽象クラス。
 *
 * @author naotake
 */
abstract class AbstractFileUser implements User {

    private static final String DEFAULT_SEPARATOR_CHARS = ",";

    /**
     * 具象クラスと同名のファイルを読み取り、そこから単語の情報を抽出する。
     */
    protected AbstractFileUser() {
        initializeWords();

        FileReader fileReader = FileReader.asText(userType());

        List<String> lines = fileReader.readLinesDeletedWhitespace();
        for (String line : lines) {
            String[] words = StringUtils.split(line, DEFAULT_SEPARATOR_CHARS);
            for (String word : words) {
                importWord(word);
            }
        }
    }

    /**
     * ユーザの具象クラスの型を取得する。
     *
     * @return ユーザの具象クラスの型
     */
    protected abstract Class<?> userType();

    /**
     * 単語一覧を初期化する。
     */
    protected abstract void initializeWords();

    /**
     * 単語を取り込む。
     *
     * @param word 単語
     */
    protected abstract void importWord(String word);

    @Override
    public String toString() {
        return userType().getSimpleName();
    }
}
