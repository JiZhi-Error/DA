package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new Parcelable.Creator() {
        /* class com.facebook.login.GetTokenLoginMethodHandler.AnonymousClass3 */

        @Override // android.os.Parcelable.Creator
        public final GetTokenLoginMethodHandler createFromParcel(Parcel parcel) {
            AppMethodBeat.i(7794);
            GetTokenLoginMethodHandler getTokenLoginMethodHandler = new GetTokenLoginMethodHandler(parcel);
            AppMethodBeat.o(7794);
            return getTokenLoginMethodHandler;
        }

        @Override // android.os.Parcelable.Creator
        public final GetTokenLoginMethodHandler[] newArray(int i2) {
            return new GetTokenLoginMethodHandler[i2];
        }
    };
    private GetTokenClient getTokenClient;

    GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return "get_token";
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public void cancel() {
        AppMethodBeat.i(7797);
        if (this.getTokenClient != null) {
            this.getTokenClient.cancel();
            this.getTokenClient.setCompletedListener(null);
            this.getTokenClient = null;
        }
        AppMethodBeat.o(7797);
    }

    /* access modifiers changed from: package-private */
    @Override // com.facebook.login.LoginMethodHandler
    public boolean tryAuthorize(final LoginClient.Request request) {
        AppMethodBeat.i(7798);
        this.getTokenClient = new GetTokenClient(this.loginClient.getActivity(), request.getApplicationId());
        if (!this.getTokenClient.start()) {
            AppMethodBeat.o(7798);
            return false;
        }
        this.loginClient.notifyBackgroundProcessingStart();
        this.getTokenClient.setCompletedListener(new PlatformServiceClient.CompletedListener() {
            /* class com.facebook.login.GetTokenLoginMethodHandler.AnonymousClass1 */

            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public void completed(Bundle bundle) {
                AppMethodBeat.i(7791);
                GetTokenLoginMethodHandler.this.getTokenCompleted(request, bundle);
                AppMethodBeat.o(7791);
            }
        });
        AppMethodBeat.o(7798);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void getTokenCompleted(LoginClient.Request request, Bundle bundle) {
        AppMethodBeat.i(7799);
        if (this.getTokenClient != null) {
            this.getTokenClient.setCompletedListener(null);
        }
        this.getTokenClient = null;
        this.loginClient.notifyBackgroundProcessingStop();
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            Set<String> permissions = request.getPermissions();
            if (stringArrayList == null || (permissions != null && !stringArrayList.containsAll(permissions))) {
                HashSet hashSet = new HashSet();
                for (String str : permissions) {
                    if (!stringArrayList.contains(str)) {
                        hashSet.add(str);
                    }
                }
                if (!hashSet.isEmpty()) {
                    addLoggingExtra("new_permissions", TextUtils.join(",", hashSet));
                }
                request.setPermissions(hashSet);
            } else {
                complete(request, bundle);
                AppMethodBeat.o(7799);
                return;
            }
        }
        this.loginClient.tryNextHandler();
        AppMethodBeat.o(7799);
    }

    /* access modifiers changed from: package-private */
    public void onComplete(LoginClient.Request request, Bundle bundle) {
        AppMethodBeat.i(7800);
        this.loginClient.completeAndValidate(LoginClient.Result.createTokenResult(this.loginClient.getPendingRequest(), createAccessTokenFromNativeLogin(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId())));
        AppMethodBeat.o(7800);
    }

    /* access modifiers changed from: package-private */
    public void complete(final LoginClient.Request request, final Bundle bundle) {
        AppMethodBeat.i(7801);
        String string = bundle.getString(NativeProtocol.EXTRA_USER_ID);
        if (string == null || string.isEmpty()) {
            this.loginClient.notifyBackgroundProcessingStart();
            Utility.getGraphMeRequestWithCacheAsync(bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN), new Utility.GraphMeRequestWithCacheCallback() {
                /* class com.facebook.login.GetTokenLoginMethodHandler.AnonymousClass2 */

                @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                public void onSuccess(JSONObject jSONObject) {
                    AppMethodBeat.i(7792);
                    try {
                        bundle.putString(NativeProtocol.EXTRA_USER_ID, jSONObject.getString("id"));
                        GetTokenLoginMethodHandler.this.onComplete(request, bundle);
                        AppMethodBeat.o(7792);
                    } catch (JSONException e2) {
                        GetTokenLoginMethodHandler.this.loginClient.complete(LoginClient.Result.createErrorResult(GetTokenLoginMethodHandler.this.loginClient.getPendingRequest(), "Caught exception", e2.getMessage()));
                        AppMethodBeat.o(7792);
                    }
                }

                @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                public void onFailure(FacebookException facebookException) {
                    AppMethodBeat.i(7793);
                    GetTokenLoginMethodHandler.this.loginClient.complete(LoginClient.Result.createErrorResult(GetTokenLoginMethodHandler.this.loginClient.getPendingRequest(), "Caught exception", facebookException.getMessage()));
                    AppMethodBeat.o(7793);
                }
            });
            AppMethodBeat.o(7801);
            return;
        }
        onComplete(request, bundle);
        AppMethodBeat.o(7801);
    }

    GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(7802);
        super.writeToParcel(parcel, i2);
        AppMethodBeat.o(7802);
    }

    static {
        AppMethodBeat.i(7803);
        AppMethodBeat.o(7803);
    }
}
