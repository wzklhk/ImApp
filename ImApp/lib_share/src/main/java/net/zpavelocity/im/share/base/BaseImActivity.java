package net.zpavelocity.im.share.base;

import androidx.databinding.ViewDataBinding;

import com.alibaba.android.arouter.launcher.ARouter;

import net.zpavelocity.im.common.base.BaseDataBindingActivity;

public abstract class BaseImActivity<T extends ViewDataBinding> extends BaseDataBindingActivity<T> {
    @Override
    protected void beforeSetContentView() {
        super.beforeSetContentView();
    }

    @Override
    protected void initAfterBinding() {
        super.initAfterBinding();
        ARouter.getInstance().inject(this);
    }

    @Override
    protected void afterSetContentView() {
        super.afterSetContentView();
    }
}
