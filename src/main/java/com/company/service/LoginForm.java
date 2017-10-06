package com.company.service;

import com.company.dao.MyBatisConnectionFactory;
import com.company.dao.SubscriberMapper;
import com.company.model.Subscriber;
import org.apache.ibatis.session.SqlSession;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class {@code LoginForm} for a ${PROJECT_NAME}.
 *
 * @author V.Mankivskiy
 * @see com.company.service.LoginForm
 * @since 1.0.1
 */
class LoginForm extends Form {
    private String username;
    private String password;

    private static final Logger log = Logger.getLogger(LoginForm.class.getName());

    public LoginForm(String id) {
        super("loginForm");
        setDefaultModel(new CompoundPropertyModel(this));
        add(new TextField("username"));
        add(new PasswordTextField("password"));
        add(new Label("loginStatus"));
    }

    @Override
    public final void onSubmit() {

        try (SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession()) {
            Subscriber subscriber = new Subscriber();
            subscriber.setLog(username);
            subscriber.setPas(password);
        /*
        Method Create mapper. Method will getting getSubscriberById And getSubscribers from DB.
         */
            SubscriberMapper subscriberMapper = sqlSession.getMapper(SubscriberMapper.class);
            subscriberMapper.insertSubscriber(subscriber);

            getRequestCycle().setResponsePage(Hello.class);

        } catch (Exception io) {
            log.log(Level.WARNING, "Exception IO");
        }
    }
}
