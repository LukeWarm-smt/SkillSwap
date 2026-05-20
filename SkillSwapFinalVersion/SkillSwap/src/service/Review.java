package SkillSwap.src.service;

public class Review {
    private final int exchange_id;
    private final String reviewer_id;
    private final int rating;
    private final String note;

    public Review(Exchange exchange, String reviewer_id)
    {
        this.exchange_id = exchange.getID();
        this.reviewer_id = reviewer_id;
        if (exchange.getOutcome() == Transaction_Result.COMPLETED) {
            rating = (int)(Math.random() * 3) + 3;
            note = "This exchange was great!";
        }
        else {
            rating = (int)(Math.random() * 2) + 1;
            note = "This exchange wasn't really good...";
        }
    }
    public Review(String line) throws IllegalArgumentException{
        //EXId; reviewer_id; rating; note
        if (line.isEmpty()){
            throw new IllegalArgumentException("Empty String");
        }
        String parsed[] = line.split(";", -1);

        if(parsed.length != 4){
            throw new IllegalArgumentException("Not the correct amount of information");
        }
        if(Integer.parseInt(parsed[0]) < 1){
            throw new IllegalArgumentException("Not a valid Id number");
        }
        exchange_id = Integer.parseInt(parsed[0]);
        reviewer_id = parsed[1];
        rating = Integer.parseInt(parsed[2]);
        note = parsed[3];
    }

    public int getRating() {return rating;}
    public String getReviewID() { return reviewer_id; }
    public int getExchangeId() { return exchange_id; }
    @Override
    public String toString()
    {
        return (" Review: [" + rating + "] " + note);
    }
    public String parseToCsv(){
        return (exchange_id + ";" + reviewer_id + ";" + rating + ";" + note);
    }
    @Override
    public int hashCode() {
        return exchange_id*13 + reviewer_id.hashCode()*17 + rating*19 + note.hashCode()*23;
    }
}

