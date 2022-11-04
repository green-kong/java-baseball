package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Game {
    private List<Integer> answer = new ArrayList<>();
    private Map<String, Integer> resultMap;

    public Game(List<Integer> randomNumberList) {
        this.answer = randomNumberList;
    }

    public Map<String, Integer> getResult(List<Integer> userAnswer) {
        for (int index = 0; index < userAnswer.size(); index++) {
            Integer currentAnswer = answer.get(index);
            Integer currentUserAnswer = userAnswer.get(index);

            countScore(currentAnswer, currentUserAnswer);
        }
        return resultMap;
    }

    public void initializeResultMap() {
        this.resultMap = new HashMap<>() {{
            put("ball", 0);
            put("strike", 0);
        }};
    }

    private void countScore(Integer currentAnswer, Integer currentUserAnswer) {
        if (isStrike(currentAnswer, currentUserAnswer)) {
            resultMap.put("strike", resultMap.get("strike") + 1);
        }

        if (isBall(currentAnswer, currentUserAnswer)) {
            resultMap.put("ball", resultMap.get("ball") + 1);
        }
    }

    private boolean isBall(Integer answerInt, Integer userAnswerInt) {
        return answer.contains(userAnswerInt)
                && !Objects.equals(answerInt, userAnswerInt);
    }

    private boolean isStrike(Integer answerInt, Integer userAnswerInt) {
        return Objects.equals(answerInt, userAnswerInt);
    }
}
