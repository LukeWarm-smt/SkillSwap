package SkillSwap.src.service;

public class Review {
    private final String exchange_id;
    private final String reviewer_id;
    private final int rating;
    private final String note;

    public Review(Exchange exchange, String reviewer_id)
    {
        this.exchange_id = exchange.getID();
        this.reviewer_id = reviewer_id;
        if (exchange.getOutcome() == Transaction_Result.COMPLETED) {rating = (int)(Math.random() * 3) + 3;}
        else {rating = (int)(Math.random() * 2) + 1;}
        note = "this is a default note, Silva is too lazy to generate one properly :3";
    }
    public int getRating() {return rating;}
    @Override
    public String toString()
    {
        return ("Review: [" + rating + "] " + note);
    }
}
