package net.zpavelocity.im.common.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.DataBindingUtil;

public abstract class BaseDataBindingActivity<T extends ViewDataBinding> extends BaseActivity {

    private static final String TAG = BaseDataBindingActivity.class.getSimpleName();
    public T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        beforeSetContentView();
        binding = DataBindingUtil.setContentView(this, getContentViewResId());
        initAfterBinding();
        afterSetContentView();
    }

    public abstract int getContentViewResId();

    protected void beforeSetContentView() {
    }

    protected void initAfterBinding() {
    }

    protected void afterSetContentView() {
    }

    public void gotoActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }
}
