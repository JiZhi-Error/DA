package com.tencent.mm.ui.h.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Calendar;
import org.json.JSONObject;

public final class d {
    long QjF;
    public AccessToken QjM;
    private CallbackManager QjN;
    b QjO;
    private FacebookCallback QjP = new FacebookCallback<LoginResult>() {
        /* class com.tencent.mm.ui.h.a.d.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.FacebookCallback
        public final /* synthetic */ void onSuccess(LoginResult loginResult) {
            AppMethodBeat.i(152824);
            LoginResult loginResult2 = loginResult;
            d.this.QjM = loginResult2.getAccessToken();
            d.this.QjF = loginResult2.getAccessToken().getExpires().getTime();
            if (d.this.QjM != null) {
                Log.i("MicroMsg.FacebookAndroid", "facebook auth success! token %s, expire %d", d.this.QjM.getToken(), Long.valueOf(d.this.QjF));
            }
            if (d.this.QjO != null) {
                d.this.QjO.onSuccess();
            }
            AppMethodBeat.o(152824);
        }

        @Override // com.facebook.FacebookCallback
        public final void onCancel() {
            AppMethodBeat.i(152822);
            Log.i("MicroMsg.FacebookAndroid", "facebook auth cancel!");
            if (d.this.QjO != null) {
                d.this.QjO.onCancel();
            }
            AppMethodBeat.o(152822);
        }

        @Override // com.facebook.FacebookCallback
        public final void onError(FacebookException facebookException) {
            AppMethodBeat.i(152823);
            Log.e("MicroMsg.FacebookAndroid", "facebook auth error! %s", facebookException.getMessage());
            if (d.this.QjO != null) {
                d.this.QjO.onError(facebookException.getMessage());
            }
            AppMethodBeat.o(152823);
        }
    };
    private final String mAppId;

    public interface a {
        void A(JSONObject jSONObject);

        void onError(String str);
    }

    public interface b {
        void onCancel();

        void onError(String str);

        void onSuccess();
    }

    public d(String str) {
        AppMethodBeat.i(152826);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
            AppMethodBeat.o(152826);
            throw illegalArgumentException;
        }
        this.mAppId = str;
        AppMethodBeat.o(152826);
    }

    public final void gWp() {
        AppMethodBeat.i(152827);
        gWq();
        FacebookSdk.setApplicationId(this.mAppId);
        FacebookSdk.sdkInitialize(MMApplicationContext.getContext());
        Log.i("MicroMsg.FacebookAndroid", "installerPkg %s", AttributionIdentifiers.getAttributionIdentifiers(MMApplicationContext.getContext()).getAndroidInstallerPackage());
        this.QjN = CallbackManager.Factory.create();
        AppMethodBeat.o(152827);
    }

    private static void gWq() {
        AppMethodBeat.i(152828);
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(1, instance.get(1) + 100);
            Field declaredField = AttributionIdentifiers.class.getDeclaredField("recentlyFetchedIdentifiers");
            Field declaredField2 = AttributionIdentifiers.class.getDeclaredField("fetchTime");
            declaredField2.setAccessible(true);
            AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
            declaredField2.set(attributionIdentifiers, Long.valueOf(instance.getTimeInMillis()));
            declaredField.setAccessible(true);
            declaredField.set(AttributionIdentifiers.class, attributionIdentifiers);
            AppMethodBeat.o(152828);
        } catch (Exception e2) {
            Log.e("MicroMsg.FacebookAndroid", e2.getMessage());
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(152828);
            throw runtimeException;
        }
    }

    public final void a(Activity activity, b bVar, String[] strArr) {
        AppMethodBeat.i(152829);
        LoginManager.getInstance().registerCallback(this.QjN, this.QjP);
        this.QjO = bVar;
        LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList(strArr));
        AppMethodBeat.o(152829);
    }

    public final void a(String str, final a aVar) {
        AppMethodBeat.i(152830);
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, str);
        new GraphRequest(this.QjM, "me", bundle, HttpMethod.GET, new GraphRequest.Callback() {
            /* class com.tencent.mm.ui.h.a.d.AnonymousClass2 */

            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AppMethodBeat.i(152825);
                if (graphResponse != null) {
                    try {
                        aVar.A(graphResponse.getJSONObject());
                        AppMethodBeat.o(152825);
                    } catch (Exception e2) {
                        aVar.onError("Retrieve Failed, Error Format!");
                        AppMethodBeat.o(152825);
                    }
                } else {
                    aVar.onError("Retrieve Failed, No response!");
                    AppMethodBeat.o(152825);
                }
            }
        }).executeAsync();
        AppMethodBeat.o(152830);
    }

    public final boolean gWo() {
        AppMethodBeat.i(152831);
        if (this.QjM == null || (this.QjF != 0 && System.currentTimeMillis() >= this.QjF)) {
            AppMethodBeat.o(152831);
            return false;
        }
        AppMethodBeat.o(152831);
        return true;
    }

    public final void j(int i2, int i3, Intent intent) {
        AppMethodBeat.i(152832);
        if (this.QjN != null) {
            this.QjN.onActivityResult(i2, i3, intent);
        }
        AppMethodBeat.o(152832);
    }

    public final void logout() {
        AppMethodBeat.i(152833);
        this.QjM = null;
        this.QjF = 0;
        this.QjO = null;
        LoginManager.getInstance().logOut();
        AppMethodBeat.o(152833);
    }
}
