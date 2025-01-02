package com.rent_a_car.car_service.query.config;

import com.rent_a_car.car_service.event.car.CarCreatedEvent;
import com.rent_a_car.car_service.event.car.CarDeletedEvent;
import com.rent_a_car.car_service.event.car.CarUpdatedEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaAddress;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Value("${spring.kafka.consumer.group-update-id}")
    private String updateGroupId;

    @Value("${spring.kafka.consumer.group-delete-id}")
    private String deleteGroupId;

// create
   @Bean
    public ConsumerFactory<String, CarCreatedEvent> consumerFactory() {
        JsonDeserializer<CarCreatedEvent> jsonDeserializer = new JsonDeserializer<>(CarCreatedEvent.class);
        jsonDeserializer.addTrustedPackages("*"); // Specify trusted packages
        jsonDeserializer.setUseTypeHeaders(false); // If type headers are not used

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName()); // Use class name

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CarCreatedEvent> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CarCreatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
//update
    @Bean
    public ConsumerFactory<String, CarUpdatedEvent> consumerUpdateFactory() {
            JsonDeserializer<CarUpdatedEvent> jsonDeserializer = new JsonDeserializer<>(CarUpdatedEvent.class);
            jsonDeserializer.addTrustedPackages("*"); // Specify trusted packages
            jsonDeserializer.setUseTypeHeaders(false); // If type headers are not used

            Map<String, Object> props = new HashMap<>();
            props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
            props.put(ConsumerConfig.GROUP_ID_CONFIG, updateGroupId);
            props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName()); // Use class name

            return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer);
   }

   @Bean
   public ConcurrentKafkaListenerContainerFactory<String, CarUpdatedEvent> kafkaListenerUpdateContainerFactory() {
            ConcurrentKafkaListenerContainerFactory<String, CarUpdatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(consumerUpdateFactory());
            return factory;
   }
   // delete
   @Bean
   public ConsumerFactory<String, CarDeletedEvent> consumerDeleteFactory() {
       JsonDeserializer<CarDeletedEvent> jsonDeserializer = new JsonDeserializer<>(CarDeletedEvent.class);
       jsonDeserializer.addTrustedPackages("*"); // Specify trusted packages
       jsonDeserializer.setUseTypeHeaders(false); // If type headers are not used

       Map<String, Object> props = new HashMap<>();
       props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
       props.put(ConsumerConfig.GROUP_ID_CONFIG, updateGroupId);
       props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
       props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName()); // Use class name

       return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), jsonDeserializer);
   }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CarDeletedEvent> kafkaListenerDeleteContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CarDeletedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerDeleteFactory());
        return factory;
    }


}