
package SkillSwap.src.service;


public final class ReviewService {

    public static Review addReview(Exchange exchange)
    {
        return new Review(exchange, exchange.getSearcher().getId());
    }
}