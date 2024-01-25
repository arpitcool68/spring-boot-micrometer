package pl.akolata.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.influx.InfluxMeterRegistry;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class PizzaOrderController {

    @Autowired
    private InfluxMeterRegistry influxMeterRegistry;
    PizzaOrderController(InfluxMeterRegistry influxMeterRegistry){
        this.influxMeterRegistry = influxMeterRegistry;
    }
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public long createOrder(@RequestParam String partnerId,
            @RequestParam String type,@RequestParam String location) {
        long orderId = createOrder(type);
        increaseCount(partnerId, "received");
        return orderId;
    }
    private void increaseCount(String partnerId, String state) {
        // Counter class stores the measurement name and the tags and
        // their values
        Metrics.counter("request.orders", "partnerId",
                partnerId, "state", state).increment(new Random().nextInt(10));


        influxMeterRegistry.counter("request.orders", "partnerId",
                partnerId, "state", state).increment();

//        Counter counter =Metrics.counter("request.orders",  "partnerId",
//                partnerId, "state", state);
       // counter.increment();
    }
    private long createOrder(String type) {
        // create order
        return (long) Math.random();
    }
//    private void processOrders() {
//        List<Order> orders = getReceivedOrders();
//        int processedOrders = 0;
//        orders.forEach(order -> {
//            bool processed = processOrder(order);
//            if(processed){
//                increaseCount(order.getPartnerId(), “processed”);
//            }
//        });
//    }
}
