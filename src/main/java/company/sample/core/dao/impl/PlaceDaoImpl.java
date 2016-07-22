package company.sample.core.dao.impl;

import ml.rugal.sshcommon.hibernate.HibernateBaseDao;
import ml.rugal.sshcommon.page.Pagination;
import org.hibernate.Criteria;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import company.sample.core.dao.PlaceDao;
import company.sample.core.entity.Place;

/**
 *
 * @author company com
 */
@Repository
public class PlaceDaoImpl extends HibernateBaseDao<Place, Integer> implements PlaceDao
{

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(PlaceDaoImpl.class.getName());

    @Override
    public Pagination getPage(int pageNo, int pageSize)
    {
        Criteria crit = createCriteria();
        Pagination page = findByCriteria(crit, pageNo, pageSize);
        return page;
    }

    @Override
    public Place findById(Integer id)
    {
        Place entity = get(id);
        return entity;
    }

    @Override
    public Place save(Place bean)
    {
        getSession().save(bean);
        return bean;
    }

    @Override
    public Place deleteById(Integer id)
    {
//        throw new UnsupportedOperationException();
        Place entity = super.get(id);
        if (entity != null)
        {
            getSession().delete(entity);
        }
        return entity;
    }

    @Override
    protected Class<Place> getEntityClass()
    {
        return Place.class;
    }

}
