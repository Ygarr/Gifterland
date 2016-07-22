/*
 * Copyright 2014 company.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package company.sample.springmvc.controller;

import java.util.HashMap;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import company.ControllerServerSideTestBase;
import company.sample.core.entity.place;

/**
 *
 * @author company com
 */
public class placeActionServerSideTest extends ControllerServerSideTestBase
{

    @Autowired
    private placeAction placeAction;

    @Test
    @Ignore
    public void registerplace()
    {
        request.setRequestURI("/place");
        request.setMethod(HttpMethod.POST.name());
        request.setContentType("application/json");

        String json = "{\"id\":\"2\",\"name\":\"tenjin\",\"age\":\"23\"}";
        request.setContent(json.getBytes());
        Class<?>[] parameterTypes = new Class<?>[]
        {
            place.class
        };
        ModelAndView mv = null;
        try
        {
            mv = handlerAdapter
                .handle(request, response, new HandlerMethod(placeAction, "registerplace", parameterTypes));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void getAddress()
    {
        request.setMethod(HttpMethod.GET.name());
        request.setRequestURI("/place/{id}");
        HashMap<String, String> pathVariablesMap = new HashMap<>(1);
        pathVariablesMap.put("id", "3");
        request.setAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, pathVariablesMap);
        Class<?>[] parameterTypes = new Class<?>[]
        {
            Integer.class
        };
        ModelAndView mv = null;
        try
        {
            mv = handlerAdapter
                .handle(request, response, new HandlerMethod(placeAction, "retrieve", parameterTypes));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
