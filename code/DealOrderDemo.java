package miniTest;

public class DealOrderDemo {

	 public void deal(OrderEntity orderEntity) {
		 DealFactory dealFactory = new DealFactory();
	 
		 DealOrder dealOrder = dealFactory.getDeal(orderEntity.getOrderStatus());
	 
		 dealOrder.dealOrder(orderEntity);
   }
}
