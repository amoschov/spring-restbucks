package org.springsource.restbucks.order;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author mucahitkurt
 * @since 26.08.2018
 */
@Service
@RequiredArgsConstructor
public class OrderCreatedEventHandler {
    private final MeterRegistry registry;

    @Async
    @TransactionalEventListener
    public void handleAfterCreate(OrderCreated orderCreated) {
        final Counter counter = registry.counter("entity.count", "type", "order");
        counter.increment();
    }
}
