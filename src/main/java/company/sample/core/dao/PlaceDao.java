package company.sample.core.dao;

import ml.rugal.sshcommon.hibernate.Updater;
import ml.rugal.sshcommon.page.Pagination;
import company.sample.core.entity.Place;

/**
 *
 * @author company com
 */
public interface PlaceDao
{

    Place deleteById(Integer id);

    Place findById(Integer id);

    Pagination getPage(int pageNo, int pageSize);

    Place save(Place bean);

    Place updateByUpdater(Updater<Place> updater);

}
