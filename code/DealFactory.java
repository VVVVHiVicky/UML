package miniTest;

public class DealFactory {
	//使用 getShape 方法获取形状类型的对象
   public DealOrder getDeal(String orderStatus){
      if(orderStatus == null){
         return null;
      }        
      if(orderStatus.equalsIgnoreCase("Add")){
         return new DealAddOrder();
      } else {
    	  return new DealUpdateOrder();
      }
   }
}
