    package com.os.reservation_service.kafka;

    import com.os.event.PaymentCreatedEvent;
    import com.os.event.PaymentFailedEvent;
    import com.os.reservation_service.service.ReservationService;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.kafka.annotation.KafkaListener;
    import org.springframework.stereotype.Service;

    @Service
    public class PaymentConsumer {
        private final ReservationService reservationService;
        private Logger log = LoggerFactory.getLogger(PaymentConsumer.class);
        public PaymentConsumer(ReservationService reservationService) {
            this.reservationService = reservationService;
        }

        @KafkaListener(topics = "${spring.kafka.template.payment-failed-topic}", groupId = "${spring.kafka.consumer.group-id}")
        public void consume(PaymentFailedEvent event)
        {
            reservationService.deleteReservation(event.getReservationId());
            System.out.println("Reservation Deleted: " + event);

        }
        @KafkaListener(topics = "${spring.kafka.template.payment-success-topic}", groupId = "${spring.kafka.consumer.group-my-id}",containerFactory = "paymentCreatedEventKafkaListenerContainerFactory")
        public void consumePaymentCreated(PaymentCreatedEvent event) {
            log.info("Reservation Status Changed Successfly");
            System.out.println("Reservation Status Changed Successfly");
            reservationService.changedStatus(event.getId());

        }
    }
