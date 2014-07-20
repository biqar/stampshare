package model;

/**
 * Created with IntelliJ IDEA.
 * User: raqibul
 * Date: 10/21/13
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class AdvancedSearchModel {
    private int stampYearFrom, stampYearTo;
    private double stampRatingFrom, stampRatingTo;
    private String stampCountryName;
    private String stampExchangePolicyName;

    public AdvancedSearchModel() {
    }

    public int getStampYearFrom() {
        return stampYearFrom;
    }

    public void setStampYearFrom(int stampYearFrom) {
        this.stampYearFrom = stampYearFrom;
    }

    public int getStampYearTo() {
        return stampYearTo;
    }

    public void setStampYearTo(int stampYearTo) {
        this.stampYearTo = stampYearTo;
    }

    public double getStampRatingFrom() {
        return stampRatingFrom;
    }

    public void setStampRatingFrom(double stampRatingFrom) {
        this.stampRatingFrom = stampRatingFrom;
    }

    public double getStampRatingTo() {
        return stampRatingTo;
    }

    public void setStampRatingTo(double stampRatingTo) {
        this.stampRatingTo = stampRatingTo;
    }

    public String getStampCountryName() {
        return stampCountryName;
    }

    public void setStampCountryName(String stampCountryName) {
        this.stampCountryName = stampCountryName;
    }

    public String getStampExchangePolicyName() {
        return stampExchangePolicyName;
    }

    public void setStampExchangePolicyName(String stampExchangePolicyName) {
        this.stampExchangePolicyName = stampExchangePolicyName;
    }
}
