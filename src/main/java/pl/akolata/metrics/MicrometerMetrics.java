//package pl.akolata.metrics;
//
//import io.micrometer.core.instrument.Tags;
//import io.micrometer.core.instrument.Timer;
//import io.micrometer.influx.InfluxMeterRegistry;
//import java.util.Map;
//import java.util.function.ToDoubleFunction;
//import org.springframework.stereotype.Component;
//
///**
// * Metrics facade generating count and time events for reporting tools
// */
//@Component
//public class MicrometerMetrics {
//
//    private final MetricsConfiguration metricsConfiguration;
//    private final InfluxMeterRegistry influxMeterRegistry;
//
//    public MicrometerMetrics(InfluxMeterRegistry influxMeterRegistry, MetricsConfiguration metricsConfiguration) {
//        this.metricsConfiguration = metricsConfiguration;
//        this.influxMeterRegistry = influxMeterRegistry;
//    }
//
//    /**
//     * Creates and begins a timer to be programmatically stopped
//     * @return returns a @see Timer.Sample
//     */
//    public Timer.Sample timerSample() {
//        return Timer.start(influxMeterRegistry);
//    }
//
//    public void countEvent(double amount) {
//        influxMeterRegistry.counter(metricsConfiguration.getMeasurementCount(), "").increment(amount);
//    }
//}
