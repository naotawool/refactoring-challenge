package challenge.refactoring.lastandfirst.before;

import org.apache.commons.lang.BooleanUtils;

public class Main {

    public static void main(String[] args) {

        DefaultUser user1 = new DefaultUser();
        FileUser user2 = new FileUser();

        Judge judge = new Judge();

        String startWord = judge.getStartWord();
        System.out.println(String.format("[ %s ]でしりとり開始!!", startWord));

        String nextWord = user1.nextWord(startWord);
        System.out.println(String.format("user1 は [ %s ]と答えました。", nextWord));

        boolean isUser2 = true;
        while (judge.okWord(nextWord)) {
            nextWord = judge.nextWord(nextWord);
            System.out.println(String.format("次の文字は [ %s ]です！", nextWord));
            if (isUser2) {
                nextWord = user2.nextWord(nextWord);
                System.out.println(String.format("user2 は [ %s ]と答えました。",
                        nextWord));
            } else {
                nextWord = user1.nextWord(nextWord);
                System.out.println(String.format("user1 は [ %s ]と答えました。",
                        nextWord));
            }

            isUser2 = BooleanUtils.negate(isUser2);
        }

        if (isUser2) {
            System.out.println("user1 の負け");
        } else {
            System.out.println("user2 の負け");
        }
    }
}
