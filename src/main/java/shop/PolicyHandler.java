package shop;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import shop.config.kafka.KafkaProcessor;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }
    
    @Autowired
    OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverShipped_UpdateStatus(@Payload Shipped shipped){

        if(shipped.isMe()){ //발행이 되면 가지고 와서 shipped가 실제 맞는지를 체크하는 것. 
           // System.out.println("##### listener UpdateStatus : " + shipped.toJson());
            // 재고량 수정
        	//배송상태에 따른 주문서비스의 배송 상태값 업테이트 (Delivery 서비스의 Shipped 이벤트에 listening 하는 코드 작성)
            Optional<Order> orderOptional = orderRepository.findById(Long.valueOf((shipped.getOrderId().toString())));
            Order order = orderOptional.get();
            order.setStatus(shipped.getStatus());

            orderRepository.save(order);
        }
    }
}






