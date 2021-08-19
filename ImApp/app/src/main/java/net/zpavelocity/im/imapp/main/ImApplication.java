package net.zpavelocity.im.imapp.main;

import net.zpavelocity.im.common.base.BaseApplication;
import net.zpavelocity.im.share.main.ImARouter;

public class ImApplication extends BaseApplication {
    @Override
    protected void init() {
        ImARouter.init(this);
    }
}
