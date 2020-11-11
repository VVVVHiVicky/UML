package miniTest;

import java.util.Date;
import java.util.UUID;

public class DealAddOrder implements DealOrder {
	
	@Override
	public void dealOrder(OrderEntity orderEntity) {
		UUID uuid = UUID.randomUUID();
		orderEntity.setOrderId(uuid.toString());
		orderEntity.setCreateTime(new Date());
		//save order
		saveOrder(orderEntity);
	}
	
	private void saveOrder(OrderEntity orderEntity) {
		//TODO save order into oracle
	}
}