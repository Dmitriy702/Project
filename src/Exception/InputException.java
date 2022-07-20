package Exception;

import Enum.Messages;

public class InputException extends RuntimeException {
    public InputException() {
    }

    public InputException(Messages message) {
        super(message.toString());
    }
}
