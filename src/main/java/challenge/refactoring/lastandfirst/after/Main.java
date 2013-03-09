package challenge.refactoring.lastandfirst.after;

import org.apache.commons.lang.BooleanUtils;

import challenge.refactoring.lastandfirst.after.user.AnyWordFileUser;
import challenge.refactoring.lastandfirst.after.user.User;
import challenge.refactoring.lastandfirst.after.user.WordTrapUser;
import challenge.refactoring.lastandfirst.after.word.Word;

/**
 * リファクタリング後のコードで「しりとり」を実施するメインクラス。
 *
 * @author naotake
 */
public class Main {

    /** 先攻ユーザ */
    private static User firstAttackUser;
    /** 後攻ユーザ */
    private static User afterAttackUser;

    /**
     * 「しりとり」を実施。
     *
     * @param args ※使用しない
     */
    public static void main(String[] args) {

        firstAttackUser = new WordTrapUser();
        afterAttackUser = new AnyWordFileUser();

        Judge judge = new Judge();

        String initialWord = judge.startWord();
        printStartWith(initialWord);

        Word nextWord = firstAttackUser.nextWord(initialWord);
        printAnswer(firstAttackUser, nextWord);

        boolean isNextAttackAfter = false;
        User user = afterAttackUser;
        while (judge.isValidWord(nextWord)) {

            initialWord = judge.nextWord(nextWord);
            printNextInitialWord(initialWord);

            nextWord = user.nextWord(initialWord);
            printAnswer(user, nextWord);

            user = nextAttackUser(isNextAttackAfter);
            isNextAttackAfter = BooleanUtils.negate(isNextAttackAfter);
        }

        printWinner(user);
    }

    private static User nextAttackUser(boolean isNextAttackAfter) {
        if (isNextAttackAfter) {
            return afterAttackUser;
        } else {
            return firstAttackUser;
        }
    }

    private static void printStartWith(String initialWord) {
        System.out.println(String.format("[ %s ]でしりとり開始!!", initialWord));
    }

    private static void printAnswer(User user, Word answerWord) {
        String answer = String.format("%s は [ %s ]と答えました。", user, answerWord);
        if (answerWord == null) {
            answer = String.format("%s は答えられませんでした。", user, answerWord);
        }
        System.out.println(answer);
    }

    private static void printNextInitialWord(String initialWord) {
        System.out.println(String.format("次の文字は [ %s ]です！", initialWord));
    }

    private static void printWinner(User user) {
        System.out.println(user + " の勝ち！！");
    }
}
