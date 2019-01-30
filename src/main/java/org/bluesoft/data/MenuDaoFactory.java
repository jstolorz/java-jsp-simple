package org.bluesoft.data;

public class MenuDaoFactory {

    private static MenuDao menuDao;

    public static MenuDao getMenuDao() {

        if(menuDao == null){
            menuDao = new MenuDao();
        }

        return menuDao;
    }
}
