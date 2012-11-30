package challenge.refactoring.lastandfirst.after.user;

import challenge.refactoring.lastandfirst.after.word.Word;

/**
 * しりとりを行うユーザを表すインタフェース。
 *
 * @author naotake
 */
public interface User {

    /**
     * 指定された頭文字を基に次の単語を取得する。
     *
     * @param initialWord 頭文字
     * @return 次の単語
     */
    Word nextWord(String initialWord);
}
