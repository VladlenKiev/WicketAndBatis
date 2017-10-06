package com.company.service;

import com.company.dao.MyBatisConnectionFactory;
import com.company.dao.SubscriberMapper;
import com.company.model.Subscriber;
import org.apache.ibatis.session.SqlSession;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {code Hello} is entered point of Wicket.
 *
 * @author Volodymye Mankivskiy
 * @see org.apache.wicket.markup.html.WebPage
 * @since 1.0.1
 */

public class Hello extends WebPage {

    private transient List<Subscriber> subscriberList = new ArrayList<>();
	private static final long serialVersionUID = 1L;

    public Hello(final PageParameters parameters) {

        add(new Label("message", "service World, Wicket"));

        loadFromDBSubscribers();
        @SuppressWarnings("unchecked") ListView listViewSubscriber = new ListView("listViewSubscriber", subscriberList) {
            protected void populateItem(ListItem item) {
                item.add(new Label("subscribers", item.getModel()));
            }
        };
        add(listViewSubscriber);

    }

    void loadFromDBSubscribers(){
        /*
        Method Create mapper. Method will getting getSubscriberById And getSubscribers from DB.
         */
        try(SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession())  {
            //noinspection unchecked
            subscriberList = sqlSession.getMapper(SubscriberMapper.class).getSubscribers();
        }

    }


}
