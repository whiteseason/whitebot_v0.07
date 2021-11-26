package live.whiteseason.whitebot.modules.cqhttp.Enum.bot;

public enum MessageType {
    TEXT("text"),
    FACE("face"),
    IMAGE("image"),
    RECORD("record"),
    VIDEO("video"),
    AT("at");

    private final String value;

    MessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
