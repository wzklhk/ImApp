package net.zpavelocity.im.main.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import net.zpavelocity.im.share.base.BaseImActivity;
import net.zpavelocity.im.share.databinding.ActivityMainBinding;
import net.zpavelocity.im.share.main.ImARouter;

@Route(path = ImARouter.Path.MAIN)
public class MainActivity extends BaseImActivity<ActivityMainBinding> {

    @Override
    public int getContentViewResId() {
        return net.zpavelocity.im.share.R.layout.activity_main;
    }

    @Override
    protected void afterSetContentView() {
        binding.tvMain.setOnClickListener((v) -> {
            ARouter.getInstance().build(ImARouter.Path.START).navigation();
        });
    }
}
