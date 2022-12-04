package de.fynnhenck.homesystemcommon.config;

public class HomeMessages {

    public static String NO_PERMISSION;
    public static String GUI_TELEPORT;
    public static String GUI_DELETE;
    public static String DELETE_SINGLE;
    public static String DELETE_ALL;
    public static String GUI_TITLE;
    public static String TELEPORT;
    public static String SET_HOME;
    public static String HOME_DUPLICATE;
    public static String NO_HOME_FOUND;

    public HomeMessages(String noPerm, String guiTel, String guiDel, String delSin, String delAll, String guiTit, String tel, String setHome, String homeDub, String noHome){
        NO_PERMISSION = noPerm;
        GUI_TELEPORT = guiTel;
        GUI_DELETE = guiDel;
        DELETE_SINGLE = delSin;
        DELETE_ALL = delAll;
        GUI_TITLE = guiTit;
        TELEPORT = tel;
        SET_HOME = setHome;
        HOME_DUPLICATE = homeDub;
        NO_HOME_FOUND = noHome;
    }

}
