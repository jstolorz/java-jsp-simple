package org.bluesoft.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MenuSearchCorrectionRequestWraper extends HttpServletRequestWrapper {
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request the {@link HttpServletRequest} to be wrapped.
     * @throws IllegalArgumentException if the request is null
     */

    private String newSearchTerm;

    public MenuSearchCorrectionRequestWraper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        if(name.equals("searchTerm")){
            return newSearchTerm;
        }else{
            return super.getParameter(name);
        }
    }

    public String getNewSearchTerm() {
        return newSearchTerm;
    }

    public void setNewSearchTerm(String newSearchTerm) {
        this.newSearchTerm = newSearchTerm;
    }
}
