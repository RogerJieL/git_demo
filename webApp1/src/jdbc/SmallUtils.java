package jdbc;

public class SmallUtils {
	public static String getServletValue(int  end) {
		String endrs="";
		if(end!=0){
			  endrs="1";
		  }else{
			  endrs="0";
		  }
	return endrs;
	}
}
