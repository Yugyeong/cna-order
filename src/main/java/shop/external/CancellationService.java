
package shop.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

//@FeignClient(name="delivery", url="http://delivery:8080") //클라우드는 이렇게 감
//@FeignClient(name="delivery", url="http://localhost:8082") //딜리버리 주소 줘야 함  
@FeignClient(name="delivery", url="${api.url.delivery}") //pom.xml에 설정(해당 값을 가져옴)
public interface CancellationService {

    @RequestMapping(method= RequestMethod.POST, path="/cancellations") //기본 주소 뒤에 cancellations 붙어서 감 
    //http http://localhost:8082/cancellations orderId=3 status=DeliveryCancelled 랑 똑같음
    public void cancel(@RequestBody Cancellation cancellation);

}