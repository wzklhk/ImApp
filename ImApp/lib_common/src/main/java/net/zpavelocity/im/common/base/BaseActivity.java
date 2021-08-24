package net.zpavelocity.im.common.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void toastMsg(String msg) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    public void toastLongMsg(String msg) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_LONG).show();
    }

    public void toastMsg(int resId) {
        Toast.makeText(this, "" + this.getString(resId), Toast.LENGTH_SHORT).show();
    }

    public void toastLongMsg(int resId) {
        Toast.makeText(this, "" + this.getString(resId), Toast.LENGTH_LONG).show();
    }

    public void gotoActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    public void gotoActivityWithExtra(Class activity, String name, Serializable extra) {
        Intent intent = new Intent(this, activity);
        intent.putExtra(name, extra);
        startActivity(intent);
    }

    public void gotoActivityForResult(Class activity, int requestCode) {
        Intent intent = new Intent(this, activity);
        startActivityForResult(intent, requestCode);
    }

    public void gotoActivityWithExtraForResult(Class activity, String name, Serializable extra, int requestCode) {
        Intent intent = new Intent(this, activity);
        intent.putExtra(name, extra);
        startActivityForResult(intent, requestCode);
    }

    public void finishActivity() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        this.finish();
    }

    public void finishActivityWithResult(String name, Serializable result) {
        Intent intent = new Intent();
        intent.putExtra(name, result);
        setResult(RESULT_OK, intent);
        this.finish();
    }
}
