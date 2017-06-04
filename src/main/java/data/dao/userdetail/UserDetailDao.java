package data.dao.userdetail;

import data.bo.userdetail.UserDetailBO;
import data.model.userdetail.UserDetail;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDetailDao implements UserDetailBO{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public UserDetail getUserDetail(String user) {

        List<UserDetail> userDetailList = (List<UserDetail>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(UserDetail.class)
                .add(Restrictions.eq("active", true))
                .add(Restrictions.eq("user", user)), 1, 1);

        return userDetailList.isEmpty() ? null : userDetailList.get(0);
    }
}
