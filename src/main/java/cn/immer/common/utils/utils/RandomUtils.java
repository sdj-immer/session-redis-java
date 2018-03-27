package cn.immer.common.utils.utils;

public class RandomUtils {
	private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	
	private static final String NUMBER_STR = "0123456789";

	  private static final java.util.Random RANDOM = new java.util.Random();

	  public static String getRandomStr(int num) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < num; i++) {
	      sb.append(RANDOM_STR.charAt(RANDOM.nextInt(RANDOM_STR.length())));
	    }
	    return sb.toString();
	  }
	  
	  public static String  getRandomNumStr(int num){
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < num; i++) {
		      sb.append(NUMBER_STR.charAt(RANDOM.nextInt(NUMBER_STR.length())));
		    }
		    return sb.toString();
	  }
	  
}
