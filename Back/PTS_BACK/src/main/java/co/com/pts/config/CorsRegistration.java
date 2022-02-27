package co.com.pts.config;

public class CorsRegistration {

    private final String pathPattern;

    private final CorsConfig config;

    public CorsRegistration(String pathPattern) {
        this.pathPattern = pathPattern;
        this.config = new CorsConfig().applyPermitDefaultValues();
    }

    public CorsRegistration(String pathPattern, CorsConfig config) {
        this.pathPattern = pathPattern;
        this.config = config;
    }

    public String getPathPattern() {
        return pathPattern;
    }

    public CorsConfig getConfig() {
        return config;
    }
}
