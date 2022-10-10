package racingcar.common;

import org.junit.platform.commons.util.StringUtils;

import java.util.Objects;

public class UserString {
    private static final String ERROR_USER_INPUT_BLANK = "비어있는 문자를 입력할 수 없습니다";
    private static final String delimiter = ",";
    private final String userInput;

    public UserString(String userInput) {
        validate(userInput);
        this.userInput = userInput;
    }

    public static UserString of(String s) {
        return new UserString(s);
    }

    private void validate(String userInput) {
        if (StringUtils.isBlank(userInput)) {
            throw new IllegalArgumentException(ERROR_USER_INPUT_BLANK);
        }
    }

    public UserString[] split() {
        String[] split = userInput.split(delimiter);
        UserString[] result = new UserString[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = UserString.of(split[i]);
        }
        return result;
    }

    public int length() {
        return this.userInput.length();
    }

    @Override
    public String toString() {
        return userInput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserString that = (UserString) o;
        return Objects.equals(userInput, that.userInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userInput);
    }
}
