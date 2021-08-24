package net.zpavelocity.im.main.main;

import android.view.View;

import net.zpavelocity.im.share.base.BaseImActivity;
import net.zpavelocity.im.share.databinding.ActivityMainConfigBinding;

import java.io.Serializable;

public class MainConfigActivity extends BaseImActivity<ActivityMainConfigBinding> {

    @Override
    public int getContentViewResId() {
        return net.zpavelocity.im.share.R.layout.activity_main_config;
    }

    @Override
    protected void afterSetContentView() {
        binding.tvMainConfig.setText((String) getIntent().getSerializableExtra("extra"));

        binding.tvMainConfigBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivityWithResult("extra", "result test");
            }
        });
    }
}
