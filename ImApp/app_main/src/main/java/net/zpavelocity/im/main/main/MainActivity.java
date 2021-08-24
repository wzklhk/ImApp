package net.zpavelocity.im.main.main;

import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import net.zpavelocity.im.share.base.BaseImActivity;
import net.zpavelocity.im.share.databinding.ActivityMainBinding;
import net.zpavelocity.im.share.main.ImARouter;

import java.io.Serializable;

@Route(path = ImARouter.Path.MAIN)
public class MainActivity extends BaseImActivity<ActivityMainBinding> {

    @Override
    public int getContentViewResId() {
        return net.zpavelocity.im.share.R.layout.activity_main;
    }

    @Override
    protected void afterSetContentView() {
        binding.tvMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoActivityWithExtraForResult(MainConfigActivity.class, "extra", (Serializable) "main extra test", 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    toastMsg((String) data.getSerializableExtra("extra"));
                }
        }
    }
}
