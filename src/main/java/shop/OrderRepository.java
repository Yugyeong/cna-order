package shop;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>{

	//Optional<Order> findById(Double orderId);

	//Optional<Order> findById(Double orderId);


}