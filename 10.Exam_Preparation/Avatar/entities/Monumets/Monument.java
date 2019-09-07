package Avatar.entities.Monumets;

import static Avatar.utilities.Constants.STRING_FORMAT_MONUMENT;

public abstract class Monument {
    private String name;

    protected Monument(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract int getAffinity();

    @Override
    public String toString() {
        return STRING_FORMAT_MONUMENT;
    }
}