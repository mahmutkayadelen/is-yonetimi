package com.mahmutkayadelen.isyonetimi.util;
/**
 *Created by mahmutkayadelen on 20.12.2020
 **/

public final class ApiPaths {
    private static  final String BASE_PATH = "/api";

    public static  final class IssueCtrl{
        public static final String CTRL = BASE_PATH+"/Issue";
    }
    public static  final class ProjectCtrl{
        public static final String CTRL = BASE_PATH+"/project";
    }
    public static  final class UserCtrl{
        public static final String CTRL = BASE_PATH+"/user";
    }
}
