package live.whiteseason.whitebot.modules.cqhttp.Enum;

public enum GameMode {
    CTB("fruits"),
    MANIA("mania"),
    OSU("osu"),
    TAIKO("taiko");

    private final String Name;

    GameMode(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
