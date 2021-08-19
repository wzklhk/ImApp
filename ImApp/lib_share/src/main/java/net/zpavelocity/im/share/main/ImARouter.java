package net.zpavelocity.im.share.main;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import net.zpavelocity.im.common.BuildConfig;

public class ImARouter {

    public static void init(Application app) {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(app);
    }

    public static void destroy() {
        ARouter.getInstance().destroy();
    }

    public static class Path {
        public static final String START = "/imapp/main/ImActivity";
        public static final String MAIN = "/main/main/MainActivity";
    }
}
