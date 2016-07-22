package company.sample.springmvc.controller;

import ml.rugal.sshcommon.springmvc.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import company.sample.common.CommonMessageContent;
import company.sample.core.entity.Place;
import company.sample.core.service.PlaceService;

import java.util.Map;

/**
 *
 * A sample controller class for GET/DELETE/POST/PUT.
 *
 * @author company com
 */
@Controller
@RequestMapping(value = "/place")
public class PlaceAction
{

    private static final Logger LOG = LoggerFactory.getLogger(PlaceAction.class.getName());

    @Autowired
    private PlaceService placeService;

    /**
     * Persist a place bean into database.
     *
     * @param bean place bean resembled from request body.
     *
     * @return The persisted place bean.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Message registerPlace(@RequestBody Place bean)
    {
        placeService.save(bean);
        /*
         * Now we need to push message notify them
         */
        return Message.successMessage(CommonMessageContent.SAVE_SUCCEED, bean);
    }

    /**
     * Update a place bean.
     *
     * @param id   primary key of target place.
     * @param bean the newer place bean
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Message updatePlaceProfile(@PathVariable("id") Integer id, @RequestBody Place bean)
    {
        Place dbplace = placeService.findById(id);
        if (null != dbplace)
        {
            placeService.update(bean);
        }
        /*
         * Here we need to push message to client
         */
        return Message.successMessage(CommonMessageContent.PROFILE_UPDATED, bean);
    }

    /**
     * DELETE a place record from database.
     *
     * @param id the target place id.
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Message deregister(@PathVariable("id") Integer id)
    {
        Place bean = placeService.findById(id);
        if (null != bean)
        {
            placeService.deleteById(id);
        }
        return Message.successMessage(CommonMessageContent.PLACE_DELETED, bean);
    }

    /**
     * GET a place record from database.
     *
     * @param id primary key of target place.
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Message retrieve(@PathVariable("id") Integer id)
    {
        Place bean = placeService.findById(id);
        return Message.successMessage(CommonMessageContent.GET_PLACE, bean);
    }

    /**
	 * Корневой каталог перенаправляем на(на самом деле не перенаправляем)
	 *
	 * @return "redirect:/путь"
	 */
	@RequestMapping("/")
	public String home() {
		return "redirect:/place/1";
	}


    /**
     * К пути /place привязывается main.jsp.(на самом деле нет)
     *
     *
     * @param map
     * @return "employee"
     */
    @RequestMapping("/place")
    public String main(Map<String, Object> map) {
        map.put("place", placeService.findById(2).toString());
        return "place";
    }

}
