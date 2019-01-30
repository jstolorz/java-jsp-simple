package org.bluesoft.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = {"/searchResults.html"})
public class MenuSearchCorrectionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String searchTerm = request.getParameter("searchTerm");

        if(searchTerm.toLowerCase().equals("chook")){
            MenuSearchCorrectionRequestWraper wraper = new MenuSearchCorrectionRequestWraper((HttpServletRequest) request);
            wraper.setNewSearchTerm("chicken");
            chain.doFilter(wraper,response);
        }else {
            chain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
