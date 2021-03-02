package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class FacebookActivity extends FragmentActivity {
    private static String FRAGMENT_TAG = "SingleFragment";
    public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static final String TAG = FacebookActivity.class.getName();
    private Fragment singleFragment;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(7616);
        AppMethodBeat.o(7616);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7612);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!FacebookSdk.isInitialized()) {
            Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            FacebookSdk.sdkInitialize(getApplicationContext());
        }
        setContentView(R.layout.vf);
        if (PASS_THROUGH_CANCEL_ACTION.equals(intent.getAction())) {
            handlePassThroughError();
            AppMethodBeat.o(7612);
            return;
        }
        this.singleFragment = getFragment();
        AppMethodBeat.o(7612);
    }

    /* access modifiers changed from: protected */
    public Fragment getFragment() {
        AppMethodBeat.i(7613);
        Intent intent = getIntent();
        g supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        FacebookDialogFragment facebookDialogFragment = findFragmentByTag;
        if (findFragmentByTag == null) {
            if (FacebookDialogFragment.TAG.equals(intent.getAction())) {
                FacebookDialogFragment facebookDialogFragment2 = new FacebookDialogFragment();
                facebookDialogFragment2.setRetainInstance(true);
                facebookDialogFragment2.show(supportFragmentManager, FRAGMENT_TAG);
                facebookDialogFragment = facebookDialogFragment2;
            } else if (DeviceShareDialogFragment.TAG.equals(intent.getAction())) {
                DeviceShareDialogFragment deviceShareDialogFragment = new DeviceShareDialogFragment();
                deviceShareDialogFragment.setRetainInstance(true);
                deviceShareDialogFragment.setShareContent((ShareContent) intent.getParcelableExtra("content"));
                deviceShareDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
                facebookDialogFragment = deviceShareDialogFragment;
            } else {
                LoginFragment loginFragment = new LoginFragment();
                loginFragment.setRetainInstance(true);
                supportFragmentManager.beginTransaction().a(R.id.b86, loginFragment, FRAGMENT_TAG).commit();
                facebookDialogFragment = loginFragment;
            }
        }
        AppMethodBeat.o(7613);
        return facebookDialogFragment;
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(7614);
        super.onConfigurationChanged(configuration);
        if (this.singleFragment != null) {
            this.singleFragment.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(7614);
    }

    public Fragment getCurrentFragment() {
        return this.singleFragment;
    }

    private void handlePassThroughError() {
        AppMethodBeat.i(7615);
        setResult(0, NativeProtocol.createProtocolResultIntent(getIntent(), null, NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(getIntent()))));
        finish();
        AppMethodBeat.o(7615);
    }
}
