package racingcar.common;

import org.junit.platform.commons.util.StringUtils;

public class UserString {
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
            throw new IllegalArgumentException();
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
}
