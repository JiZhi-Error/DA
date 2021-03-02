package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookDialogFragment extends DialogFragment {
    public static final String TAG = "FacebookDialogFragment";
    private Dialog dialog;

    static /* synthetic */ void access$000(FacebookDialogFragment facebookDialogFragment, Bundle bundle, FacebookException facebookException) {
        AppMethodBeat.i(7662);
        facebookDialogFragment.onCompleteWebDialog(bundle, facebookException);
        AppMethodBeat.o(7662);
    }

    static /* synthetic */ void access$100(FacebookDialogFragment facebookDialogFragment, Bundle bundle) {
        AppMethodBeat.i(7663);
        facebookDialogFragment.onCompleteWebFallbackDialog(bundle);
        AppMethodBeat.o(7663);
    }

    public void setDialog(Dialog dialog2) {
        this.dialog = dialog2;
    }

    @Override // android.support.v4.app.Fragment, android.support.v4.app.DialogFragment
    public void onCreate(Bundle bundle) {
        WebDialog newInstance;
        AppMethodBeat.i(7655);
        super.onCreate(bundle);
        if (this.dialog == null) {
            FragmentActivity activity = getActivity();
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(activity.getIntent());
            if (!methodArgumentsFromIntent.getBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, false)) {
                String string = methodArgumentsFromIntent.getString(NativeProtocol.WEB_DIALOG_ACTION);
                Bundle bundle2 = methodArgumentsFromIntent.getBundle(NativeProtocol.WEB_DIALOG_PARAMS);
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd(TAG, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    AppMethodBeat.o(7655);
                    return;
                }
                newInstance = new WebDialog.Builder(activity, string, bundle2).setOnCompleteListener(new WebDialog.OnCompleteListener() {
                    /* class com.facebook.internal.FacebookDialogFragment.AnonymousClass1 */

                    @Override // com.facebook.internal.WebDialog.OnCompleteListener
                    public void onComplete(Bundle bundle, FacebookException facebookException) {
                        AppMethodBeat.i(7653);
                        FacebookDialogFragment.access$000(FacebookDialogFragment.this, bundle, facebookException);
                        AppMethodBeat.o(7653);
                    }
                }).build();
            } else {
                String string2 = methodArgumentsFromIntent.getString("url");
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd(TAG, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    AppMethodBeat.o(7655);
                    return;
                }
                newInstance = FacebookWebFallbackDialog.newInstance(activity, string2, String.format("fb%s://bridge/", FacebookSdk.getApplicationId()));
                newInstance.setOnCompleteListener(new WebDialog.OnCompleteListener() {
                    /* class com.facebook.internal.FacebookDialogFragment.AnonymousClass2 */

                    @Override // com.facebook.internal.WebDialog.OnCompleteListener
                    public void onComplete(Bundle bundle, FacebookException facebookException) {
                        AppMethodBeat.i(7654);
                        FacebookDialogFragment.access$100(FacebookDialogFragment.this, bundle);
                        AppMethodBeat.o(7654);
                    }
                });
            }
            this.dialog = newInstance;
        }
        AppMethodBeat.o(7655);
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AppMethodBeat.i(7656);
        if (this.dialog == null) {
            onCompleteWebDialog(null, null);
            setShowsDialog(false);
        }
        Dialog dialog2 = this.dialog;
        AppMethodBeat.o(7656);
        return dialog2;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        AppMethodBeat.i(7657);
        super.onResume();
        if (this.dialog instanceof WebDialog) {
            ((WebDialog) this.dialog).resize();
        }
        AppMethodBeat.o(7657);
    }

    @Override // android.support.v4.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(7658);
        super.onConfigurationChanged(configuration);
        if ((this.dialog instanceof WebDialog) && isResumed()) {
            ((WebDialog) this.dialog).resize();
        }
        AppMethodBeat.o(7658);
    }

    @Override // android.support.v4.app.Fragment, android.support.v4.app.DialogFragment
    public void onDestroyView() {
        AppMethodBeat.i(7659);
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
        AppMethodBeat.o(7659);
    }

    private void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        AppMethodBeat.i(7660);
        FragmentActivity activity = getActivity();
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(activity.getIntent(), bundle, facebookException));
        activity.finish();
        AppMethodBeat.o(7660);
    }

    private void onCompleteWebFallbackDialog(Bundle bundle) {
        AppMethodBeat.i(7661);
        FragmentActivity activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
        AppMethodBeat.o(7661);
    }
}
