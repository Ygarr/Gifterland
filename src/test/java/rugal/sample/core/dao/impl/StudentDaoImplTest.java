package company.sample.core.dao.impl;

import ml.rugal.sshcommon.page.Pagination;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import company.JUnitSpringTestBase;
import company.sample.core.dao.PlaceDao;
import company.sample.core.entity.place;

/**
 *
 * @author company
 */
public class placeDaoImplTest extends JUnitSpringTestBase
{

    @Autowired
    private PlaceDao placeDao;

    public placeDaoImplTest()
    {
    }

//    @Test
    public void testGetPage()
    {
        System.out.println("getPage");
        int pageNo = 0;
        int pageSize = 0;
        Pagination result = placeDao.getPage(pageNo, pageSize);
    }

    @Test
    public void testFindById()
    {
        System.out.println("findById");
        Integer id = 1;
        place result = placeDao.findById(id);
    }

//    @Test
    public void testSave()
    {
        System.out.println("save");
        place bean = new place();
        bean.setId(1);
        bean.setAge(23);
        bean.setName("company com");
        place result = placeDao.save(bean);
    }

//    @Test
    public void testDeleteById()
    {
        System.out.println("deleteById");
        Integer id = 1;
        place result = placeDao.deleteById(id);
    }

}
