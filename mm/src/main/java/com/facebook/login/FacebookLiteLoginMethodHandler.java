package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class FacebookLiteLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<FacebookLiteLoginMethodHandler> CREATOR = new Parcelable.Creator<FacebookLiteLoginMethodHandler>() {
        /* class com.facebook.login.FacebookLiteLoginMethodHandler.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final FacebookLiteLoginMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(7785);
            FacebookLiteLoginMethodHandler facebookLiteLoginMethodHandler = new FacebookLiteLoginMethodHandler(parcel);
            AppMethodBeat.o(7785);
            return facebookLiteLoginMethodHandler;
        }

        @Override // android.os.Parcelable.Creator
        public final FacebookLiteLoginMethodHandler[] newArray(int i2) {
            return new FacebookLiteLoginMethodHandler[i2];
        }
    };

    FacebookLiteLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return "fb_lite_login";
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.NativeAppLoginMethodHandler, com.facebook.login.LoginMethodHandler
    public boolean tryAuthorize(LoginClient.Request request) {
        AppMethodBeat.i(7788);
        String e2e = LoginClient.getE2E();
        Intent createFacebookLiteIntent = NativeProtocol.createFacebookLiteIntent(this.loginClient.getActivity(), request.getApplicationId(), request.getPermissions(), e2e, request.isRerequest(), request.hasPublishPermission(), request.getDefaultAudience(), getClientState(request.getAuthId()), request.getAuthType());
        addLoggingExtra("e2e", e2e);
        boolean tryIntent = tryIntent(createFacebookLiteIntent, LoginClient.getLoginRequestCode());
        AppMethodBeat.o(7788);
        return tryIntent;
    }

    FacebookLiteLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(7789);
        super.writeToParcel(parcel, i2);
        AppMethodBeat.o(7789);
    }

    static {
        AppMethodBeat.i(7790);
        AppMethodBeat.o(7790);
    }
}
