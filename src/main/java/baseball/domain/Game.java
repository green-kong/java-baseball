package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import baseball.utils.Converter;

public class Game {
    private List<Integer> answer = new ArrayList<>();

    public Game(List<Integer> randomNumberList) {
        this.answer = randomNumberList;
    }

    public Map<String, Integer> getResult(String userInput) {
        Map<String, Integer> resultMap = new HashMap<>() {{
            put("ball", 0);
            put("strike", 0);
        }};

        List<Integer> userAnswer = Converter.toIntegerList(userInput);
        for (int index = 0; index < userAnswer.size(); index++) {
            Integer currentAnswer = answer.get(index);
            Integer currentUserAnswer = userAnswer.get(index);

            countScore(resultMap, currentAnswer, currentUserAnswer);
        }
        return resultMap;
    }

    private void countScore(Map<String, Integer> resultMap, Integer currentAnswer, Integer currentUserAnswer) {
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
