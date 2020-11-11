package miniTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DealUpdateOrder implements DealOrder {
	
	@Override
	public void dealOrder(OrderEntity orderEntity) {
		OrderEntity curOrder = getCurrentOrder(orderEntity.getOrderId());
		orderEntity.setModifyTime(new Date());
		//save order
		saveOrder(orderEntity);
		//when there is a change of status in an order
		if(!curOrder.getOrderStatus().equals(orderEntity.getOrderStatus())) {
			//publish
			publishOrder(orderEntity);
		}
		
        Instant instant = orderEntity.getCreateTime().toInstant();
		LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		Instant instant2 = orderEntity.getModifyTime().toInstant();
		LocalDateTime localDateTime2 = instant2.atZone(ZoneId.systemDefault()).toLocalDateTime();
		long min = ChronoUnit.MINUTES.between(localDateTime, localDateTime2);
		//when order done within 5 mins
		if("compelete".equals(orderEntity.getOrderStatus()) && min > 5) {
			sendOrderMessage(orderEntity);
		}
		

	}

	/**
	 * get current order data
	 * @param orderId
	 * @return
	 */
	private OrderEntity getCurrentOrder(String orderId) {
		OrderEntity entity = new OrderEntity();
		//TODO get current order data from oracle
		
		return entity;
	}
	
	/**
	 * publish order
	 * @param orderId
	 * @return
	 */
	private void publishOrder(OrderEntity orderEntity) {
		//TODO publish order
	}
	
	/**
	 * 
	 * @param orderEntity
	 */
	private void saveOrder(OrderEntity orderEntity) {
		//TODO save order into oracle
	} 
	
	/**
	 * send order and sign "yes" with order
	 * @param orderEntity
	 */
	private void sendOrderMessage(OrderEntity orderEntity) {
		OrderEntity cur = getCurrentOrder(orderEntity.getOrderId());
		if(!"Y".equals(cur.getSendStatus())) {
			
			//TODO send order by e-mail or other channels
			
			cur.setSendStatus("Y");
			saveOrder(cur);
		}
		
	}
}