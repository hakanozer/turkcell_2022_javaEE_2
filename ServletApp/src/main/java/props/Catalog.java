package props;

public class Catalog {

    private String COMMON;
    private String BOTANICAL;
    private String ZONE;
    private String LIGHT;
    private String PRICE;

    public Catalog(String COMMON, String BOTANICAL, String ZONE, String LIGHT, String PRICE) {
        this.COMMON = COMMON;
        this.BOTANICAL = BOTANICAL;
        this.ZONE = ZONE;
        this.LIGHT = LIGHT;
        this.PRICE = PRICE;
    }

    public String getCOMMON() {
        return COMMON;
    }

    public void setCOMMON(String COMMON) {
        this.COMMON = COMMON;
    }

    public String getBOTANICAL() {
        return BOTANICAL;
    }

    public void setBOTANICAL(String BOTANICAL) {
        this.BOTANICAL = BOTANICAL;
    }

    public String getZONE() {
        return ZONE;
    }

    public void setZONE(String ZONE) {
        this.ZONE = ZONE;
    }

    public String getLIGHT() {
        return LIGHT;
    }

    public void setLIGHT(String LIGHT) {
        this.LIGHT = LIGHT;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }
}
