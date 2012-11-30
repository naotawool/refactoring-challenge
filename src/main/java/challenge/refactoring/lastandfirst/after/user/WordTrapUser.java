package challenge.refactoring.lastandfirst.after.user;

/**
 * ある特定が次の言葉になるように相手を陥れるユーザ。
 *
 * @author naotake
 */
public class WordTrapUser extends OnlyWordPickUpUser {

    public WordTrapUser() {
        pickUpWord("あみ");
        pickUpWord("いみ");
        pickUpWord("うみ");
        pickUpWord("えみ"); // 笑み
        pickUpWord("かみ");
        pickUpWord("きみ"); // 黄身
        pickUpWord("くるみ");
        pickUpWord("けまり");
        pickUpWord("こうみ"); // 香味
        pickUpWord("さしみ");
        pickUpWord("しじみ");
        pickUpWord("すみ");
        pickUpWord("せみ");
        pickUpWord("そーきそば");
        pickUpWord("たみ"); // 民
        pickUpWord("ちんみ");
        pickUpWord("つみ"); // 罪
        pickUpWord("てあみ");
        pickUpWord("とみ"); // 富
        pickUpWord("なみ");
        pickUpWord("にっち");
        pickUpWord("ぬいぐるみ");
        pickUpWord("ねずみ");
        pickUpWord("のみ");
        pickUpWord("はらみ");
        pickUpWord("ひとみ");
        pickUpWord("ふみ"); // 文
        pickUpWord("へみんぐうぇい");
        pickUpWord("ほーる");
        pickUpWord("まどろみ");
        pickUpWord("みみ");
        pickUpWord("むみ"); // 無味
        pickUpWord("めれんげ");
        pickUpWord("もろみ"); // もろ味
        pickUpWord("やみ");
        pickUpWord("ゆみ");
        pickUpWord("よみ"); // 黄泉
        pickUpWord("らくだ");
        pickUpWord("りちうむ");
        pickUpWord("るーる");
        pickUpWord("れしぴ");
        pickUpWord("ろんり");
        pickUpWord("わさび");
    }

    @Override
    public String toString() {
        return WordTrapUser.class.getSimpleName();
    }
}
