package com.group5.designpatters.ebazaar.servletfilter;

import com.group5.designpatters.ebazaar.utilities.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Odiljon Sattarov
 */
public class OpenSessionInViewFilter implements Filter {

    private SessionFactory sessionFactory;

    public void init(FilterConfig filterConfig) throws ServletException {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        Transaction transaciton = null;
        try {
            transaciton = sessionFactory.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            transaciton.commit();
        } catch (RuntimeException ex) {
            try {
                ex.printStackTrace();
                transaciton.rollback();
            } catch (RuntimeException rbEx) {
                System.out.println("Could not rollback transaction " + rbEx);
                rbEx.printStackTrace();
            }
            throw ex;
        }
    }

    public void destroy() {
    }
}
