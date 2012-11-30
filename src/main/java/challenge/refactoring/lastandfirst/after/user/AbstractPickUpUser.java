package challenge.refactoring.lastandfirst.after.user;

/**
 * 単語を覚えさせることができるユーザの抽象クラス。
 *
 * @author naotake
 */
abstract class AbstractPickUpUser implements User {

    /**
     * 単語を覚える。
     *
     * @param wordStr 単語の文字列
     * @return 覚えることが出来た場合は{@code true}
     */
    protected abstract boolean pickUpWord(String wordStr);

}
