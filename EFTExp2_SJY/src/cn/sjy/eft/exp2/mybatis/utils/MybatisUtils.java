package cn.sjy.eft.exp2.mybatis.utils;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 工具�?
 */
public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory = null;
	// 初始化SqlSessionFactory对象
	static {
		try {
			// 使用MyBatis提供的Resources类加载mybatis的配置文�?
			Reader reader = 
					Resources.getResourceAsReader("mybatis-config.xml");
			// 构建sqlSession的工�?
			sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 获取SqlSession对象的静态方�?
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}
