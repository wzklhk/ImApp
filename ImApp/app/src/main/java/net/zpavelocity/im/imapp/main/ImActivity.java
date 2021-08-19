package net.zpavelocity.im.imapp.main;

import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import net.zpavelocity.im.share.base.BaseImActivity;
import net.zpavelocity.im.share.databinding.ActivityImStartPageBinding;
import net.zpavelocity.im.share.main.ImARouter;

@Route(path = ImARouter.Path.START)
public class ImActivity extends BaseImActivity<ActivityImStartPageBinding> {
    private static final String TAG = ImActivity.class.getSimpleName();

    @Override
    public int getContentViewResId() {
        return net.zpavelocity.im.share.R.layout.activity_im_start_page;
    }

    @Override
    protected void afterSetContentView() {
        super.afterSetContentView();
        binding.tvTest.setText("hello world");
        binding.tvTest.setOnClickListener(v -> {
            ARouter.getInstance().build(ImARouter.Path.MAIN).navigation();
        });
    }
}