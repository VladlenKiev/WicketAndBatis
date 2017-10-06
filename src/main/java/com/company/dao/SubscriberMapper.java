package com.company.dao;

import com.company.model.Subscriber;

import java.util.List;

/**
 * Class {@code = SubscriberMapper} consist method for operate with MyBatis.
 *
 * @author V.Mankivskiy
 * @see com.company.dao.SubscriberMapper
 * @since 1.0.1
 */
public interface SubscriberMapper {

    Subscriber getSubscriberById(Integer id);

    List getSubscribers();

    void insertSubscriber(Subscriber subscriber);

}
