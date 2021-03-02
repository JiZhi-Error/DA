package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* access modifiers changed from: package-private */
public class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR = new Parcelable.Creator() {
        /* class com.facebook.login.DeviceAuthMethodHandler.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final DeviceAuthMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(7773);
            DeviceAuthMethodHandler deviceAuthMethodHandler = new DeviceAuthMethodHandler(parcel);
            AppMethodBeat.o(7773);
            return deviceAuthMethodHandler;
        }

        @Override // android.os.Parcelable.Creator
        public final DeviceAuthMethodHandler[] newArray(int i2) {
            return new DeviceAuthMethodHandler[i2];
        }
    };
    private static ScheduledThreadPoolExecutor backgroundExecutor;

    DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean tryAuthorize(LoginClient.Request request) {
        AppMethodBeat.i(7776);
        showDialog(request);
        AppMethodBeat.o(7776);
        return true;
    }

    private void showDialog(LoginClient.Request request) {
        AppMethodBeat.i(7777);
        DeviceAuthDialog createDeviceAuthDialog = createDeviceAuthDialog();
        createDeviceAuthDialog.show(this.loginClient.getActivity().getSupportFragmentManager(), "login_with_facebook");
        createDeviceAuthDialog.startLogin(request);
        AppMethodBeat.o(7777);
    }

    /* access modifiers changed from: protected */
    public DeviceAuthDialog createDeviceAuthDialog() {
        AppMethodBeat.i(7778);
        DeviceAuthDialog deviceAuthDialog = new DeviceAuthDialog();
        AppMethodBeat.o(7778);
        return deviceAuthDialog;
    }

    public void onCancel() {
        AppMethodBeat.i(7779);
        this.loginClient.completeAndValidate(LoginClient.Result.createCancelResult(this.loginClient.getPendingRequest(), "User canceled log in."));
        AppMethodBeat.o(7779);
    }

    public void onError(Exception exc) {
        AppMethodBeat.i(7780);
        this.loginClient.completeAndValidate(LoginClient.Result.createErrorResult(this.loginClient.getPendingRequest(), null, exc.getMessage()));
        AppMethodBeat.o(7780);
    }

    public void onSuccess(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        AppMethodBeat.i(7781);
        this.loginClient.completeAndValidate(LoginClient.Result.createTokenResult(this.loginClient.getPendingRequest(), new AccessToken(str, str2, str3, collection, collection2, accessTokenSource, date, date2, date3)));
        AppMethodBeat.o(7781);
    }

    public static synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceAuthMethodHandler.class) {
            AppMethodBeat.i(7782);
            if (backgroundExecutor == null) {
                backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = backgroundExecutor;
            AppMethodBeat.o(7782);
        }
        return scheduledThreadPoolExecutor;
    }

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return "device_auth";
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(7783);
        super.writeToParcel(parcel, i2);
        AppMethodBeat.o(7783);
    }

    static {
        AppMethodBeat.i(7784);
        AppMethodBeat.o(7784);
    }
}
