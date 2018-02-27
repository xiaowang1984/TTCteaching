package auto;

public class AutoUtil {
	public static final String PACK="com.neuedu.pojo";
	public static final String BEAN="WorkStudentDetail";
	public static final String SMALLBEAN=BEAN.substring(0, 1).toLowerCase()+BEAN.substring(1);
	public static final String BASEPATH=System.getProperty("user.dir");
	public static final String DAOPATH=BASEPATH+"\\src\\main\\java\\com\\neuedu\\dao";
	public static final String SERVICEPATH=BASEPATH+"\\src\\main\\java\\com\\neuedu\\service";
	public static final String MAPPERPATH=BASEPATH+"\\src\\main\\resources\\com\\neuedu\\dao";
	public static final String TMP=BASEPATH+"\\src\\test\\resources\\temp";
	public static final String DAOINTERFILE="daointer.tmp";
	public static final String SERVICEINTERFILE="serviceinter.tmp";
	public static final String SERVICEIMPLFILE="serviceimpl.tmp";
	public static final String MAPPERFILE="mapper.tmp";
}
