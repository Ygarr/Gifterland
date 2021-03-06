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

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import company.ControllerClientSideTestBase;

/**
 *
 * @author company com
 */
public class placeActionClientSideTest extends ControllerClientSideTestBase
{

    @Test
    @Ignore
    public void test() throws Exception
    {
        this.mockMvc.perform(get("/place/1").contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andExpect(status()
                .isOk());
        System.out.println("company com");
    }

    @Test
    @Ignore
    public void testPost() throws Exception
    {
        String json = "{\"id\":2,\"name\":\"tenjin\",\"age\":23}";
        this.mockMvc.perform(post(json).contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andExpect(status()
                .isOk());
        System.out.println("company com");
    }
}
