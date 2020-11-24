class Publication {

    static final String S = ": ";
    private final String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        return this.getType() + this.getDetails() + title;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public String getDetails() {
        return S;
    }
}

class Newspaper extends Publication {

    private final String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    @Override
    public String getDetails() {
        return " (source - " + source + ")" + S;
    }
}

class Article extends Publication {

    private final String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String getDetails() {
        return " (author - " + author + ")" + S;
    }
}

class Announcement extends Publication {

    private final int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String getDetails() {
        return " (days to expire - " + daysToExpire + ")" + S;
    }
}