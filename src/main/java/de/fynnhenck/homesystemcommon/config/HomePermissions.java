package de.fynnhenck.homesystemcommon.config;

public class HomePermissions {

    public static String TELEPORT_PERMISSION;
    public static String ADD_PERMISSION;
    public static String LIST_PERMISSION;
    public static String DELETE_PERMISSION;


    public HomePermissions(String addPermission, String deletePermission, String teleportPermission, String listPermission){
        HomePermissions.ADD_PERMISSION = addPermission;
        HomePermissions.DELETE_PERMISSION = deletePermission;
        HomePermissions.TELEPORT_PERMISSION = teleportPermission;
        HomePermissions.LIST_PERMISSION = listPermission;
    }


}
