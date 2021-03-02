package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.login.LoginClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class LoginFragment extends Fragment {
    static final String EXTRA_REQUEST = "request";
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
    static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
    private static final String SAVED_LOGIN_CLIENT = "loginClient";
    private static final String TAG = "LoginFragment";
    private String callingPackage;
    private LoginClient loginClient;
    private LoginClient.Request request;

    static /* synthetic */ void access$000(LoginFragment loginFragment, LoginClient.Result result) {
        AppMethodBeat.i(7880);
        loginFragment.onLoginClientCompleted(result);
        AppMethodBeat.o(7880);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundleExtra;
        AppMethodBeat.i(7870);
        super.onCreate(bundle);
        if (bundle != null) {
            this.loginClient = (LoginClient) bundle.getParcelable(SAVED_LOGIN_CLIENT);
            this.loginClient.setFragment(this);
        } else {
            this.loginClient = createLoginClient();
        }
        this.loginClient.setOnCompletedListener(new LoginClient.OnCompletedListener() {
            /* class com.facebook.login.LoginFragment.AnonymousClass1 */

            @Override // com.facebook.login.LoginClient.OnCompletedListener
            public void onCompleted(LoginClient.Result result) {
                AppMethodBeat.i(7867);
                LoginFragment.access$000(LoginFragment.this, result);
                AppMethodBeat.o(7867);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity == null) {
            AppMethodBeat.o(7870);
            return;
        }
        initializeCallingPackage(activity);
        Intent intent = activity.getIntent();
        if (!(intent == null || (bundleExtra = intent.getBundleExtra(REQUEST_KEY)) == null)) {
            this.request = (LoginClient.Request) bundleExtra.getParcelable("request");
        }
        AppMethodBeat.o(7870);
    }

    /* access modifiers changed from: protected */
    public LoginClient createLoginClient() {
        AppMethodBeat.i(7871);
        LoginClient loginClient2 = new LoginClient(this);
        AppMethodBeat.o(7871);
        return loginClient2;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        AppMethodBeat.i(7872);
        this.loginClient.cancelCurrentHandler();
        super.onDestroy();
        AppMethodBeat.o(7872);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(7873);
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        final View findViewById = inflate.findViewById(R.id.b87);
        this.loginClient.setBackgroundProcessingListener(new LoginClient.BackgroundProcessingListener() {
            /* class com.facebook.login.LoginFragment.AnonymousClass2 */

            @Override // com.facebook.login.LoginClient.BackgroundProcessingListener
            public void onBackgroundProcessingStarted() {
                AppMethodBeat.i(7868);
                findViewById.setVisibility(0);
                AppMethodBeat.o(7868);
            }

            @Override // com.facebook.login.LoginClient.BackgroundProcessingListener
            public void onBackgroundProcessingStopped() {
                AppMethodBeat.i(7869);
                findViewById.setVisibility(8);
                AppMethodBeat.o(7869);
            }
        });
        AppMethodBeat.o(7873);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.vh;
    }

    private void onLoginClientCompleted(LoginClient.Result result) {
        AppMethodBeat.i(7874);
        this.request = null;
        int i2 = result.code == LoginClient.Result.Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_KEY, result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i2, intent);
            getActivity().finish();
        }
        AppMethodBeat.o(7874);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        AppMethodBeat.i(7875);
        super.onResume();
        if (this.callingPackage == null) {
            getActivity().finish();
            AppMethodBeat.o(7875);
            return;
        }
        this.loginClient.startOrContinueAuth(this.request);
        AppMethodBeat.o(7875);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        View findViewById;
        AppMethodBeat.i(7876);
        super.onPause();
        if (getView() == null) {
            findViewById = null;
        } else {
            findViewById = getView().findViewById(R.id.b87);
        }
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        AppMethodBeat.o(7876);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(7877);
        super.onActivityResult(i2, i3, intent);
        this.loginClient.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(7877);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(7878);
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(SAVED_LOGIN_CLIENT, this.loginClient);
        AppMethodBeat.o(7878);
    }

    private void initializeCallingPackage(Activity activity) {
        AppMethodBeat.i(7879);
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            AppMethodBeat.o(7879);
            return;
        }
        this.callingPackage = callingActivity.getPackageName();
        AppMethodBeat.o(7879);
    }

    /* access modifiers changed from: package-private */
    public LoginClient getLoginClient() {
        return this.loginClient;
    }
}
