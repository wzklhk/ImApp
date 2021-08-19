package net.zpavelocity.im.common.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (getApplicationContext().getPackageName().equals(getCurrentProcessName())) {
            instance = this;
            init();
        }
    }

    private String getCurrentProcessName() {
        int pid = android.os.Process.myPid();
        String processName = "";
        ActivityManager manager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo process : manager.getRunningAppProcesses()) {
            if (process.pid == pid) {
                processName = process.processName;
                break;
            }
        }
        return processName;
    }

    @Override
    public void onTerminate() {
        unInit();
        super.onTerminate();
    }

    protected void init() {
    }

    protected void unInit() {
    }
}
