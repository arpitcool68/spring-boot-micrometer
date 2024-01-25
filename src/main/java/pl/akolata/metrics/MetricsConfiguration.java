package pl.akolata.metrics;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "cc.metrics.event")
@Component
public class MetricsConfiguration {

    private String measurementCount;
    private String measurementTimeElapsed;

    public String getMeasurementCount() {
        return measurementCount;
    }

    public void setMeasurementCount(String measurementCount) {
        this.measurementCount = measurementCount;
    }

    public String getMeasurementTimeElapsed() {
        return measurementTimeElapsed;
    }

    public void setMeasurementTimeElapsed(String measurementTimeElapsed) {
        this.measurementTimeElapsed = measurementTimeElapsed;
    }
}

