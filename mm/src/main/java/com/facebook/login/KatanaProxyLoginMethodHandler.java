package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new Parcelable.Creator<KatanaProxyLoginMethodHandler>() {
        /* class com.facebook.login.KatanaProxyLoginMethodHandler.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final KatanaProxyLoginMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(7804);
            KatanaProxyLoginMethodHandler katanaProxyLoginMethodHandler = new KatanaProxyLoginMethodHandler(parcel);
            AppMethodBeat.o(7804);
            return katanaProxyLoginMethodHandler;
        }

        @Override // android.os.Parcelable.Creator
        public final KatanaProxyLoginMethodHandler[] newArray(int i2) {
            return new KatanaProxyLoginMethodHandler[i2];
        }
    };

    KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return "katana_proxy_auth";
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.NativeAppLoginMethodHandler, com.facebook.login.LoginMethodHandler
    public boolean tryAuthorize(LoginClient.Request request) {
        AppMethodBeat.i(7807);
        String e2e = LoginClient.getE2E();
        Intent createProxyAuthIntent = NativeProtocol.createProxyAuthIntent(this.loginClient.getActivity(), request.getApplicationId(), request.getPermissions(), e2e, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience(), getClientState(request.getAuthId()), request.getAuthType());
        addLoggingExtra("e2e", e2e);
        boolean tryIntent = tryIntent(createProxyAuthIntent, LoginClient.getLoginRequestCode());
        AppMethodBeat.o(7807);
        return tryIntent;
    }

    KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(7808);
        super.writeToParcel(parcel, i2);
        AppMethodBeat.o(7808);
    }

    static {
        AppMethodBeat.i(7809);
        AppMethodBeat.o(7809);
    }
}
