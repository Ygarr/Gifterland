package company.sample.core.service;

import ml.rugal.sshcommon.page.Pagination;
import company.sample.core.entity.Place;

/**
 *
 * @author company com
 */
public interface PlaceService
{

    Place deleteById(Integer id);

    Place findById(Integer id);

    Pagination getPage(int pageNo, int pageSize);

    Place save(Place bean);

    Place update(Place bean);

}
