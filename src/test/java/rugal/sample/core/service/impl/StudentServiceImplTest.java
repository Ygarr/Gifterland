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
package company.sample.core.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import company.JUnitSpringTestBase;
import company.sample.core.entity.place;
import company.sample.core.service.placeService;

/**
 *
 * @author company
 */
public class placeServiceImplTest extends JUnitSpringTestBase
{

    @Autowired
    private placeService placeService;

    public placeServiceImplTest()
    {
    }

//    @Test
    public void testDeleteById()
    {
        System.out.println("deleteById");
        Integer id = null;
        placeServiceImpl instance = new placeServiceImpl();
        place expResult = null;
        place result = placeService.deleteById(id);
    }

    @Test
    @Ignore
    public void testFindById()
    {
        System.out.println("findById");
        Integer id = 1;
        placeService.findById(id);
    }

    @Test
//    @Ignore
    public void testSave()
    {
        System.out.println("save");
        place bean = new place();
        bean.setId(2);
        bean.setAge(132);
        bean.setName("company");
        placeService.save(bean);
    }

}
