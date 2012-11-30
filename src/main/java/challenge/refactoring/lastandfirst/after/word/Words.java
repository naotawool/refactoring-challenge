package challenge.refactoring.lastandfirst.after.word;

/**
 * 単語の一覧を表すインタフェース。
 *
 * @author naotake
 */
public interface Words {

    /**
     * 単語を追加する。
     *
     * @param word 単語
     * @return 追加に成功した場合は{@code true}
     */
    boolean add(Word word);

    /**
     * 単語を削除する。
     *
     * @param word 単語
     * @return 削除に成功した場合は{@code true}
     */
    boolean remove(Word word);

    /**
     * 単語が含まれているかどうかを返す。
     *
     * @param word 単語
     * @return 含まれている場合は{@code true}
     */
    boolean contains(Word word);

    /**
     * 頭文字と同じ単語が含まれているかどうかを返す。
     *
     * @param initialWord 単語の頭文字
     * @return 含まれている場合は{@code true}
     */
    boolean containsInitialWord(String initialWord);

    /**
     * 単語の頭文字を基に、単語一覧から単語を取得する。
     *
     * @param initialWord 単語の頭文字
     * @return 単語
     */
    Word getByInitial(String initialWord);

    /**
     * 単語一覧に単語が 1 つでも含まれているかどうかを返す。
     *
     * @return 単語が 1 つも含まれていない場合は{@code true}
     */
    boolean isEmpty();
}
