package company.sample.springmvc.controller;

import ml.rugal.sshcommon.springmvc.util.Message;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import company.ControllerClientSideTestBase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import company.sample.core.entity.place;

/**
 *
 * @author company
 */
public class placeActionTest extends ControllerClientSideTestBase
{

    @Autowired
    private placeAction placeAction;

    public placeActionTest()
    {
    }

    @Test
    public void testRegisterplace() throws Exception
    {
        System.out.println("registerplace");
        this.mockMvc.perform(post("/place")
            .content("{\"id\":\"3\",\"name\":\"tenjin\",\"age\":\"23\"}")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
        System.out.println("company com");
    }

    //    @Test
    public void testUpdateplaceProfile()
    {
        System.out.println("updateplaceProfile");
        Integer id = null;
        place bean = null;
        placeAction instance = new placeAction();
        Message expResult = null;
        Message result = instance.updateplaceProfile(id, bean);
    }

//    @Test
    public void testDeregister()
    {
        System.out.println("cancelOrder");
        Integer id = null;
        placeAction instance = new placeAction();
        Message expResult = null;
        Message result = instance.deregister(id);
    }

//    @Test
    public void testRetrieve()
    {
        System.out.println("retrieve");
        Integer id = null;
        placeAction instance = new placeAction();
        Message expResult = null;
        Message result = instance.retrieve(id);
    }

}
