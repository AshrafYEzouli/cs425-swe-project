package cs425.project.moviemail.model;

public enum Genre {
    Action(0),
    Anime(1),
    Romance(2),
    Comedy(3),
    Documentry(4),
    Thriller(5);

    public final int value;

    Genre(int i) {
        this.value = i;
    }

    /*public int getValue() {
        return va;
    }*/
}
