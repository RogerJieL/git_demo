package action;

/* 重新生成  */
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import jdbc.ImageUtil;


@WebServlet("/checkCode.action")
public class VerificationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	/*简单来说，Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。
	在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的
	serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，
	否则就会出现序列化版本不一致的异常。(InvalidCastException)
     serialVersionUID有两种显示的生成方式：        一个是默认的1L，
    比如：private static final long serialVersionUID = 1L;        
一个是根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段*/
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
  
  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String,BufferedImage> map = ImageUtil.createImage(); //创建一张图片
		String key = map.keySet().iterator().next(); 
		//将Map<String，BufferedImage>中的key值，也就是String拿出来，而BufferedImage对应的为图像对象
		session.setAttribute("checkCode", key);//将key值存在Session中
		//下面的代码是使用流的方式将图片输出到前台（也就是register_form.jsp页面）
		BufferedImage image = map.get(key);
		ServletOutputStream out= response.getOutputStream();
		JPEGImageEncoder imageEncoder = JPEGCodec.createJPEGEncoder(out);
		imageEncoder.encode(image);
		out.flush();
	}

}