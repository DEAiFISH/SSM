import bean.Emp;
import bean.EmpExample;
import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

import static util.SqlSessionFactoryUtils.getSqlSessionFactory;

public class MBG_Test {
    SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();


    @Test
    public void test1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        EmpExample empExample = new EmpExample();

        empExample.createCriteria().andAgeBetween(10, 50).andDeptidEqualTo(1);
        empExample.or().andDeptidEqualTo(2);

        List<Emp> list = mapper.selectByExample(empExample);

        list.forEach(System.out::println);

        sqlSession.close();
    }
}
