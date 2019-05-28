import com.itheima.dao.CustomerDao;
import com.itheima.dao.LinkManDao;
import com.itheima.pojo.Customer;
import com.itheima.pojo.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DaoTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional //注解开启事务
    @Rollback(false)//设置为不回滚
    public void testAdd() {

        Customer c = new Customer();
        c.setCustName("TBD云集中心");
        c.setCustLevel("VIP客户");
        c.setCustSource("网络");
        c.setCustIndustry("商业办公");
        c.setCustAddress("昌平区北七家镇");
        c.setCustPhone("010-84389340");

        LinkMan l = new LinkMan();
        l.setLkmName("TBD联系人");
        l.setLkmGender("male");
        l.setLkmMobile("13811111111");
        l.setLkmPhone("010-34785348");
        l.setLkmEmail("98354834@qq.com");
        l.setLkmPosition("校长");
        l.setLkmMemo("一般般");

        LinkMan l2 = new LinkMan();
        l2.setLkmName("迟武义");
        l2.setLkmPhone("3241351351");

//dfsdfsdf
        c.getLinkmans().add(l); //通过客户去关联联系人
//        c.getLinkmans().add(l2);
        l.setCustomer(c); //通过联系人来关联用户
        customerDao.save(c);
        linkManDao.save(l);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testDelet() {
        customerDao.delete(5L);
//        linkManDao.delete(2L);
    }

    /**
     * 级联保存
     */
    @Test
    @Transactional //注解开启事务
    @Rollback(false)//设置为不回滚
    public void testAdd1() {

        Customer c = new Customer();
        c.setCustName("TBD云集中心");
        c.setCustLevel("VIP客户");
        c.setCustSource("网络");
        c.setCustIndustry("商业办公");
        c.setCustAddress("昌平区北七家镇");
        c.setCustPhone("010-84389340");

        LinkMan l = new LinkMan();
        l.setLkmName("TBD联系人");
        l.setLkmGender("male");
        l.setLkmMobile("13811111111");
        l.setLkmPhone("010-34785348");
        l.setLkmEmail("98354834@qq.com");
        l.setLkmPosition("校长");
        l.setLkmMemo("一般般");

        LinkMan l2 = new LinkMan();
        l2.setLkmName("迟武义");
        l2.setLkmPhone("3241351351");


        c.getLinkmans().add(l); //通过客户去关联联系人
        c.getLinkmans().add(l2);
//        l.setCustomer(c); //通过联系人来关联用户
        customerDao.save(c);
//        linkManDao.save(l);
        //提交到gif中都是
    }
}
