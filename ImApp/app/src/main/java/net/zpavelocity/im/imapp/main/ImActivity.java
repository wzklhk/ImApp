package net.zpavelocity.im.imapp.main;

import android.os.Handler;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import net.zpavelocity.im.share.base.BaseImActivity;
import net.zpavelocity.im.share.databinding.ActivityImStartPageBinding;
import net.zpavelocity.im.share.main.ImARouter;


@Route(path = ImARouter.Path.START)
public class ImActivity extends BaseImActivity<ActivityImStartPageBinding> {

    private static final String TAG = ImActivity.class.getSimpleName();
    private Handler mHandler;
    private MyRunnable mMyRunnable;

    @Override

    public int getContentViewResId() {
        return net.zpavelocity.im.share.R.layout.activity_im_start_page;
    }

    @Override
    protected void afterSetContentView() {
        super.afterSetContentView();
        getSupportActionBar().hide();

        mHandler = new Handler();
        mMyRunnable = new MyRunnable();
        mHandler.postDelayed(mMyRunnable, 1000);

    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            ARouter.getInstance().build(ImARouter.Path.MAIN).navigation();
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null || mMyRunnable != null) {
            mHandler.removeCallbacks(mMyRunnable);
            mHandler = null;
        }
    }
}