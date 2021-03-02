package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator<WebViewLoginMethodHandler>() {
        /* class com.facebook.login.WebViewLoginMethodHandler.AnonymousClass2 */

        @Override // android.os.Parcelable.Creator
        public final WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(7955);
            WebViewLoginMethodHandler webViewLoginMethodHandler = new WebViewLoginMethodHandler(parcel);
            AppMethodBeat.o(7955);
            return webViewLoginMethodHandler;
        }

        @Override // android.os.Parcelable.Creator
        public final WebViewLoginMethodHandler[] newArray(int i2) {
            return new WebViewLoginMethodHandler[i2];
        }
    };
    private String e2e;
    private WebDialog loginDialog;

    WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return "web_view";
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.WebLoginMethodHandler
    public AccessTokenSource getTokenSource() {
        return AccessTokenSource.WEB_VIEW;
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean needsInternetPermission() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public void cancel() {
        AppMethodBeat.i(7959);
        if (this.loginDialog != null) {
            this.loginDialog.cancel();
            this.loginDialog = null;
        }
        AppMethodBeat.o(7959);
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean tryAuthorize(final LoginClient.Request request) {
        AppMethodBeat.i(7960);
        Bundle parameters = getParameters(request);
        AnonymousClass1 r1 = new WebDialog.OnCompleteListener() {
            /* class com.facebook.login.WebViewLoginMethodHandler.AnonymousClass1 */

            @Override // com.facebook.internal.WebDialog.OnCompleteListener
            public void onComplete(Bundle bundle, FacebookException facebookException) {
                AppMethodBeat.i(7954);
                WebViewLoginMethodHandler.this.onWebDialogComplete(request, bundle, facebookException);
                AppMethodBeat.o(7954);
            }
        };
        this.e2e = LoginClient.getE2E();
        addLoggingExtra("e2e", this.e2e);
        FragmentActivity activity = this.loginClient.getActivity();
        this.loginDialog = new AuthDialogBuilder(activity, request.getApplicationId(), parameters).setE2E(this.e2e).setIsChromeOS(Utility.isChromeOS(activity)).setAuthType(request.getAuthType()).setOnCompleteListener(r1).build();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.setDialog(this.loginDialog);
        facebookDialogFragment.show(activity.getSupportFragmentManager(), FacebookDialogFragment.TAG);
        AppMethodBeat.o(7960);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void onWebDialogComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        AppMethodBeat.i(7961);
        super.onComplete(request, bundle, facebookException);
        AppMethodBeat.o(7961);
    }

    static class AuthDialogBuilder extends WebDialog.Builder {
        private static final String OAUTH_DIALOG = "oauth";
        private String authType;
        private String e2e;
        private String redirect_uri = ServerProtocol.DIALOG_REDIRECT_URI;

        public AuthDialogBuilder(Context context, String str, Bundle bundle) {
            super(context, str, OAUTH_DIALOG, bundle);
        }

        public AuthDialogBuilder setE2E(String str) {
            this.e2e = str;
            return this;
        }

        public AuthDialogBuilder setIsRerequest(boolean z) {
            return this;
        }

        public AuthDialogBuilder setIsChromeOS(boolean z) {
            this.redirect_uri = z ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : ServerProtocol.DIALOG_REDIRECT_URI;
            return this;
        }

        public AuthDialogBuilder setAuthType(String str) {
            this.authType = str;
            return this;
        }

        @Override // com.facebook.internal.WebDialog.Builder
        public WebDialog build() {
            AppMethodBeat.i(7958);
            Bundle parameters = getParameters();
            parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.redirect_uri);
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", this.e2e);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, this.authType);
            WebDialog newInstance = WebDialog.newInstance(getContext(), OAUTH_DIALOG, parameters, getTheme(), getListener());
            AppMethodBeat.o(7958);
            return newInstance;
        }
    }

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(7962);
        this.e2e = parcel.readString();
        AppMethodBeat.o(7962);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(7963);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.e2e);
        AppMethodBeat.o(7963);
    }

    static {
        AppMethodBeat.i(7964);
        AppMethodBeat.o(7964);
    }
}
