package company.sample.core.service.impl;

import ml.rugal.sshcommon.hibernate.Updater;
import ml.rugal.sshcommon.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import company.sample.core.dao.PlaceDao;
import company.sample.core.entity.Place;
import company.sample.core.service.PlaceService;

/**
 *
 * @author company com
 */
@Service
@Transactional
public class PlaceServiceImpl implements PlaceService
{

    @Autowired
    private PlaceDao PlaceDao;

    @Override
    public Place deleteById(Integer id)
    {
        //Used for transaction test
        return PlaceDao.deleteById(id);
//        throw new UnsupportedOperationException();
    }

    @Override
    @Transactional(readOnly = true)
    public Place findById(Integer id)
    {
        return PlaceDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Pagination getPage(int pageNo, int pageSize)
    {
        return PlaceDao.getPage(pageNo, pageSize);
    }

    @Override
    public Place save(Place bean)
    {
        //Used for transaction test
        return PlaceDao.save(bean);
//        this.deleteById(1);
//        return null;
    }

    @Override
    public Place update(Place bean)
    {
        Updater<Place> updater = new Updater<>(bean);
        return PlaceDao.updateByUpdater(updater);
    }

}
