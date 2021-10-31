package CommandlineVesion;
public class Word implements Comparable{
    protected String word_target;
    protected String word_explain;

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word_target='" + word_target + '\'' +
                ", word_explain='" + word_explain + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return word_target.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return word_target.equalsIgnoreCase(((Word) obj).word_target);
    }

    @Override
    public int compareTo(Object o) {
        boolean x = word_target.equalsIgnoreCase(((Word) o).word_target);
        return x ? 0 : word_target.compareTo(((Word) o).word_target);
    }
}
