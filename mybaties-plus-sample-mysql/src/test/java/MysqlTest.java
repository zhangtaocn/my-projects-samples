//
//import com.zt.mybatiesPlusMysql.MybatiesPlusMysql;
//import com.zt.mybatiesPlusMysql.entity.TestData;
//import com.zt.mybatiesPlusMysql.enums.TestEnum;
//import com.zt.mybatiesPlusMysql.mapper.TestDataMapper;
//import mybatis.mate.ddl.DdlScript;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import java.util.List;
//
//import javax.annotation.Resource;
//import java.io.StringReader;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MysqlTest {
//    @Autowired
//    private TestDataMapper testDataMapper;
//    @Autowired
//    private DdlScript ddlScript;
//
//    void truncateTable() throws Exception {
//        ddlScript.run(new StringReader("TRUNCATE TABLE test_data;"));
//    }
//
//    @Test
//    public void insertBatch() {
//        int size = 9;
//        List<TestData> testDataList = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            String str = i + "条";
//            testDataList.add(new TestData().setTestInt(i).setTestEnum(TestEnum.TWO).setTestStr(str));
//        }
//        assertEquals(size, testDataMapper.insertBatchSomeColumn(testDataList));
//        testDataList.forEach(System.err::println);
//    }
//
//    @Test
//    public void testInsertAutoId() {
//        // 自增 id 增长为 1
//        TestData testData = new TestData().setTestInt(1);
//        testData.setTestEnum(TestEnum.ONE).setTestStr("abc");
//        Assertions.assertEquals(testDataMapper.insert(testData), 1);
//        testData = testDataMapper.selectById(testData.getId());
//        Assertions.assertTrue(null != testData);
//        Assertions.assertEquals(1, testData.getId());
//        System.err.println(testData);
//        // 自增 id 增长为 2
//        TestData testData2 = new TestData().setTestInt(1);
//        testData2.setTestEnum(TestEnum.TWO).setTestStr("def");
//        Assertions.assertEquals(testDataMapper.insert(testData2), 1);
//        testData2 = testDataMapper.selectById(testData2.getId());
//        Assertions.assertTrue(null != testData2);
//        Assertions.assertEquals(2, testData2.getId());
//        System.err.println(testData2);
//    }
//}
